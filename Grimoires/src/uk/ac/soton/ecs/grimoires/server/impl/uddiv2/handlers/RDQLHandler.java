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


/*
 * Created on 06-Jan-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import uk.ac.soton.ecs.grimoires.server.impl.RDF;
import uk.ac.soton.ecs.grimoires.server.impl.RDQLQueryQualifier;
import uk.ac.soton.ecs.grimoires.server.impl.VariableGenerator;
import uk.ac.soton.ecs.grimoires.server.impl.damls.datamodel.DAMLSRDF;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataRDF;
import uk.ac.soton.ecs.grimoires.server.impl.topics.datamodel.TopicsRDF;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AccessPoint;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Add_publisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Address;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AddressLine;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusItem;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusReport;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AuthToken;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplates;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetailExt;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntityExt;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfos;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessServices;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contact;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contacts;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_binding;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_publisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Direction;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Discard_authToken;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURL;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DiscoveryURLs;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Email;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.FindQualifiers;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_binding;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_relatedBusinesses;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_assertionStatusReport;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_authToken;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_bindingDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetailExt;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_publisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_registeredInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_serviceDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_tModelDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.HostingRedirector;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.IdentifierBag;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.InstanceDetails;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeysOwned;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.OverviewDoc;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Phone;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertion;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RegisteredInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessInfos;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessesList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_binding;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_service;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceInfos;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Set_publisherAssertions;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.SharedRelationships;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelBag;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfos;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceDetails;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInstanceInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Validate_values;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.datamodel.WSDLRDF;
import uk.ac.soton.ecs.grimoires.server.rdql.SimpleRDQLQueryQualifier;
import uk.ac.soton.ecs.grimoires.server.rdql.SimpleVariableGenerator;

/**
 * @author wf
 *
 * Generate RDQL Query
 */
public class RDQLHandler extends NotImplementedUDDIv2DataModelHandler implements
									  UDDIv2DataModelVisitor {

    // singleton
    static private RDQLHandler onlyInstance = new RDQLHandler();

    static public RDQLHandler getInstance() {
	return onlyInstance;
    }

    private Hashtable getUsualNamespaces() {
	Hashtable hash = new Hashtable();

	hash.put(UDDIv2RDF.myGridUDDIv2NS, "uddi");
	hash.put(MetadataRDF.myGridMetadataNS, "metadata");
	hash.put(WSDLRDF.myGridWSDLNS, "wsdl");
	hash.put(DAMLSRDF.myGridDAMLSNS, "damls");
	hash.put(TopicsRDF.myGridTopicsNS, "topics");
	hash.put(RDF.rdfNS, "rdf");

	return hash;
    }

    /*
     * data objects used during RDQL generation.
     * variables: the set of variables over which the query occurs
     * namespaces: a hastable of namesspaces already produced
     * statements: a sequence of rdql statements already generated
     * constraints: a sequence of constraints to be satisfied
     * variableGenerator: a generator of new variables
     * qualifier: a query qualifier to control the generation of RDQL
     */
    private Vector variables;

    private Hashtable namespaces = getUsualNamespaces();

    private Vector statements;

    private Vector constraints;

    private VariableGenerator variableGenerator = new SimpleVariableGenerator(
									      "v_");

    private RDQLQueryQualifier qualifier = new SimpleRDQLQueryQualifier(false);

    /*
     * Called before actually generating RDQL. It prepares the data objects
     */
    private void setUp() {
	variables = new Vector();
	statements = new Vector();
	constraints = new Vector();
	variableGenerator = new SimpleVariableGenerator("v_");
    }

    public String generateRdqlQuery(UDDIv2DataModelVisitable concept)
	throws Exception {
	setUp();
	String findVariable = (String) concept.accept(this);
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
//	System.err.println(query);
	return query.toString();
    }

    /* (non-Javadoc)
     * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_business)
     */
    public Object process(Find_business dm) throws Exception {
	String findBusVar = variableGenerator.next("businessEntity");
	String nameBagVar = variableGenerator.next("nameBag");
	String nameVar = variableGenerator.next("name");
	String bindBagVar = variableGenerator.next("bindingTemplateBag");
	String bindTempVar = variableGenerator.next("bindingTemplate");
	String tModelInstDetVar = variableGenerator.next("tModelInstanceDetails");
	String catBagVar;
	String identBagVar;
	Iterator eachName;
	Iterator eachVar;
	    
	// INCOMPLETE - DOES NOT IMPLEMENT FOR DISCOVERYURLS
	    
	statements.add("(" + findBusVar
		       + ", <rdf:type>, <uddi:BusinessEntity>)");
	    
	// find qualifiers (only two are implemented)
	boolean exactNameMatch = false;
	boolean caseSensitiveMatch = false;
	FindQualifiers fqs = dm.getFindQualifiers();
	if (fqs != null) {
	    String[] findQualifiers = dm.getFindQualifiers()
		.getFindQualifier();
	    if(findQualifiers != null) {
		for (int i = 0; i < findQualifiers.length; i++) {
		    if (findQualifiers[i].equals("exactNameMatch")) {
			exactNameMatch = true;
		    } else if (findQualifiers[i].equals("caseSensitiveMatch")) {
			caseSensitiveMatch = true;
		    }
		}
	    }
	}

	// DiscoveryURL
	    
	// IdentifierBag
	if (dm.getIdentifierBag() != null) {
	    identBagVar = (String) dm.getIdentifierBag().accept(this);
	    statements.add("(" + findBusVar + ", <uddi:hasIdentifierBag>, "
			   + identBagVar + ")");
	}
	    
	// CategoryBag
	if (dm.getCategoryBag() != null) {
	    catBagVar = (String) dm.getCategoryBag().accept(this);
	    statements.add("(" + findBusVar + ", <uddi:hasCategoryBag>, "
			   + catBagVar + ")");
	}
	    
	// TModelBag
	if (dm.getTModelBag() != null) {
	    statements.add("(" + findBusVar + ", <uddi:hasBindingTemplate>, "
			   + bindBagVar + ")");
	    statements.add("(" + bindBagVar + ", " + variableGenerator.next()
			   + ", " + bindTempVar + ")");
	    statements.add("(" + bindTempVar
			   + ", <uddi:hastModelInstanceDetail>, " + tModelInstDetVar
			   + ")");
		
	    /* May be an abuse of the variables parameter, but need to return a set of variable names */
	    dm.getTModelBag().accept(this);
	    eachVar = variables.iterator();
	    while (eachVar.hasNext()) {
		statements.add("(" + tModelInstDetVar + ", "
			       + variableGenerator.next() + ", " + eachVar.next()
			       + ")");
	    }
	    variables.removeAllElements();
	}

	// name
	if (dm.getName() != null && dm.getName().length > 0) {
        boolean firstName = true;
	    
	    eachName = Arrays.asList(dm.getName()).iterator();
	    while (eachName.hasNext()) {
		    
		// convert the name to suitable perl5 regular expression
		String name = ((Name) eachName.next()).get_value();
		
		name = handleWildcard(name);
		
		if (name.equals(""))
			name = "%";
		    
		// a single % means all names
		if (!name.equals("%")) {
            if (firstName) {
                statements.add("(" + findBusVar + ", <uddi:hasName>, " + nameBagVar
                       + ")");
                firstName = false;
            }
            statements.add("(" + nameBagVar + ", "
                   + variableGenerator.next() + ", " + nameVar + ")");
        
		    String pattern = "";
			
		    if (exactNameMatch && name.indexOf("%") == -1) {
			// if there's a % in the name, ignore the exactNameMatch findQualifier
			pattern = "eq \"" + name + "\"";
		    } else {
			pattern = "=~ ";
			    
			// match initial subtring if no % is present
			if (name.indexOf("%") == -1) {
			    pattern += "/^" + name + "/";
			} else {
			    // does the name start with a %
			    if (name.startsWith("%")) {
				name = name.substring(1, name.length());
				pattern += "/";
			    } else {
				pattern += "/^";
			    }
				
			    // does the name end with a %?
			    if (name.endsWith("%")) {
				name = name.substring(0, name.length() - 1);
				// \\\\w\\\\s becomes \w\s after java's string processing has finished with it
				pattern += name
				    .replaceAll("%", "[\\\\w\\\\s]*");
				pattern += "/";
			    } else {
				pattern += name
				    .replaceAll("%", "[\\\\w\\\\s]*");
				pattern += "$/";
			    }
			}
			    
			if (!caseSensitiveMatch) {
			    pattern += "i";
			}
		    }
		    statements.add("AND " + nameVar + " " + pattern);
		}
	    }
	}
	    
	return findBusVar;
    }

    /* (non-Javadoc)
     * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag)
     */
    public Object process(CategoryBag dm) throws Exception {
	String catBagVariable = variableGenerator.next("categoryBag");
	Iterator eachRef = Arrays.asList(dm.getKeyedReference()).iterator();
	String keyRefVariable;
	int j = 0;

	while (eachRef.hasNext()) {
	    keyRefVariable = (String) ((UDDIv2DataModelVisitable) eachRef
				       .next()).accept(this);
	    statements.add("(" + catBagVariable + ", ?j_" + j + ","
			   + keyRefVariable + ")");
	    j += 1;
	}

	return catBagVariable;
    }

    /*
     * (non-Javadoc)
     * 
     * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.IdentifierBag)
     */
    public Object process(IdentifierBag dm) throws Exception {
	Iterator eachRef = Arrays.asList(dm.getKeyedReference()).iterator();
	String indentifierBagVariable = variableGenerator.next("identifierBag");
	String keyRefVariable;
	int j = 0;

	while (eachRef.hasNext()) {
	    keyRefVariable = (String) ((UDDIv2DataModelVisitable) eachRef
				       .next()).accept(this);
	    statements.add("(" + indentifierBagVariable + ", ?j_" + j + ","
			   + keyRefVariable + ")");
	    j += 1;
	}

	return indentifierBagVariable;
    }

    /*
     * (non-Javadoc)
     * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelBag)
     */
    public Object process(TModelBag dm) throws Exception {
	String tModelKeyStr = null;
	Iterator eachKey = Arrays.asList(dm.getTModelKey()).iterator();
	int j = 0;

	while (eachKey.hasNext()) {
	    String tModelKeyVar = variableGenerator.next("tModelKey");

	    tModelKeyStr = (String) eachKey.next();

	    statements.add("(" + tModelKeyVar + ", <uddi:hasTModel>,\""
			   + tModelKeyStr + "\")");
	    variables.add(tModelKeyVar);
	}

	return tModelKeyStr;
    }

    /* (non-Javadoc)
     * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference)
     */
    public Object process(KeyedReference dm) throws Exception {
	String keyRefVariable = variableGenerator.next("keyedReference");

	statements.add("(" + keyRefVariable + ", <uddi:hasKeyName> ,\""
		       + dm.getKeyName() + "\")");
	statements.add("(" + keyRefVariable + ", <uddi:hasKeyValue> , \""
		       + dm.getKeyValue() + "\")");

	return keyRefVariable;
    }

    /* (non-Javadoc)
     * @see uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor#process(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_service)
     */
    public Object process(Find_service dm) throws Exception {
	String findServVar = variableGenerator.next("businessService");
	String busEntVar = variableGenerator.next("businessEntity");
	String nameVar = variableGenerator.next("name");
	String nameBagVar = variableGenerator.next("nameBag");
	String bindBagVar = variableGenerator.next("bindingTemplateBag");
	String bindTempVar = variableGenerator.next("bindingTemplate");
	String tModelInstDetVar = variableGenerator
	    .next("tModelInstanceDetails");
	String catBagVar;
	Iterator eachName;
	Iterator eachVar;

	statements.add("(" + findServVar
		       + ", <rdf:type>, <uddi:BusinessService>)");

	// find qualifiers (only two are implemented)
	boolean exactNameMatch = false;
	boolean caseSensitiveMatch = false;
	FindQualifiers fqs = dm.getFindQualifiers();
	if (fqs != null) {
	    String[] findQualifiers = dm.getFindQualifiers().getFindQualifier();
	    if(findQualifiers != null) {
		for (int i = 0; i < findQualifiers.length; i++) {
		    if (findQualifiers[i].equals("exactNameMatch")) {
			exactNameMatch = true;
		    } else if (findQualifiers[i].equals("caseSensitiveMatch")) {
			caseSensitiveMatch = true;
		    }
		}
	    }
	}

	// business key
	if (dm.getBusinessKey() != null && !dm.getBusinessKey().equals("")) {
	    statements.add("(" + findServVar + ", <uddi:hasBusinessEntity>, "
			   + busEntVar + ")");
	    statements.add("(" + busEntVar + ", <uddi:hasBusinessKey>, \""
			   + dm.getBusinessKey() + "\")");
	}

	// cat bag
	if (dm.getCategoryBag() != null) {
	    catBagVar = (String) dm.getCategoryBag().accept(this);
	    statements.add("(" + findServVar + ", <uddi:hasCategoryBag>, "
			   + catBagVar + ")");
	}

	// tea bag
	if (dm.getTModelBag() != null) {
	    statements.add("(" + findServVar + ", <uddi:hasBindingTemplate>, "
			   + bindBagVar + ")");
	    statements.add("(" + bindBagVar + ", " + variableGenerator.next()
			   + ", " + bindTempVar + ")");
	    statements.add("(" + bindTempVar
			   + ", <uddi:hastModelInstanceDetail>, " + tModelInstDetVar
			   + ")");

	    /* May be an abuse of the variables parameter, but need to return a set of variable names */
	    dm.getTModelBag().accept(this);
	    eachVar = variables.iterator();
	    while (eachVar.hasNext()) {
		statements.add("(" + tModelInstDetVar + ", "
			       + variableGenerator.next() + ", " + eachVar.next()
			       + ")");
	    }
	    variables.removeAllElements();
	}

	// name
	if (dm.getName() != null && dm.getName().length > 0) {
	    boolean firstName = true;
	    eachName = Arrays.asList(dm.getName()).iterator();
	    while (eachName.hasNext()) {
		
		// convert the name to suitable perl5 regular expression
		String name = ((Name) eachName.next()).get_value();
		
		name = handleWildcard(name);
		
		if (name.equals(""))
			name = "%";

		// a single % means all names
		if (!name.equals("%")) {
            if (firstName) {
                statements.add("(" + findServVar + ", <uddi:hasName>, "
                       + nameBagVar + ")");
                firstName = false;
            }
            statements.add("(" + nameBagVar + ", "
                   + variableGenerator.next() + ", " + nameVar + ")");

		    String pattern = "";

		    if (exactNameMatch && name.indexOf("%") == -1) {
			// if there's a % in the name, ignore the exactNameMatch findQualifier
			pattern = "eq \"" + name + "\"";
		    } else {
			pattern = "=~ ";

			// match initial subtring if no % is present
			if (name.indexOf("%") == -1) {
			    pattern += "/^" + name + "/";
			} else {
			    // does the name start with a %
			    if (name.startsWith("%")) {
				name = name.substring(1, name.length());
				pattern += "/";
			    } else {
				pattern += "/^";
			    }

			    // does the name end with a %?
			    if (name.endsWith("%")) {
				name = name.substring(0, name.length() - 1);
				// \\\\w\\\\s becomes \w\s after java's string processing has finished with it
				pattern += name
				    .replaceAll("%", "[\\\\w\\\\s]*");
				pattern += "/";
			    } else {
				pattern += name
				    .replaceAll("%", "[\\\\w\\\\s]*");
				pattern += "$/";
			    }
			}

			if (!caseSensitiveMatch) {
			    pattern += "i";
			}
		    }
		    statements.add("AND " + nameVar + " " + pattern);
		}
	    }
	}

	return findServVar;
    }

    public Object process(Find_tModel dm) throws Exception {
	String findTModelVar = variableGenerator.next("tModel");
	String bindBagVar = variableGenerator.next("bindingTemplateBag");
	String bindTempVar = variableGenerator.next("bindingTemplate");
	String tModelInstDetVar = variableGenerator
	    .next("tModelInstanceDetails");
	String nameVar = variableGenerator.next("name");
	String catBagVar;
	String identBagVar;
	Iterator eachVar;

	statements.add("(" + findTModelVar + ", <rdf:type>, <uddi:TModel>)");

	// only retrieve tmodels that aren't deleted
	statements.add("(" + findTModelVar + ", <uddi:isDeleted>, \"false\")"); 

	// find qualifiers (only two are implemented)
	boolean exactNameMatch = false;
	boolean caseSensitiveMatch = false;
	FindQualifiers fqs = dm.getFindQualifiers();
	if (fqs != null) {
	    String[] findQualifiers = dm.getFindQualifiers().getFindQualifier();
	    if(findQualifiers != null) {
		for (int i = 0; i < findQualifiers.length; i++) {
		    if (findQualifiers[i].equals("exactNameMatch")) {
			exactNameMatch = true;
		    } else if (findQualifiers[i].equals("caseSensitiveMatch")) {
			caseSensitiveMatch = true;
		    }
		}
	    }
	}

	// IdentifierBag
	if (dm.getIdentifierBag() != null) {
	    identBagVar = (String) dm.getIdentifierBag().accept(this);
	    statements.add("(" + findTModelVar + ", <uddi:hasIdentifierBag>, "
			   + identBagVar + ")");
	}

	// CategoryBag
	if (dm.getCategoryBag() != null) {
	    catBagVar = (String) dm.getCategoryBag().accept(this);
	    statements.add("(" + findTModelVar + ", <uddi:hasCategoryBag>, "
			   + catBagVar + ")");
	}

	// name
	if (dm.getName() != null) {
	    
	    // convert the name to suitable perl5 regular expression
	    String name = dm.getName().get_value();
	    
	    name = handleWildcard(name);

	    // a single % means all names
	    if (!name.equals("%")) {
            statements.add("(" + findTModelVar + ", <uddi:hasName>, " + nameVar
                   + ")");

		String pattern = "";

		if (exactNameMatch && name.indexOf("%") == -1) {
		    // if there's a % in the name, ignore the exactNameMatch findQualifier
		    pattern = "eq \"" + name + "\"";
		} else {
		    pattern = "=~ ";

		    // match initial subtring if no % is present
		    if (name.indexOf("%") == -1) {
			pattern += "/^" + name + "/";
		    } else {
			// does the name start with a %
			if (name.startsWith("%")) {
			    name = name.substring(1, name.length());
			    pattern += "/";
			} else {
			    pattern += "/^";
			}

			// does the name end with a %?
			if (name.endsWith("%")) {
			    name = name.substring(0, name.length() - 1);
			    // \\\\w\\\\s becomes \w\s after java's string processing has finished with it
			    pattern += name.replaceAll("%", "[\\\\w\\\\s]*");
			    pattern += "/";
			} else {
			    pattern += name.replaceAll("%", "[\\\\w\\\\s]*");
			    pattern += "$/";
			}
		    }

		    if (!caseSensitiveMatch) {
			pattern += "i";
		    }
		}
		statements.add("AND " + nameVar + " " + pattern);
	    }
	}

	return findTModelVar;
    }

    public Object process(Find_binding dm) throws Exception {
	String findBindVar = variableGenerator.next("bindingTemplate");
	String serviceVar = variableGenerator.next("businessService");
	String tModelInstDetVar = variableGenerator
	    .next("tModelInstanceDetails");
	Iterator eachVar;

	statements.add("(" + findBindVar
		       + ", <rdf:type>, <uddi:BindingTemplate>)");

	if (dm.getServiceKey() != null) {
	    statements.add("(" + findBindVar + ", <uddi:hasBusinessService>, "
			   + serviceVar + ")");
	    statements.add("(" + serviceVar + ", <uddi:hasServiceKey>, \""
			   + dm.getServiceKey() + "\")");
	}

	if (dm.getTModelBag() != null) {
	    statements.add("(" + findBindVar
			   + ", <uddi:hastModelInstanceDetail>, " + tModelInstDetVar
			   + ")");

	    /* May be an abuse of the variables parameter, but need to return a set of variable names */
	    //dm.getTModelBag().generateRdqlQuery(variables, namespaces, statements, constraints, variableGenerator, qualifier);
	    dm.getTModelBag().accept(this);
	    eachVar = variables.iterator();
	    while (eachVar.hasNext()) {
		statements.add("(" + tModelInstDetVar + ", "
			       + variableGenerator.next() + ", " + eachVar.next()
			       + ")");
	    }
	    variables.removeAllElements();
	}

	System.err.println(findBindVar);
	return findBindVar;
    }
    
    private String handleWildcard(String string) {
    	if (string == null || string.length() == 0 || string.equals("%"))
    		return string;
    	int i = string.indexOf('%', 1);
    	if (i == -1 || i == string.length() - 1)
    		return string;
    	else
    		return string.substring(0, i + 1);
    }
}
