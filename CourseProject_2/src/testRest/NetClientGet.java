package testRest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetClientGet {

	public static void main(String[] args) {

		try {
			String sesID = "JSESSIONID=b81a9ba0-d5ac-4eac-b4b8-04e5c003f38b.localhost";
			
			String assign = "http://10.20.0.15:8080/direct/assignment/site/mercury.json";
			String assign_Single = "http://10.20.0.15:8080/direct/assignment/403d28b4-e152-463d-a615-972db97d34d3.json";
			String assign_deepLink = "http://10.20.0.15:8080/direct/assignment/deepLink/mercury/403d28b4-e152-463d-a615-972db97d34d3.json";
			String anoce = "http://10.20.0.15:8080/direct/announcement/site/7ba242f6-b728-478b-a126-431aafbde62e.json";
			String myAnoce = "http://10.20.0.15:8080/direct/announcement/user.json";
			String anoce_Single = "http://10.20.0.15:8080/direct/announcement/mercury:main:e54dc676-5956-4158-b3ce-e802a80f0b4f.json";
			String anoce_普通生物学的公告  = "http://learning.sustc.edu.cn/access/content/attachment/7ba242f6-b728-478b-a126-431aafbde62e/%E9%80%9A%E7%9F%A5/d5b089bd-0b21-4989-9289-9cffd1293fbf/%E8%80%83%E7%94%9F%E9%A1%BB%E7%9F%A5.doc";
//			String anounce = "http://10.20.0.15:8080/direct/announcement/site/mercury";
			URL url = new URL(
					anoce_普通生物学的公告);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Cookie", sesID);
			// conn.setRequestProperty("Accept", "application/xml");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}