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
 * Copyright 2003 The University of Southampton
 *
 *   
 *  Simon Miles - 2003
 *  Luc Moreau  - 2003
 *  Juri Papay  - 2003
 *
 *  This file is part of myGrid.  Further information, and the
 *  latest version, can be found at http://www.mygrid.org.uk
 *
 *  myGrid is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as
 *  published by the Free Software Foundation; either version 2.1
 *  of the License, or (at your option) any later version.
 *
 *  myGrid is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with myGrid; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package uk.ac.soton.ecs.grimoires.server.impl.wsdl.message;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Vector;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail;
import uk.ac.soton.ecs.grimoires.server.impl.AbstractMessage;
import uk.ac.soton.ecs.grimoires.server.impl.RDQLQueryQualifier;
import uk.ac.soton.ecs.grimoires.server.impl.SupportsRDQLQuery;
import uk.ac.soton.ecs.grimoires.server.impl.VariableGenerator;
import uk.ac.soton.ecs.grimoires.server.impl.Message;

public class FindServicesByInterface extends AbstractMessage implements
		Message, SupportsRDQLQuery {
	private String filename;

	public FindServicesByInterface(String intfFilename) {
		filename = intfFilename;
	}

	public String getWSDLFile() {
		return filename;
	}

	public void setWSDLFile(String filename) {
		this.filename = filename;
	}

	public Object accept(WSDLHandler v) {
		return v.process(this);
	}

	/** Generates part of a rdql query.
	 @param variables the set of variables over which the query occurs
	 @param namespaces a hastable of namesspaces already produced
	 @param statements a sequence of rdql statements already generated
	 @param constraints a sequence of constraints to be satisfied
	 @param variableGenerator a generator of new variables
	 @param qualifier a query qualifier to control the generation of RDQL
	 @return the name of the variable for the current context.
	 */
	public String generateRdqlQuery(Vector variables, Hashtable namespaces,
			Vector statements, Vector constraints,
			VariableGenerator variableGenerator, RDQLQueryQualifier qualifier) {

		String findServiceKeyVar = variableGenerator.next("serviceKey");
		String businessServiceVar = variableGenerator.next("businessService");
		String bindBagVar = variableGenerator.next("bindingTemplateBag");
		String bindTempVar = variableGenerator.next("bindingTemplate");
		String tModelInstDetVar = variableGenerator
				.next("tModelInstanceDetails");
		String tModelInstInfoVar = variableGenerator.next("tModelInstanceInfo");
		String instDetsVar = variableGenerator.next("instanceDetails");
		String overviewDocVar = variableGenerator.next("overviewDoc");
		String tModelKeyVar = variableGenerator.next("tModelKey");

		statements.add("(" + businessServiceVar + ", <uddi:hasServiceKey>, "
				+ findServiceKeyVar + ")");
		statements.add("(" + businessServiceVar + ", <uddi:hasBindingTemplate>, "
				+ bindBagVar + ")");
		statements.add("(" + bindBagVar + ", " + variableGenerator.next()
				+ ", " + bindTempVar + ")");
		statements.add("(" + bindTempVar + ", <uddi:hastModelInstanceDetail>, "
				+ tModelInstDetVar + ")");
		statements.add("(" + tModelInstDetVar + ", " + variableGenerator.next()
				+ ", " + tModelInstInfoVar + ")");
		statements.add("(" + tModelInstInfoVar + ", <uddi:hasTModel>, "
				+ tModelKeyVar + ")");
//		statements.add("(" + tModelInstInfoVar + ", <uddi:hasInstanceDetail>, "
//				+ instDetsVar + ")");
		statements.add("(" + instDetsVar + ", <uddi:hasTModelKey>,    "
				+ tModelKeyVar + ")");
		statements.add("(" + instDetsVar + ", <uddi:hasOverviewDoc>,    "
				+ overviewDocVar + ")");
		statements.add("(" + overviewDocVar + ", <uddi:hasOverviewURL>,    "
				+ "\"" + filename + "\")");

		return findServiceKeyVar;
	}
}