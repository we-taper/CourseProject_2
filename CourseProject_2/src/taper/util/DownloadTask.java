package taper.util;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
 

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.apache.log4j.Logger;
 
/**
 * Execute file download in a background thread and update the progress.
 * @author www.codejava.net
 *
 */
public class DownloadTask extends SwingWorker<Void, Void> {
    private static final int BUFFER_SIZE = 4096;   
    private String downloadURL;
    private String saveDirectory;
    private String cookie;
    private Logger log = Logger.getLogger(DownloadTask.class);
     
    public DownloadTask( String downloadURL, String saveDirectory) {
    	this(downloadURL, saveDirectory, "");
    }
    
    public DownloadTask( String downloadURL, String saveDirectory, String cookie) {
        this.downloadURL = downloadURL;
        this.saveDirectory = saveDirectory;
        this.cookie = cookie;
    }
    /**
     * Executed in background thread
     */
    @Override
    protected Void doInBackground() throws Exception {
        try {
            HTTPDownloadUtil util = new HTTPDownloadUtil();
            util.downloadFile(downloadURL,cookie);
             
             
            String saveFilePath = saveDirectory + File.separator + util.getFileName();
 
            InputStream inputStream = util.getInputStream();
            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
 
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
            long totalBytesRead = 0;
            int percentCompleted = 0;
            long fileSize = util.getContentLength();
 
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;
                percentCompleted = (int) (totalBytesRead * 100 / fileSize);
                log.debug("read:"+bytesRead);
                setProgress(percentCompleted);         
            }
 
            outputStream.close();
 
            util.disconnect();
        } catch (IOException ex) {
            ex.printStackTrace();
            setProgress(0);
            cancel(true);          
        }
        return null;
    }
 
    /**
     * Executed in Swing's event dispatching thread
     */
    @Override
    protected void done() {
        if (!isCancelled()) {
        }
    }  
}