/*
 * Created on 22-May-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.server.security;

import java.security.Principal;
import java.util.Iterator;

import org.apache.axis.MessageContext;
import org.apache.log4j.Logger;

import uk.ac.soton.itinnovation.grid.gridservit.GridConstants;
import uk.ac.soton.itinnovation.grid.gridservit.context.ContextUnavailableException;
import uk.ac.soton.itinnovation.grid.gridservit.context.ServiceContext;
import uk.ac.soton.itinnovation.grid.utils.DNParser;

public class Utils {
	static private Logger logger = Logger.getLogger("uk.ac.soton.ecs.grimoires.server.security.Utils");
	
	static public void logAllMessageProperties() {
		try {
			MessageContext context = MessageContext.getCurrentContext();
			Iterator it = context.getAllPropertyNames();
			while (it.hasNext()) {
				String name = (String) it.next();
				String value = context.getProperty(name).toString();
				logger.info("wf: " + name + ": " + value);
			}
		} catch (Exception e) {
			logger.info(e);
		}
	}
	
//	@SuppressWarnings("finally")
	static public String getClientSubjectDN() {
		String clientSubjectDN = "Anonymous Publisher";
		MessageContext context = MessageContext.getCurrentContext();
		
		try {
			/*
			 * Assume we are in OMII.
			 */
			ServiceContext servCtx = (ServiceContext)context.getProperty(
						GridConstants.AXIS_CONTEXT_OBJECT_IDENTIFIER);
			if (servCtx != null) {
				Principal subjectDN =
					servCtx.getEScienceContext().getSecurityContext().getAuthenticatedSubjectPrincipal();
				clientSubjectDN = new DNParser(subjectDN.toString()).getStandardStringDN();							
			}			
		} catch (Exception e) {
			
		} finally {
//			logger.info("wf: " + clientSubjectDN);
			return clientSubjectDN;
		}		
	}		
}
