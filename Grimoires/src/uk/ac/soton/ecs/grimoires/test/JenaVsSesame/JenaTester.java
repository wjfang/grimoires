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

import java.util.Iterator;

import uk.ac.soton.ecs.grimoires.jena.sesame.ModelSesame;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdql.Query;
import com.hp.hpl.jena.rdql.QueryEngine;
import com.hp.hpl.jena.rdql.QueryExecution;
import com.hp.hpl.jena.rdql.QueryResults;
import com.hp.hpl.jena.rdql.ResultBinding;

/**
 * @author wf
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class JenaTester extends Tester {

	Model model;
    
    public JenaTester() {
    	//model = ModelFactory.createDefaultModel();
        model = ModelSesame.createDefaultModel();
    }
    
	protected void saveService() throws Exception {
		model.read(getInputStreamOfNextBusiness(), null);
        model.read(getInputStreamOfNexttModel(), null);
        model.read(getInputStreamOfNextService(), null);
        
//        java.util.Iterator it = model.listStatements();
//        int count = 0;
//        while (it.hasNext()) {
//            it.next();
//        	count++;
//        }
//        System.out.println("One service contains " + count + " statements.");
        
        if (verbose) {
            System.out.println("No." + getIndex() + " service published.");
        }
	}

	protected void getService() throws Exception {
        String queryString = getQuery();
        Query query = new Query(queryString) ;
        // Need to set the source if the query does not.
        query.setSource(model);
        QueryExecution qe = new QueryEngine(query);
        QueryResults results = qe.exec();
        
        if (verbose) {
            printResults(results);
        }
	}
    
	private void printResults(QueryResults results) {
        // each time find two services with identical key in Sesame model
//      for (Iterator iter = results; iter.hasNext();) {
//          ResultBinding res = (ResultBinding)iter.next();
//          System.out.println(res.get("key")); // "key" is the variable in service.rdql
//      }
      Iterator iter = results;
      if (iter.hasNext()) {
          ResultBinding res = (ResultBinding)iter.next();
          System.out.println(res.get("key")); // "key" is the variable in service.rdql
      }
      results.close();
	}

	public static void main(String[] args) throws Exception {
        dataFileName = "L:\\Documents and Settings\\wf\\My Documents\\Temp\\jena-perf.txt";
        
        new JenaTester().testServicePerformance();
    }
}
