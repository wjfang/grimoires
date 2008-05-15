/*
 * Created on 25-Apr-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.test.misc;

import com.hp.hpl.jena.rdf.model.Bag;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class JenaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Model model = ModelFactory.createDefaultModel();
		Bag bag = model.createBag();
		Resource r1 = model.createResource();
		bag.add(r1);
		Resource r2 = model.createResource();
		bag.add(r2);
		model.write(System.out, "N-TRIPLE");
		System.out.println("========");
		StmtIterator it = model.listStatements(bag, null, r1);
//		while (it.hasNext()) {
			bag.remove(it.nextStatement());
//		}
		model.write(System.out, "N-TRIPLE");
	}

}
