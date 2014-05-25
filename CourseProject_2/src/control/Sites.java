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

@SuppressWarnings("unchecked")
public class Sites 
{
	public static SitesAdd handler;
	
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
	
	public static void updateSites() throws ParserConfigurationException, SAXException, IOException, JAXBException
	{
		SakaiSite[] sites = 
				SiteServices.getSitesForUser(LocalConstants.sessionID, SakaiConstants.SERVER_URL);
		Set<String> siteTitles = sitesInfo.keySet();
		
		for(SakaiSite site:sites)
		{
			if(!siteTitles.contains(site.getTitle()))
			{
				site.updateAssignment();
				
				sitesInfo.put(site.getTitle(), site);
				if(handler != null)
				{
					handler.siteAdd(site);
				}
			}
		}
	}
	
//	Must be called before exit
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
	
	public HashMap<String, SakaiSite> getAllSites()
	{
		return sitesInfo;
	}


}
