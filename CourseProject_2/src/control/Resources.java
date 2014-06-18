package control;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import core.sakai.objects.SakaiResource;
import core.sakai.objects.SakaiSite;
import core.sakai.serviceWrapper.ContentHosting;

public class Resources
{
	private final static String APP_PATH;
	static
	{
		File current = new File("");
		APP_PATH = current.getAbsolutePath();
	}
	
	public static void main(String[] args) throws RemoteException, ParserConfigurationException, SAXException, IOException, JAXBException
	{
		
	}
	
	public static void getResources(SakaiSite targetSite) throws RemoteException, ParserConfigurationException, SAXException, IOException, JAXBException
	{
		String id = "/group/" + targetSite.getId() + "/";
		
		System.out.println(id);
		
		SakaiResource[] ress = 
				new ContentHosting(LocalConstants.sessionID).getResources(id);
		System.out.println(ress.length);
		
		for(SakaiResource res : ress)
		{
			
		}
	}
	
	private static boolean createPath(String path) throws IOException
	{
		path = APP_PATH + path;

		File filePath = new File(path);
		return filePath.mkdir();
	}
	
}
