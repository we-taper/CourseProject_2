package taper.util;

import java.awt.BorderLayout;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import core.sakai.objects.SakaiConstants;
import core.sakai.serviceWrapper.SakaiLogin;

/**
 * 
 * @author we.taper
 *
 */
public class CreateSubmissionWindow extends JPanel {

	JPanel webBrowserPanel;
	final JWebBrowser webBrowser;
	String URL,cookie;
	
	private CreateSubmissionWindow(String URL, String sessionStr) {
		cookie = SakaiConstants.decorateSesStr(sessionStr);
		this.URL = URL;
		
		setLayout(new BorderLayout());
		
		webBrowser = new JWebBrowser();
		JWebBrowser.setCookie(SakaiConstants.SERVER_URL, cookie);
		webBrowser.navigate(URL);
		webBrowser.setMenuBarVisible(false);
		
		add(webBrowser,BorderLayout.CENTER);
	}

	/**
	 * 
	 * @param titleOfWindow The title shown top of the window.
	 * @param URL_To_Assignment The URL you find by {@code getEntityUrl()} method.
	 * @param sessionId
	 */
	public static void openWindow(final String titleOfWindow, final String URL_To_Assignment, final String sessionId) {
		if(!NativeInterface.isOpen()){

		UIUtils.setPreferredLookAndFeel();
			NativeInterface.open();
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame(titleOfWindow);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.getContentPane().add(new CreateSubmissionWindow(URL_To_Assignment, sessionId),
						BorderLayout.CENTER);
				frame.setSize(800, 600);
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
			}
		});
		if(!NativeInterface.isEventPumpRunning()) {
			NativeInterface.runEventPump();
		}
	}
	
	/**
	 * @deprecated
	 * @param args
	 */
	public static void main(String[] args) {
		String urlString = "http://10.21.67.116:8080/direct/assignment/a95c1f3a-6b2c-47da-a0fe-30a2c4af43da";
		String sesStr = "";
		try {
			sesStr = SakaiLogin.login("test", "test");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		openWindow("title",urlString,sesStr);
	}

}
