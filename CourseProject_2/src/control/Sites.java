package control;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Set;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import core.sakai.serviceWrapper.SiteServices;
import core.sakai.objects.SakaiConstants;
import core.sakai.objects.SakaiSite;

/**
 * Sites class holds local data,
 * including <code>SakaiSite</code> and 
 *<code>SakaiAssignment</code>, <code>SakaiAnnouncement</code>
 * associate with that Site.
 */

@SuppressWarnings("unchecked")
public class Sites 
{
	private static SitesAdd handler;
	
//	Static caluse read data from local storage.
	static
	{
		sitesInfo = new HashMap<String, SakaiSite>();
		
		try(ObjectInputStream loader = 
				new ObjectInputStream(new BufferedInputStream
						(new FileInputStream(LocalConstants.sitesMapPath))))
		{
			sitesInfo = (HashMap<String, SakaiSite>)loader.readObject();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(EOFException e)
		{
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
	}
	
	public static HashMap<String, SakaiSite> sitesInfo;
	
	public static void addSitesAddHandler(SitesAdd handler)
	{
		Sites.handler = handler;
	}
	
	/**
	 * Find if there is new site added. 
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws JAXBException
	 */
	
	public static void updateSites() throws ParserConfigurationException, SAXException, IOException, JAXBException
	{
		SakaiSite[] sites = 
				SiteServices.getSitesForUser(LocalConstants.sessionID, SakaiConstants.SERVER_URL);
		Set<String> siteTitles = sitesInfo.keySet();
		
		for(SakaiSite site:sites)
		{
			if(!siteTitles.contains(site.getTitle()))
			{
				
				try
				{
					site.updataAnnouncement();
					site.updateAssignment();
				}
				catch(Exception e)
				{
//					e.printStackTrace();
				}
				
				
				sitesInfo.put(site.getTitle(), site);
				if(handler != null)
				{
					handler.siteAdd(site);
				}
			}
		}
	}
	
	/**
	 * Write all information onto storage
	 */
	
	public static void saveInfo()
	{
		try(ObjectOutputStream saver = 
				new ObjectOutputStream(new BufferedOutputStream
						(new FileOutputStream(LocalConstants.sitesMapPath))))
		{
			saver.writeObject(sitesInfo);
			saver.flush();
		} 
		
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Get a <code>HashMap</code> for all sites.
	 * @return HashMap(SiteTitle, Site Object)
	 */
	
	public static HashMap<String, SakaiSite> getAllSites()
	{
		return sitesInfo;
	}

	


}

