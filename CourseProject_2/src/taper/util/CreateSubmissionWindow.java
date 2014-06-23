package taper.util;

import java.awt.BorderLayout;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import core.sakai.objects.SakaiAssignment.SakaiAssignmentContent;
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
	final static boolean DEBUG = false;
	String URL, cookie;

	private CreateSubmissionWindow(String URL, String sessionStr) {
		cookie = SakaiConstants.decorateSesStr(sessionStr);
		this.URL = URL;

		setLayout(new BorderLayout());

		JWebBrowser.setCookie(SakaiConstants.SERVER_URL, cookie);
		webBrowser = new JWebBrowser();
		if (!DEBUG) {
			webBrowser.navigate(URL);
			webBrowser.setMenuBarVisible(false);// hide menu bar (like options
												// e.g.)
			webBrowser.setLocationBarVisible(false); // hide URL typing bar
			webBrowser.setButtonBarVisible(false); // hide the reload buttons
		} else {
			webBrowser.navigate(URL);
			webBrowser.setMenuBarVisible(false);// hide menu bar (like options
												// e.g.)
			webBrowser.setLocationBarVisible(false); // hide URL typing bar
			webBrowser.setButtonBarVisible(false); // hide the reload buttons
		}
		add(webBrowser, BorderLayout.CENTER);
	}

	private CreateSubmissionWindow(String URL, String sessionStr, boolean b) {
		webBrowser = null;
		cookie = SakaiConstants.decorateSesStr(sessionStr);
		this.URL = URL;

		setLayout(new BorderLayout());

		// BrComponent.DESIGN_MODE = false;
		// BrTabbed browser = new BrTabbed();
		// browser.setURL(URL);
		// add(browser, BorderLayout.CENTER);

	}

	/**
	 * 
	 * @param titleOfWindow
	 *            The title shown top of the window.
	 * @param assign
	 *            the assignment to be submitted.
	 * @param sessionId
	 */
	public static void openWindow_old(final String titleOfWindow,
			final SakaiAssignmentContent assign, final String sessionId) {

		if (!DEBUG) {
			UIUtils.setPreferredLookAndFeel();
			if (!NativeInterface.isOpen()) {
				NativeInterface.open();
			}
		}

		JFrame frame = new JFrame(titleOfWindow);
		if (DEBUG) {
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} else {
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		String url = SakaiConstants.SERVER_URL + "/direct/assignment/"
				+ assign.getAssignmentId();
		frame.getContentPane().add(new CreateSubmissionWindow(url, sessionId),
				BorderLayout.CENTER);
		frame.setSize(800, 600);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);

		if (!NativeInterface.isEventPumpRunning() && !DEBUG) {
			NativeInterface.runEventPump();
		}
	}

	public static void openWindow(final String titleOfWindow,
			final SakaiAssignmentContent assign, final String sessionId) {
		class Temp extends SwingWorker<Void, Void> {

			@Override
			protected Void doInBackground() throws Exception {
				UIUtils.setPreferredLookAndFeel();
				if (!NativeInterface.isOpen()) {
					NativeInterface.open();
				}
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						openWindow_old(titleOfWindow, assign, sessionId);

					}
				});
				if (!NativeInterface.isEventPumpRunning()) {
					NativeInterface.runEventPump();
				}
				return null;
			}

		}
		new Temp().execute();
	}

	// /**
	// *
	// * @param titleOfWindow
	// * The title shown top of the window.
	// * @param assign
	// * the assignment to be submitted.
	// * @param sessionId
	// */
	// public static void openWindow(final String titleOfWindow,
	// final SakaiAssignment assign, final String sessionId) {
	//
	// if (!NativeInterface.isOpen()) {
	// UIUtils.setPreferredLookAndFeel();
	// NativeInterface.open();
	// }
	// JFrame frame = new JFrame(titleOfWindow);
	// frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	// frame.getContentPane().add(
	// new CreateSubmissionWindow(assign.getEntityURL(), sessionId),
	// BorderLayout.CENTER);
	// frame.setSize(800, 600);
	// frame.setLocationByPlatform(true);
	// frame.setVisible(true);
	// if (!NativeInterface.isEventPumpRunning()) {
	// NativeInterface.runEventPump();
	// }
	// }

	/**
	 * @deprecated
	 * @param args
	 */
	public static void main(String[] args) {
		// String urlString =
		// "http://10.21.67.116:8080/direct/assignment/280f7eac-1b97-4c6f-a261-88084922e054";
		// String urlString =
		// "/assignment/a/mercury/651ccf6b-2f90-4131-8721-54b4ed35f083";
		final StringBuffer sesStr = new StringBuffer();

		try {
			sesStr.append(SakaiLogin.login("test", "test"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		final SakaiAssignmentContent ass = new SakaiAssignmentContent();
		ass.setAssignmentId("651ccf6b-2f90-4131-8721-54b4ed35f083");

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				openWindow("title", ass, sesStr.toString());

			}
		});

	}

}
