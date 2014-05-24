package control;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

public class TestClass 
{
	public static void main(String[] args) throws AxisFault, RemoteException
	{
		LoginControl.login("admin", "admin");
	}
}
