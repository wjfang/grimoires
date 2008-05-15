/**
 * GrimoiresTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry;

public class GrimoiresTestCase extends junit.framework.TestCase {
    public GrimoiresTestCase(java.lang.String name) {
        super(name);
    }

    public void testinquireWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator().getinquireAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1inquireFind_binding() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator().getinquire();
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
            value = binding.find_binding(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_binding());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test2inquireFind_business() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator().getinquire();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList value = null;
            value = binding.find_business(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_business());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test3inquireFind_relatedBusinesses() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator().getinquire();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessesList value = null;
            value = binding.find_relatedBusinesses(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_relatedBusinesses());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test4inquireFind_service() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator().getinquire();
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
            value = binding.find_service(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_service());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test5inquireFind_tModel() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator().getinquire();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelList value = null;
            value = binding.find_tModel(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_tModel());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test6inquireGet_bindingDetail() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator().getinquire();
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
            value = binding.get_bindingDetail(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_bindingDetail());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test7inquireGet_businessDetail() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator().getinquire();
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
            value = binding.get_businessDetail(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetail());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test8inquireGet_businessDetailExt() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator().getinquire();
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
            uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetailExt value = null;
            value = binding.get_businessDetailExt(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetailExt());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test9inquireGet_serviceDetail() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator().getinquire();
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
            value = binding.get_serviceDetail(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_serviceDetail());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test10inquireGet_tModelDetail() throws Exception {
        uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub binding;
        try {
            binding = (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.InquireSoapStub)
                          new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry.GrimoiresLocator().getinquire();
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
            value = binding.get_tModelDetail(new uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_tModelDetail());
        }
        catch (uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport e1) {
            throw new junit.framework.AssertionFailedError("error Exception caught: " + e1);
        }
            // TBD - validate results
    }

}
