/**
 * GrimoiresTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.metadata.api.uddi;

public class GrimoiresTestCase extends junit.framework.TestCase {
    public GrimoiresTestCase(java.lang.String name) {
        super(name);
    }

    public void testinquire_uddiMetadataWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.uddi.GrimoiresLocator().getinquire_uddiMetadataAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.uddi.GrimoiresLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1inquire_uddiMetadataFind_service() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireUddiMetadataSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.metadata.api.InquireUddiMetadataSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.metadata.api.uddi.GrimoiresLocator().getinquire_uddiMetadata();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList value = null;
            value = binding.find_service(new uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.Find_service());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

}
