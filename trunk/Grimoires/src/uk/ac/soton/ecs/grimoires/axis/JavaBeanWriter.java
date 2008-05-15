package uk.ac.soton.ecs.grimoires.axis;

import org.apache.axis.wsdl.symbolTable.TypeEntry;
import org.apache.axis.wsdl.toJava.Emitter;
import org.apache.axis.wsdl.toJava.JavaWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.Iterator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class JavaBeanWriter
    extends  org.apache.axis.wsdl.toJava.JavaBeanWriter {

    TypeEntry type;

    JavaBeanWriter(Emitter emitter,
		   TypeEntry type,
		   Vector elements,
		   TypeEntry extendType,
		   Vector attributes,
		   JavaWriter helper) {
	super(emitter,type,elements,
	      extendType,attributes,helper);
	this.type=type;
	// at a later stage, config file will have to be put into the jar file.
	
	//fwj
//	if (type.getName().endsWith("Save_business")) {
//		System.out.println(type.getQName().getLocalPart());
//		System.out.println(type.getQName().getNamespaceURI());
//	}
	
	try {
	    System.out.println("Loading config");
	    // String confFile = getClass().getResource("wsdl2java-generator-config.xml").toURI().toString(); // Java 1.5
	    String confFile = getClass().getResource("wsdl2java-generator-config.xml").toString(); // Java 1.4
        if (confFile.startsWith("file:/")) {
	    	load(confFile.substring("file:".length()));
	    } else {
	    	System.out.println("The configuration file is at:\n" + confFile);
	    	System.exit(1);
	    }
	    
	    //load(getClass().getResource("wsdl2java-generator-config.xml").openStream());
	    //System.exit(1);
	    //load("L:/Documents and Settings/wf/My Documents/workspace/Grimoires/src/uk/ac/soton/ecs/grimoires/axis/wsdl2java-generator-config.xml");
	    System.out.println("Loading config done");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    protected String getExtendsText() {
    	
	String extendsText=super.getExtendsText();
	
	// fwj: can only extend from one superclass
	if (extendsText.startsWith("extends")) {
		System.out.println(type.getName() + " " + extendsText);
		System.out.println("Can not add more \"extends\".");
		System.exit(1);		
	}
	String foundExtendsText="";

	try {
	    Node node=search(type.getQName().getLocalPart(),
			     type.getQName().getNamespaceURI());
	    if (node!=null) {
		Iterator eachInfo = new NodeListIterator (node.getChildNodes ());
		Node     info;
		while (eachInfo.hasNext ()) {
		    info = (Node) eachInfo.next ();
		    if (info.getNodeName ().equals ("extends")) {
			foundExtendsText=getAttrValue (info, "name");
		    }
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	};

	if (!(foundExtendsText.equals(""))) {
	    extendsText = " extends " + foundExtendsText + " ";
	}
        return extendsText;
    }


    /**
     * Returns the appropriate implements text
     * @return " implements <classes> "
     */
    protected String getImplementsText() {
    	String implementsText = super.getImplementsText();
//        // See if this class extends another class
//
//        String implementsText = " implements java.io.Serializable";
//        if (type.isSimpleType()) {
//            implementsText += ", org.apache.axis.encoding.SimpleType";
//        }
//
	try {
	    Node node=search(type.getQName().getLocalPart(),
			     type.getQName().getNamespaceURI());
	    if (node!=null) {
		Iterator eachInfo = new NodeListIterator (node.getChildNodes ());
		Node     info;
		while (eachInfo.hasNext ()) {
		    info = (Node) eachInfo.next ();
		    if (info.getNodeName ().equals ("implements")) {
			String nameAttribute = getAttrValue (info, "name");
			if (nameAttribute!=null) {
			    implementsText += ", " + nameAttribute;
			}
		    }
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	};

	implementsText += " ";

	
        return implementsText;
    }

    protected void writePackage(PrintWriter pw) throws IOException {
	super.writePackage(pw);
	writeImports(pw);
    }

    
    protected void writeImports(PrintWriter pw) throws IOException {
	boolean done=false;
	try {
	    Node node=search(type.getQName().getLocalPart(),
			     type.getQName().getNamespaceURI());
	    if (node!=null) {
		Iterator eachInfo = new NodeListIterator (node.getChildNodes ());
		Node     info;
		while (eachInfo.hasNext ()) {
		    info = (Node) eachInfo.next ();
		    if (info.getNodeName ().equals ("import")) {
			String nameAttribute = getAttrValue (info, "name");
			if (nameAttribute!=null) {
			    pw.println("import " + nameAttribute + ";");
			    done=true;
			}
		    }
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	};
	if (done) pw.println("");
    }

    protected void writeFileBody(PrintWriter pw) throws IOException {
    	super.writeFileBody(pw);
    	writeMethods(pw);
    }

    protected void writeMethods(PrintWriter pw) throws IOException {
	try {
	    Node node=search(type.getQName().getLocalPart(),
			     type.getQName().getNamespaceURI());
	    if (node!=null) {
		Iterator eachInfo = new NodeListIterator (node.getChildNodes ());
		Node     info;
		while (eachInfo.hasNext ()) {
		    info = (Node) eachInfo.next ();
		    if (info.getNodeName ().equals ("method")) {
			String nameAttribute = getAttrValue (info, "text");
			if (nameAttribute!=null) {
			    pw.println(nameAttribute.replaceAll("\\$\\{classname\\}",
								//getPackage()
								//+ "." +
								getClassName()));
			    pw.println("");
			}
		    }
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	};
    }

    static Document configDocument=null;

    /** Search for element with attributes name and namespace in configuration dom. */
    public Node search (String name, String namespace) throws FactoryException {
	Element root=configDocument.getDocumentElement();
	Iterator eachInfo = new NodeListIterator (root.getChildNodes ());
        Node     info;
	while (eachInfo.hasNext ()) {
	    info = (Node) eachInfo.next ();
	    if (info.getNodeName ().equals ("element")) {
		String namespaceAttribute = getAttrValue (info, "namespace");
		if (namespaceAttribute.equals(namespace)) {
		    String nameAttribute = getAttrValue (info, "name");
		    String [] names=nameAttribute.split(",");
		    for (int i=0;i<names.length;i++) {
			if (names[i].equals(name)) {
			    return info;
			}
		    }
		}
	    }
	}
	return null;
    }

    protected static String getAttrValue (Node parent, String attrName) throws FactoryException {
        NamedNodeMap allAttrs = parent.getAttributes ();
        Node         attrNode;

        if (allAttrs == null) {
            throw new FactoryException ("Element expected but not found: "
					+ parent.getNodeName ());
        }
        attrNode = allAttrs.getNamedItem (attrName);
        if (attrNode == null) {
            throw new FactoryException ("Attribute with name "
					+ attrName + " expected but not found: "
					+ parent.getNodeName ());
        }
        
        return attrNode.getNodeValue ();
    }

    public void load (String configFile) throws FactoryException {
    //public void load (java.io.InputStream configFileInputStream) throws FactoryException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance ();
            DocumentBuilder        builder = factory.newDocumentBuilder ();
            Document               xmldoc  = builder.parse (configFile);
            //Document               xmldoc  = builder.parse (configFileInputStream);

            configDocument=xmldoc;
                        
        } catch (ParserConfigurationException builderCreationProblem) {
            throw new FactoryException (builderCreationProblem);
        } catch (IOException fileAccessProblem) {
            throw new FactoryException (fileAccessProblem);
        } catch (SAXException parsingProblem) {
            throw new FactoryException (parsingProblem);
        }
    }
    
}

