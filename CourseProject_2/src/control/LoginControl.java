package control;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import core.sakai.serviceWrapper.SakaiLogin;

public class LoginControl 
{
	public static void login(String userID, String password) throws ParserConfigurationException, SAXException, IOException, JAXBException
	{
		String sessionid = SakaiLogin.login(userID, password);
		LocalConstants.sessionID = sessionid;
		LocalConstants.online = true;
		
		Sites.updateSites();
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
