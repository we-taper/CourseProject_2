package control;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import core.sakai.objects.SakaiSite;
import core.sakai.serviceWrapper.SakaiLogin;

public class LoginControl 
{
	public static void login(String userID, String password) throws ParserConfigurationException, SAXException, IOException, JAXBException
	{
		String sessionid = SakaiLogin.login(userID, password);
		LocalConstants.sessionID = sessionid;
		LocalConstants.online = true;
		
		Thread thread = new Thread()
		{
			public void run()
			{
				try {
					Sites.updateSites();
				} catch (ParserConfigurationException | SAXException
						| IOException | JAXBException e) {
					e.printStackTrace();
				}
				for(SakaiSite site : Sites.getAllSites().values())
				{
					try {
						site.updateAssignment();
					} catch (IOException | JAXBException
							| ParserConfigurationException | SAXException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		thread.start();
		
	}
	
	public static boolean logout() throws RemoteException
	{
		boolean state = SakaiLogin.logout(LocalConstants.sessionID);
		if(state)
		{
			LocalConstants.online = false;
		}
		return state;
	}
}
