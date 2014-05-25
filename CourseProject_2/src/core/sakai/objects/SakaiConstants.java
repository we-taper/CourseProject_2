package core.sakai.objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import javax.swing.JOptionPane;

public final class SakaiConstants {

	public static String APPEND_TO_SESSION_ID;
	public static String PRECEDE_TO_SESSION_ID;
	public static String SERVER_URL;

	static {
		try {
			FileInputStream fis = new FileInputStream(new File(
					"Config\\config.xml"));
			Properties properties = new Properties();
			properties.loadFromXML(fis);
			APPEND_TO_SESSION_ID = properties
					.getProperty("APPEND_TO_SESSION_ID");
			PRECEDE_TO_SESSION_ID = properties
					.getProperty("PRECEDE_TO_SESSION_ID");
			SERVER_URL = properties.getProperty("SERVER_URL");
		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(
							null,
							"Cannot load configuration file: Config\\config.xml. The application is missing some important files. Will now close.",
							"Error", JOptionPane.WARNING_MESSAGE);
		}

	}
}
