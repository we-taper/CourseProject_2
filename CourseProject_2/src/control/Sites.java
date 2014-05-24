package control;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import core.sakai.serviceWrapper.SiteServices;


import core.sakai.objects.SakaiConstants;
import core.sakai.objects.SakaiSite;

@SuppressWarnings("unchecked")
public class Sites 
{
	static 
	{
		try(ObjectInputStream loader = 
				new ObjectInputStream(new BufferedInputStream
						(new FileInputStream(LocalInfo.sitesMapPath))))
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
	
	public static String[] loadSites() throws ParserConfigurationException, SAXException, IOException, JAXBException
	{
		SakaiSite[] sites = 
				SiteServices.getSitesForUser(LocalInfo.sessionID, SakaiConstants.SERVER_URL);
		for(SakaiSite site:sites)
		{
			sitesInfo.put(site.getTitle(), site);
		}
		
		return sitesInfo.keySet().toArray(new String[0]);
	}
	
	


}
