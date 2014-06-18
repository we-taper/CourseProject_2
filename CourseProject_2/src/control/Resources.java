package control;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import taper.util.SakaiBase64Decoder;
import core.sakai.objects.SakaiResource;
import core.sakai.objects.SakaiSite;
import core.sakai.serviceWrapper.ContentHosting;

public class Resources
{
	private final static String APP_PATH;
	
	
	static
	{
		File current = new File("");
		APP_PATH = current.getAbsolutePath() + "\\Resources";
	}
	
	public static void updateSiteResource(SakaiSite targetSite, final ResourceAdd handler) throws RemoteException, ParserConfigurationException, SAXException, IOException, JAXBException
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
										handler.resourceAdd(resource);
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
		createResources(Sites.getAllSites().get("mercury site"));
	}
	
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
