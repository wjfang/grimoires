package uk.ac.soton.ecs.grimoires.test.echo;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import uk.ac.soton.ecs.grimoires.test.throughput2.Tester;
import uk.ac.soton.ecs.grimoires.test.throughput2.Worker;

public class EchoWorker extends Worker {
	private static Logger logger = Logger.getLogger(EchoWorker.class);
	
	private static Echo_PortType echoPort;

	public EchoWorker() {
		
	}

	public static void init(Tester t) {
		Worker.init(t);
		
		String gl = tester.getStringProperty("grimoires.location");
		if (!gl.endsWith("/"))
			gl += "/";
		Echo_ServiceLocator locator = new Echo_ServiceLocator();
		locator.setechoSOAPEndpointAddress(gl + "echo");
		while (true) {
			try {
				echoPort = locator.getechoSOAP();
				return;
			} catch (ServiceException e) {
				logger.error("Cannot connect to the echo service: " + e.getLocalizedMessage());
				logger.debug(e.getLocalizedMessage(), e);
			}
		}
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				String echo = echoPort.echo(tester.getCurrentTime());
				tester.inc();
				logger.debug(echo);
			} catch (RemoteException e) {
				logger.error("Echo failed: " + e.getLocalizedMessage());
				logger.debug(e.getLocalizedMessage(), e);
			}
		}
	}
}
