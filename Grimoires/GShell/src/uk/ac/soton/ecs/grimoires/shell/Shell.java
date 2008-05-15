/*
 * Created on 14-Jun-2005
 * 
 */
package uk.ac.soton.ecs.grimoires.shell;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxyFactory;
import uk.ac.soton.ecs.grimoires.proxy.MetadataFormatException;
import uk.ac.soton.ecs.grimoires.proxy.MissingInformationException;
import uk.ac.soton.ecs.grimoires.server.impl.metadata.datamodel.FaultDetailList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingTemplate;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessService;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail;

/**
 * @author wf
 * 
 */
public class Shell {
    
    // some constants
    protected static final String MessagePartReferenceURI = 
        "http://www.grimoires.org/metadata.xsd#messagePartReference";
    protected static final String OperationReferenceURI = 
        "http://www.grimoires.org/metadata.xsd#operationReference";
    protected static final String BusinessKeyReferenceURI = 
        "http://www.uddi.org/schema/uddi_v2.xsd#businessKey";
    protected static final String ServiceKeyReferenceURI = 
        "http://www.uddi.org/schema/uddi_v2.xsd#serviceKey";
    protected static final String SemanticTypeURI = 
        "http://www.grimoires.org/SemanticType";
    
    protected static GrimoiresProxy grimoiresProxy;
    
    protected static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    protected static PrintStream out = new PrintStream(System.out);
    
    private static String packageName = "uk.ac.soton.ecs.grimoires.shell";
    
    private static ArrayList variables = new ArrayList();
    
    // return the index of the newly added variable
    protected static int addEnv(String var) {
    	variables.add(var);
        return variables.size() - 1;
    }
    
    protected static String getEnv(int index) {
        if (variables.size() > index)
        	return (String)variables.get(index);
        else
            return "No such variable.";
    }
    
    protected static String labelEnv(int index) {
    	return "[$" + index + "]";
    }
    
    protected static String readAndParseLine() throws IOException, GShellException {
    	String line = in.readLine().trim();
        if (line.startsWith("$")) {
        	int eid = 0;
        	try {
        		eid = Integer.parseInt(line.trim().substring(1));
        	} catch (NumberFormatException e) {
        		throw new GShellException("Incorrect environment variable index.", e);
        	}
        	return getEnv(eid);
        } else
            return line;
    }
    
    protected static void printEnv(String name, String value) throws Exception {
        int index = addEnv(value);
        out.println(name + "[$" + index + "]: " + value);
    }
    
    protected static void printNonEnv(String name, String value) throws Exception {
    	out.println(name + ": " + value);
    }
    
    protected static void setUpStubs(String prefix) {
    	Object object = null;
    	try {
    		Properties properties = new Properties();
    		properties.load(new FileInputStream("gshell.properties"));
    		String factoryClassName = properties.getProperty("GrimoiresProxyFactory");
    		Class classDefinition = Class.forName(factoryClassName);
//    		object = classDefinition.newInstance();
    		Method getInstanceMethod = classDefinition.getMethod("getInstance", null);
    		object = getInstanceMethod.invoke(null, null);
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.exit(1);
    	}
    	GrimoiresProxyFactory factory = (GrimoiresProxyFactory) object;
		    	 
        grimoiresProxy = factory.createProxy(prefix);
    }
    
    private static final int HELP = 0;
    private static final int RUN = 1;
    private static final int LS = 2;
    private static final int ENV = 3;
    private static final int EXIT = 4;
    private static final int ERROR = 5;
    private static final int COMMENT = 6;
    
    private static void loop() {
		String input;
		boolean continued = true;
		int op = 0;

		do {
			try {
				out.print(">");
				input = in.readLine().trim();

				// parse the user input
				if (input.startsWith("help")) {
					op = HELP;
				} else if (input.startsWith("run")) {
					op = RUN;
				} else if (input.startsWith("ls")) {
					op = LS;
				} else if (input.startsWith("env")) {
					op = ENV;
				} else if (input.startsWith("exit")) {
					op = EXIT;
                } else if (input.startsWith("#")) {
                    op = COMMENT;
				} else {
					op = ERROR;
				}

				// execute in behalf of users
				switch (op) {
				case HELP:
					usage();
					break;

				case RUN:
					invoke(input);
					break;

				case LS:
					list();
					break;

				case ENV:
					environ(input);
					break;

                case COMMENT:
                    break;
                
				case EXIT:
					continued = false;
					out.println("Thank you. Bye bye.");
					break;

                case ERROR:
					out.println("ERROR: I can not understand you.");
					break;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} while (continued);
		
    }
    
	/**
	 * @param input
	 */
	private static void environ(String input) throws Exception {
		String[] ss = input.split("\\s");
        if (ss.length == 1) {
        	// print all the environment variables
            if (variables.size() > 0) {
            	String[] all = (String[])variables.toArray(new String[1]);
            	for (int i = 0; i < all.length; i++)
            		out.println("$" + i + ": " + all[i]);
            }
            
        } else {
            // print the selected environment variable
            int index = Integer.parseInt(ss[1]);
            out.println("$" + index + ": " + getEnv(index));
        }
	}

	/**
	 *  
	 */
	private static void list() throws Exception {
        URL pkg = Class.forName("uk.ac.soton.ecs.grimoires.shell.Shell").getResource("Shell.class");
//        out.println(pkg);
        ArrayList cmdList = new ArrayList();
        
        if (pkg.toString().startsWith("file:")) {
        	/*
        	 * classes are loaded from a directory
        	 */ 
        	String dirName = pkg.toString().substring(0,
                    pkg.toString().length() - "Shell.class".length());
//            out.println(dirName);
            File dir = new File(new URI(dirName));
//            out.println(dir.isDirectory());
            File[] files = dir.listFiles();
            for (int i = 0; i < files.length; i++) {
            	String n = files[i].getName();
            	if (n.matches(".+Command.class"))
            		cmdList.add(n.substring(0, n.length() - "Command.class".length()));    
            }
        } else if (pkg.toString().startsWith("jar:")) {
        	/*
        	 * classes are loaded from a jar file
        	 */
        	String temp = pkg.toString();
        	String jarFileName = temp.substring("jar:".length(), temp.indexOf("!/"));
//        	out.println(jarFileName);
        	JarFile jarFile = new JarFile(new File(new URI(jarFileName)));
        	Enumeration enu = jarFile.entries();
        	while (enu.hasMoreElements()) {
        		JarEntry je = (JarEntry)enu.nextElement();
        		String n = je.getName();
//        		out.println(n);
        		if (n.matches("uk/ac/soton/ecs/grimoires/shell/[^/]+Command.class")) {
//        			out.println(n);
        			cmdList.add(n.substring("uk/ac/soton/ecs/grimoires/shell/".length(), 
        					n.length() - "Command.class".length()));
        		}
        	}
        }
        
        for (int i = 0; i < cmdList.size(); i++) {
        	String cmdName = (String)cmdList.get(i);
            out.println(cmdName);
        }
	}

    /**
	 * @param command
	 */
	private static void invoke(String input) throws Exception {
        String[] ss = input.split("\\s");
        if (ss.length == 1) {
        	out.println("Which command to run?");
            return;
        }
        String command = ss[1];
		String className = packageName + "." + command + "Command";
        
        try {
            Class classDefinition = Class.forName(className);
			Object object = classDefinition.newInstance();
			Command cmd = (Command)object;
			cmd.expect();
			cmd.execute();
			beforePresent();
			cmd.present();
			afterPresent();
		} catch (java.lang.ClassNotFoundException ex) {
			out.println("ERROR: No such command.");
		} catch (java.lang.NullPointerException ex) {
			out.println("No matched entity found");
        } catch (org.apache.axis.types.URI.MalformedURIException ex) {
            out.println("ERROR: Namespace and metadata type should be in the form of URI.");
        } catch (FaultDetailList ex) {
            out.println("ERROR: " + ex.getFaultDetail(0).getErrorMessage());
        } catch (java.lang.NoClassDefFoundError error) {
        	out.println("ERROR: Check the correctness of the command name.");
        } catch (org.apache.axis.AxisFault ex) {
        	String errmsg = ex.getMessage();
        	if (errmsg.indexOf("unauthorized") > 0) {
        		out.println("ERROR: You are not authorized to perform this operation.");        		
        	}
        	out.println(errmsg);
//        } catch (javax.xml.bind.JAXBException ex) {
//        	String errmsg = ex.getMessage();
//        	if (errmsg == null) {
//        		errmsg = ex.getLinkedException().getMessage();
//        	}
//        	out.println("ERROR: " + errmsg);
        } catch (MetadataFormatException ex) {
        	out.println("ERROR: " + ex.getMessage());
        } catch (MissingInformationException ex) {
        	out.println("ERROR: " + ex.getMessage());
        } catch (GShellException ex) {
        	out.println("ERROR: " + ex.getMessage());
        } catch (Exception ex) {
        	out.println("ERROR: " + ex.getClass());            
            ex.printStackTrace();
        }
    }        
     
	private static void beforePresent() {
		if (supportRichText()) {
			/*
			 * green font in black background
			 */
			out.print("\033[32;40m");
		}
	}
	
	private static void afterPresent() {
		if (supportRichText()) {
			/*
			 * white font in black background
			 */
			out.print("\033[37;40m");
		}
	}
	
	/*
	 * Check whether the term supports rich text, such as bold text, 
	 * colorful background and foreground, etc.
	 */
	private static boolean supportRichText() {
		/*
		 * We do not use this feature right now.
		 */
		return false;
		
//		try {
//			String term = System.getenv("TERM");
//			if (term.equals("cygwin"))
//				return true;
//			else
//				return false;			
//		} catch (Exception e) {
////			out.println(e);
//			return false;
//		}
	}
	
	/**
	 *  
	 */
	private static void usage() {
		out.println("Grimoires Shell Usage:\n" + 
                "help\t- print this message.\n" +
                "ls\t- list available commands. A command is a simple client to interact with Grimoires registry.\n" +
                "run\t- run a command, e.g., run PublishBusiness.\n" +
                "env\t- display all the reusable environment variables. env 3: display the third variable.\n" +
                "exit\t- exit Grimoires shell.");        
	}

	protected static String registryLocation;
	
	public static void main(String[] args) throws Exception {
        // URL prefix should be in the form of "http://localhost:8080/grimoires/"
        String prefix;
        if (args.length == 0) {
//        	prefix = "http://localhost:8080/wsrf/services/grimoires/";
            prefix = "http://localhost:8080/grimoires/services/";
        } else {
        	prefix = args[0];
        }
        
        if (!prefix.endsWith("/")) {
        	prefix = prefix + "/";
        }
        
        setUpStubs(prefix);
        registryLocation = prefix;
        
        // Test the end point.
        InquireBusinessCommand cmd = new InquireBusinessCommand("abc");
        try {
        	cmd.execute();
        } catch (NullPointerException e) {
        	// This is the only exception allowed.
        } catch (Exception e) {
        	out.println("\nThe Grimoires registry can not be found at the specified location. " +
        		"Please check your Grimoires deployment.\n");
        	e.printStackTrace();
        	System.exit(1);        	
        }
        
        out.println("\nGRIMOIRES SHELL. Type \'help\' for the help information.\n");
        
        loop();
	}
    
    protected static void printBusiness(BusinessEntity b) throws Exception {
        try {
            printNonEnv("Business name", b.getName(0).get_value());
        } catch (java.lang.NullPointerException ex) {
        }
        try {
            printNonEnv("Business description", b.getDescription(0).get_value());
        } catch (java.lang.NullPointerException ex) {
        }
        try {
            printNonEnv("Business key", b.getBusinessKey());
        } catch (java.lang.NullPointerException ex) {
        }
        
    }
    
    protected static void printService(BusinessService service) throws Exception {
        try {
            printNonEnv("Service name", service.getName(0).get_value());
        } catch (java.lang.NullPointerException ex) {
        }

        try {
            printNonEnv("Service key", service.getServiceKey());
        } catch (java.lang.NullPointerException ex) {
        }
        
        try {
            printNonEnv("Business key", service.getBusinessKey());
        } catch (java.lang.NullPointerException ex) {
        }

        try {
            printNonEnv("Service description", service.getDescription(0)
                    .get_value());
        } catch (java.lang.NullPointerException ex) {
        }

        BindingTemplate bt = null;
        try {
            bt = service.getBindingTemplates().getBindingTemplate(0);
        } catch (java.lang.NullPointerException ex) {
            return;
        }

        try {
            printNonEnv("Access point in binding template", bt.getAccessPoint()
                    .get_value());
        } catch (java.lang.NullPointerException ex) {
        }

        try {
        	String tModelKey = bt.getTModelInstanceDetails().getTModelInstanceInfo(0).getTModelKey();
        	printNonEnv("tModel", getOverviewURL(tModelKey));
        } catch (java.lang.NullPointerException ex) {
        }
       
    }

    /**
     * Get overview URL of a tModel by given its key.
     * @param tModelKey
     * @return
     */
	private static String getOverviewURL(String tModelKey) throws Exception {
		TModelDetail response = grimoiresProxy.getTModelDetail(tModelKey);
		return response.getTModel()[0].getOverviewDoc().getOverviewURL();		
	}
}
