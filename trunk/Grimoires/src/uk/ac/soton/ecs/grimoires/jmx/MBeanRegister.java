package uk.ac.soton.ecs.grimoires.jmx;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import org.apache.log4j.Logger;

public class MBeanRegister {
	private static final Logger logger = Logger.getLogger(MBeanRegister.class);

	public static final void register() {
		try {
			_register();
		} catch (MalformedObjectNameException e) {
			logger.error(e.getLocalizedMessage(), e);
		} catch (InstanceAlreadyExistsException e) {
			logger.error(e.getLocalizedMessage(), e);
		} catch (MBeanRegistrationException e) {
			logger.error(e.getLocalizedMessage(), e);
		} catch (NotCompliantMBeanException e) {
			logger.error(e.getLocalizedMessage(), e);
		} catch (NullPointerException e) {
			logger.error(e.getLocalizedMessage(), e);
		}		 
	}
	
	static private void _register() throws MalformedObjectNameException, NullPointerException, 
			InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		
		/*
		 * OpsMXBean
		 */
		ObjectName opsName = new ObjectName("uk.ac.soton.ecs.grimoires:type=Ops");
		Ops ops = new Ops();
	    mbs.registerMBean(ops, opsName);
	}
}
