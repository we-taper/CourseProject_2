package core.sakai.serviceWrapper;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.axis2.AxisFault;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import taper.util.XMLUtil;
import core.sakai.objects.Site;
import core.sakai.wsdl.SakaiScriptServiceStub;

public class SakaiScript {

	private SakaiScriptServiceStub stub;
	public SakaiScript() throws AxisFault {
		stub = new SakaiScriptServiceStub();
	}
	
	/**
	 * Change the Email address of a user. Admin can modify other's email address.
	 * @param sessionID
	 * @param userName the login username (ie jsmith26) of the user you want to edit
	 * @param email the updated email address for the user
	 * @return success or exception message.
	 * @throws RemoteException Something went wrong.
	 * TODO test
	 */
	public String changeUserEmail(String sessionID, String userName, String email) throws RemoteException {
		SakaiScriptServiceStub.ChangeUserEmail op = new SakaiScriptServiceStub.ChangeUserEmail();
		op.setSessionid(sessionID);
		op.setEid(userName);
		op.setEmail(email);
		SakaiScriptServiceStub.ChangeUserEmailResponse response = stub.changeUserEmail(op);
		return response.getChangeUserEmailReturn();
	}
	
	/**
	 * Get all sites related to a user.
	 * 
	 * @param sessionID
	 * @return An array containing all the sites retrieved from Sakai.
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public Site[] getAllSitesForUser (String sessionID) throws ParserConfigurationException, SAXException, IOException {
		String xml = getAllSitesForUserInXml(sessionID);
		Document read = XMLUtil.loadXMLFromString(xml);
		NodeList itemList = read.getElementsByTagName("item");
		ArrayList<Site> sites = new ArrayList<>();
		for(int i = 0; i < itemList.getLength(); i++) {
			Site aSite = new Site();
			
			Element oneItem = (Element) itemList.item(i);
			NodeList siteId = oneItem.getElementsByTagName("siteId");
			assert siteId.getLength() == 1;
			Element line = (Element) siteId.item(0);
			aSite.setID(line.getFirstChild().getTextContent());
			
			NodeList siteTitle = oneItem.getElementsByTagName("siteTitle");
			assert siteTitle.getLength() == 1;
			line = (Element) siteId.item(0);
			aSite.setTitle(line.getFirstChild().getTextContent());
			
			sites.add(aSite);
		}
		return sites.toArray(new Site[0]);
	}
	
	/**
	 * Get all sites related to a user.
	 * 
	 * @param sessionID
	 * @return XML document listing all sites user has read or write access
	 *         based on their session id, including My Workspace sites.
	 * @throws RemoteException Something went wrong.
	 * TODO test
	 */
	private String getAllSitesForUserInXml (String sessionID) throws RemoteException {
		SakaiScriptServiceStub.GetAllSitesForUser op = new SakaiScriptServiceStub.GetAllSitesForUser();
		op.setSessionid(sessionID);
		SakaiScriptServiceStub.GetAllSitesForUserResponse response = stub.getAllSitesForUser(op);
		return response.getGetAllSitesForUserReturn();
	}
	
	/**
	 * Get a user's email address based on their session id 
	 * 
	 * @param sessionID
	 * @return User's email address.
	 * @throws RemoteException
	 * TODO test
	 */
	public String getUserEmail(String sessionID) throws RemoteException {
		SakaiScriptServiceStub.GetUserEmail op = new SakaiScriptServiceStub.GetUserEmail();
		op.setSessionid(sessionID);
		SakaiScriptServiceStub.GetUserEmailResponse response = stub.getUserEmail(op);
		return response.getGetUserEmailReturn();
	}
	
	/**
	 * Gets the user ID associated with the session id.
	 * 
	 * @param sessionID
	 * @return
	 * @throws RemoteException
	 * TODO test
	 */
	public String getUserId(String sessionID) throws RemoteException {
		SakaiScriptServiceStub.GetUserId op = new SakaiScriptServiceStub.GetUserId();
		op.setSessionid(sessionID);
		SakaiScriptServiceStub.GetUserIdResponse response = stub.getUserId(op);
		return response.getGetUserIdReturn();
	}
}
