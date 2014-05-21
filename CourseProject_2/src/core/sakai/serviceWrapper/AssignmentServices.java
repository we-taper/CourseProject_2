package core.sakai.serviceWrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import core.sakai.objects.Constants;
import core.sakai.objects.SakaiAssignment;
import core.sakai.objects.SakaiAssignmentCollection;

public class AssignmentServices {

	public static void main(String[] args) throws IOException, JAXBException {
		SakaiAssignment[] assignments = getAssignmentsForSite("mercury",
				"fd1b44ea-6ee4-4857-809b-dfe5bdb8f0f0",
				"http://localhost:8080/");
		for (SakaiAssignment a : assignments) {
			System.out.println(a);
		}
	}

	/**
	 * Get all assignment for a site
	 * @param siteId e.g. mercury
	 * @param sessionStr The session that you got.
	 * @param serverURL URL points to the server
	 * @return An array of Assignments.
	 * @throws IOException
	 * @throws JAXBException
	 */
	public static SakaiAssignment[] getAssignmentsForSite(String siteId,
			String sessionStr, String serverURL) throws IOException,
			JAXBException {

		if (siteId.startsWith("/")) {
			siteId = siteId.substring(1, siteId.length());
		}
		if (siteId.endsWith("/")) {
			siteId = siteId.substring(0, siteId.length() - 1);
		}
		if (serverURL.endsWith("/")) {
			serverURL = serverURL.substring(0, serverURL.length() - 1);
		}

		URL url = new URL(serverURL + "/direct/assignment/site/" + siteId);
		String acceptType = "application/xml";
		String cookie = Constants.PRECEDE_TO_SESSION_ID + sessionStr
				+ Constants.APPEND_TO_SESSION_ID;
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		BufferedReader br = new BufferedReader(new InputStreamReader(
				getRemoteInputStream(conn, acceptType, cookie)));

		JAXBContext jc = JAXBContext
				.newInstance(SakaiAssignmentCollection.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		SakaiAssignmentCollection collection = (SakaiAssignmentCollection) unmarshaller
				.unmarshal(br);
		conn.disconnect();
		return collection.getAssignment().toArray(new SakaiAssignment[0]);
	}

	private static InputStream getRemoteInputStream(final HttpURLConnection conn,
			String acceptType, String cookie) throws IOException {
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", acceptType);
		conn.setRequestProperty("Cookie", cookie);
		// conn.setRequestProperty("Accept", "application/xml");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		return conn.getInputStream();
	}
}
