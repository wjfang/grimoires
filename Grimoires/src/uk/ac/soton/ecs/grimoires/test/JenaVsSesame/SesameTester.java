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
 * Created on 06-May-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package uk.ac.soton.ecs.grimoires.test.JenaVsSesame;

import org.openrdf.model.Resource;
import org.openrdf.model.URI;
import org.openrdf.model.Value;
import org.openrdf.model.ValueFactory;
import org.openrdf.sesame.Sesame;
import org.openrdf.sesame.admin.AdminListener;
import org.openrdf.sesame.admin.DummyAdminListener;
import org.openrdf.sesame.admin.StdOutAdminListener;
import org.openrdf.sesame.config.ConfigurationException;
import org.openrdf.sesame.config.RepositoryConfig;
import org.openrdf.sesame.config.SailConfig;
import org.openrdf.sesame.constants.QueryLanguage;
import org.openrdf.sesame.constants.RDFFormat;
import org.openrdf.sesame.query.QueryResultsTable;
import org.openrdf.sesame.repository.local.LocalRepository;
import org.openrdf.sesame.repository.local.LocalService;

import uk.ac.soton.ecs.grimoires.jena.sesame.impl.GraphSesame;

/**
 * @author wf
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SesameTester extends Tester {
    
    private LocalRepository repo;
    
    public SesameTester() {
    	// create repository
        RepositoryConfig repConfig = new RepositoryConfig("myCustomRep");
//        SailConfig memSail = new org.openrdf.sesame.sailimpl.memory.RdfRepositoryConfig();
        SailConfig memSail = new org.openrdf.sesame.sailimpl.memory.RdfRepositoryConfig("c:\\sesame.rdf", RDFFormat.NTRIPLES);
        repConfig.addSail(memSail);
        repConfig.setWorldReadable(true);
        repConfig.setWorldWriteable(true);
        LocalService service = Sesame.getService();
        try {
			repo = service.createRepository(repConfig);
		} catch (ConfigurationException e) {
			e.printStackTrace();
            System.exit(1);
		}
    }
    
    protected void saveService() throws Exception {
        String baseURI = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
        boolean verifyData = true;
        AdminListener myListener = new DummyAdminListener(); //StdOutAdminListener();
        
        repo.addData(getInputStreamOfNextBusiness(), 
                baseURI, RDFFormat.RDFXML, verifyData, myListener);
        repo.addData(getInputStreamOfNexttModel(), 
                baseURI, RDFFormat.RDFXML, verifyData, myListener);
        repo.addData(getInputStreamOfNextService(), 
                baseURI, RDFFormat.RDFXML, verifyData, myListener);
//        org.openrdf.model.Graph sesameGraph = repo.getGraph();
//        ValueFactory factory = sesameGraph.getValueFactory();
//        
//        Resource subject = factory.createURI("http://abc.edf/sub");
//        URI predicate = factory.createURI("http://abc.edf/pre");
//        Value object = factory.createURI("http://abc.edf/obj");
//        
//        sesameGraph.add(subject, predicate, object);
               
	}

    protected void getService() throws Exception {
        String query = getQuery();
        QueryResultsTable resultsTable = repo.performTableQuery(QueryLanguage.RDQL, query);
        
        if (verbose) {
        	printResultsTable(resultsTable);
        }
	}
    
    private void printResultsTable(QueryResultsTable resultsTable) throws Exception {
        int rowCount = resultsTable.getRowCount();
        int columnCount = resultsTable.getColumnCount();
        
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                Value value = resultsTable.getValue(row, column);
                if (value != null) {
                    System.out.print(value.toString());
                }
                else {
                    System.out.print("null");
                }
                System.out.print("\t");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) throws Exception {
        dataFileName = "L:\\Documents and Settings\\wf\\My Documents\\Temp\\sesame-perf-file.txt";
        
    	new SesameTester().testServicePerformance();
    }
}
