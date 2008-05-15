package uk.ac.soton.ecs.grimoires.test.echo;

public class EchoClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Echo_ServiceLocator locator = new Echo_ServiceLocator();
		locator.setechoSOAPEndpointAddress("http://localhost:8081/grimoires/services/echo");
		Echo_PortType echoPort = locator.getechoSOAP();
		System.out.println(echoPort.echo("hello"));
		System.out.println(echoPort.echo("world"));
	}
}
