/**
 * GrimoiresTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication;

public class GrimoiresTestCase extends junit.framework.TestCase {
    public GrimoiresTestCase(java.lang.String name) {
        super(name);
    }

    public void testpublishWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator().getpublishAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1publishAdd_publisherAssertions() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator().getpublish();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport value = null;
            value = binding.add_publisherAssertions(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Add_publisherAssertions());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test2publishDelete_binding() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator().getpublish();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport value = null;
            value = binding.delete_binding(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_binding());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test3publishDelete_business() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator().getpublish();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport value = null;
            value = binding.delete_business(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_business());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test4publishDelete_publisherAssertions() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator().getpublish();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport value = null;
            value = binding.delete_publisherAssertions(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_publisherAssertions());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test5publishDelete_service() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator().getpublish();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport value = null;
            value = binding.delete_service(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_service());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test6publishDelete_tModel() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator().getpublish();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport value = null;
            value = binding.delete_tModel(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_tModel());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test7publishDiscard_authToken() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator().getpublish();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport value = null;
            value = binding.discard_authToken(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Discard_authToken());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test8publishGet_assertionStatusReport() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator().getpublish();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusReport value = null;
            value = binding.get_assertionStatusReport(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_assertionStatusReport());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test9publishGet_authToken() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator().getpublish();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AuthToken value = null;
            value = binding.get_authToken(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_authToken());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test10publishGet_publisherAssertions() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator().getpublish();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertions value = null;
            value = binding.get_publisherAssertions(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_publisherAssertions());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test11publishGet_registeredInfo() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator().getpublish();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RegisteredInfo value = null;
            value = binding.get_registeredInfo(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_registeredInfo());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test12publishSave_binding() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator().getpublish();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail value = null;
            value = binding.save_binding(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_binding());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test13publishSave_business() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator().getpublish();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail value = null;
            value = binding.save_business(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_business());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test14publishSave_service() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator().getpublish();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail value = null;
            value = binding.save_service(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_service());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test15publishSave_tModel() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator().getpublish();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail value = null;
            value = binding.save_tModel(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_tModel());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test16publishSet_publisherAssertions() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.PublishSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication.GrimoiresLocator().getpublish();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertions value = null;
            value = binding.set_publisherAssertions(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Set_publisherAssertions());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

}
