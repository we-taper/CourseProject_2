package control;

import java.io.IOException;
import java.util.HashMap;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import core.sakai.objects.SakaiAssignment.SakaiAssignmentContent;
import core.sakai.objects.SakaiSite;

public class TestClass 
{
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, JAXBException
	{
		LoginControl.login("admin", "admin");
		HashMap<String, SakaiSite> sites = Sites.getAllSites();
		
		for(String str : sites.keySet())
		{
			System.out.println(str);
		}
		
		SakaiSite mercury = sites.get("mercury site");
		HashMap<String, SakaiAssignmentContent> assignments = 
				mercury.getAllAssignments();
		
		for(String str : assignments.keySet())
		{
			System.out.println(str);
		}
		
		System.out.println(assignments.get("123test").getInstructions());
		
		Sites.addSitesAddHandler
		(
			new SitesAdd()
			{
				@Override
				public void siteAdd(SakaiSite newSite) 
				{
					System.out.println("A new Site is added:" + newSite.getTitle());
				}
			}
		);
		
		mercury.addAssignmentAddHandler
		(
			new AssignmentAdd()
			{

				@Override
				public void newAssignment(SakaiAssignmentContent assignment) 
				{
					System.out.println("new ass add:" + assignment.getTitle());
				}
				
			}
		);
		
		UpdateTasker.startUpdateSites();
		UpdateTasker.startAssignmentUpdater(mercury);
		
		if(LoginControl.logout())
		{
			UpdateTasker.stopAllTaker();
			Sites.saveInfo();
		}
		
	}
}
