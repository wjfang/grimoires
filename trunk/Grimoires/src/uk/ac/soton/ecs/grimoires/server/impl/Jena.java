// The OMII (Open Middleware Infrastructure Institute) distribution
// comprises open source software from different sources with different
// licences. All of the software developed by OMII is provided under the
// Modified BSD licence as given below. Licences for all other software
// may be found in the top level 'licenses' directory.

// Copyright (c) 2004, OMII, University of Southampton. All rights
// reserved.

// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are
// met:

// Redistributions of source code must retain the above copyright notice,
// this list of conditions and the following disclaimer.

// Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer in the
// documentation and/or other materials provided with the distribution.

// Neither the name of the OMII, University of Southampton nor the names
// of its contributors may be used to endorse or promote products derived
// from this software without specific prior written permission.

// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
// FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
// COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
// INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
// (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
// SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
// HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
// STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
// OF THE POSSIBILITY OF SUCH DAMAGE.

package uk.ac.soton.ecs.grimoires.server.impl;

import java.util.logging.Logger;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Bag;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdql.Query;
import com.hp.hpl.jena.rdql.QueryExecution;
import com.hp.hpl.jena.rdql.QueryEngine;
import com.hp.hpl.jena.rdql.QueryResults;
import com.hp.hpl.jena.rdql.ResultBinding;
import com.hp.hpl.jena.rdf.model.RDFException;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import java.util.NoSuchElementException;
import org.doomdark.uuid.UUIDGenerator;
import uk.ac.soton.ecs.grimoires.server.impl.damls.datamodel.DAMLSRDF;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataRDF;
import uk.ac.soton.ecs.grimoires.server.impl.topics.datamodel.TopicsRDF;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2RDF;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.datamodel.WSDLRDF;
import uk.ac.soton.ecs.grimoires.server.rdql.GenerationResults;
import uk.ac.soton.ecs.grimoires.server.rdql.SimpleRDQLQueryQualifier;
import uk.ac.soton.ecs.grimoires.server.rdql.SimpleVariableGenerator;
import uk.ac.soton.ecs.grimoires.server.store.ModelChanges;

/** A class defining convenience functions to manipulate the Jena Triple store. */
public final class Jena {
	private static final UUIDGenerator uuidGen = UUIDGenerator.getInstance();

	private static final Logger logger = Logger
			.getLogger("org.grimoires.debug");

	public static void addTripleIfObjectNotNull(Model model, Resource subject,
			String propertyNS, String propertyName, Object object) {
		if (object != null) {
			subject.addProperty(model.createProperty(propertyNS, propertyName),
					object);
		}
	}

	/**
	 * Remove from the store an entity (with a given key) and all resources related to the entity. 
	 */
	public static void deleteEntity(Model readingModel, ModelChanges changes,
			Key key, String keyRelationNS, String keyRelationName) {
		Resource entityResource = Jena.getKeyedResource(readingModel,
				keyRelationNS, keyRelationName, key);
		if (entityResource != null) {
			changes.getRemovalsModel().add(
					Jena.getResourceTree(readingModel, entityResource));
		}
	}

	/**
	 * Remove a resource and its descendents from the store model: RDF model to
	 * read from changes: the changes model entity: the resource of the entity
	 * to delete exclude: if not null, the resource refered to by this property
	 * will not be deleted fromBag: if both exclude and fromBag are not null,
	 * reference to the entity will be removed from fromBag
	 */

	public static void deleteResource(Model model, ModelChanges changes,
			Resource entity, Property exclude, Property fromBag) {
		if (entity == null) {
			return;
		}

		// add all the statements with entity as the subject to the delete model
		// first
		// this stops getResourceBabyTree() from crawling into the entity, and
		// ruining
		// the exclude and fromBag checks
		Model deletes = ModelFactory.createDefaultModel();
		StmtIterator eachStatement = entity.listProperties();
		deletes.add(eachStatement);
		eachStatement.close();

		eachStatement = entity.listProperties();
		Statement statement;
		RDFNode object;
		while (eachStatement.hasNext()) {
			statement = eachStatement.nextStatement();
			if (exclude != null && statement.getPredicate().equals(exclude)) {
				Resource referedEntity = statement.getResource();
				if (fromBag != null) {
					StmtIterator from = referedEntity.listProperties(fromBag);
					while (from.hasNext()) {
						Resource bag = from.nextStatement().getResource();
						StmtIterator si = model.listStatements(bag, null,
								entity);
						if (si.hasNext()) {
//							deletes.add(si.nextStatement());
							/*
							 * Bag.add() results in
							 * (bag, _1, element0)
							 * (bag, _2, element1) etc.
							 * Correspondingly, we need to use Bag.remove() to remove element0 so that we get
							 * (bag, _1, element1) etc.
							 * 
							 * However, here we directly modify the *model*, we hence raise the 
							 * synchronization problem.
							 */
							((Bag)bag.as(Bag.class)).remove(si.nextStatement());
						}
					}
				}
			} else {
				object = statement.getObject();
				if (object instanceof Resource) {
					deletes.add(getResourceBabyTree(model, deletes,
							(Resource) object));
				}
			}
		}

		// add the deletions to the changes model
		changes.getRemovalsModel().add(deletes);
	}

	/**
	 This function calculates the the property to exclude and the bag to delete from using
	 the referenceType parameter. Then it calls 
	 deleteResource(Model model, ModelChanges changes,
	 Resource entity, Property exclude, Property fromBag)
	 to delete the resource
	 */
	public static void deleteResource(Model model, ModelChanges changes,
			Resource entity, String referenceType) {
		Property exclude = null, removeFromBag = null;
		if (referenceType.equals(UDDIv2RDF.hasServiceKey)) {
			exclude = model.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasBusinessEntity);
			removeFromBag = model.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasBusinessService);
		} else if (referenceType.equals(UDDIv2RDF.hasBindingKey)) {
			exclude = model.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasBusinessService);
			removeFromBag = model.createProperty(UDDIv2RDF.myGridUDDIv2NS,
					UDDIv2RDF.hasBindingTemplate);
		} else if (referenceType.equals(MetadataRDF.hasMetadataKey)) {
			exclude = model.createProperty(MetadataRDF.myGridMetadataNS,
					MetadataRDF.hasEntityReference);
			removeFromBag = model.createProperty(MetadataRDF.myGridMetadataNS,
					MetadataRDF.hasMetadata);
		}

		deleteResource(model, changes, entity, exclude, removeFromBag);
	}

	/**
	 * If the given key's value is null or empty (the way to specify addition in UDDIv2)
	 * then set the key's value to a newly generate string, if the key is not
	 * null or empty (the way to specify update in UDDIv2) then remove the existing
	 * entity with that key. The result of this method is to ensure that the key
	 * has a value that is valid for addition and that no other entity is saved
	 * with that key.
	 */
	public static Key ensureUniqueKey(Model readingModel, ModelChanges changes,
			Key key, String keyRelationNS, String keyRelation) {
		if (key == null) {
			throw new RuntimeException(
					"Internal exception: Jena.ensureUniqueKey was passed a null Key value");
		}
		if (key.getValue() == null || key.getValue().trim().equals("")) {
			// If key does not exist, generate a new one
			key.setValue(uuidGen.generateRandomBasedUUID().toString());
		} else {
			// If key exists, delete the service before re-saving
			Resource entity = Jena.getKeyedResource(readingModel,
					keyRelationNS, keyRelation, key);
			deleteResource(readingModel, changes, entity, keyRelation);
		}
		return key;
	}

	/**
	 * Return all statements the given resource is a subject or ancestor of,
	 * plus the relation attaching the root resource to its parent
	 */
	public static Model getAttachedTree(Model model, Resource parent,
			String relationNamespace, String relationName, Resource root) {
		Property relation = model.createProperty(relationNamespace,
				relationName);
		;
		Statement attachment = model.listStatements(parent, relation, root)
				.nextStatement();
		Model results = getResourceTree(model, root);

		results.add(attachment);

		return results;
	}

	/**
	 * Returns the nth element of a bag or null if it does not exist.
	 */
	public static RDFNode getBagElement(Bag from, int index) {
		NodeIterator eachItem = from.iterator();
		RDFNode found = null;

		while (eachItem.hasNext() && index >= 0) {
			found = eachItem.nextNode();
			index -= 1;
		}
		eachItem.close();
		if (index == -1) {
			return found;
		} else {
			return null;
		}
	}

	/**
	 * Returns the resource with the given relation to a string literal. Primarily
	 * useful for finding resources by their key, e.g. services, metadata. Returns
	 * null if no resource with this key found.
	 */
	public static Resource getKeyedResource(Model model,
			String propertyNamespace, String propertyName, Key key) {
		Property hasKey = model.createProperty(propertyNamespace, propertyName);
		Resource found = null;
		ResIterator eachRsc;

		if (key != null && key.getValue() != null) {
			eachRsc = model.listSubjectsWithProperty(hasKey, key.getValue());
			if (eachRsc.hasNext()) {
				found = (Resource) eachRsc.next();
			}
			eachRsc.close();
		}

		return found;
	}

	/**
	 * Returns the key for a resource representing a keyed resource.
	 */
	public static String getResourceKey(Model model, Resource resource,
			String propertyNamespace, String propertyName)
			throws StoreException {
		RDFNode keyResource = getUniqueObject(model, resource,
				propertyNamespace, propertyName);

		if (keyResource == null) {
			throw new StoreException("No key for resource with property "
					+ propertyNamespace + propertyName);
		}
		return ((Literal) keyResource).getString();
	}

	/**
	 Return all statements the given resource is a subject or ancestor of
	 Recursive adds are done using getResourceBabyTree which handles cyclic
	 relationship within the RDF model
	 */
	public static Model getResourceTree(Model model, Resource root) {
		Model results = ModelFactory.createDefaultModel();
		StmtIterator eachStatement = root.listProperties();
		Statement statement;
		RDFNode object;

		while (eachStatement.hasNext()) {
			statement = eachStatement.nextStatement();

			if (!results.contains(statement)) {
				results.add(statement);
				object = statement.getObject();
				if (object instanceof Resource) {
					results.add(getResourceBabyTree(model, ModelFactory
							.createDefaultModel(), (Resource) object));
				}
			}
		}
		return results;
	}

	/**
	 This is only called from getResourceTree
	 Return all statements the given resource is a subject or ancestor of
	 Statements are added only if it's not already in the model.
	 This is to stop endless recursions from cyclic relationship within 
	 the RDF model
	 */
	private static Model getResourceBabyTree(Model model, Model subtree,
			Resource root) {
		Model results = ModelFactory.createDefaultModel();
		StmtIterator eachStatement = root.listProperties();
		Statement statement;
		RDFNode object;

		while (eachStatement.hasNext()) {
			statement = eachStatement.nextStatement();

			if (!subtree.contains(statement)) {
				results.add(statement);
				subtree.add(statement); // ensure the next level of recursion gets the new statements
				object = statement.getObject();
				if (object instanceof Resource) {
					Model baby = getResourceBabyTree(model, subtree,
							(Resource) object);
					results.add(baby);
					subtree.add(baby); // ensure the next recursion gets the new nested statements
				}
			}
		}
		return results;
	}

	/**
	 * Same as getUniqueObject but used when the object should be a Bag. This is
	 * required only because of a Jena bug that means that some stored Bags are
	 * returned only as Resources.
	 */
	public static Bag getUniqueBag(Model model, Resource subject,
			String propertyNamespace, String propertyName) {
		RDFNode bagNode = getUniqueObject(model, subject, propertyNamespace,
				propertyName);

		if (bagNode == null) {
			return null;
		}
		if (bagNode instanceof Bag) {
			return (Bag) bagNode;
		} else {
			//return new BagImpl((Resource) bagNode, model);
			return (Bag) bagNode.as(Bag.class);
		}
	}

	/**
	 * Used when a resource is expected to be the subject of one and only one
	 * relation of a given type, this convenience method returns the first object
	 * found, or null if none exist.
	 */
	public static RDFNode getUniqueObject(Model model, Resource subject,
			Property relation) {
		NodeIterator eachNode = model.listObjectsOfProperty(subject, relation);

		try {
			return eachNode.nextNode();
		} catch (NoSuchElementException noKey) {
			return null;
		} finally {
			eachNode.close();
		}
	}

	/**
	 * Used when a resource is expected to be the subject of one and only one
	 * relation of a given type, this convenience method returns the first object
	 * found, or null if none exist.
	 */
	public static RDFNode getUniqueObject(Model model, Resource subject,
			String propertyNamespace, String propertyName) {
		return getUniqueObject(model, subject, model.createProperty(
				propertyNamespace, propertyName));
	}

	public static boolean isType(Model model, Resource subject, String typeNS,
			String typeName) {
		return subject.hasProperty(RDF.rdfType, model.createResource(typeNS
				+ typeName));
	}

	/**
	 * Create a new Bag resource with an associated RDF type.
	 */
	public static final Bag newTypedBag(Model model, String type)
			throws RDFException {
		Bag bag = model.createBag();
		Property rdfType = RDF.rdfType;
		Statement typeStatement = model.getProperty(bag, rdfType);

		// Jena by default gives type bag!
		model.remove(typeStatement);
		bag.addProperty(rdfType, model.createResource(type));

		return bag;
	}

	/**
	 * Create a new Bag resource with an associated RDF type and containing a
	 * list of Strings, where those Strings are gathered from the TextHolder
	 * objects given to this method.
	 */
	/* LUC
	 public static final Bag newTypedBagWithTexts (Model model, String type, Collection textObjects) throws RDFException {
	 Bag      bag      = newTypedBag (model, type);
	 Iterator eachText = textObjects.iterator ();
	 
	 while (eachText.hasNext ()) {
	 bag.add (((TextHolder) eachText.next ()).getText ().toString ());
	 }
	 
	 return bag;
	 }
	 */

	public static Vector processQuery(Model model, GenerationResults rdqlQuery,
			String variableName) {
		return processQuery(model, generateRdqlQuery(rdqlQuery), variableName);
	}

	/**
	 * Returns a vector of resources matching variableName in
	 * rdqlQuery.  This method will execute rdqlQuery on the triple
	 * store.  We assume that the query contains a select statement
	 * over a single variableName.  The result will be returned in a
	 * Vector.
	 */
	public static Vector processQuery(Model m, String rdqlQuery,
			String variableName) {
		Vector results = new Vector();
		Query query;
		QueryExecution qe;
		QueryResults queryResults;
		Iterator iter;
		ResultBinding rb;
		Resource r;

		try {
			logger.fine(rdqlQuery);
			//	    System.out.println(rdqlQuery);
			query = new Query(rdqlQuery);
			query.setSource(m);
			qe = new QueryEngine(query);
			qe.init();
			queryResults = qe.exec();

			for (iter = queryResults; iter.hasNext();) {
				logger.finer("query found one match");
				rb = (ResultBinding) iter.next();
				logger.finer(" * " + rb.toString());
				/*
				 * wf: a hack
				 */
				//				r = (Resource) rb.get(variableName);
				//				results.addElement(r);
				Object obj = rb.get(variableName);
				if (obj instanceof Resource) {
					r = (Resource) obj;
					results.addElement(r);
				} else if (obj instanceof Literal)
					results.addElement((Literal) obj);
			}
			queryResults.close();
			qe.close();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

		return results;
	}

	/** Returns a vector of resources matching variableName in
	 * rdqlQuery.  This method will execute rdqlQuery on the triple
	 * store.  We assume that the query contains a select statement
	 * over a series of variableNames.  The result will be returned in a
	 * Vector.
	 */
	public static Vector processQuery(Model m, String rdqlQuery,
			String[] variableNames) {
		Vector results = new Vector();
		Query query;
		QueryExecution qe;
		QueryResults queryResults;
		ResultBinding rb;
		Vector localResult;
		int i;
		String variableName;
		Resource r;

		try {
			query = new Query(rdqlQuery);
			query.setSource(m);
			qe = new QueryEngine(query);
			queryResults = qe.exec();

			while (queryResults.hasNext()) {
				rb = (ResultBinding) queryResults.next();

				localResult = new Vector();
				results.addElement(localResult);
				for (i = 0; i < variableNames.length; i += 1) {
					variableName = variableNames[i];
//					r = (Resource) rb.get(variableName);
//					localResult.addElement(r);
					localResult.addElement(rb.get(variableName));
				}
			}
			queryResults.close();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

		return results;
	}

	//	/**
	//	 * Saves to store, if not empty, the array field of a given resource as a bag. The relation of the owner object to its field
	//	 * is defined by the namespace + fieldName, the bag type by namespace + bagType.
	//	 */
	//	public static final void saveArrayField(Model model, Resource owner,
	//			Object[] field, String namespace, String fieldName, String bagType)
	//			throws StoreException {
	//		Property hasField = model.createProperty(namespace, fieldName);
	//		Bag bag;
	//
	//		if (field == null)
	//			return;
	//
	//		if (field.length > 0) {
	//			bag = saveArray(model, field, namespace, bagType);
	//			owner.addProperty(hasField, bag);
	//		}
	//	}
	//
	//	/**
	//	 * Saves to store an array of a given type of objects as a bag.
	//	 * The bag type by namespace + bagType. The bag is returned.
	//	 */
	//	public static final Bag saveArray(Model model, Object[] values,
	//			String namespace, String bagType) throws StoreException {
	//		Iterator each = Arrays.asList(values).iterator();
	//		Bag bag = newTypedBag(model, namespace + bagType);
	//
	//		while (each.hasNext()) {
	//			bag.add(((SerializableDataModel) each.next()).saveToStore(model));
	//		}
	//
	//		return bag;
	//	}

	public static final void setRDFType(Model m, Resource r, String resourceURI)
			throws RDFException {
		setRDFType(r, m.createResource(resourceURI));
	}

	public static final void setRDFType(Resource r, RDFNode typeResource)
			throws RDFException {
		r.addProperty(RDF.rdfType, typeResource);
	}

	/** Should be removed when all APIs converted to using RDQLGenerator */
	public static String generateRdqlQuery(SupportsRDQLQuery concept) {
		Vector variables = new Vector();
		Hashtable namespaces = usualNamespaces();
		Vector statements = new Vector();
		Vector constraints = new Vector();
		VariableGenerator variableGenerator = new SimpleVariableGenerator("v_");
		RDQLQueryQualifier qualifier = new SimpleRDQLQueryQualifier(false);
		String findVariable = concept.generateRdqlQuery(variables, namespaces,
				statements, constraints, variableGenerator, qualifier);
		StringBuffer query = new StringBuffer();
		Iterator eachStatement = statements.iterator();
		Iterator eachConstraint = constraints.iterator();
		Iterator eachNamespace = namespaces.keySet().iterator();
		String full;

		query.append("\nSELECT " + findVariable + " WHERE\n");

		while (eachStatement.hasNext()) {
			query.append(" ");
			query.append(((String) eachStatement.next()));
			query.append("\n");
		}

		if (constraints.size() > 0) {
			query.append("AND\n");
			while (eachConstraint.hasNext()) {
				query.append(" ");
				query.append(((String) eachConstraint.next()));
				if (eachConstraint.hasNext()) {
					query.append(",");
				}
				query.append("\n");
			}
		}

		if (namespaces.size() > 0) {
			query.append("USING\n");
			while (eachNamespace.hasNext()) {
				full = (String) eachNamespace.next();
				query.append(" ");
				query.append(namespaces.get(full));
				query.append(" FOR <");
				query.append(full);
				query.append(">");
				if (eachNamespace.hasNext()) {
					query.append(",");
				}
			}
		}
		//System.err.println (query);
		return query.toString();
	}

	public static String generateRdqlQuery(GenerationResults conceptQuery) {
		Vector variables = conceptQuery.getQueryDetails().variables;
		Hashtable namespaces = conceptQuery.getQueryDetails().namespaces;
		Vector statements = conceptQuery.getQueryDetails().statements;
		Vector constraints = conceptQuery.getQueryDetails().constraints;
		VariableGenerator variableGenerator = conceptQuery.getQueryDetails().variableGenerator;
		RDQLQueryQualifier qualifier = conceptQuery.getQueryDetails().qualifier;
		String findVariable = conceptQuery.getVariable();
		StringBuffer query = new StringBuffer();
		Iterator eachStatement = statements.iterator();
		Iterator eachConstraint = constraints.iterator();
		Iterator eachNamespace = namespaces.keySet().iterator();
		String full;

		query.append("\nSELECT " + findVariable + " WHERE\n");

		while (eachStatement.hasNext()) {
			query.append(" ");
			query.append(((String) eachStatement.next()));
			query.append("\n");
		}

		if (constraints.size() > 0) {
			query.append("AND\n");
			while (eachConstraint.hasNext()) {
				query.append(" ");
				query.append(((String) eachConstraint.next()));
				if (eachConstraint.hasNext()) {
					query.append(",");
				}
				query.append("\n");
			}
		}

		if (namespaces.size() > 0) {
			query.append("USING\n");
			while (eachNamespace.hasNext()) {
				full = (String) eachNamespace.next();
				query.append(" ");
				query.append(namespaces.get(full));
				query.append(" FOR <");
				query.append(full);
				query.append(">");
				if (eachNamespace.hasNext()) {
					query.append(",");
				}
			}
		}
		return query.toString();
	}

	/** Should be removed when all APIs converted to using RDQLGenerator */
	public static Hashtable usualNamespaces() {
		Hashtable hash = new Hashtable();

		hash.put(UDDIv2RDF.myGridUDDIv2NS, "uddi");
		hash.put(MetadataRDF.myGridMetadataNS, "metadata");
		hash.put(WSDLRDF.myGridWSDLNS, "wsdl");
		hash.put(DAMLSRDF.myGridDAMLSNS, "damls");
		hash.put(TopicsRDF.myGridTopicsNS, "topics");
		hash.put(RDF.rdfNS, "rdf");

		return hash;
	}

}
