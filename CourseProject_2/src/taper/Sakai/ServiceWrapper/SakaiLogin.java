package taper.Sakai.ServiceWrapper;

import java.rmi.RemoteException;

import javax.xml.stream.XMLStreamReader;

import org.apache.axis2.AxisFault;
import org.apache.axis2.databinding.ADBException;

import taper.Sakai.WSDL.SakaiLoginServiceStub;


public class SakaiLogin {

	public static void main(String[] args) throws AxisFault {

	}
	
	SakaiLoginServiceStub stub;
	public SakaiLogin(String serveAddress) throws AxisFault {
		stub = new SakaiLoginServiceStub();
	}
	
	/**
	 * Login to Sakai serve
	 * @param userId
	 * @param password
	 * @return The session id representing the logged-in user.
	 * @throws AxisException
	 * @throws RemoteException
	 */
	public String login(String userId, String password) {
		SakaiLoginServiceStub.Login login = new SakaiLoginServiceStub.Login();
		login.setId(userId);
		login.setPw(password);
		try {
			SakaiLoginServiceStub.LoginResponse loginResponse = stub.login(login);
			return loginResponse.getLoginReturn();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Logout of the Sakai serve.
	 * @param sessionid Session id representing the user.
	 * @return true if successfully logged out.
	 * @TODO Here does not return true as expected.
	 */
	public boolean logout(String sessionid) {
		SakaiLoginServiceStub.Logout logout = new SakaiLoginServiceStub.Logout();
		logout.setSessionid(sessionid);
		try {
			SakaiLoginServiceStub.LogoutResponse logoutResponse = stub.logout(logout);
			return logoutResponse.getLogoutReturn();
		}catch(RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
