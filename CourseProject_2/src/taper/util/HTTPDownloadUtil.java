package taper.util;
 
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
 
/**
 * A utility that can be used to open an InputStream to download file from a
 * URL. Provides some useful functions.
 * <br>
 * Based upon  
 * @author we.taper
 * 
 */
public class HTTPDownloadUtil {
 
    private HttpURLConnection httpConn;
 
    private InputStream inputStream;
 
    private String fileName;
    private long contentLength;
 
    /**
	 * Construct this with an URL to download.
	 * 
	 * @param fileURL
	 *            HTTP URL of the file to be downloaded
	 * @param cookie
	 *            The cookie String.
	 * @throws IOException
	 * @throws MalformedURLException
	 *             - if no protocol is specified, or an unknown protocol is
	 *             found, or spec is null.
	 */
    public HTTPDownloadUtil(String fileURL, String cookie) throws IOException {
        URL url = new URL(fileURL);
        httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("GET");
        if(cookie != null && !cookie.isEmpty()) {
        	httpConn.setRequestProperty("Cookie",cookie);
        }
        int responseCode = httpConn.getResponseCode();
 
        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
        	/*
        	 *  Content-Disposition tells us the suggested filename of this resource.
        	 *  See RFC 1806: http://www.ietf.org/rfc/rfc1806.txt
        	 */
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            contentLength = httpConn.getContentLengthLong();
 
            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10/*length of filename=*/,
                            disposition.length() - 1);
                }
            } else {
                // extracts file name from URL
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
                        fileURL.length());
            }
 
            // output for debugging purpose only
            // TODO clear this afterwards
            System.out.println("Content-Type = " + contentType);
            System.out.println("Content-Disposition = " + disposition);
            System.out.println("Content-Length = " + contentLength);
            System.out.println("fileName = " + fileName);
 
            // opens input stream from the HTTP connection
            inputStream = httpConn.getInputStream();
 
        } else {
            throw new IOException(
                    "No file to download. Server replied HTTP code: "
                            + responseCode);
        }
    }
 
    /** 
     * Close this connection.
     * @throws IOException
     */
    public void disconnect() throws IOException {
        inputStream.close();
        httpConn.disconnect();
    }
 
    /**
	 * Get name of file to be downloaded. If serve suggested a new filename
	 * instead of its original name, return it instead.
	 * 
	 * @return File's name
	 */
    public String getFileName() {
        return this.fileName;
    }
 
    /**
     * Get the length of file in bytes.
     * @return
     */
    public long getContentLength() {
        return this.contentLength;
    }
 
    /**
     * Get the InputStream for this URL.
     * @return
     */
    public InputStream getInputStream() {
        return this.inputStream;
    }
}