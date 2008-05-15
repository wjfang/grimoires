package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import uk.ac.soton.ecs.grimoires.server.configuration.Configuration;
import uk.ac.soton.ecs.grimoires.server.impl.Jena;
import uk.ac.soton.ecs.grimoires.server.impl.Key;
import uk.ac.soton.ecs.grimoires.server.impl.KeyImpl;
import uk.ac.soton.ecs.grimoires.server.impl.RDF;
import uk.ac.soton.ecs.grimoires.server.impl.StoreException;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.*;
import uk.ac.soton.ecs.grimoires.server.store.ModelChanges;


import com.sun.xacml.EvaluationCtx;
import com.sun.xacml.Indenter;

import com.sun.xacml.attr.AnyURIAttribute;
import com.sun.xacml.attr.RFC822NameAttribute;
import com.sun.xacml.attr.StringAttribute;

import com.sun.xacml.ctx.Attribute;
import com.sun.xacml.ctx.RequestCtx;
import com.sun.xacml.ctx.Subject;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.HashSet;
import java.util.Set;

import javax.security.auth.x500.X500Principal;

import com.sun.xacml.attr.X500NameAttribute;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
import java.util.*;

import java.net.URL;
import java.util.Iterator;
import java.util.Vector;
import java.util.ArrayList;

import java.util.logging.*;






public class UDDIPublishXACMLHandler {


	private static Logger mLogger = Logger.getLogger("uk.ac.soton.ecs.grimoires.server.security.AuthHandler");

   private static boolean initializedXACMLFile = false;



	public boolean initializeFromXACMLFile() {

		String fileToParse = "";
		Properties settings = new Properties();

		try {

			InputStream is = this.getClass().getClassLoader().getResourceAsStream("grimoires.properties");
			settings.load(is);
			is.close();
			fileToParse = settings.getProperty("xacmlfile");
			if (fileToParse == null)
			{
				mLogger.log(Level.SEVERE, "Unable to locate a value for authfile parameter in grimoires.properties");
				return false;
			}
			else
			{
				mLogger.log(Level.INFO, "Initializing from authorization file : " + fileToParse);
				System.err.println ("File is : " + fileToParse);
				return true;
			}
		}

		catch (NullPointerException ne) {
			mLogger.log(Level.SEVERE, "Unable to locate properties file grimoires.properties");
			return false;
		}

		catch (FileNotFoundException fe) {
			mLogger.log(Level.SEVERE, "Unable to locate authorization file : " + fileToParse);
			return false;
		}

/*
		catch (org.xml.sax.SAXParseException spe) {
			mLogger.log(Level.SEVERE, "Error in parsing authorization file : " + fileToParse);
			mLogger.log(Level.SEVERE, spe.toString());
			return false;
		}
*/
		catch (Exception e) {
			mLogger.log(Level.SEVERE, "Error in interpretation of authorization file : " + fileToParse);
			mLogger.log(Level.SEVERE, e.toString());
			return false;
		}


	}



    public Set setupSubjects() throws URISyntaxException {
        HashSet attributes = new HashSet();

        // setup the id and value for the requesting subject
        URI subjectId =
            new URI("urn:oasis:names:tc:xacml:1.0:subject:subject-id");

        X500Principal pp = new X500Principal("CN=gallagher.ecs.soton.ac.uk, OU=ECS, O=Soton, L=none, ST=Hampshire, C=UK");

        X500NameAttribute value = new X500NameAttribute(pp);

        // create the subject section with two attributes, the first with
        // the subject's identity...
        attributes.add(new Attribute(subjectId, null, null, value));
        // ...and the second with the subject's group membership
/*
        attributes.add(new Attribute(new URI("group"),
                                     "admin@users.example.com", null,
                                     new StringAttribute("developers")));

*/

        // bundle the attributes in a Subject with the default category
        HashSet subjects = new HashSet();
        subjects.add(new Subject(attributes));

        return subjects;
    }


    public Set setupResource(String resourceRequest) throws URISyntaxException {
        HashSet resource = new HashSet();

        // the resource being requested
        StringAttribute value = new StringAttribute(resourceRequest);

        // create the resource using a standard, required identifier for
        // the resource being requested
        resource.add(new Attribute(new URI(EvaluationCtx.RESOURCE_ID),
                                   null, null, value));

        return resource;
    }

    public Set setupAction(String actionToDo) throws URISyntaxException {
        HashSet action = new HashSet();

        // this is a standard URI that can optionally be used to specify
        // the action being requested
        URI actionId =
            new URI("urn:oasis:names:tc:xacml:1.0:action:action-id");

        // create the action
        action.add(new Attribute(actionId, null, null,
                                 new StringAttribute(actionToDo)));

        return action;
    }




	 public String parseMessage(Save_business message)
	 {
		   String accum = "";
			String temp;
			int i;

		   // Just deal with a single businessEntity

			System.err.println ("in the xacml handler ");

         try {
				BusinessEntity[] entities = message.getBusinessEntity();
				BusinessEntity entity = entities[0];

							System.err.println ("point1");

				DiscoveryURLs discoveryURLs = entity.getDiscoveryURLs();
				if (discoveryURLs != null)
				{
				   DiscoveryURL[] discoveryURLArray = discoveryURLs.getDiscoveryURL();
   				for (i = 0; i < discoveryURLArray.length; i++)
	   			{
		   			temp = "discoveryURL=" + discoveryURLArray[i].get_value() + ":";
			   		accum += temp;
				   }
				}

											System.err.println ("point2");


				Name[] names = entity.getName();
				for (i = 0; i < names.length; i++)
				{
					temp = "name=" + names[i].get_value() + ":";
					accum += temp;
				}

															System.err.println ("point3");

				Description[] descriptions = entity.getDescription();
				for (i = 0; i < descriptions.length; i++)
				{
					temp = "description=" + descriptions[i].get_value() + ":";
					accum += temp;
				}

				temp = "businessKey=" + entity.getBusinessKey() + ":";
				accum += temp;
				temp = "operator=" + entity.getOperator() + ":";
				accum += temp;
				temp = "authorizedName=" + entity.getAuthorizedName();

				return accum;

			}
			catch (Exception e)
			{ System.out.println (e);  return "eror";}


	 }





      public void process(Save_business message)
		{

		   String resourceRequest = parseMessage(message);

			try {

            initializeFromXACMLFile();

            RequestCtx request = new RequestCtx(setupSubjects(), setupResource(resourceRequest),
                           setupAction("Save_business"), new HashSet());

			   request.encode(System.out, new Indenter());
			}

			catch (Exception e)
			{  System.out.println (e); }




		}



}
