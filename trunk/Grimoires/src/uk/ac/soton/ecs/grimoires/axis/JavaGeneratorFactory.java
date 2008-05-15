package uk.ac.soton.ecs.grimoires.axis;
//import org.apache.axis.wsdl.toJava.JavaTypeWriter;
//import org.apache.axis.wsdl.toJava.Writers;

import org.apache.axis.wsdl.gen.Generator;
import org.apache.axis.wsdl.toJava.Emitter;

import org.apache.axis.wsdl.symbolTable.SymbolTable;
import org.apache.axis.wsdl.symbolTable.TypeEntry;

import javax.wsdl.PortType;


public class JavaGeneratorFactory extends org.apache.axis.wsdl.toJava.JavaGeneratorFactory {
    //    private Writers typeWriters = new Writers();

    public JavaGeneratorFactory(Emitter emitter) {
	super(emitter);
	System.out.println("Starting JavaGeneratorFactory");
    } // ctor
    public JavaGeneratorFactory() {
	super();
    } // ctor


    public Generator getGenerator(TypeEntry type, SymbolTable symbolTable) {
        Generator writer = new JavaTypeWriter(emitter, type, symbolTable);
        //typeWriters.addStuff(writer, type, symbolTable);
        //return typeWriters;
        System.out.println(this);
	return writer;
    } // getGenerator
}
