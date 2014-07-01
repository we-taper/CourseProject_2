package taper.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class MyHTTPUtil {

	public static InputStream getRemoteInputStream(final HttpURLConnection conn,
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
