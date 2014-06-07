package control;
import java.io.IOException;
import java.rmi.RemoteException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import core.sakai.objects.SakaiSiteInfo;
import core.sakai.serviceWrapper.ContentHosting;

public class Resources
{
	public static void main(String[] args) throws RemoteException, ParserConfigurationException, SAXException, IOException, JAXBException
	{
		LoginControl.login("admin", "admin");
		Sites.updateSites();
		getResources();
	}
	
	private static void getResources() throws RemoteException, ParserConfigurationException, SAXException, IOException, JAXBException
	{
		SakaiSiteInfo[] sites =
		new ContentHosting(LocalConstants.sessionID).getAllSitesCollection();
		
		for(SakaiSiteInfo site : sites)
		{
			System.out.println(site.getTitle());
		}
	}
}
