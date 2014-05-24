package control;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import core.sakai.serviceWrapper.SakaiLogin;

public class LoginControl 
{
	public static void login(String userID, String password) throws AxisFault, RemoteException
	{
		String sessionid = SakaiLogin.login(userID, password);
		LocalInfo.sessionID = sessionid;
		LocalInfo.online = true;
	}
	
	public static boolean logout() throws RemoteException
	{
		boolean state = SakaiLogin.logout(LocalInfo.sessionID);
		if(state)
		{
			LocalInfo.online = false;
		}
		return state;
	}
}
