package uk.ac.soton.ecs.grimoires.test.misc;

import java.io.CharArrayWriter;
import com.ibm.wsdl.xml.WSDLWriterImpl;
import com.ibm.wsdl.InputImpl;
import com.ibm.wsdl.MessageImpl;
import com.ibm.wsdl.OperationImpl;
import com.ibm.wsdl.OutputImpl;
import com.ibm.wsdl.PartImpl;
import com.ibm.wsdl.PortTypeImpl;
import javax.wsdl.Definition;
import javax.wsdl.Input;
import javax.wsdl.Message;
import javax.wsdl.Operation;
import javax.wsdl.Output;
import javax.wsdl.Part;
import javax.wsdl.PortType;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.xml.namespace.QName;

/**
 * A convenience class for constructing WSDL4J Definitions where the WSDL
 * has only one port type with one operation, both of which are given default
 * names.  Useful for interfaces of certain service types, e.g. scripts or workflows.
 */
public class ComplexWSDLBuilder {
    private Definition intf;
    private PortType currentPortType;
    private Operation currentOperation;
    private Message currentInMsg;
    private Message currentOutMsg;

    public static void main(String[] argv) throws Exception {
        ComplexWSDLBuilder builder = new ComplexWSDLBuilder(
                "http://www.tns.com/interface");
        builder.addPortType("DefaultInterface");
        builder.addOperation("adaptor::chromoadaptor");
        builder.addInputPart("inchromo", null);
        builder.addOutputPart("report", "string");
        builder.addOutputPart("detailed_status", "string");
        builder.addOutputPart("outchromo", "string");
        System.out.println(builder.getResult());
        QName qn = new QName("abc");
        System.out.println("namespace uri:" + qn.getNamespaceURI());
        System.out.println("local part:" + qn.getLocalPart());
        System.out.println("prefix:" + qn.getPrefix());
    }

    public ComplexWSDLBuilder(String tns) throws WSDLException {
        WSDLFactory factory = WSDLFactory.newInstance();

        intf = factory.newDefinition();
        intf.setTargetNamespace(tns);
        intf.addNamespace("tns", tns);
        intf.addNamespace("xsd", "http://www.w3.org/2001/XMLSchema");
    }

    public void addNamespace(String prefix, String nsURI) {
        intf.addNamespace(prefix, nsURI);
    }

    public void addPortType(String name) {
        currentPortType = new PortTypeImpl();
        currentPortType.setUndefined(false);
        intf.addPortType(currentPortType);
        currentPortType.setQName(new QName(name));
    }

    public Operation addOperation(String name) {
        currentOperation = new OperationImpl();
        currentOperation.setName(name);

        Input input = new InputImpl();
        currentInMsg = new MessageImpl();
        currentInMsg.setUndefined(false);
        QName qn = new QName(intf.getNamespace("tns"), "request");
        currentInMsg.setQName(qn);
        System.out.println("namespace uri:" + qn.getNamespaceURI());
        System.out.println("local part:" + qn.getLocalPart());
        System.out.println("prefix:" + qn.getPrefix());
        input.setMessage(currentInMsg);
        currentOperation.setInput(input);
        intf.addMessage(currentInMsg);

        Output output = new OutputImpl();
        currentOutMsg = new MessageImpl();
        currentOutMsg.setUndefined(false);
        currentOutMsg.setQName(new QName(intf.getNamespace("tns"), "response"));
        output.setMessage(currentOutMsg);
        currentOperation.setOutput(output);
        intf.addMessage(currentOutMsg);

        currentOperation.setUndefined(false);
        currentPortType.addOperation(currentOperation);
        return currentOperation;
    }

    public Part addInputPart(String name, String type) {
        Part param = new PartImpl();
        param.setName(name);
        if (type == null) {
            param.setTypeName(new QName(intf.getNamespace("xsd"), "string"));
        } else {
            param.setTypeName(new QName(intf.getNamespace("xsd"), type));
        }
        currentInMsg.addPart(param);
        return param;
    }

    public Part addOutputPart(String name, String type) {
        Part param = new PartImpl();
        param.setName(name);
        if (type == null) {
            param.setTypeName(new QName(intf.getNamespace("xsd"), "string"));
        } else {
            param.setTypeName(new QName(intf.getNamespace("xsd"), type));
        }
        currentOutMsg.addPart(param);
        return param;
    }

    public String getResult() throws Exception {
        CharArrayWriter writer = new CharArrayWriter();
        new WSDLWriterImpl().writeWSDL(intf, writer);
        writer.close();
        return writer.toString();
    }
}
