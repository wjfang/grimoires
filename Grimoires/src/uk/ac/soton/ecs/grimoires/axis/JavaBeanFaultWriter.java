package uk.ac.soton.ecs.grimoires.axis;

import org.apache.axis.wsdl.toJava.Emitter;
import org.apache.axis.wsdl.toJava.JavaWriter;
import org.apache.axis.wsdl.symbolTable.TypeEntry;
import java.util.Vector;

public class JavaBeanFaultWriter extends org.apache.axis.wsdl.toJava.JavaBeanFaultWriter {

    public JavaBeanFaultWriter(
            Emitter emitter,
            TypeEntry type,
            Vector elements,
            TypeEntry extendType,
            Vector attributes,
            JavaWriter helper) {
        super(emitter, type, elements, 
              extendType, attributes, helper);
    }
}
