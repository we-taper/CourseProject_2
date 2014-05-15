package core.sakai.serviceWrapper;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.rmi.RemoteException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.axis2.AxisFault;
import org.apache.james.mime4j.util.MimeUtil;
import org.xml.sax.SAXException;

import taper.util.MIMEUtil;
import taper.util.SakaiBase64Decoder;
import core.sakai.objects.Resource;
import core.sakai.objects.Site;

/**
 * @deprecated Test only
 * @author we.taper
 *
 */
public class Tester{

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		testContentHosting();
	
	}
	
	public static void testContentHosting() throws ParserConfigurationException, SAXException, IOException {
		
		SakaiLogin log = new SakaiLogin();
		String sesId = log.login("admin", "admin");
		ContentHosting contentHosting = new ContentHosting(sesId);
		Site[] sites = contentHosting.getAllSitesCollection();
		System.out.println("Sites size: "+sites.length);
		for(Site a:sites) {
			System.out.println("Site:  "+a.toString());
		}
		
		Resource rootCollectionResource[] = contentHosting.getRootCollection();
		Resource mercury = new Resource();
		for(Resource res: rootCollectionResource) {
			System.out.println("Root:"+res.toString());
			if(res.getID().equalsIgnoreCase("/group/mercury/")) {
				mercury = res;
			}
		}
		
		if(mercury.getID().equals("unknow")) {
			System.out.println(mercury);
			System.exit(1);
		}
		Resource testSmile = new Resource();
		Resource collectionResource[] = contentHosting.getResources(mercury.getID());
		for(Resource res: collectionResource) {
			System.out.println("Collection:"+res.toString());
			if(res.getName().equals("Test Smile.png")) {
				testSmile = res;
			}
		}
		
		
		
		if(testSmile.getName().equals("unknow")) {
			System.out.println(testSmile);
			System.exit(1);
		}
		Resource aResourceArray[] = contentHosting.getResources(testSmile.getID());
		assert aResourceArray.length == 1;
		System.out.println("aResArray:"+aResourceArray[0].toString());
		
		
		Resource fromGetInfo = contentHosting.getInfo(testSmile.getID());
		System.out.println("afromGetInfo:"+fromGetInfo.toString());
		
		
		long size = contentHosting.getSiteCollectionSize("mercury");	
		System.out.println("Size of mercury:"+size);
		
		File dest = new File(".\\Test\\test smile.png");
		
		String base64Data = contentHosting.getContentData(testSmile.getID());
		SakaiBase64Decoder.decodeAndWrite2File(base64Data, dest);
		
		String responseCreFold = contentHosting.createFolder(mercury.getID(), "CreatedBy Class Tester");
		System.out.println("Create Folder:"+responseCreFold);
		
		boolean responseCreCont = contentHosting.createContentItem("Named by Class Tester", mercury.getID(), base64Data, "Another test smile png", MIMEUtil.getMIMETypeFrom(dest), true);
		System.out.println("Create ContentItem:"+responseCreCont);
		
		boolean responseUpload = contentHosting.uploadFile("Named by Class Tester another", mercury.getID()+"d", dest, "Uploaded by methed uploadFile");
		System.out.println("Uplaod file:"+responseUpload);

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
