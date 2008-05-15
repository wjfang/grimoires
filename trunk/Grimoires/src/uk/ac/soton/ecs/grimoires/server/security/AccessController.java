/*
 * Created on 04-Oct-2006
 * 
 */
package uk.ac.soton.ecs.grimoires.server.security;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AccessController {
	
	private static AccessController instance = null;
	
	public static synchronized AccessController getInstance() {
		if (instance == null) {
			instance = new AccessController();
		}
		return instance;
	}
	
	private AccessController() {
		initializeFromResourceFile();
		
		/*
		 * after initialization, perform requisite operations to make the permissions list
		 * (groupPermissions) complete 
		 */
		expandGroups(groupOperations);
		trimGroups(groupOperations);

		expandGroups(groupIdentities);
		trimGroups(groupIdentities);

		expandPermissionList(groupIdentities, groupOperations, groupPermissions);
		trimGroups(groupPermissions);
	}
	

	/*
	 * Three arraylists to hold the contents of the ACL file, corresponding to
	 * the XML elements of groupIdentities, groupOperations and permission
	 */
	private ArrayList groupIdentities; 
	private ArrayList groupOperations; 
	private ArrayList groupPermissions; 

	private String flagAllUsers = "#AllUsers#";
	private String flagAllOperations = "#AllOperations#";
	
	private Logger logger = Logger.getLogger(this.getClass()); 
	
 	/**
	 * Intializes the arraylists from the ACL using the grimoires.properties
	 * file GroupOperation, GroupIdentities
	 */
	private void initializeFromResourceFile() {
		String fileToParse = "";
		Properties settings = new Properties();
		Document doc = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);

		groupIdentities = new ArrayList();
		groupOperations = new ArrayList();
		groupPermissions = new ArrayList();

		try {
			InputStream is = this.getClass().getClassLoader()
					.getResourceAsStream("grimoires.properties");
			settings.load(is);
			is.close();
			fileToParse = settings.getProperty("authfile");
			if (fileToParse == null) {
				logger.fatal("Unable to locate a value for authfile parameter in grimoires.properties");
				System.exit(1);
			} else {
				logger.info("Initializing from authorization file : " + fileToParse);
				doc = factory.newDocumentBuilder().parse(new File(fileToParse));
			}
		} catch (NullPointerException ne) {
			logger.fatal("Unable to locate properties file grimoires.properties");
			System.exit(1);
		} catch (FileNotFoundException fe) {
			logger.fatal("Unable to locate authorization file : " + fileToParse);
			System.exit(1);
		} catch (org.xml.sax.SAXParseException spe) {
			logger.fatal("Error in parsing authorization file : " + fileToParse);
			logger.fatal(spe.toString());
			System.exit(1);
		} catch (Exception e) {
			logger.fatal("Error in interpretation of authorization file : "	+ fileToParse);
			logger.fatal(e);
			System.exit(1);
		}

		try {
			traverseDocument(doc, 0, groupIdentities, "groupIdentity");
			traverseDocument(doc, 0, groupOperations, "groupOperation");
			traverseDocument(doc, 0, groupPermissions, "permission");
		} catch (Exception e) {
			logger.fatal("Error interpreting authorization file");
			logger.fatal(e);
			System.exit(1);
		}
	}
	
    /**
	 * Parses the ACL file recursively to construct the lists for groupOperations, groupIdentities and
	 * permission.
	 */
	private void traverseDocument(Node node, int level, ArrayList entryList, String checkType) {
		Node firstnode = null;
		Node secondnode = null;
		NamedNodeMap nm = null;
		String temp = null;
		String mode = "";
		String[] stringArray = null;
		ArrayList elementList = new ArrayList();
		int i;
		boolean found = false;

		if (checkType.equals("groupIdentity")) {
			if (node.getNodeName().equals("groupIdentity")) {
				found = true;
				nm = node.getAttributes();
				firstnode = nm.getNamedItem("groupName");
				secondnode = nm.getNamedItem("identityList");
			}
		} else if (checkType.equals("groupOperation")) {
			if (node.getNodeName().equals("groupOperation")) {
				found = true;
				nm = node.getAttributes();
				firstnode = nm.getNamedItem("groupName");
				secondnode = nm.getNamedItem("operationList");
			}
		} else if (checkType.equals("permission")) {
			if (node.getNodeName().equals("permission")) {
				found = true;
				nm = node.getAttributes();
				firstnode = nm.getNamedItem("identity");
				secondnode = nm.getNamedItem("operationList");
				temp = (String) (nm.getNamedItem("mode")).getNodeValue();
				mode = temp.trim();
			}
		}

		// If appropriate element found, store in list
		if (found) {
			temp = (String) secondnode.getNodeValue();
			stringArray = temp.split("//");
			for (i = 0; i < stringArray.length; i++) {
				elementList.add(stringArray[i].trim());
			}
			temp = (String) firstnode.getNodeValue();
			ACLEntry newEntry = new ACLEntry(temp.trim(), elementList, mode);
			entryList.add(newEntry);
		}

		// If there are any children, visit each one
		NodeList list = node.getChildNodes();
		for (i = 0; i < list.getLength(); i++) {
			// Get child node
			Node childNode = list.item(i);
			// Visit child node
			traverseDocument(childNode, level + 1, entryList, checkType);
		}
	}
	
    /**
	 * Removes redundant (i.e. repeating) values in the 2D lists by traversing horizontally
	 * and vertically
	 */
	private void trimGroups(ArrayList groupOperations) {
		ACLEntry currentEntry, tempEntry;
		ArrayList currentElementList, tempElementList;
		String currentOperation, tempOperation, currentName, tempName;

		for (int i = 0; i < groupOperations.size(); i++) {
			currentEntry = (ACLEntry) groupOperations.get(i);
			currentName = currentEntry.getListName();
			currentElementList = currentEntry.getElementList();

			// reconcile names of groups across entries or rows
			for (int m = i + 1; m < groupOperations.size(); m++) {
				tempEntry = (ACLEntry) groupOperations.get(m);
				tempName = tempEntry.getListName();
				if (tempName.equals(currentName)) {
					tempElementList = tempEntry.getElementList();
					for (int n = 0; n < tempElementList.size(); n++) {
						tempOperation = (String) tempElementList.get(n);
						currentElementList.add(tempOperation);
					}
					groupOperations.remove(m);
					m--;
				}
			}

			// reconcile names of operations across a single entry
			for (int j = 0; j < currentElementList.size(); j++) {
				currentOperation = (String) currentElementList.get(j);
				for (int k = j + 1; k < currentElementList.size(); k++) {
					tempOperation = (String) currentElementList.get(k);
					if (currentOperation.equals(tempOperation)) {
						currentElementList.remove(k);
						k--;
					}
				}
			}
		}
	}

	/**
	 * Expands values in a group by substituting values for group names
	 */
	private void expandGroups(ArrayList groupOperations) {
		ACLEntry currentEntry, tempEntry;
		ArrayList currentElementList, tempElementList;
		String currentGroupName, currentOperation, tempOperation;

		// Traverse list horizontally

		for (int i = 0; i < groupOperations.size(); i++) {
			currentEntry = (ACLEntry) groupOperations.get(i);
			currentGroupName = (String) currentEntry.getListName();
			currentElementList = currentEntry.getElementList();

			// For each vertical element

			for (int j = 0; j < currentElementList.size(); j++) {
				currentOperation = (String) currentElementList.get(j);
				for (int k = 0; k < groupOperations.size(); k++) {
					if (k != i) {
						tempEntry = (ACLEntry) groupOperations.get(k);

						// Check to see whether there is corresponding horizontal element
						if (currentOperation.equals(tempEntry.getListName())) {
							tempElementList = tempEntry.getElementList();
							// If so, add the entire list corresponding to the horizontal element
							for (int l = 0; l < tempElementList.size(); l++) {
								tempOperation = (String) tempElementList.get(l);
								if (!tempOperation.equals(currentGroupName))
									currentElementList.add(tempOperation);
							}
							currentElementList.remove(j);
							j--;
							break;
						}
					}
				}
			}
		}
	}

	/**
	 * Expands the permission list by using the values from the other lists:
	 * GroupOperation, GroupIdentities
	 */
	private void expandPermissionList(ArrayList groupIdentities,
			ArrayList groupOperations, ArrayList groupPermissions) {
		ACLEntry currentPermEntry, currentGroupOperationEntry, currentGroupIdentityEntry;
		ArrayList currentIdentityOperationList, currentGroupOperationList, currentGroupIdentityList;
		String currentIdentityName, currentIdentityOperation, currentIdentityMode, tempName;
		String currentGroupOperationName, currentGroupIdentityName, tempOperation;

		int numPermOperations;
		int numPermEntries = groupPermissions.size();

		for (int i = 0; i < numPermEntries; i++) {
			currentPermEntry = (ACLEntry) groupPermissions.get(i);
			currentIdentityName = (String) currentPermEntry.getListName();
			currentIdentityOperationList = currentPermEntry.getElementList();
			currentIdentityMode = (String) currentPermEntry.getMode();
			numPermOperations = currentIdentityOperationList.size();

			// Expand list of operations for a given permission entry, based on the other values in the
			// groupOperations list

			for (int j = 0; j < numPermOperations; j++) {
				currentIdentityOperation = (String) currentIdentityOperationList
						.get(j);
				for (int k = 0; k < groupOperations.size(); k++) {
					currentGroupOperationEntry = (ACLEntry) groupOperations
							.get(k);
					currentGroupOperationName = (String) currentGroupOperationEntry
							.getListName();
					if (currentGroupOperationName
							.equals(currentIdentityOperation)) {
						currentGroupOperationList = currentGroupOperationEntry
								.getElementList();
						for (int m = 0; m < currentGroupOperationList.size(); m++) {
							tempOperation = (String) currentGroupOperationList
									.get(m);
							currentIdentityOperationList.add(tempOperation);
						}
						currentIdentityOperationList.remove(j);
						j--;
						numPermOperations--;
						break;
					}
				}
			}

			// Create a list of entries from a single permission entry, based on the other values in the
			// groupIdentities list

			for (int j = 0; j < groupIdentities.size(); j++) {
				currentGroupIdentityEntry = (ACLEntry) groupIdentities.get(j);
				currentGroupIdentityName = currentGroupIdentityEntry
						.getListName();
				if (currentGroupIdentityName.equals(currentIdentityName)) {
					currentGroupIdentityList = currentGroupIdentityEntry
							.getElementList();
					for (int k = 0; k < currentGroupIdentityList.size(); k++) {
						tempName = (String) currentGroupIdentityList.get(k);
						ACLEntry newPermEntry = new ACLEntry(tempName,
								currentIdentityOperationList,
								currentIdentityMode);
						groupPermissions.add(newPermEntry);
					}
					groupPermissions.remove(i);
					i--;
					numPermEntries--;
					break;
				}
			}
		}
	}
	
   /**
	 * Helper function to display the contents of a list - not used currently
	 */
	private void showList(ArrayList groupList) {
		ACLEntry tempEntry;
		ArrayList elementList;
		String temp;

		for (int i = 0; i < groupList.size(); i++) {
			tempEntry = (ACLEntry) groupList.get(i);
			System.out.println("Group name : *" + tempEntry.getListName() + "*");
			System.out.println("Group elements are : ");
			elementList = tempEntry.getElementList();
			for (int j = 0; j < elementList.size(); j++) {
				temp = (String) elementList.get(j);
				System.out.print("*" + temp + "* //");
			}
			System.out.println("\nMode is : *" + tempEntry.getMode() + "*");
			System.out.println("***************************************");
		}
	}

	/**
	 * Helper function to ascertain whether a string is an X509DN or not - not used currently
	 */
	private boolean isValidDN(String name) {
		return ((name.indexOf("CN=") > 0) && (name.indexOf("OU=") > 0)
				&& (name.indexOf("O=") > 0) && (name.indexOf("L=") > 0)
				&& (name.indexOf("ST=") > 0) && (name.indexOf("C=") > 0));
	}
	
    /**
	 * Checks the requested operation and X509DN for validity against the
	 * constructed permission list. Will throw an appropriate Axis fault if the
	 * requested operation does not correlate with the permission list.
	 */
	public void checkRequestValidity(String entityName, String requestedOperation) throws Exception {
		ACLEntry currentPermEntry;
		String currentIdentityName, currentOperation;
		ArrayList currentIdentityOperationList;
		boolean foundMatchingName = false;
		boolean foundMatchingOperation = false;
		String currentIdentityMode = "";

		// Traverse permission list
		for (int i = 0; i < groupPermissions.size(); i++) {
			currentPermEntry = (ACLEntry) groupPermissions.get(i);
			currentIdentityName = (String) currentPermEntry.getListName();
			currentIdentityMode = (String) currentPermEntry.getMode();
			if (currentIdentityName.equals(entityName)
					|| currentIdentityName.equals(flagAllUsers)) {
				foundMatchingName = true;
				currentIdentityOperationList = currentPermEntry
						.getElementList();

				// Traverse operations for a given identity name in an entry in
				// the permission list
				// and compare against requested operation
				for (int j = 0; j < currentIdentityOperationList.size(); j++) {
					currentOperation = (String) currentIdentityOperationList
							.get(j);
					if (currentOperation.equals(requestedOperation)
							|| currentOperation.equals(flagAllOperations)) {
						foundMatchingOperation = true;
						break;
					}
				}
				break;
			}
		}

		if (foundMatchingName && !foundMatchingOperation
				&& currentIdentityMode.equals("allow")) {
			logger.fatal("Principal : " + entityName
					+ " recognized, operation " + requestedOperation
					+ " unauthorized !");
			throw new GrimoiresAuthorizationException("Principal : " + entityName
					+ " recognized, operation " + requestedOperation
					+ " unauthorized !");
		} else if (foundMatchingName && foundMatchingOperation
				&& currentIdentityMode.equals("restrict")) {
			logger.fatal("Principal : " + entityName
					+ " recognized, operation " + requestedOperation
					+ " unauthorized !");
			throw new GrimoiresAuthorizationException("Principal : " + entityName
					+ " recognized, operation " + requestedOperation
					+ " unauthorized !");
		} else if (!foundMatchingName) {
			logger.fatal("Principal : " + entityName
					+ " unrecognized !");
			throw new GrimoiresAuthorizationException("Principal : " + entityName
					+ " unrecognized !");
		}
	}
}
