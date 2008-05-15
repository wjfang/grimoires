/*
 * Created on 20-Mar-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.test.rdf;

import java.util.ArrayList;
import java.util.Iterator;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdql.Query;
import com.hp.hpl.jena.rdql.QueryEngine;
import com.hp.hpl.jena.rdql.QueryExecution;
import com.hp.hpl.jena.rdql.QueryResults;
import com.hp.hpl.jena.rdql.ResultBinding;

import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;
import uk.ac.soton.ecs.grimoires.server.configuration.TestConfiguration;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessagePartDetail;
import uk.ac.soton.ecs.grimoires.server.store.ReadWriteLock;

public class RDQLTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Configuration configuration = new TestConfiguration();
		Model model = configuration.getDefaultModel();
		ReadWriteLock lock = configuration.getDefaultModelLock();
        
        // Grimoires lock
        lock.beforeRead();
        
		String clause = 
        	"SELECT ?msgNamePart ?mpbag WHERE\n" +
            "  (?mnp, <rdf:type>, <wsdl:MessagePart>)\n" +
//            "  (?mnp, <metadata:hasMetadata>, ?metadata)\n" +
            "  (?mnp, <wsdl:hasName>, ?msgNamePart)\n" +
            "  (?msg, <wsdl:hasMessagePart>, ?mpbag)\n" +
            "  (?msg, <rdf:type>, <wsdl:Message>)\n" +
            "  (?mpbag, ?v, ?mnp)\n" +
            "  (?msg, <wsdl:hasQName>, ?qname)\n" +
            "  (?qname, <wsdl:hasLocalName>, ?msgName)\n" +
            "  (?qname, <wsdl:hasNameSpace>, ?msgNS)\n" +
            "USING\n" +
            "  wsdl FOR <http://www.mygrid.ecs.soton.ac.uk/wsdl.rdfs#>\n" +
            "  rdf FOR <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "  metadata FOR <http://www.mygrid.ecs.soton.ac.uk/metadata.rdfs#>";
	
		Query query = new Query(clause);
        query.setSource(model);
        QueryExecution qe = new QueryEngine(query);
        QueryResults results = qe.exec();
        
        ArrayList mpList = new ArrayList();
        for (Iterator iter = results; iter.hasNext();) {
        	ResultBinding res = (ResultBinding)iter.next();
        	MessagePartDetail mp = new MessagePartDetail();
        	mp.setMessageNamespace(res.get("msgNS").toString());
        	System.out.println(mp.getMessageNamespace());
        	mp.setMessageName(res.get("msgName").toString());
        	System.out.println(mp.getMessageName());
        	mp.setPartName(res.get("msgNamePart").toString());
        	System.out.println(mp.getPartName());        	
        	mpList.add(mp);
        }
        results.close();
		        
        // Grimoires unlock
        lock.afterRead();
	}

}
