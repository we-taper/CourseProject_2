package control;

import java.io.IOException;
import java.rmi.RemoteException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import core.sakai.objects.SakaiSite;
import core.sakai.serviceWrapper.SakaiLogin;

/**
 * A class that packs the log in and log out method.
 * .
 *
 */

public class LoginControl 
{
	/**A method for loging in. </br>if it successes, another <code>Thread</code>
	 * object is executed to update information.
	 * 
	 * @param userID The account of current user.
	 * @param password Password associates with the userID.
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws JAXBException
	 */
	
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
						site.updataAnnouncement();
					} catch (IOException | JAXBException
							| ParserConfigurationException | SAXException e) {
						e.printStackTrace();
					}
					catch(Exception e)
					{
//						e.printStackTrace();
					}
				}
			}
		};
		
		thread.start();
		
	}
	
	/**
	 *  Log out method.
	 * 
	 * @return <tt>ture</tt> if log out successfully, otherwise <tt>false.</tt>
	 * @throws RemoteException  A exception indicates there is something wrong
	 * with the server. Do not need to be caught.
	 */
	
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
