package core.sakai.serviceWrapper;

import java.rmi.RemoteException;
import java.util.Scanner;

import org.apache.axis2.AxisFault;

import core.sakai.wsdl.SakaiLoginServiceStub;

public class SakaiLogin {

	private static SakaiLoginServiceStub stub;

	private SakaiLogin() throws AxisFault {
		stub = new SakaiLoginServiceStub();
	}

	/**
	 * Login to Sakai serve
	 * 
	 * @param userId
	 * @param password
	 * @return The session id representing the logged-in user.
	 * @throws RemoteException
	 *             If password is wrong or not connected to serve.
	 */
	public static String login(String userId, String password) throws RemoteException, AxisFault {
		stub = new SakaiLoginServiceStub();
		SakaiLoginServiceStub.Login login = new SakaiLoginServiceStub.Login();
		login.setId(userId);
		login.setPw(password);
		SakaiLoginServiceStub.LoginResponse loginResponse = stub.login(login);
		return loginResponse.getLoginReturn();
	}

	/**
	 * Logout of the Sakai serve.
	 * 
	 * @param sessionid
	 *            Session id representing the user.
	 * @return True if successfully logged out.
	 * @throws RemoteException
	 *             if cannot logout properly.(Maybe session is wrong or not
	 *             connected.)
	 * @TODO Here does not return true as expected. On the other hand, even if
	 *       the user had successfully logged out, it would still return false.
	 */
	public static boolean logout(String sessionid) throws RemoteException {
		SakaiLoginServiceStub.Logout logout = new SakaiLoginServiceStub.Logout();
		logout.setSessionid(sessionid);
		SakaiLoginServiceStub.LogoutResponse logoutResponse = stub
				.logout(logout);
		return logoutResponse.getLogoutReturn();
	}

}
