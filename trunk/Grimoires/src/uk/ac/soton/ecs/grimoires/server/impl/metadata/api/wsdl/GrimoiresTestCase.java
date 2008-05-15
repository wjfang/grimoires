/**
 * GrimoiresTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.api.wsdl;

public class GrimoiresTestCase extends junit.framework.TestCase {
    public GrimoiresTestCase(java.lang.String name) {
        super(name);
    }

    public void testinquire_wsdlMetadataWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.wsdl.GrimoiresLocator().getinquire_wsdlMetadataAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.wsdl.GrimoiresLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1inquire_wsdlMetadataFind_interfaceByMessagePartMetadata() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireWsdlMetadataSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireWsdlMetadataSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.wsdl.GrimoiresLocator().getinquire_wsdlMetadata();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        try {
            uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.UriBag value = null;
            value = binding.find_interfaceByMessagePartMetadata(new uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_interfaceByMessagePartMetadata());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test2inquire_wsdlMetadataFind_interfaceByOperationMetadata() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireWsdlMetadataSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireWsdlMetadataSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.wsdl.GrimoiresLocator().getinquire_wsdlMetadata();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        try {
            uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.UriBag value = null;
            value = binding.find_interfaceByOperationMetadata(new uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_interfaceByOperationMetadata());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test3inquire_wsdlMetadataFind_operation() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireWsdlMetadataSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireWsdlMetadataSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.wsdl.GrimoiresLocator().getinquire_wsdlMetadata();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        try {
            uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.OperationReferenceList value = null;
            value = binding.find_operation(new uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_operation());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

}
