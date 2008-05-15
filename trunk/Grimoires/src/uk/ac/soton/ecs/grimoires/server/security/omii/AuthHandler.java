// The OMII (Open Middleware Infrastructure Institute) distribution
// comprises open source software from different sources with different
// licences. All of the software developed by OMII is provided under the
// Modified BSD licence as given below. Licences for all other software
// may be found in the top level 'licenses' directory.

// Copyright (c) 2005, OMII, University of Southampton. All rights
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


package uk.ac.soton.ecs.grimoires.server.security.omii;

import org.apache.axis.AxisFault;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;
import org.apache.log4j.Logger;

import java.security.Principal;

import uk.ac.soton.ecs.grimoires.server.security.AccessController;
import uk.ac.soton.ecs.grimoires.server.security.GrimoiresAuthorizationException;
import uk.ac.soton.itinnovation.grid.gridservit.context.ServiceContext;
import uk.ac.soton.itinnovation.grid.gridservit.GridConstants;
import uk.ac.soton.itinnovation.grid.utils.DNParser;

import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
import java.util.*;

import java.util.Iterator;
import java.util.ArrayList;

/**
 * Authorization handler sits at the end of chain of handlers at the server side. It intercepts
 * a verified signed SOAP message, extracts the requested operation and X509DN and then decides
 * whether the operation is permitted on the basis of an XML-based access control list on file.
 * It uses the auth parameter from grimoires.properties to located this access control list file.
 * If operation is not permitted, an Axis fault with an appropriate message is thrown.
 *
 * @author  vt
 * Created 9 September 2005
 *
 */

public class AuthHandler extends BasicHandler {

	private Logger logger = Logger.getLogger(this.getClass()); 

	private AccessController accessController;
	
	/**
	 * invoke method automatically called in the handler chain when an incoming SOAP message occurs
	 */
	public void invoke(MessageContext msgContext) throws AxisFault {
		logger.info("Authorization handler in operation");

		if (accessController == null)
			accessController = AccessController.getInstance();

		try {
			// Obtain the X509DN from the message context, and the requested
			// operation from
			// the SOAP body
			String userSubjectDN, requestedOperation;
			ServiceContext servCtx = (ServiceContext) msgContext
					.getProperty(GridConstants.AXIS_CONTEXT_OBJECT_IDENTIFIER);
			Principal subjectDN = servCtx.getEScienceContext()
					.getSecurityContext().getAuthenticatedSubjectPrincipal();
			userSubjectDN = new DNParser(subjectDN.toString())
					.getStandardStringDN();
			SOAPMessage soapMsg = msgContext.getMessage();
			SOAPBody soapBody = soapMsg.getSOAPPart().getEnvelope().getBody();
			Iterator children = soapBody.getChildElements();
			requestedOperation = (((SOAPElement) children.next())
					.getElementName()).getLocalName();

			logger.info("X509DN Subject DN : " + userSubjectDN
					+ " requesting operation : " + requestedOperation);

			accessController.checkRequestValidity(userSubjectDN,
					requestedOperation);
			logger.info("Requesting operation authorized ");
		} catch (uk.ac.soton.itinnovation.grid.gridservit.context.ContextUnavailableException cue) {
			logger.fatal("Unable to retrieve necessary security context");
			throw AxisFault.makeFault(cue);
		} catch (javax.xml.soap.SOAPException soe) {
			logger.fatal("Unable to interpret SOAP body correctly");
			throw AxisFault.makeFault(soe);
		} catch (GrimoiresAuthorizationException e) {
			throw AxisFault.makeFault(e);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}
}
