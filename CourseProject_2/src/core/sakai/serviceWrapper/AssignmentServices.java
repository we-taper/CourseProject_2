package core.sakai.serviceWrapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import taper.util.MyHTTPUtil;
import taper.util.XMLUtil;
import core.sakai.objects.SakaiConstants;
import core.sakai.objects.SakaiAssignment;
import core.sakai.objects.SakaiSubmission;
import core.sakai.wsdl.AssignmentsServiceStub;
import core.sakai.wsdl.AssignmentsServiceStub.CreateSubmission;
import core.sakai.wsdl.AssignmentsServiceStub.GetSubmissionsForAssignment;
import core.sakai.wsdl.ContentHostingServiceStub.GetContentData;

public class AssignmentServices {

	private static Logger log = Logger.getLogger(AssignmentServices.class);

	public static void main(String[] args) throws Exception {
		new TesterForThis().testCreSub();
	}

	private static class TesterForThis {
		private static void testGetAssign() throws Exception, JAXBException {
			SakaiAssignment[] assignments = getAssignmentsForSite("mercury",
					"df4c6378-a8cd-4ab3-b0a6-b3aab984d9a7",
					"http://localhost:8080/");
			for (SakaiAssignment a : assignments) {
				System.out.println(a.toString());
			}
		}

		private static void testGetAsignCont() throws Exception {
			System.out.println(getAssignmentContent("http://localhost:8080/",
					"mercury", "142c8ef4-2c0d-4119-9890-c08a5c2fedff",
					"df4c6378-a8cd-4ab3-b0a6-b3aab984d9a7"));
		}

		private static void testGetSubm() throws Exception {
			String ses = SakaiLogin.login("admin", "admin");
			SakaiSubmission[] sakaiSubmissions = getSubmissionsForAssignment(
					"a04e98ad-f233-4ff4-95b3-13653d1b3ed2", ses);
			SakaiLogin.logout(ses);
			for (SakaiSubmission s : sakaiSubmissions) {
				log.error(s);
			}
		}

		private static void testCreSub() throws Exception {
			String ses = SakaiLogin.login("admin", "admin");
			String context = "this is my context for submissioin 込込込込込込";
			String context2 = "mercury";
			String rep = createSubmission("142c8ef4-2c0d-4119-9890-c08a5c2fedff",
					context2, ses,
					System.currentTimeMillis(), "admin");
			SakaiLogin.logout(ses);
			log.error(rep);
		}
	}

	/**
	 * Get all assignments for a site
	 * 
	 * @param siteId
	 *            e.g. mercury
	 * @param sessionStr
	 *            The session that you got.
	 * @param serverURL
	 *            URL points to the server
	 * @return An array of Assignments.
	 * @throws IOException
	 *             if something wrong with the remote server or if the
	 *             {@link serverURL} is illegal.
	 * @throws JAXBException
	 *             if the message got from remote cannot be recognized.
	 * @throws RemoteException
	 *             if the session String is invalid.
	 */
	public static SakaiAssignment[] getAssignmentsForSite(String siteId,
			String sessionStr, String serverURL) throws IOException,
			JAXBException {

		@XmlRootElement(name = "assignment_collection")
		class SakaiAssignmentCollection {
			private List<SakaiAssignment> assignment;

			public List<SakaiAssignment> getAssignment() {
				return assignment;
			}

			@SuppressWarnings("unused")
			// Do not delete this method. It's important for a unmarshaller to
			// work.
			public void setAssignment(List<SakaiAssignment> assignment) {
				this.assignment = assignment;
			}

		}

		if (siteId.startsWith("/")) {
			siteId = siteId.substring(1, siteId.length());
		}
		if (siteId.endsWith("/")) {
			siteId = siteId.substring(0, siteId.length() - 1);
		}
		if (serverURL.endsWith("/")) {
			serverURL = serverURL.substring(0, serverURL.length() - 1);
		}

		/* Get general assignment */
		URL url = new URL(serverURL + "/direct/assignment/site/" + siteId);
		String acceptType = "application/xml";
		String cookie = SakaiConstants.PRECEDE_TO_SESSION_ID + sessionStr
				+ SakaiConstants.APPEND_TO_SESSION_ID;
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		BufferedReader br = new BufferedReader(new InputStreamReader(
				MyHTTPUtil.getRemoteInputStream(conn, acceptType, cookie),
				"UTF-8"));

		JAXBContext jc = JAXBContext
				.newInstance(SakaiAssignmentCollection.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		SakaiAssignmentCollection collection = (SakaiAssignmentCollection) unmarshaller
				.unmarshal(br);
		conn.disconnect();
		try {
			return collection.getAssignment().toArray(new SakaiAssignment[0]);
		} catch (NullPointerException e) {
			throw new RemoteException("The session String is invalid");
		}

	}

	/**
	 * Get the detailed information, especially the teacher's instruction for an
	 * assignment.
	 * 
	 * @param serverURL
	 * @param siteId
	 * @param assignmentId
	 * @param sessionStr
	 * @return The assignment content.
	 * @throws IOException
	 *             if the server URL is illegal or there's something wrong with
	 *             the Internet connection.
	 * @throws JAXBException
	 *             if we cannot process the information got from remote server.
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 *             if something wrong in parsing xml.
	 */
	public static SakaiAssignment.SakaiAssignmentContent getAssignmentContent(
			String serverURL, String siteId, String assignmentId,
			String sessionStr) throws IOException, JAXBException,
			ParserConfigurationException, SAXException {

		if (siteId.startsWith("/")) {
			siteId = siteId.substring(1, siteId.length());
		}
		if (siteId.endsWith("/")) {
			siteId = siteId.substring(0, siteId.length() - 1);
		}
		if (serverURL.endsWith("/")) {
			serverURL = serverURL.substring(0, serverURL.length() - 1);
		}
		String urlString = serverURL + "/direct/assignment/annc/" + siteId
				+ "/" + assignmentId;
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		String acceptType = "application/xml";
		String cookie = SakaiConstants.PRECEDE_TO_SESSION_ID + sessionStr
				+ SakaiConstants.APPEND_TO_SESSION_ID;
		Document document = XMLUtil.loadXMLFromInputStream(MyHTTPUtil
				.getRemoteInputStream(conn, acceptType, cookie));
		Node content = document.getElementsByTagName("content").item(0);
		return getAssignmentContent(content);
	}

	/**
	 * 
	 * @param contentNode
	 * @return
	 * @throws JAXBException
	 *             if we cannot process the information got from remote server.
	 */
	private static SakaiAssignment.SakaiAssignmentContent getAssignmentContent(
			Node contentNode) throws JAXBException {

		// Remove all trouble properties.
		NodeList propertieslist = null;
		NodeList nodelist = contentNode.getChildNodes();
		for (int i = 0; i < nodelist.getLength(); i++) {
			if (nodelist.item(i).getNodeName().equals("properties")) {
				propertieslist = nodelist.item(i).getChildNodes();
			}
		}
		while (propertieslist.getLength() > 0) {
			propertieslist.item(0).getParentNode()
					.removeChild(propertieslist.item(0));
		}

		JAXBContext jc = JAXBContext
				.newInstance(SakaiAssignment.SakaiAssignmentContent.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		SakaiAssignment.SakaiAssignmentContent content2 = (SakaiAssignment.SakaiAssignmentContent) unmarshaller
				.unmarshal(contentNode);
		return content2;
	}

	/**
	 * TODO test
	 * 
	 * @param assignmentId
	 * @param context
	 * @param session
	 * @param time
	 * @param userId
	 * @return
	 * @throws RemoteException
	 */
	public static String createSubmission(String assignmentId, String context,
			String session, long time, String userId) throws RemoteException {
		AssignmentsServiceStub stub = new AssignmentsServiceStub();
		AssignmentsServiceStub.CreateSubmission a = new AssignmentsServiceStub.CreateSubmission();
		a.setAssignmentId(assignmentId);
		a.setContext(context);
		a.setSessionId(session);
		a.setTime(time);
		a.setUserId(userId);
		AssignmentsServiceStub.CreateSubmissionResponse b = stub
				.createSubmission(a);
		return b.getCreateSubmissionReturn();
	}

	/**
	 * Get all submitted submission for an assignment.
	 * 
	 * @param assignmentId
	 * @param session
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 *             if the xml got from server has something wrong.
	 * @throws ParserConfigurationException
	 * @throws JAXBException
	 *             if we cannot store XML into java object.
	 */
	public static SakaiSubmission[] getSubmissionsForAssignment(
			String assignmentId, String session)
			throws ParserConfigurationException, SAXException, IOException,
			JAXBException {
		String submissionsXml = getSubmissionsForAssignmentInXML(assignmentId,
				session);
		Document submissionsDoc = XMLUtil.loadXMLFromString(submissionsXml);
		Node temp = submissionsDoc.getChildNodes().item(0);
		NodeList submissions = temp.getChildNodes();
		SakaiSubmission[] submissions_array = new SakaiSubmission[submissions
				.getLength()];
		for (int i = 0; i < submissions.getLength(); i++) {
			JAXBContext jc = JAXBContext.newInstance(SakaiSubmission.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			submissions_array[i] = (SakaiSubmission) unmarshaller
					.unmarshal(submissions.item(i));
		}
		return submissions_array;
	}

	/**
	 * 
	 * @param assignmentId
	 * @param session
	 * @returns
	 * @throws RemoteException
	 */
	private static String getSubmissionsForAssignmentInXML(String assignmentId,
			String session) throws RemoteException {
		AssignmentsServiceStub stub = new AssignmentsServiceStub();
		AssignmentsServiceStub.GetSubmissionsForAssignment a = new AssignmentsServiceStub.GetSubmissionsForAssignment();
		a.setAssignmentId(assignmentId);
		a.setSessionId(session);
		AssignmentsServiceStub.GetSubmissionsForAssignmentResponse b = stub
				.getSubmissionsForAssignment(a);
		return b.getGetSubmissionsForAssignmentReturn();
	}
}
