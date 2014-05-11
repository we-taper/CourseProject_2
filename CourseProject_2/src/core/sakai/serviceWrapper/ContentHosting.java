package core.sakai.serviceWrapper;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.codehaus.stax2.io.EscapingWriterFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import taper.util.XMLUtil;
import core.sakai.objects.Resource;
import core.sakai.objects.Site;
import core.sakai.wsdl.ContentHostingServiceStub;

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
	 * TODO test
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
	 * TODO test
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
	 * TODO test
	 */
	public long getSiteCollectionSize(String siteID) throws RemoteException {
		ContentHostingServiceStub.GetSiteCollectionSize getSiteCollectionSize = new ContentHostingServiceStub.GetSiteCollectionSize();
		getSiteCollectionSize.setSessionid(sessionID);
		getSiteCollectionSize.setContext(siteID);
		ContentHostingServiceStub.GetSiteCollectionSizeResponse response = stub.getSiteCollectionSize(getSiteCollectionSize);
		return response.getGetSiteCollectionSizeReturn();
	}
	
	/**
	 * Will return a list of all sites in Site[], including id, size, title etc.
	 * @return
	 * @throws RemoteException
	 * TODO test
	 */
	public Site[] getAllSitesCollection() throws ParserConfigurationException, SAXException, IOException {
		String xml = getAllSitesCollectionSizeInXml();
		Document read = XMLUtil.loadXMLFromString(xml);
		NodeList listList = read.getElementsByTagName("list");
		ArrayList<Site> sites= new ArrayList<>();
		Element line;
		for(int i = 0; i < listList.getLength(); i++) {
			Site aSite = new Site();
			
			Element oneSite = (Element) listList.item(i);
			
			
			line = (Element) oneSite.getElementsByTagName("site").item(0);
			aSite.setCreatedBy(line.getAttribute("createdBy"));
			aSite.setCreatedTime(line.getAttribute("createdTime"));
			aSite.setID(line.getAttribute("id"));
			aSite.setSize(Long.parseLong(line.getAttribute("size")));
			aSite.setTitle(line.getAttribute("title"));
			aSite.setType(line.getAttribute("type"));
			
			sites.add(aSite);
		}
		return sites.toArray(new Site[0]);
	}
	
	/**
	 * Will return a list of all sites in XML, including id, size, title etc.
	 * @return
	 * @throws RemoteException
	 * TODO test
	 */
	private String getAllSitesCollectionSizeInXml() throws RemoteException {
		ContentHostingServiceStub.GetAllSitesCollectionSize getAllSitesCollectionSize = new ContentHostingServiceStub.GetAllSitesCollectionSize();
		getAllSitesCollectionSize.setSessionid(sessionID);
		ContentHostingServiceStub.GetAllSitesCollectionSizeResponse response = stub.getAllSitesCollectionSize(getAllSitesCollectionSize);
		return response.getGetAllSitesCollectionSizeReturn();
	}
	
	/**
	 * Get the resources related to the id, including their id and name etc. 
	 * 
	 * @param id of virtual root, collection, or resource.
	 * @return A list of resources.
	 * @throws RemoteException Wrong id, wrong sessionID, etc.
	 * TODO test, virtual id, collections, resource
	 */
	public Resource[] getResources(String id) throws ParserConfigurationException, SAXException, IOException {
		String xml = getResourcesInXml(id);
		Document read = XMLUtil.loadXMLFromString(xml);
		NodeList listList = read.getElementsByTagName("list");
		ArrayList<Resource> resources = new ArrayList<>();
		Element line;
		for(int i = 0; i < listList.getLength(); i++) {
			Resource aResource = new Resource();
			
			Element oneRes = (Element) listList.item(i);
			
			line = (Element) oneRes.getElementsByTagName("id").item(0);
			aResource.setID(line.getFirstChild().getTextContent());
			
			line = (Element) oneRes.getElementsByTagName("name").item(0);
			aResource.setName(line.getFirstChild().getTextContent());
			
			line = (Element) oneRes.getElementsByTagName("type").item(0);
			aResource.setType(line.getFirstChild().getTextContent());
			
			line = (Element) oneRes.getElementsByTagName("url").item(0);
			aResource.setUrl(line.getFirstChild().getTextContent());
			
			resources.add(aResource);
		}
		return resources.toArray(new Resource[0]);
		
	}
	/**
	 * Get the resources related to the id, including their id and name etc. 
	 * 
	 * @param id of virtual root, collection, or resource.
	 * @return The XML String describing the resources.
	 * @throws RemoteException Wrong id, wrong sessionID, etc.
	 * TODO test
	 */
	private String getResourcesInXml(String id) throws RemoteException {
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
	 * TODO test
	 */
	public String getContentData(String resourceID) throws RemoteException{
		ContentHostingServiceStub.GetContentData getContentData = new ContentHostingServiceStub.GetContentData();
		getContentData.setSessionid(sessionID);
		getContentData.setResourceId(resourceID);
		ContentHostingServiceStub.GetContentDataResponse response = stub.getContentData(getContentData);
		return response.getGetContentDataReturn();
	}
	
	/**
	 * Returns a Resource.
	 * 
	 * @param id
	 *            of the virtual root, a collection, or a resource.
	 * @return
	 * @throws RemoteException
	 *             Something went wrong.
	 * TODO test, virtual root, a collection, or a resource. null.
	 */
	public Resource getInfo(String id) throws ParserConfigurationException, SAXException, IOException {
		String xml; Resource resource; Document read; NodeList list; Element aRes;
		xml = getInfoInXml(id);
		if(xml == null) { return null;};
		read = XMLUtil.loadXMLFromString(xml);
		list = read.getElementsByTagName("resource");
		assert list.getLength() == 1;
		aRes = (Element) list.item(0);

		String 
			resID = aRes.getElementsByTagName("id").item(0).getFirstChild().getTextContent(),
			name = aRes.getElementsByTagName("name").item(0).getFirstChild().getTextContent(),
			type = aRes.getElementsByTagName("type").item(0).getFirstChild().getTextContent(),
			url = aRes.getElementsByTagName("url").item(0).getFirstChild().getTextContent();
		resource = new Resource(name, resID, type, url);
		return resource;
	}
	/**
	 * Returns an empty string if no resources in this collection or an XML list
	 * of resource ids, names, and types.
	 * 
	 * @param id
	 *            of the virtual root, a collection, or a resource.
	 * @return
	 * @throws RemoteException
	 *             Something went wrong.
	 * TODO test
	 */
	private String getInfoInXml(String id) throws RemoteException {
		ContentHostingServiceStub.GetInfo getInfo = new ContentHostingServiceStub.GetInfo();
		getInfo.setSessionid(sessionID);
		getInfo.setId(id);
		ContentHostingServiceStub.GetInfoResponse response = stub.getInfo(getInfo);
		return response.getGetInfoReturn();
	}
	
	/**
	 * Create a collection for a site given it's id (with path).
	 * @param collectionID e.g. /group/mercury/
	 * @param nameOfFolder
	 * @return The id of the new collection. "failure" if failed.
	 * @throws RemoteException Something went wrong.
	 * TODO test
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
	 * TODO test
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
