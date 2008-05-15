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
 * ModelChanges.java
 *
 * Created on 13 May 2004, 12:43
 */

package uk.ac.soton.ecs.grimoires.server.store;

import java.util.logging.Logger;
import java.io.ByteArrayOutputStream;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;

/**
 * A temporary store to record all the changes made to be made to the registry model.
 * The store contains two temporary model: one for the statements that are
 * to be added, one for the statements that are to be removed. Clients should
 * use getAdditionsModel () and getRemovalsModel () to add or otherwise
 * manipulate these, then commit () to make the changes to the registry model.
 */
public class ModelChanges {
	final private Model additions;

	final private Model removals;

	private Configuration configuration;

	/** Creates a new instance of ModelChanges */
	public ModelChanges(Configuration configuration) {
		this.configuration = configuration;
		additions = ModelFactory.createDefaultModel();
		removals = ModelFactory.createDefaultModel();
	}

	/**
	 * Remove the triples in the removals model from the given model, then add
	 * all the triples in the additions model.
	 */
	public void commit() {
		Model commitInto = configuration.getDefaultModel();

		configuration.getDefaultModelLock().beforeWrite();
		commitInto.remove(removals);
		commitInto.add(additions);

		// debug print
		// 	Logger logger = Logger.getLogger("org.grimoires.debug");
		// 	ByteArrayOutputStream os = new ByteArrayOutputStream();
		// 	commitInto.write(os);
		// 	logger.fine(os.toString());

//		System.out.println("======== REMOVAL begins ========");
//		removals.write(System.out);
//        System.out.println("======== REMOVAL ends ========");
//        System.out.println("======== ADDITION begins ========");
//		additions.write(System.out);
//        System.out.println("======== ADDITION ends ========");

		configuration.getDefaultModelLock().afterWrite();
	}

	/**
	 * Returns the model to which new statements should be added.
	 */
	public Model getAdditionsModel() {
		return additions;
	}

	/**
	 * Returns the model to which statements to be removed should be added.
	 */
	public Model getRemovalsModel() {
		return removals;
	}
}