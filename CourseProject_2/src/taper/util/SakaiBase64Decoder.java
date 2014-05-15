package taper.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import com.sun.corba.se.impl.orb.ParserTable.TestAcceptor1;

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
	public static byte[] decodeBase64ToByte(String base64String) throws IOException {
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
		writeByte2File(decodeBase64ToByte(base64String), dest);
	}
	
    /**
     * Read all the bytes from a file. The method ensures that the file is
     * closed when all bytes have been read or an I/O error, or other runtime
     * exception, is thrown.
     *
     * <p> Note that this method is intended for simple cases where it is
     * convenient to read all bytes into a byte array. It is not intended for
     * reading in large files.
     *
     * @param   path
     *          the path to the file
     *
     * @return  a byte array containing the bytes read from the file
     *
     * @throws  IOException
     *          if an I/O error occurs reading from the stream
     * @throws  OutOfMemoryError
     *          if an array of the required size cannot be allocated, for
     *          example the file is larger that {@code 2GB}
     * @throws  SecurityException
     *          In the case of the default provider, and a security manager is
     *          installed, the {@link SecurityManager#checkRead(String) checkRead}
     *          method is invoked to check read access to the file.
     */
	public static byte[] readFileAsByte(File fileToRead) throws IOException {
		return Files.readAllBytes(fileToRead.toPath());
	}
}
