package core.sakai.objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

public final class SakaiConstants {

	public static final String APPEND_TO_SESSION_ID;
//	/** For Publication */
//	public static final String APPEND_TO_SESSION_ID = ".SUSTC-Learning";
	public static final String PRECEDE_TO_SESSION_ID;
	public static final String SERVER_URL;
	static {
		Unmarshaller unmarshaller;
		Logger log = Logger.getLogger(SakaiConstants.class);
		Property property = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(new File(".\\Config\\config.xml")), "UTF-8"));

			JAXBContext jc = JAXBContext
					.newInstance(Property.class);
			unmarshaller = jc.createUnmarshaller();
			property = (Property) unmarshaller
					.unmarshal(br);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal("Error reading configuration file \"Config\\config.xml\"", e);
			System.exit(1);
		}
		APPEND_TO_SESSION_ID = property.APPEND_TO_SESSION_ID;
		PRECEDE_TO_SESSION_ID = property.PRECEDE_TO_SESSION_ID;
		SERVER_URL = property.SERVER_URL;
	}

	
	@XmlRootElement(name = "properties")
	private static class Property{
		@XmlElement(name = "comment")
		private String comment;
		@XmlElement(name = "SERVER_URL")
		private String SERVER_URL;
		@XmlElement(name = "PRECEDE_TO_SESSION_ID")
		private String PRECEDE_TO_SESSION_ID;
		@XmlElement(name = "APPEND_TO_SESSION_ID")
		private String APPEND_TO_SESSION_ID;
	}
}
