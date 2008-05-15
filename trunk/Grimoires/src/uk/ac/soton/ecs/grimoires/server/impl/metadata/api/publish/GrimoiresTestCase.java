/**
 * GrimoiresTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.api.publish;

public class GrimoiresTestCase extends junit.framework.TestCase {
    public GrimoiresTestCase(java.lang.String name) {
        super(name);
    }

    public void testpublish_metadataWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.publish.GrimoiresLocator().getpublish_metadataAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.publish.GrimoiresLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1publish_metadataAddMetadataToEntity() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.publish.GrimoiresLocator().getpublish_metadata();
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
            value = binding.addMetadataToEntity(new uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.AddMetadataToEntity());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test2publish_metadataDeleteMetadata() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.metadata.api.PublishMetadataSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.publish.GrimoiresLocator().getpublish_metadata();
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
            boolean value = false;
            value = binding.deleteMetadata(new uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.DeleteMetadata());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

}
