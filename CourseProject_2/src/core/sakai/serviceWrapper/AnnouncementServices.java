package core.sakai.serviceWrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

import taper.util.MyHTTPUtil;
import core.sakai.objects.Constants;
import core.sakai.objects.SakaiAnnouncement;

public class AnnouncementServices {
	
	public static void main(String[] args) throws IOException, JAXBException{
		SakaiAnnouncement[] as = getAnnouncementsForSite("mercury",
				"fd1b44ea-6ee4-4857-809b-dfe5bdb8f0f0",
				"http://localhost:8080/");
		for (SakaiAnnouncement a : as) {
			System.out.println(a);
		}
	}
	
	public static SakaiAnnouncement[] getAnnouncementsForSite(String siteId,
			String sessionStr, String serverURL) throws IOException,
			JAXBException {

		@XmlRootElement(name = "announcement_collection")
		class SakaiAnnouncementCollection {
			private List<SakaiAnnouncement> announcement;
			public List<SakaiAnnouncement> getAnnouncement() {
				return announcement;
			}
			@SuppressWarnings("unused")
			public void setAnnouncement(List<SakaiAnnouncement> announcement) {
				this.announcement = announcement;
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

		URL url = new URL(serverURL + "/direct/announcement/site/" + siteId);
		String acceptType = "application/xml";
		String cookie = Constants.PRECEDE_TO_SESSION_ID + sessionStr
				+ Constants.APPEND_TO_SESSION_ID;
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		BufferedReader br = new BufferedReader(new InputStreamReader(
				MyHTTPUtil.getRemoteInputStream(conn, acceptType, cookie), "UTF-8"));

		JAXBContext jc = JAXBContext
				.newInstance(SakaiAnnouncementCollection.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		SakaiAnnouncementCollection collection = (SakaiAnnouncementCollection) unmarshaller
				.unmarshal(br);
		conn.disconnect();
		return collection.getAnnouncement().toArray(new SakaiAnnouncement[0]);

	}
}
