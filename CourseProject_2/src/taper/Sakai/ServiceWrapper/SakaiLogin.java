package taper.Sakai.ServiceWrapper;

import java.rmi.RemoteException;
import java.util.Scanner;

import org.apache.axis2.AxisFault;

import taper.Sakai.WSDL.SakaiLoginServiceStub;


public class SakaiLogin {

	@Deprecated
	/*Test only*/
	public static void main(String[] args) throws RemoteException {

		SakaiLogin login = new SakaiLogin();
		String sessionidString = login.login("test", "taper");
		Scanner input = new Scanner(System.in);
		input.nextLine();
	
		login.logout(sessionidString);
		input.nextLine();
		login.logout(sessionidString);
		input.nextLine();
		
		input.close();
	}
	
	private SakaiLoginServiceStub stub;
	public SakaiLogin() throws AxisFault {
		stub = new SakaiLoginServiceStub();
	}
	
	/**
	 * Login to Sakai serve
	 * @param userId
	 * @param password
	 * @return The session id representing the logged-in user.
	 * @throws RemoteException If password is wrong or not connected to serve.
	 */
	public String login(String userId, String password) throws RemoteException {
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
	public boolean logout(String sessionid) throws RemoteException {
		SakaiLoginServiceStub.Logout logout = new SakaiLoginServiceStub.Logout();
		logout.setSessionid(sessionid);
		SakaiLoginServiceStub.LogoutResponse logoutResponse = stub.logout(logout);
		return logoutResponse.getLogoutReturn();
	}
	
}
