package core.sakai.serviceWrapper;

import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * @deprecated Test only
 * @author we.taper
 *
 */
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	}
	
	public static void testLogin(String[] args) throws RemoteException {

		SakaiLogin login = new SakaiLogin();
		String sessionidString = login.login("admin", "admin");
		Scanner input = new Scanner(System.in);
		System.out.printf("To logout?");
		input.nextLine();

		login.logout(sessionidString);
		input.nextLine();
		login.logout(sessionidString);
		input.nextLine();

		input.close();
	}

}
