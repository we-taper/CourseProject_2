package taper.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * A Class for convenience in dealing with BASE64 data in Sakai.
 * @author we.taper
 *
 */
public class SakaiBase64Decoder {

	private static BASE64Encoder encoder = new BASE64Encoder();
	private static BASE64Decoder decoder = new BASE64Decoder();
	
	public static String encode2Base64(byte[] data) {
		return encoder.encode(data);
	}
	public static byte[] decodeBase64(String base64String) throws IOException {
		return decoder.decodeBuffer(base64String);
	}
	/**
	 * Convenient read whole file into one String
	 * @param file The file to read. Must encoded using UTF-8!!
	 * @return
	 * @throws IOException
	 */
	public static String readFileAsString(File file) throws IOException {
		try (BufferedReader reader = Files.newBufferedReader(file.toPath(),
				StandardCharsets.UTF_8)) {
			StringBuffer result = new StringBuffer();
			for (;;) {
				String line = reader.readLine();
				if (line == null)
					break;
				result.append(line);
			}
			return result.toString();
		}
	}
	
	public static void writeByte2File(byte[] data, File dest) throws IOException {
		Files.write(dest.toPath(), data, StandardOpenOption.CREATE);
	}
	
	public static void decodeAndWrite2File(String base64String, File dest) throws IOException {
		writeByte2File(decodeBase64(base64String), dest);
	}
}
