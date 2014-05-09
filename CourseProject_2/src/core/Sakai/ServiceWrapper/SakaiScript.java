package core.Sakai.ServiceWrapper;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;




import core.Sakai.WSDL.SakaiScriptServiceStub;
import core.Sakai.WSDL.SakaiScriptServiceStub.GetAllSitesForUser;

public class SakaiScript {

	private SakaiScriptServiceStub stub;
	public SakaiScript() throws AxisFault {
		stub = new SakaiScriptServiceStub();
	}
	
	/**
	 * Change the Email address of a user. Admin can modify other's email address.
	 * @param sessionID
	 * @param userName the login username (ie jsmith26) of the user you want to edit
	 * @param email the updated email address for the user
	 * @return success or exception message.
	 * @throws RemoteException Something went wrong.
	 * TODO test
	 */
	public String changeUserEmail(String sessionID, String userName, String email) throws RemoteException {
		SakaiScriptServiceStub.ChangeUserEmail op = new SakaiScriptServiceStub.ChangeUserEmail();
		op.setSessionid(sessionID);
		op.setEid(userName);
		op.setEmail(email);
		SakaiScriptServiceStub.ChangeUserEmailResponse response = stub.changeUserEmail(op);
		return response.getChangeUserEmailReturn();
	}
	
	/**
	 * Get all sites related to a user.
	 * 
	 * @param sessionID
	 * @return XML document listing all sites user has read or write access
	 *         based on their session id, including My Workspace sites.
	 * @throws RemoteException Something went wrong.
	 * TODO test
	 */
	public String getAllSitesForUser (String sessionID) throws RemoteException {
		SakaiScriptServiceStub.GetAllSitesForUser op = new SakaiScriptServiceStub.GetAllSitesForUser();
		op.setSessionid(sessionID);
		SakaiScriptServiceStub.GetAllSitesForUserResponse response = stub.getAllSitesForUser(op);
		return response.getGetAllSitesForUserReturn();
	}
	
	/**
	 * Get a user's email address based on their session id 
	 * 
	 * @param sessionID
	 * @return User's email address.
	 * @throws RemoteException
	 * TODO test
	 */
	public String getUserEmail(String sessionID) throws RemoteException {
		SakaiScriptServiceStub.GetUserEmail op = new SakaiScriptServiceStub.GetUserEmail();
		op.setSessionid(sessionID);
		SakaiScriptServiceStub.GetUserEmailResponse response = stub.getUserEmail(op);
		return response.getGetUserEmailReturn();
	}
	
	/**
	 * Gets the user ID associated with the session id.
	 * 
	 * @param sessionID
	 * @return
	 * @throws RemoteException
	 * TODO test
	 */
	public String getUserId(String sessionID) throws RemoteException {
		SakaiScriptServiceStub.GetUserId op = new SakaiScriptServiceStub.GetUserId();
		op.setSessionid(sessionID);
		SakaiScriptServiceStub.GetUserIdResponse response = stub.getUserId(op);
		return response.getGetUserIdReturn();
	}
}
