package taper.Sakai.ServiceWrapper;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;


import taper.Sakai.WSDL.SakaiScriptServiceStub;

public class SakaiScript {

	private SakaiScriptServiceStub stub;
	public SakaiScript() throws AxisFault {
		stub = new SakaiScriptServiceStub();
	}
	
	/**
	 * @param sessionID
	 * @param userName the login username (ie jsmith26) of the user you want to edit
	 * @param email the updated email address for the user
	 * @return success or exception message.
	 * @throws RemoteException Something went wrong.
	 */
	public String changeUserEmail(String sessionID, String userName, String email) throws RemoteException {
		SakaiScriptServiceStub.ChangeUserEmail op = new SakaiScriptServiceStub.ChangeUserEmail();
		op.setSessionid(sessionID);
		op.setEid(userName);
		op.setEmail(email);
		SakaiScriptServiceStub.ChangeUserEmailResponse response = stub.changeUserEmail(op);
		return response.getChangeUserEmailReturn();
	}
}
