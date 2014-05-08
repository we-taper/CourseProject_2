package taper.Sakai.ServiceWrapper;

import java.rmi.RemoteException;
import java.util.Scanner;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axis2.AxisFault;
import org.apache.axis2.databinding.ADBBean;
import org.apache.axis2.databinding.ADBException;

import taper.Sakai.WSDL.SakaiLoginServiceStub;


public class SakaiLogin {

	public static void main(String[] args) throws AxisFault {

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
	
	SakaiLoginServiceStub stub;
	public SakaiLogin() throws AxisFault {
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
	 * @return True if successfully logged out.
	 * @TODO Here does not return true as expected. On the other hand, even
	 * if the user had successfully logged out, it would still return false.
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
