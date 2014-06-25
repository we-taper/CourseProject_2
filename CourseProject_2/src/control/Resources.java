package control;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import GUI.VersionUtil;
import GUI.myDialog;
import taper.util.SakaiBase64Decoder;
import core.sakai.objects.SakaiAnnouncement;
import core.sakai.objects.SakaiResource;
import core.sakai.objects.SakaiSite;
import core.sakai.serviceWrapper.ContentHosting;



/**
 * Provide mathod for downloading resource form specific 
 * <code>SakaiSite.</code> 
 * 
 */
public class Resources
{
	
	private final static String APP_PATH;
//	Static initialize block, find current path of program.
	static
	{
		File current = new File("");
		APP_PATH = current.getAbsolutePath() + "\\Resources";
	}
	
	/**
	 * The method for updating resource for specific <code>SakaiSite.</code>  
	 * 
	 *  <p>Exception is not expected to be caught by application because  
	 * It often indicates problem on the server site.</p>
	 * 
	 * @param targetSite Target site which need to be updated. 
	 * @param handler The event handler which is called if new resource is added.
	 *
	 */			
	
	public static void updateSiteResource(final SakaiSite targetSite, final ResourceAdd handler) throws RemoteException, ParserConfigurationException, SAXException, IOException, JAXBException
	{
		String id = "/group/" + targetSite.getId() + "/";
		SakaiResource[] ress = 
				new ContentHosting(LocalConstants.sessionID).getResources(id);
		
		for(SakaiResource res : ress)
		{
			if(res.getType().equals("collection"))
			{
				String path = urlToPath(res.getUrl(), id);
				path = trimPath(path, res.getName());
				createPath(id.replace("/", "\\") + path);
			}
		}
		
		ExecutorService tasks = Executors.newCachedThreadPool();
		
		for(SakaiResource res : ress)
		{
			if(res.getType().equals("resource"))
			{
				String path = urlToPath(res.getUrl(), id);
				path = trimPath(path, res.getName());
				
				final SakaiResource downloadRes = res;
				final String downloadPath = APP_PATH + id.replace("/", "\\") + path;
				final File resource = new File(downloadPath);
				
				if(!resource.exists())
				{
					tasks.execute(
							new Runnable()
							{
								@Override
								public void run()
								{
									try 
									{
										downloadFile(downloadRes, downloadPath);
										new VersionUtil
										("新资源", downloadRes.getName(), "请到资源中查看");
										if(handler != null)
										{
											handler.resourceAdd(resource);
										}
									} 
									catch (IOException e) 
									{
										e.printStackTrace();
									}
								}
							});
				}
			}
		}
	}
	
	public static void main(String[] args) throws RemoteException, ParserConfigurationException, SAXException, IOException, JAXBException
	{
//		For testing only
		LoginControl.login("admin", "admin");
		
	
	}
	
	/**
	 * Create resource for a newly added site, or the first time 
	 * the program is being executed.
	 * 
	 * @param targetSite The Target site whose resource need to be constructed.
	 */
	
	public static void createResources(SakaiSite targetSite) throws RemoteException, ParserConfigurationException, SAXException, IOException, JAXBException
	{
		String id = "/group/" + targetSite.getId() + "/";
		SakaiResource[] ress = 
				new ContentHosting(LocalConstants.sessionID).getResources(id);
		
		for(SakaiResource res : ress)
		{
			if(res.getType().equals("collection"))
			{
				String path = urlToPath(res.getUrl(), id);
				path = trimPath(path, res.getName());
				createPath(id.replace("/", "\\") + path);
			}
		}
		
		ExecutorService tasks = Executors.newCachedThreadPool();
		
		for(SakaiResource res : ress)
		{
			if(res.getType().equals("resource"))
			{
				String path = urlToPath(res.getUrl(), id);
				path = trimPath(path, res.getName());
				
				final SakaiResource downloadRes = res;
				final String downloadPath = APP_PATH + id.replace("/", "\\") + path;
				
				tasks.execute(
				new Runnable()
				{
					@Override
					public void run()
					{
						try 
						{
							
							downloadFile(downloadRes, downloadPath);
						} 
						catch (IOException e) 
						{
							e.printStackTrace();
						}
					}
				});
			
			}
		}
		
		
	}
	
	private static void downloadFile(SakaiResource res, String path) throws IOException
	{
		String content = new ContentHosting(LocalConstants.sessionID).getContentData(res.getID());
		
		File resourceFile = new File(path);
		resourceFile.createNewFile();
		
		SakaiBase64Decoder.decodeAndWrite2File(content, resourceFile);
	}
	
	
	private final static String LEADING = ".*";
	private final static String TAIL = "(.*)";
	
	private static String urlToPath(String url, String id)
	{
		
		java.util.regex.Pattern pattern = 
				java.util.regex.Pattern.compile(LEADING + id + TAIL);
		
		Matcher matcher = pattern.matcher(url);
		
		matcher.find();
		return matcher.group(1);
	}
	
	
	private static String trimPath(String path, String name)
	{
		Matcher matcher = java.util.regex.Pattern.compile("^(.*/)?.+?$").matcher(path);

		matcher.find();
		String leading = matcher.group(1);
		if(leading == null)
		{
			leading = "";
		}
		
		return (leading + name).replace("/", "\\");
	}
	
	private static boolean createPath(String path) throws IOException
	{
		path = APP_PATH + path;

		File filePath = new File(path);
		if(!filePath.exists())
		{
			return filePath.mkdirs();
		}
		
		return false;
	}
	
}
