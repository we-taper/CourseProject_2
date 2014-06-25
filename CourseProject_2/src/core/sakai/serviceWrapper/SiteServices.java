package core.sakai.serviceWrapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import taper.util.MyHTTPUtil;
import taper.util.XMLUtil;
import core.sakai.objects.SakaiAnnouncement;
import core.sakai.objects.SakaiAssignment.SakaiAssignmentContent;
import core.sakai.objects.SakaiConstants;
import core.sakai.objects.SakaiSite;

public class SiteServices {

	private static Logger log = Logger.getLogger(SiteServices.class);

	public static void main(String[] args) throws Exception {
		String sessionStr = SakaiLogin.login("test", "test");
		String serverURL = "http://localhost:8080/";
		getSitesForUser(sessionStr, serverURL);
	}

	/**
	 * Get all the sites available for this user representing by sessionStr.
	 * 
	 * @param sessionStr
	 * @param serverURL
	 * @return
	 * @throws IOException
	 *             If URL is illegal or something wrong on the server side.
	 * @throws SAXException
	 *             If the data retrieved from server is invalid.
	 * @throws ParserConfigurationException
	 *             If the data retrieved from server is invalid.
	 * @throws JAXBException
	 *             If the data retrieved from server is invalid.
	 */
	public static SakaiSite[] getSitesForUser(String sessionStr,
			String serverURL) throws ParserConfigurationException,
			SAXException, IOException, JAXBException {
		if (serverURL.endsWith("/")) {
			serverURL = serverURL.substring(0, serverURL.length() - 1);
		}

		URL url = new URL(serverURL + "/direct/site");
		String acceptType = "application/xml";
		String cookie = SakaiConstants.PRECEDE_TO_SESSION_ID + sessionStr
				+ SakaiConstants.APPEND_TO_SESSION_ID;
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		Document sitesDocument = XMLUtil.loadXMLFromInputStream(MyHTTPUtil
				.getRemoteInputStream(conn, acceptType, cookie));

		NodeList sites = sitesDocument.getElementsByTagName("site");

		SakaiSite[] sites_array = new SakaiSite[sites.getLength()];
		JAXBContext jc = JAXBContext.newInstance(SakaiSite.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		for (int i = 0; i < sites.getLength(); i++) {
			sites_array[i] = (SakaiSite) unmarshaller.unmarshal(sites.item(i));
			sites_array[i].assignments = 
					new java.util.HashMap<String, SakaiAssignmentContent>();
			sites_array[i].setAllAnnouncements
					(new java.util.HashMap<String, SakaiAnnouncement>());
		}

		conn.disconnect();

		return sites_array;
	}
}
