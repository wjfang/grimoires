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

package uk.ac.soton.ecs.grimoires.server.impl.wsdl.api;

import java.rmi.RemoteException;
import java.util.Collection;

import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.AddWSDLFileAdvertRequest;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.FindServicesByInterfaceResponse;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GetAllWSDLFilesRequest;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GetAllWSDLFilesResponse;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GetOperationsByURLResponse;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessageDetail;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessagePartDetail;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WSDL;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.handlers.WSDLHandlerImplemented;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.AddWSDLFile;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.AddWSDLFileAdvert;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.FindServicesByInterface;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.GetAllWSDLFiles;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.GetWSDLAdvertContent;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.GetWSDLAdvertContentByURL;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.RemoveWSDLFile;
import uk.ac.soton.ecs.grimoires.server.impl.wsdl.message.WSDLHandler;
import uk.ac.soton.ecs.grimoires.server.impl.RegistryException;

public class WSDLTie implements WSDL {
	private WSDLHandler handler;

	public WSDLTie(WSDLHandler operationHandler) {
		handler = operationHandler;
	}

	/** 
	 * Add a WSDL file to the repository.
	 * @param	filename	url of wsdl file
     * @return 				WSDL key
     */
	public String addWSDLFile(String filename) throws RemoteException {
		//WSDLHandler handler = (WSDLHandler) ServerConfiguration.getDefaultAPI (WSDLHandler.class);
		AddWSDLFile message = new AddWSDLFile(filename);

		message.accept(handler);
		if (message.errorThrown()) {
			throw new RemoteException("addWSDLFile failed on server side",
					new RegistryException(message.getErrors()));
		}
		return (String) message.getResult();
	}

	/**
     * Add a WSDL file with content to the repository.
     * @param	filename	url of wsdl file
     * @param	advertContent	content of wsdl file
     * @return				WSDL key
     */
	public String addWSDLFileAdvert(AddWSDLFileAdvertRequest body)
			throws RemoteException {
		//WSDLHandler       handler = (WSDLHandler) ServerConfiguration.getDefaultAPI (WSDLHandler.class);
		AddWSDLFileAdvert message = new AddWSDLFileAdvert(body.getUrl(), body.getContent());

		message.accept(handler);
		if (message.errorThrown()) {
			throw new RemoteException(
					"addWSDLFileAdvert failed on server side",
					new RegistryException(message.getErrors()));
		}
		return (String) message.getResult();
	}

    /**
     * Return the WSDL content of the advert identified by the given key.
     * @param	key		WSDL key
     * @return			content of WSDL file
     */
	public String getWSDLAdvertContent(String key) throws RemoteException {
		//WSDLHandler          handler = (WSDLHandler) ServerConfiguration.getDefaultAPI (WSDLHandler.class);
		GetWSDLAdvertContent message = new GetWSDLAdvertContent(key);

		message.accept(handler);

		if (message.errorThrown()) {
			throw new RemoteException(
					"getWSDLAdvertContent failed on server side",
					new RegistryException(message.getErrors()));
		}
		return (String) message.getResult();
	}

    /**
     * Return the WSDL content of the advert identified by the url of WSDL.
     * @param	wsdlURL		url of WSDL file
     * @return			content of WSDL file
     */
	public String getWSDLAdvertContentByURL(String wsdlURL)
			throws RemoteException {
		//WSDLHandler               handler = (WSDLHandler) ServerConfiguration.getDefaultAPI (WSDLHandler.class);
		GetWSDLAdvertContentByURL message = new GetWSDLAdvertContentByURL(
				wsdlURL);

		message.accept(handler);
		if (message.errorThrown()) {
			throw new RemoteException(
					"getWSDLAdvertContentByURL failed on server side",
					new RegistryException(message.getErrors()));
		}
		return (String) message.getResult();
	}

    /** 
     * Remove a WSDL file from the repository.
     * @param 	filename	url of WSDL file
     * @return	true or false
     */
	public boolean removeWSDLFile(String filename) throws RemoteException {
		//WSDLHandler    handler = (WSDLHandler) ServerConfiguration.getDefaultAPI (WSDLHandler.class);
		RemoveWSDLFile message = new RemoveWSDLFile(filename);

		message.accept(handler);
		if (message.errorThrown()) {
			throw new RemoteException("removeWSDLFile failed on server side",
					new RegistryException(message.getErrors()));
		}
		return ((Boolean) message.getResult()).booleanValue();
		
	}

    /**
     * Return all services that are registered as implementing the WSDL interface
     * t the given URL.
     * @param	filename	url of wsdl file
     * @return				service keys
     */
	public FindServicesByInterfaceResponse findServicesByInterface(String filename)
			throws RemoteException {
		//WSDLHandler handler = (WSDLHandler) ServerConfiguration.getDefaultAPI (WSDLHandler.class);
		FindServicesByInterface message = new FindServicesByInterface(filename);
		message.accept(handler);
		if (message.errorThrown()) {
			throw new RemoteException(
					"findServicesByInterface failed on server side",
					new RegistryException(message.getErrors()));
		}
		return new FindServicesByInterfaceResponse((String[]) message.getResult());
	}

    /**
     * Return the URLs of all WSDL adverts.
     * @return	all urls of registered WSDLs
     */
	public GetAllWSDLFilesResponse getAllWSDLFiles(GetAllWSDLFilesRequest body) throws RemoteException {
		//WSDLHandler handler = (WSDLHandler) ServerConfiguration.getDefaultAPI (WSDLHandler.class);
		GetAllWSDLFiles message = new GetAllWSDLFiles();
		message.accept(handler);
		if (message.errorThrown()) {
			throw new RemoteException("getAllWSDLFiles failed on server side",
					new RegistryException(message.getErrors()));
		}
        String[] urls = (String[]) ((Collection) message.getResult()).toArray(new String[0]); 
		return new GetAllWSDLFilesResponse(urls);
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WSDL#getOperationsByURL(java.lang.String)
	 */
	public GetOperationsByURLResponse getOperationsByURL(String url) throws RemoteException {
		return new GetOperationsByURLResponse(((WSDLHandlerImplemented) handler).getOperationsByURL(url));
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WSDL#getInputMessageOfOperation(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail)
	 */
	public MessageDetail getInputMessageOfOperation(OperationDetail opDetail) throws RemoteException {
		return ((WSDLHandlerImplemented) handler).getInputMessageOfOperation(opDetail);
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WSDL#getOutputMessageOfOperation(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail)
	 */
	public MessageDetail getOutputMessageOfOperation(OperationDetail opDetail) throws RemoteException {
		return ((WSDLHandlerImplemented) handler).getOutputMessageOfOperation(opDetail);
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WSDL#getFaultMessageOfOperation(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail)
	 */
	public MessageDetail getFaultMessageOfOperation(OperationDetail opDetail) throws RemoteException {
		return ((WSDLHandlerImplemented) handler).getFaultMessageOfOperation(opDetail);
	}

	public String findInterfaceByOperation(OperationDetail body) throws RemoteException {
		return ((WSDLHandlerImplemented) handler).findInterfaceByOperation(body);
	}

	/* (non-Javadoc)
	 * @see uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WSDL#findOperationByMessage(uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessageDetail)
	 */
	public OperationDetail findOperationByMessagePart(MessagePartDetail body) throws RemoteException {
		return ((WSDLHandlerImplemented) handler).findOperationByMessagePart(body);
	}

}