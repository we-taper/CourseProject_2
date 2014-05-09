package taper.Sakai.ServiceWrapper;

import java.rmi.RemoteException;

import org.apache.log4j.Logger;

import com.sun.corba.se.spi.activation.Repository;

import taper.Sakai.WSDL.ContentHostingServiceStub;
import taper.Sakai.WSDL.ContentHostingServiceStub.CreateContentItem;
import taper.Sakai.WSDL.ContentHostingServiceStub.CreateFolder;
import taper.Sakai.WSDL.ContentHostingServiceStub.GetAllSitesCollectionSize;
import taper.Sakai.WSDL.ContentHostingServiceStub.GetInfo;
import taper.Sakai.WSDL.ContentHostingServiceStub.GetResources;

/**
 * Manage the content(resources) for a given user.
 * @author we.taper
 *
 */
public class ContentHosting {
	
	private ContentHostingServiceStub stub;
	private Logger log;
	private String sessionID;
	private String virtualRoot;
	
	/**
	 * Create a content hoster for a specific user. There is no need to specify
	 * the address for services address.
	 * 
	 * @param sessionID
	 *            The sessionID for this user.
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
	
	/**
	 * Get virtual root id for this user.
	 * @return Virtual Root Id
	 * @throws RemoteException
	 */
	private String getVirtualRoot() throws RemoteException {
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
	
	/**
	 * Get the resources related to the id, including their id and name etc. 
	 * 
	 * @param id of virtual root, collection, or resource.
	 * @return The XML String describing the resources.
	 * @throws RemoteException Wrong id, wrong sessionID, etc.
	 */
	public String getResources(String id) throws RemoteException {
		ContentHostingServiceStub.GetResources getResources = new ContentHostingServiceStub.GetResources();
		getResources.setSessionid(sessionID);
		getResources.setId(id);
		ContentHostingServiceStub.GetResourcesResponse response = stub.getResources(getResources);
		return response.getGetResourcesReturn();
	}
	
	/**
	 * This will return the resource (like a pdf, a ppt, a mp3 etc.) encoded in
	 * base64 as a String. The return could be huge if the resource is big.<br>
	 * You may use #SakaiBase64Decoder to decode this String.
	 * 
	 * @param resourceID
	 * @return resource (like a pdf, a ppt, a mp3 etc.) encoded in base64 as a
	 *         String
	 * @throws RemoteException
	 *             Something went wrong: sessionID, resourceID etc.
	 */
	public String getContentData(String resourceID) throws RemoteException{
		ContentHostingServiceStub.GetContentData getContentData = new ContentHostingServiceStub.GetContentData();
		getContentData.setSessionid(sessionID);
		getContentData.setResourceId(resourceID);
		ContentHostingServiceStub.GetContentDataResponse response = stub.getContentData(getContentData);
		return response.getGetContentDataReturn();
	}
	
	/**
	 * Returns an empty string if no resources in this collection or an XML list
	 * of resource ids, names, and types.
	 * 
	 * @param ID
	 *            of the virtual root, a collection, or a resource.
	 * @return
	 * @throws RemoteException
	 *             Something went wrong.
	 */
	public String getInfo(String ID) throws RemoteException {
		ContentHostingServiceStub.GetInfo getInfo = new ContentHostingServiceStub.GetInfo();
		getInfo.setSessionid(sessionID);
		getInfo.setId(ID);
		ContentHostingServiceStub.GetInfoResponse response = stub.getInfo(getInfo);
		return response.getGetInfoReturn();
	}
	
	/**
	 * Create a collection for a site given it's id (with path).
	 * @param collectionID e.g. /group/mercury/
	 * @param nameOfFolder
	 * @return The id of the new collection. "failure" if failed.
	 * @throws RemoteException Something went wrong.
	 */
	public String createFolder(String collectionID, String nameOfFolder) throws RemoteException {
		if(!collectionID.endsWith("/")) {
			collectionID = collectionID + "/"; // Avoid accidentally creating a
												// new collection.
		}
		ContentHostingServiceStub.CreateFolder createFolder = new ContentHostingServiceStub.CreateFolder();
		createFolder.setSessionid(sessionID);
		createFolder.setCollectionId(collectionID);
		createFolder.setName(nameOfFolder);
		ContentHostingServiceStub.CreateFolderResponse response = stub.createFolder(createFolder);
		return response.getCreateFolderReturn();
	}
	
	/**
	 * Add a resource to a given collection. The resource is passed either as
	 * text or encoded using Base64 flagged using the binary parameter.
	 * 
	 * @param nameOfContent
	 *            of the resource to be added
	 * @param collectionID
	 *            of the collection it is to be added to (e.g. /group/mercury/)
	 * @param content
	 *            content string
	 * @param descrip
	 *            of the resource to be added
	 * @param mime
	 *            the type of the content, in MIME style (e.g. image/png for png
	 *            files)
	 * @param isBinary
	 *            if true, content is encoded using Base64, if false content is
	 *            assumed to be text.
	 * @return true if successfully added. false if failed or some error
	 *         happened.
	 * @throws RemoteException
	 *             Something went wrong.
	 */
	public boolean createContentItem(String nameOfContent, String collectionID, String content, String descrip, String mime, boolean isBinary  ) throws RemoteException {
		ContentHostingServiceStub.CreateContentItem createContentItem = new ContentHostingServiceStub.CreateContentItem();
		createContentItem.setSessionid(sessionID);
		createContentItem.setName(nameOfContent);
		createContentItem.setCollectionId(collectionID);
		createContentItem.setContentMime(content);
		createContentItem.setDescription(descrip);
		createContentItem.setType(mime);
		createContentItem.setBinary(isBinary);
		ContentHostingServiceStub.CreateContentItemResponse response = stub.createContentItem(createContentItem);
		if(response.getCreateContentItemReturn().equalsIgnoreCase("success")) {
			return true;
		}else if(response.getCreateContentItemReturn().equalsIgnoreCase("failure")) {
			return false;
		}else{
			log.error("Wrong return from CreateContentItem");
			return false;
		}
	}
}
