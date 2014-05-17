package taper.util;

import java.awt.Component;
import java.awt.Container;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.apache.log4j.Logger;


/**
 * Download file in a background thread and update the progress. Using
 * SwingWorker.
 * 
 * @author we.taper
 *
 */
public class DownloadTask4GUI extends SwingWorker<Void, Void> {

    private static final int BUFFER_SIZE = 4096;   
    private String downloadURL, cookie;
    private String saveDirectory;
    private Component parent;
    private Logger log = Logger.getLogger(this.getClass());
    
    /**
	 * @param cookie
	 *            The cookie String, e.g.
	 *            "JSESSIONID=5cc93ba0-7642-459c-ba35-5e598680eab9.localhost"
	 *            for Sakai.
	 */
    public DownloadTask4GUI(Container gui, String downloadURL, String cookie, String saveDirectory) {
    	this.parent = gui;
    	this.cookie = cookie;
        this.downloadURL = downloadURL;
        this.saveDirectory = saveDirectory;
    }
     
	@Override
	protected Void doInBackground() {
        HTTPDownloadUtil util;
        InputStream inputStream;
        FileOutputStream outputStream;
        try {
            util = new HTTPDownloadUtil(downloadURL,cookie);
             
            String saveFilePath = saveDirectory + File.separator + util.getFileName();
 
            // opens an output stream to save into file
            inputStream = util.getInputStream();
            outputStream = new FileOutputStream(saveFilePath);
 
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
            long totalBytesRead = 0;
            int percentCompleted = 0;
            long fileSize = util.getContentLength();
 
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;
                percentCompleted = (int) (totalBytesRead * 100 / fileSize);
                setProgress(percentCompleted);         
            }
 
            outputStream.close();
            util.disconnect();
        } catch (IOException ex) {
        	errorOp(ex);
            log.error("Download error", ex);
            setProgress(0);
            cancel(true);          
        }
        return null;
	}

	@Override
    protected void done() {
        if (!isCancelled()) {
        	doneOp();
        }
    }
	
	protected void doneOp(){
        JOptionPane.showMessageDialog(parent,
                "File has been downloaded successfully!", "Message",
                JOptionPane.INFORMATION_MESSAGE);
	}
	
	protected void errorOp(Exception ex) {
        JOptionPane.showMessageDialog(parent, "Error downloading file: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);    
	}
}
