package taper.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.log4j.Logger;


public class MIMEUtil {
	private static Logger log = Logger.getLogger("taper.util.MIMEUtil");
	
	/**
	 * @deprecated Test only.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		System.out.println(getMIMETypeFrom("html"));
	}
	/**
	 * 
	 * @param file The file does not have to exist!
	 * @return The content type of the file, or null if the content type cannot be determined.
	 * @throws IOException
	 */
	public static String getMIMETypeFrom(File file) throws IOException {
		return Files.probeContentType(file.toPath());
	}
	
	/**
	 * 
	 * @param fileExt The extension of a file.
	 * @return The content type of the file, or null if the content type cannot be determined.
	 * @throws IOException 
	 */
	public static String getMIMETypeFrom(String fileExt) {
		try {
			return getMIMETypeFrom(new File("abc."+fileExt));
		} catch (IOException e) {
			log.error("",e);
			return null;
		}
	}
}
