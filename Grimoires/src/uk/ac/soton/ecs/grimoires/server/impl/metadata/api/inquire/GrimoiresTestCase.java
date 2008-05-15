/**
 * GrimoiresTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.api.inquire;

public class GrimoiresTestCase extends junit.framework.TestCase {
    public GrimoiresTestCase(java.lang.String name) {
        super(name);
    }

    public void testinquire_metadataWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.inquire.GrimoiresLocator().getinquire_metadataAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.inquire.GrimoiresLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1inquire_metadataGet_metadataDetail() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.inquire.GrimoiresLocator().getinquire_metadata();
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
            uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfo value = null;
            value = binding.get_metadataDetail(new uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_metadataDetail());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test2inquire_metadataFind_entityByMetadata() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.inquire.GrimoiresLocator().getinquire_metadata();
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
            uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.EntityReferenceList value = null;
            value = binding.find_entityByMetadata(new uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_entityByMetadata());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test3inquire_metadataGet_entityMetadata() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.inquire.GrimoiresLocator().getinquire_metadata();
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
            uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.MetadataInfos value = null;
            value = binding.get_entityMetadata(new uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_entityMetadata());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test4inquire_metadataGet_supportedEntityType() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireMetadataSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.inquire.GrimoiresLocator().getinquire_metadata();
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
            value = binding.get_supportedEntityType(new uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Get_supportedEntityType());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

}
