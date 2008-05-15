package uk.ac.soton.ecs.grimoires.axis;

import org.apache.axis.wsdl.toJava.JavaWriter;
import org.apache.axis.wsdl.toJava.Emitter;
import org.apache.axis.wsdl.symbolTable.TypeEntry;
import org.apache.axis.wsdl.symbolTable.SymbolTable;

import java.util.Vector;

public class JavaTypeWriter
    extends org.apache.axis.wsdl.toJava.JavaTypeWriter {

	
    public JavaTypeWriter(
			  Emitter emitter,
			  TypeEntry type,
			  SymbolTable symbolTable) {
	super(emitter,type,symbolTable);

//	System.out.println("JavaTypeWriter");
				  
    }

    /*
     * Axis 1.2RC changed the interface of getBeanWriter();
     */

    /* (non-Javadoc)
	 * @see org.apache.axis.wsdl.toJava.JavaTypeWriter#getBeanWriter(org.apache.axis.wsdl.toJava.Emitter, org.apache.axis.wsdl.symbolTable.TypeEntry, org.apache.axis.wsdl.symbolTable.TypeEntry)
	 */
	protected JavaWriter getBeanWriter(Emitter emitter, TypeEntry type, TypeEntry base) {   // CONTAINED_ELEM_AND_ATTR
		System.out.println(this);
		
        Vector elements = type.getContainedElements();
        Vector attributes = type.getContainedAttributes();
        
        // If this complexType is referenced in a
        // fault context, emit a bean-like exception
        // class
        Boolean isComplexFault = (Boolean) type.getDynamicVar(
                JavaGeneratorFactory.COMPLEX_TYPE_FAULT);

        if ((isComplexFault != null) && isComplexFault.booleanValue()) {

            return new JavaBeanFaultWriter(emitter, type, elements, base,
                attributes,
                getBeanHelperWriter(emitter, type, elements, base,
                                    attributes, true));
        }

        return new JavaBeanWriter(emitter, type, elements, base, attributes,
                getBeanHelperWriter(emitter, type, elements, base,
                                    attributes, false));
    }
	
/*
	protected JavaWriter getBeanWriter(Emitter emitter, TypeEntry type, 
				       Vector elements, TypeEntry base,
				       Vector attributes) {
    	System.out.println(this);
        JavaWriter helperWriter = getBeanHelperWriter(emitter,
						      type,
						      elements,
						      base,
						      attributes,
						      true);
        // If this complexType is referenced in a
        // fault context, emit a bean-like exception 
        // class
        Boolean isComplexFault = (Boolean)
            type.getDynamicVar(
                               JavaGeneratorFactory.COMPLEX_TYPE_FAULT);
        if (isComplexFault != null && 
            isComplexFault.booleanValue()) {
            return new JavaBeanFaultWriter(emitter, type, 
                                           elements, base, attributes, 
                                           helperWriter);
        }
        return new JavaBeanWriter(emitter, type, 
                                  elements, base, attributes, 
                                  helperWriter);
    }
*/
}
