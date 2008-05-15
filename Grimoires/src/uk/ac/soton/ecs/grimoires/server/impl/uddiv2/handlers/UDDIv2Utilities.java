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


/* Change 1 */

/*
 * UDDIv2Utilities.java
 *
 * Created on 14 May 2004, 15:32
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import uk.ac.soton.ecs.grimoires.server.impl.Jena;
import uk.ac.soton.ecs.grimoires.server.impl.KeyImpl;
import uk.ac.soton.ecs.grimoires.server.impl.Message;
import uk.ac.soton.ecs.grimoires.server.impl.StoreException;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ErrInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.KeyedReference;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertion;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Result;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfo;
import uk.ac.soton.ecs.grimoires.server.store.ModelChanges;

public class UDDIv2Utilities {
    public static DispositionReport createSuccessReport() {
        DispositionReport dispositionReport = new DispositionReport();
        Result report = new Result();
        ErrInfo success = new ErrInfo();

        success.setErrCode("E_success");
        success.set_value("");
        report.setErrno(0);
        report.setErrInfo(success);
        dispositionReport.setResult(new Result[] { report });

        return dispositionReport;
    }

    public static DispositionReport createErrorReport(int errorNum,
            String errorCode, String errorInfo) {
        DispositionReport dispositionReport = new DispositionReport();
        Result report = new Result();
        ErrInfo error = new ErrInfo();

        error.setErrCode(errorCode);
        error.set_value(errorInfo);
        report.setErrno(errorNum);
        report.setErrInfo(error);
        dispositionReport.setResult(new Result[] { report });

        return dispositionReport;
    }

    public static Set findAssertionByPublisher(Model model, String publisher)
            throws StoreException {
        Iterator eachResource = findAssertionResourcesByPublisher(model,
                publisher).iterator();
        Set results = new HashSet();

        while (eachResource.hasNext()) {
            //results.add(new PublisherAssertion(model, (Resource) eachResource.next()));
            results.add(LoaderUtilities.loadPublisherAssertion(model, (Resource) eachResource.next()));
        }

        return results;
    }

    public static Set findAssertionResourcesByPublisher(Model model,
            String publisher) {
        Property hasAuthorizedName = model.createProperty(
                UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasAuthorizedName);
        ResIterator eachFound = model.listSubjectsWithProperty(
                hasAuthorizedName, publisher);
        Set results = new HashSet();
        Resource found;

        while (eachFound.hasNext()) {
            found = eachFound.nextResource();
            if (Jena.isType(model, found, UDDIv2RDF.myGridUDDIv2NS,
                    UDDIv2RDF.publisherAssertion)) {
                results.add(found);
            }
        }
        eachFound.close();

        return results;
    }

    public static Set findBusinessByPublisher(Model model, String publisher)
            throws StoreException {
        Property hasAuthorizedName = model.createProperty(
                UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasAuthorizedName);
        ResIterator eachFound = model.listSubjectsWithProperty(
                hasAuthorizedName, publisher);
        Set results = new HashSet();
        Resource found;

        while (eachFound.hasNext()) {
            found = eachFound.nextResource();
            if (Jena.isType(model, found, UDDIv2RDF.myGridUDDIv2NS,
                    UDDIv2RDF.businessEntity)) {
                results.add(LoaderUtilities.loadBusinessInfo(model, found));
            }
        }
        eachFound.close();

        return results;
    }

    public static Resource findKeyedReference(Model model,
            KeyedReference reference) {
        Resource tModel = Jena.getKeyedResource(model,
                UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasTModelKey, new KeyImpl(reference
                        .getTModelKey()));
        Property hasTModel = model.createProperty(UDDIv2RDF.myGridUDDIv2NS,
                UDDIv2RDF.hasTModel);
        Property hasKeyName = model.createProperty(UDDIv2RDF.myGridUDDIv2NS,
                UDDIv2RDF.hasKeyName);
        Property hasKeyValue = model.createProperty(UDDIv2RDF.myGridUDDIv2NS,
                UDDIv2RDF.hasKeyValue);
        ResIterator eachFound = model.listSubjectsWithProperty(hasTModel,
                tModel);
        Resource found;

        while (eachFound.hasNext()) {
            found = eachFound.nextResource();
            if (found.hasProperty(hasKeyName, reference.getKeyName())
                    && found.hasProperty(hasKeyValue, reference.getKeyValue())) {
                return found;
            }
        }
        eachFound.close();

        throw new NoSuchElementException("Cannot find keyed reference: "
                + reference);
    }

    public static Resource findPublisherAssertion(Model model,
            PublisherAssertion assertion) {
        Resource reference = findKeyedReference(model, assertion
                .getKeyedReference());
        Resource fromBusiness = Jena.getKeyedResource(model,
                UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasBusinessKey,
                new KeyImpl(assertion.getFromKey()));
        Resource toBusiness = Jena.getKeyedResource(model,
                UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasBusinessKey,
                new KeyImpl(assertion.getToKey()));
        Property hasReference = model.createProperty(UDDIv2RDF.myGridUDDIv2NS,
                UDDIv2RDF.hasKeyedReference);
        Property hasFrom = model.createProperty(UDDIv2RDF.myGridUDDIv2NS,
                UDDIv2RDF.hasFromBusiness);
        Property hasTo = model.createProperty(UDDIv2RDF.myGridUDDIv2NS,
                UDDIv2RDF.hasToBusiness);
        ResIterator eachFound = model.listSubjectsWithProperty(hasReference,
                reference);
        Resource found;

        while (eachFound.hasNext()) {
            found = eachFound.nextResource();
            if (found.hasProperty(hasFrom, fromBusiness)
                    && found.hasProperty(hasTo, toBusiness)) {
                return found;
            }
        }
        eachFound.close();

        throw new NoSuchElementException("Cannot find publisher assertion: "
                + assertion);
    }

    public static Set findTModelByPublisher(Model model, String publisher)
            throws StoreException {
        Property hasAuthorizedName = model.createProperty(
                UDDIv2RDF.myGridUDDIv2NS, UDDIv2RDF.hasAuthorizedName);
        ResIterator eachFound = model.listSubjectsWithProperty(
                hasAuthorizedName, publisher);
        Set results = new HashSet();
        Resource found;

        while (eachFound.hasNext()) {
            found = eachFound.nextResource();
            if (Jena.isType(model, found, UDDIv2RDF.myGridUDDIv2NS,
                    UDDIv2RDF.tModel)) {
                //results.add(new TModelInfo(model, found));
                results.add(LoaderUtilities.loadTModelInfo(model, found));
            }
        }
        eachFound.close();

        return results;
    }

    public static void saveAssertions(Model readingModel, ModelChanges changes,
            Message saveMessage, PublisherAssertion[] assertions) {
        Iterator eachAssert = Arrays.asList(assertions).iterator();
        PublisherAssertion entity;

        while (eachAssert.hasNext()) {
            try {
                entity = (PublisherAssertion) eachAssert.next();
                //((SerializableDataModel) entity).saveToStore(changes.getAdditionsModel());
                SaveHandler.saveToStore(entity, changes.getAdditionsModel());
            } catch (Exception couldntSave) {
                saveMessage.addError(couldntSave);
            }
        }
    }
}