package uk.ac.soton.ecs.grimoires.test.misc;

import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.XMLConfiguration;

public class XmlConfigurationTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		XMLConfiguration config;
		try {
		    config = new XMLConfiguration("translator/translator.xml");
		    // do something with config
		} catch(ConfigurationException cex) {
		    throw cex;
		}
		
		List translators = config.configurationsAt("translators");
		for (Object t : translators) {
			HierarchicalConfiguration translator = (HierarchicalConfiguration) t;
			System.out.println(translator.getString("[@name]"));
			
			List n2gTranslators = translator.configurationsAt("n2gTranslator");
			for (Object o : n2gTranslators) {
				HierarchicalConfiguration n2gTranslator = (HierarchicalConfiguration) o;
				System.out.println(n2gTranslator.getString("[@elementNamespace]"));
				System.out.println(n2gTranslator.getString("[@elementLocalname]"));
				System.out.println(n2gTranslator.getBoolean("[@validate]"));
				
				List actions = n2gTranslator.configurationsAt("action");
				for (Object a : actions) {
					HierarchicalConfiguration action = (HierarchicalConfiguration) a;
					System.out.println(action.getString("[@type]"));
					System.out.println(action.getString("[@xslt]"));
				}
			}
		}
	}

}
