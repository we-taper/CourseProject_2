package taper.Sakai.ServiceWrapper;

import java.rmi.RemoteException;

import org.apache.log4j.Logger;

import taper.Sakai.WSDL.ContentHostingServiceStub;
import taper.Sakai.WSDL.ContentHostingServiceStub.GetAllSitesCollectionSize;

public class ContentHosting {
	
	private ContentHostingServiceStub stub;
	private Logger log;
	private String sessionID;
	private String virtualRoot;
	private boolean isDeveloping;
	
	/**
	 * Create a content host. There is no need to specify the address for services
	 * address.
	 * @param sessionID The sessionID for this user.
	 * @author we.taper
	 * @throws RemoteException 
	 */
	private ContentHosting(String sessionID) throws RemoteException {
		log = Logger.getLogger(ContentHosting.class);

		this.sessionID = sessionID;
		try {
			stub = new ContentHostingServiceStub();
			this.virtualRoot = getVirtualRoot();
		} catch (RemoteException e) {
			log.error(e);
			throw e;
		}
	}
	
//	public ContentHosting() {
//		this.isDeveloping = true;
//	}
	
	public String getVirtualRoot() throws RemoteException {
		ContentHostingServiceStub.GetVirtualRoot getVirtualRoot = new ContentHostingServiceStub.GetVirtualRoot();
		getVirtualRoot.setSessionid(sessionID);
		ContentHostingServiceStub.GetVirtualRootResponse response = stub.getVirtualRoot(getVirtualRoot);
		return response.getGetVirtualRootReturn();
	}
	
	/**
	 * Get the size of this size's collection (the size of resources? I don't know).
	 * @param siteID Like: "mercury"
	 * @return The size.
	 * @throws RemoteException
	 */
	public long getSiteCollectionSize(String siteID) throws RemoteException {
		ContentHostingServiceStub.GetSiteCollectionSize getSiteCollectionSize = new ContentHostingServiceStub.GetSiteCollectionSize();
		getSiteCollectionSize.setSessionid(sessionID);
		getSiteCollectionSize.setContext(siteID);
		ContentHostingServiceStub.GetSiteCollectionSizeResponse response = stub.getSiteCollectionSize(getSiteCollectionSize);
		return response.getGetSiteCollectionSizeReturn();
	}
	
	/**
	 * Will return a list of all sites in XML, including id, size, title etc.
	 * @return
	 * @throws RemoteException
	 */
	public String getAllSitesCollectionSize() throws RemoteException {
		ContentHostingServiceStub.GetAllSitesCollectionSize getAllSitesCollectionSize = new ContentHostingServiceStub.GetAllSitesCollectionSize();
		getAllSitesCollectionSize.setSessionid(sessionID);
		ContentHostingServiceStub.GetAllSitesCollectionSizeResponse response = stub.getAllSitesCollectionSize(getAllSitesCollectionSize);
		return response.getGetAllSitesCollectionSizeReturn();
	}
}
