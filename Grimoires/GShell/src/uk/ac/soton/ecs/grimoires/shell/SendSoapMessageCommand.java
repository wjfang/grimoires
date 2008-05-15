package uk.ac.soton.ecs.grimoires.shell;

import java.io.*;
import javax.xml.soap.*;
import javax.xml.transform.stream.StreamSource;

public class SendSoapMessageCommand extends Shell implements Command {
	
	private String endpoint;
	private String filename;
	private String response;

    public SendSoapMessageCommand() throws Exception {
		
	}
    
    public SendSoapMessageCommand(String endpoint, String filename) throws Exception {
		this.endpoint = endpoint;
		this.filename = filename;
	}

    private String readFile(String fileName) throws Exception {
        StringBuffer strbuf = new StringBuffer(1024);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileName)));
        
        String line = null;
        while ((line = br.readLine()) != null) {
            strbuf.append(line);
            strbuf.append("\n");
        }
        
        return strbuf.toString();
    }

    private String construct(String m) throws Exception {
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                "<SOAP-ENV:Header/>" +
                "<SOAP-ENV:Body>";
		String footer = "</SOAP-ENV:Body>" +
                "</SOAP-ENV:Envelope>";

		return header + m + footer;
	}
    
	private String send() throws Exception {
        // Create a SOAP connection
        SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection connection = soapConnFactory.createConnection();
        
        // Create a SOAP message
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage message = messageFactory.createMessage();
		SOAPPart soapPart = message.getSOAPPart();
		String msg = construct(readFile(filename));
        Reader inXML = new StringReader(msg);
        StreamSource ss = new StreamSource(inXML);
        soapPart.setContent(ss);

        // Call and get a reply
        SOAPMessage reply = connection.call(message, endpoint);
		SOAPPart rSoapPart = reply.getSOAPPart();
		SOAPEnvelope rEnv = rSoapPart.getEnvelope();
		SOAPBody rBody = rEnv.getBody();
        
        connection.close();
        return rBody.toString();
	}

	public static void main(String[] args) throws Exception {
		
        if (args.length != 2) {
        	usage();
            System.exit(1);
        }
		
        SendSoapMessageCommand sender = new SendSoapMessageCommand(args[0], args[1]);
        sender.execute();
        sender.present();
	}

	/**
	 * 
	 */
	private static void usage() {
		System.out.println("java SendSoapMessage endpoint xmlfile");
	}

	public void expect() throws Exception {
		out.println("==== Send a SOAP message to a Web Service endpoint ====");
        out.println("Input the Web Service endpoint:");
        endpoint = readAndParseLine();
        out.println("Input the XML filename whose content constructs the SOAP message body:");
        filename = readAndParseLine();
	}

	public void execute() throws Exception {
		response = send();
	}

	public void present() throws Exception {
		out.println("\n" + response + "\n");
	}
}
