/**
 * EchoSOAPSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.test.echo;

public class EchoSOAPSkeleton implements uk.ac.soton.ecs.grimoires.test.echo.Echo_PortType, org.apache.axis.wsdl.Skeleton {
    private uk.ac.soton.ecs.grimoires.test.echo.Echo_PortType impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.grimoires.org/echo/", "echoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("echo", _params, new javax.xml.namespace.QName("http://www.grimoires.org/echo/", "echoResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "echo"));
        _oper.setSoapAction("http://www.grimoires.org/echo/echo");
        _myOperationsList.add(_oper);
        if (_myOperations.get("echo") == null) {
            _myOperations.put("echo", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("echo")).add(_oper);
    }

    public EchoSOAPSkeleton() {
        this.impl = new uk.ac.soton.ecs.grimoires.test.echo.EchoSOAPImpl();
    }

    public EchoSOAPSkeleton(uk.ac.soton.ecs.grimoires.test.echo.Echo_PortType impl) {
        this.impl = impl;
    }
    public java.lang.String echo(java.lang.String parameters) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.echo(parameters);
        return ret;
    }

}
