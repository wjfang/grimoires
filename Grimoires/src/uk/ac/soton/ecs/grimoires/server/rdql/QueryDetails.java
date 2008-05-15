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


package uk.ac.soton.ecs.grimoires.server.rdql;

import java.util.Hashtable;
import java.util.Vector;
import uk.ac.soton.ecs.grimoires.server.impl.RDF;
import uk.ac.soton.ecs.grimoires.server.impl.RDQLQueryQualifier;
import uk.ac.soton.ecs.grimoires.server.impl.VariableGenerator;
import uk.ac.soton.ecs.grimoires.server.impl.damls.datamodel.DAMLSRDF;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataRDF;
import uk.ac.soton.ecs.grimoires.server.impl.topics.datamodel.TopicsRDF;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2RDF;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.datamodel.WSDLRDF;

public class QueryDetails {
    public Vector             variables;
    public Hashtable          namespaces;
    public Vector             statements;
    public Vector             constraints;
    public VariableGenerator  variableGenerator;
    public RDQLQueryQualifier qualifier;
    
    public QueryDetails (Vector initialVariables, Hashtable initialNamespaces, Vector initialStatements, Vector initialConstraints, VariableGenerator initialVariableGenerator, RDQLQueryQualifier initialQualifier) {
        variables         = initialVariables;
        namespaces        = initialNamespaces;
        statements        = initialStatements;
        constraints       = initialConstraints;
        variableGenerator = initialVariableGenerator;
        qualifier         = initialQualifier;
    }
    
    public QueryDetails () {
        this (new Vector (), usualNamespaces (), new Vector (), new Vector (), new SimpleVariableGenerator ("v_"), new SimpleRDQLQueryQualifier (false));
    }

    /** Creates a hashtable with the usual namespaces. */
    public static Hashtable usualNamespaces () {
        Hashtable hash = new Hashtable ();
        
        hash.put (UDDIv2RDF.myGridUDDIv2NS,     "uddi");
        hash.put (MetadataRDF.myGridMetadataNS, "metadata");
        hash.put (WSDLRDF.myGridWSDLNS,         "wsdl");
        hash.put (DAMLSRDF.myGridDAMLSNS,       "damls");
        hash.put (TopicsRDF.myGridTopicsNS,     "topics");
        hash.put (RDF.rdfNS,                    "rdf");
        
        return hash;
    }
}
