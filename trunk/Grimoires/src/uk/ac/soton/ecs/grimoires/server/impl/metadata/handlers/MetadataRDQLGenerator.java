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


package uk.ac.soton.ecs.grimoires.server.impl.metadata.handlers;

import java.util.Iterator;
import java.util.Arrays;
import java.util.logging.Logger;
import com.hp.hpl.jena.rdf.model.RDFException;
import uk.ac.soton.ecs.grimoires.server.impl.RDF;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.*;
import uk.ac.soton.ecs.grimoires.server.rdql.AbstractRDQLGenerator;
import uk.ac.soton.ecs.grimoires.server.rdql.GenerationResults;
import uk.ac.soton.ecs.grimoires.server.rdql.QueryDetails;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.CategoryBag;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelBag;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Name;

public class MetadataRDQLGenerator extends AbstractRDQLGenerator {

    private static final Logger logger = Logger.getLogger("org.grimoires.debug");

    /**
       returns a GenerationResults with variable = messagePart
     */
    public GenerationResults generateRdqlQuery(MessagePartReference queryObject, QueryDetails details) 
	throws RDFException { 
	String holder   = "?" + MetadataUtilities.MetadataHolderVariableName;
	String msgVar = details.variableGenerator.next("message");
	String qnameVar = details.variableGenerator.next ("qname");
	String partBagVar = details.variableGenerator.next ("partBag");
	String messageNamespace = queryObject.getMessageNamespace();
	String messageName = queryObject.getMessageName();
	String messagePartName = queryObject.getMessagePartName();

	details.statements.add("(" + msgVar + ", <rdf:type>, <wsdl:Message>)");
	details.statements.add("(" + msgVar + ", <wsdl:hasQName>, " + qnameVar + ")");
	details.statements.add("(" + qnameVar + ", <wsdl:hasNameSpace>, \"" + messageNamespace + "\")");
	details.statements.add("(" + qnameVar + ", <wsdl:hasLocalName>, \"" + messageName + "\")");
	details.statements.add("(" + msgVar + ", <wsdl:hasMessagePart>, " + partBagVar + ")");
	details.statements.add("(" + partBagVar + " " + details.variableGenerator.next("v_") + " " + holder  + ")");
	details.statements.add("(" + holder + ", <wsdl:hasName>, \"" + messagePartName + "\")");
		
	return new GenerationResults (holder, details);
    }


    /**
       returns a GenerationResults with variable = operation
    */
    public GenerationResults generateRdqlQuery(OperationReference queryObject, QueryDetails details) 
	throws RDFException { 
	String holder   = "?" + MetadataUtilities.MetadataHolderVariableName;
	String portTypeVar = details.variableGenerator.next("portType");
	String typeNameVar = details.variableGenerator.next("typeName");
	String operBagVar = details.variableGenerator.next ("operationBag");
	String portTypeNamespace = queryObject.getPortTypeNamespace();
	String portTypeName = queryObject.getPortTypeName();
	String operationName = queryObject.getOperationName();

	details.statements.add("(" + portTypeVar + ", <rdf:type>, <wsdl:PortType>)");
	details.statements.add("(" + portTypeVar + ", <wsdl:hasTypeName>, " + typeNameVar + ")");
	details.statements.add("(" + typeNameVar + ", <wsdl:hasNameSpace>, \"" + portTypeNamespace + "\")");
	details.statements.add("(" + typeNameVar + ", <wsdl:hasLocalName>, \"" + portTypeName + "\")");
	details.statements.add("(" + portTypeVar + ", <wsdl:hasOperation>, " + operBagVar + ")");
	details.statements.add("(" + operBagVar + " " + details.variableGenerator.next("v_") + " " + holder  + ")");
	details.statements.add("(" + holder + ", <wsdl:hasName>, \"" + operationName + "\")");
		
	return new GenerationResults (holder, details);
    }
    

    /**
       Find a resource that are annotated with metatdata that fits the description in the
       MetadataQueryBag
     */
    public GenerationResults generateRdqlQuery(MetadataQueryBag queryObject, QueryDetails details) 
	throws RDFException { 
	MetadataQuery[] metadataQueries = queryObject.getMetadataQuery();
	String metadataBagVar = details.variableGenerator.next("metadataBag");

	for(int i=0; i<metadataQueries.length; i++) {
	    String metadataVar = generateRdqlQuery(metadataQueries[i], details).getVariable();
	    details.statements.add("(" + metadataBagVar + " " + details.variableGenerator.next("v_") + " " + metadataVar + ")");
	}
			
	return new GenerationResults (metadataBagVar, details);
    }

    
    /**
       Find a resource that are annotated with metatdata that fits the description in the
       MetadataQuery
     */
    public GenerationResults generateRdqlQuery(MetadataQuery queryObject, QueryDetails details) 
	throws RDFException {
	String metadataVar = details.variableGenerator.next("metadata");
	
	details.statements.add("(" + metadataVar + ", <metadata:hasMetadataType>, \"" + queryObject.getMetadataType() + "\")");
	if(queryObject.getDate() != null) {
	    details.statements.add("(" + metadataVar + ", <metadata:hasDate>, \"" + queryObject.getDate() + "\")");
	}
	if(queryObject.getAuthor() != null) {
	    details.statements.add("(" + metadataVar + ", <metadata:hasAuthor>, \"" + queryObject.getAuthor() + "\")");
	}

	String metadataValueVar = generateRdqlQuery(queryObject.getMetadataValue(), details, queryObject.getFindQualifiers()).getVariable();
//	if (queryObject.getMetadataValue().getTriplesAssertion() != null) {
//		/*
//		 * The code in this if clause is a fix to the query by triplesAssertion Metadata.
//		 */
//		String mdv = details.variableGenerator.next("metadataValue");
//		details.statements.add("(" + metadataVar + ", <metadata:hasMetadataValue>, " + mdv + ")");
//		if (metadataValueVar.startsWith("?"))
//			// this is a variable
//			details.statements.add("(" + mdv + ", <metadata:hasTriplesAssertion>, " + metadataValueVar + ")");
//		else
//			// it is a uri, therefore should be inside < >.
//			details.statements.add("(" + mdv + ", <metadata:hasTriplesAssertion>, <" + metadataValueVar + ">)");
//	}
//	else
		details.statements.add("(" + metadataVar + ", <metadata:hasMetadataValue>, " + metadataValueVar + ")");

	return new GenerationResults (metadataVar, details);
    }


    /**
       returns a list of statements that for metadataValue
     */
    public GenerationResults generateRdqlQuery (MetadataValue queryObject, QueryDetails details, FindQualifiers fqs) throws RDFException {
    	
    	// find qualifiers (only two are implemented)
    	boolean wildCardSearch = false;
    	boolean caseSensitiveSearch = false;
    	if (fqs != null) {
    		String[] findQualifiers = fqs.getFindQualifier();
    		for (int i = 0; i < findQualifiers.length; i++) {
    			if (findQualifiers[i].equals("wildCardSearch")) {
    				wildCardSearch   = true;
    			} else if (findQualifiers[i].equals("caseSensitiveSearch")) {
    				caseSensitiveSearch= true;
    			}
    		}
    	}
    	
    	String metadataValueVar = details.variableGenerator.next("metadataValue");
    	String stringValueVar = details.variableGenerator.next("stringValue");
    	
    	if (queryObject.getStringValue () != null) {
    		details.statements.add ("(" + metadataValueVar + ", <metadata:hasString>, \"" +queryObject.getStringValue()  + "\")");
    		// String constraint = "";
//  		details.statements.add ("(" + metadataValueVar + ", <metadata:hasString>, " + stringValueVar + ")");
//  		if(wildCardSearch) {
//  		constraint = stringValueVar + " =~ /" + queryObject.getStringValue() + "/";
//  		}
//  		else {
//  		constraint = stringValueVar + " =~ /^" + queryObject.getStringValue() + "$/";
//  		}
    		
//  		if(!caseSensitiveSearch) {
//  		constraint += "i";
//  		}
//  		details.constraints.add(constraint);
    	}
    	else if(queryObject.getUriValue () != null) {
    		// wf: uri metadata
    		/*
    		 * 
    		 */
//    		String conceptVar = details.variableGenerator.next("concept");
//    		details.statements.add ("(" + metadataValueVar + ", <metadata:hasURI>, " + conceptVar + ")");
//    		details.statements.add("(" + conceptVar + ", <rdf:type>, <" + queryObject.getUriValue() + ">)");
    		details.statements.add ("(" + metadataValueVar 
    				+ ", <metadata:hasURI>, <" + queryObject.getUriValue() + ">)");
    	}
    	else if (queryObject.getTriplesAssertion () != null) {
//    		return new GenerationResults (generateRdqlQuery (queryObject.getTriplesAssertion (), details).getVariable (), details);
    		TriplesAssertion triples = queryObject.getTriplesAssertion();
    		if (!triples.getLanguage().equals("RDQL"))
    			throw new RDFException("Unknown RDF query language.");
    		
    		/*
    		 * This is a safety measure to avoid user-defined variables to conflict with
    		 * Grimoires-defined variables by prefixing all user-defined variables with "user".
    		 */  
    		triples.setResourceIdentifier(triples.getResourceIdentifier().replaceAll("\\B\\?", "?user"));
    		triples.setTriples(triples.getTriples().replaceAll("\\B\\?", "?user"));    		
    		
    		details.statements.add ("(" + metadataValueVar
    				+ ", <metadata:hasTriplesAssertion>, " + triples.getResourceIdentifier() + ")");
    		String[] statements = triples.getTriples().split("\n");
    		for (int i = 0; i < statements.length; i++)
    			details.statements.add(statements[i]);    			
    	}
    	
    	return new GenerationResults(metadataValueVar, details);
    }
    

    public GenerationResults generateRdqlQuery (TriplesAssertion queryObject, QueryDetails details) throws RDFException {
        if (queryObject.getTriples () != null) {
            details.statements.add (queryObject.getTriples ());
        }
        
        return new GenerationResults (queryObject.getResourceIdentifier (), details);
    }


    public GenerationResults generateRdqlQuery(Find_service queryObject, QueryDetails details) 
	throws RDFException {

	String findServVar = details.variableGenerator.next("businessService");
	Iterator eachVar;

	details.statements.add("(" + findServVar + ", <rdf:type>, <uddi:BusinessService>)");
	
	// find qualifiers (only two are implemented)
	boolean exactNameMatch = false;
	boolean caseSensitiveMatch = false;
	FindQualifiers fqs = queryObject.getFindQualifiers();
	if (fqs != null) {
	    String[] findQualifiers = queryObject.getFindQualifiers()
		.getFindQualifier();
	    for (int i = 0; i < findQualifiers.length; i++) {
		if (findQualifiers[i].equals("exactNameMatch")) {
		    exactNameMatch = true;
		} else if (findQualifiers[i].equals("caseSensitiveMatch")) {
		    caseSensitiveMatch = true;
		}
	    }
	}

	// name
	String nameBagVar = details.variableGenerator.next("nameBag");
	Iterator eachName;
	if (queryObject.getName() != null && queryObject.getName().length > 0) {
	    details.statements.add("(" + findServVar + " <uddi:hasName> " + nameBagVar + ")");
	    eachName = Arrays.asList(queryObject.getName()).iterator();
	    while (eachName.hasNext()) {
		String nameVar = details.variableGenerator.next("name");
		details.statements.add("(" + nameBagVar + " " + details.variableGenerator.next("v_") + " " + nameVar + ")");

		// convert the name to suitable perl5 regular expression
		String name = ((Name) eachName.next()).get_value();

		// a single % means all names
		if (!name.equals("%")) {
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
		    details.constraints.add(nameVar + " " + pattern);
		}
	    }	    
	}

	// cat bag
	if (queryObject.getCategoryBag() != null) {
	    String catBagVar = generateRdqlQuery(queryObject.getCategoryBag(), details).getVariable();
	    details.statements.add("(" + findServVar + " <uddi:hasCategoryBag> " + catBagVar + ")");
	}
	
	// tea bag
	if (queryObject.getTModelBag() != null) {
	    String bindBagVar = generateRdqlQuery(queryObject.getTModelBag(), details).getVariable();
	    details.statements.add("(" + findServVar + " <uddi:hasBindingTemplate> " + bindBagVar + ")");
	}

	// metadataQueryBag
	if(queryObject.getMetadataQueryBag() != null) {
	    String metadataBagVar = generateRdqlQuery(queryObject.getMetadataQueryBag(), details).getVariable();
	    details.statements.add("(" + findServVar + " <metadata:hasMetadata> " + metadataBagVar + ")");   
	}

	// business key
	if (queryObject.getBusinessKey() != null && !queryObject.getBusinessKey().equals("")) {
	    String busEntVar = details.variableGenerator.next("businessEntity");
	    details.statements.add("(" + findServVar + " <uddi:hasBusinessEntity> " + busEntVar + ")");
	    details.statements.add("(" + busEntVar + " <uddi:hasBusinessKey> \"" + queryObject.getBusinessKey() + "\")");
	}

	return new GenerationResults (findServVar, details);
    }

    // would like to use the UDDIv2 ones, but they use private GenerationResults variables
    public GenerationResults generateRdqlQuery(CategoryBag queryObject, QueryDetails details) 
	throws RDFException {
	String catBagVariable = details.variableGenerator.next("categoryBag");
	Iterator eachRef = Arrays.asList(queryObject.getKeyedReference()).iterator();
	String keyRefVariable;
	int j = 0;

	while (eachRef.hasNext()) {
	    keyRefVariable = generateRdqlQuery( (KeyedReference) eachRef.next(), details).getVariable();
	    details.statements.add("(" + catBagVariable + " " + details.variableGenerator.next("v_") + " "  + keyRefVariable + ")");
	}

	return new GenerationResults(catBagVariable, details);
    }

    public GenerationResults generateRdqlQuery(KeyedReference queryObject, QueryDetails details) 
	throws RDFException {
	String keyRefVariable = details.variableGenerator.next("keyedReference");
	
	details.statements.add("(" + keyRefVariable + " <uddi:hasKeyName> \"" + queryObject.getKeyName() + "\")");
	details.statements.add("(" + keyRefVariable + " <uddi:hasKeyValue>  \"" + queryObject.getKeyValue() + "\")");

	return new GenerationResults(keyRefVariable, details);
    }


    public GenerationResults generateRdqlQuery(TModelBag queryObject, QueryDetails details) 
	throws RDFException {	
	String bindBagVar = details.variableGenerator.next("bindingTemplateBag");
	String bindTempVar = details.variableGenerator.next("bindingTemplate");
	String tModelInstDetVar = details.variableGenerator.next("tModelInstanceDetails");
	    
	details.statements.add("(" + bindBagVar + " " + details.variableGenerator.next("v_") + " " + bindTempVar + ")");
	details.statements.add("(" + bindTempVar + " <uddi:hastModelInstanceDetail> " +  tModelInstDetVar + ")");

	Iterator eachKey = Arrays.asList(queryObject.getTModelKey()).iterator();
	while (eachKey.hasNext()) {
	    String tModelKeyVar = details.variableGenerator.next("tModelKey");
	    String tModelKeyStr = (String) eachKey.next();
	    details.statements.add("(" + tModelInstDetVar  + " " + details.variableGenerator.next("v_") + " " + tModelKeyVar + ")");
	    details.statements.add("(" + tModelKeyVar + " <uddi:hasTModel> \"" + tModelKeyStr + "\")");
	}
	return new GenerationResults(bindBagVar, details);
    }
}

