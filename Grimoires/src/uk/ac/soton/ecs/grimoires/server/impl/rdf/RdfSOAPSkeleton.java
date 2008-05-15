/**
 * RdfSOAPSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.rdf;

public class RdfSOAPSkeleton implements uk.ac.soton.ecs.grimoires.server.impl.rdf.RDF, org.apache.axis.wsdl.Skeleton {
    private uk.ac.soton.ecs.grimoires.server.impl.rdf.RDF impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/rdf", "inquireRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.grimoires.org/rdf", "inquireRequest"), uk.ac.soton.ecs.grimoires.server.impl.rdf.InquireRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("inquire", _params, new javax.xml.namespace.QName("http://www.grimoires.org/rdf", "inquireResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.grimoires.org/rdf", "inquireResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "inquire"));
        _oper.setSoapAction("http://www.grimoires.org/rdf/inquire");
        _myOperationsList.add(_oper);
        if (_myOperations.get("inquire") == null) {
            _myOperations.put("inquire", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("inquire")).add(_oper);
    }

    public RdfSOAPSkeleton() {
        this.impl = new uk.ac.soton.ecs.grimoires.server.impl.rdf.RdfSOAPImpl();
    }

    public RdfSOAPSkeleton(uk.ac.soton.ecs.grimoires.server.impl.rdf.RDF impl) {
        this.impl = impl;
    }
    public uk.ac.soton.ecs.grimoires.server.impl.rdf.InquireResponse inquire(uk.ac.soton.ecs.grimoires.server.impl.rdf.InquireRequest inquireRequest) throws java.rmi.RemoteException
    {
        uk.ac.soton.ecs.grimoires.server.impl.rdf.InquireResponse ret = impl.inquire(inquireRequest);
        return ret;
    }

}
