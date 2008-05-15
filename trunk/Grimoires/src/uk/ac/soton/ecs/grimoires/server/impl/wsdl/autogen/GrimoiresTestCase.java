/**
 * GrimoiresTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen;

public class GrimoiresTestCase extends junit.framework.TestCase {
    public GrimoiresTestCase(java.lang.String name) {
        super(name);
    }

    public void testwsdlWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator().getwsdlAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1wsdlAddWSDLFileAdvert() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator().getwsdl();
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
        java.lang.String value = null;
        value = binding.addWSDLFileAdvert(new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.AddWSDLFileAdvertRequest());
        // TBD - validate results
    }

    public void test2wsdlAddWSDLFile() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator().getwsdl();
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
        java.lang.String value = null;
        value = binding.addWSDLFile(new java.lang.String());
        // TBD - validate results
    }

    public void test3wsdlGetWSDLAdvertContent() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator().getwsdl();
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
        java.lang.String value = null;
        value = binding.getWSDLAdvertContent(new java.lang.String());
        // TBD - validate results
    }

    public void test4wsdlGetWSDLAdvertContentByURL() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator().getwsdl();
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
        java.lang.String value = null;
        value = binding.getWSDLAdvertContentByURL(new java.lang.String());
        // TBD - validate results
    }

    public void test5wsdlRemoveWSDLFile() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator().getwsdl();
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
        boolean value = false;
        value = binding.removeWSDLFile(new java.lang.String());
        // TBD - validate results
    }

    public void test6wsdlFindServicesByInterface() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator().getwsdl();
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
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.FindServicesByInterfaceResponse value = null;
        value = binding.findServicesByInterface(new java.lang.String());
        // TBD - validate results
    }

    public void test7wsdlGetAllWSDLFiles() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator().getwsdl();
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
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GetAllWSDLFilesResponse value = null;
        value = binding.getAllWSDLFiles(new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GetAllWSDLFilesRequest());
        // TBD - validate results
    }

    public void test8wsdlGetOperationsByURL() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator().getwsdl();
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
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GetOperationsByURLResponse value = null;
        value = binding.getOperationsByURL(new java.lang.String());
        // TBD - validate results
    }

    public void test9wsdlGetInputMessageOfOperation() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator().getwsdl();
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
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessageDetail value = null;
        value = binding.getInputMessageOfOperation(new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail());
        // TBD - validate results
    }

    public void test10wsdlGetOutputMessageOfOperation() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator().getwsdl();
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
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessageDetail value = null;
        value = binding.getOutputMessageOfOperation(new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail());
        // TBD - validate results
    }

    public void test11wsdlGetFaultMessageOfOperation() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator().getwsdl();
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
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessageDetail value = null;
        value = binding.getFaultMessageOfOperation(new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail());
        // TBD - validate results
    }

    public void test12wsdlFindInterfaceByOperation() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator().getwsdl();
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
        java.lang.String value = null;
        value = binding.findInterfaceByOperation(new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail());
        // TBD - validate results
    }

    public void test13wsdlFindOperationByMessagePart() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.WsdlSoapBindingStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.GrimoiresLocator().getwsdl();
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
        uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.OperationDetail value = null;
        value = binding.findOperationByMessagePart(new uk.ac.soton.ecs.grimoires.server.impl.wsdl.autogen.MessagePartDetail());
        // TBD - validate results
    }

}
