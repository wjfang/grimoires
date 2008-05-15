/**
 * GrimoiresTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.rdf;

public class GrimoiresTestCase extends junit.framework.TestCase {
    public GrimoiresTestCase(java.lang.String name) {
        super(name);
    }

    public void testrdfSOAPWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new uk.ac.soton.ecs.grimoires.server.impl.rdf.GrimoiresLocator().getrdfSOAPAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new uk.ac.soton.ecs.grimoires.server.impl.rdf.GrimoiresLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1rdfSOAPInquire() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.rdf.RdfSOAPStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.rdf.RdfSOAPStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.rdf.GrimoiresLocator().getrdfSOAP();
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
        uk.ac.soton.ecs.grimoires.server.impl.rdf.InquireResponse value = null;
        value = binding.inquire(new uk.ac.soton.ecs.grimoires.server.impl.rdf.InquireRequest());
        // TBD - validate results
    }

}
