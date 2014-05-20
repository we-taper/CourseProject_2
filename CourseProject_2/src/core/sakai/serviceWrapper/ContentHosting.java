package core.sakai.serviceWrapper;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import taper.util.EndEventHandler;
import taper.util.MIMEUtil;
import taper.util.SakaiBase64Decoder;
import taper.util.XMLUtil;
import core.sakai.objects.Resource;
import core.sakai.objects.SakaiList;
import core.sakai.objects.Site;
import core.sakai.wsdl.ContentHostingServiceCallbackHandler;
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
	 */
	public ContentHosting(String sessionID) throws RemoteException {
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
	 * @deprecated Does not work properly. Don't use this.
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
	 * @throws JAXBException 
	 * @throws RemoteException
	 */
	public Site[] getAllSitesCollection() throws ParserConfigurationException, SAXException, IOException, JAXBException {
		String xml = getAllSitesCollectionSizeInXml();
		Document read = XMLUtil.loadXMLFromString(xml);
		NodeList listList = read.getElementsByTagName("list");
		NodeList siteList = listList.item(0).getChildNodes();
		ArrayList<Site> sites= new ArrayList<>();
		for(int i = 0; i < siteList.getLength(); i++) {
			Site aSite = new Site();
			
	        JAXBContext jc = JAXBContext.newInstance(Site.class);
	        Unmarshaller unmarshaller = jc.createUnmarshaller();
	        aSite = (Site) unmarshaller.unmarshal(siteList.item(i));
			
//			Element oneSite = (Element) siteList.item(i);
//			aSite.setCreatedBy(oneSite.getAttribute("createdBy"));
//			aSite.setCreatedTime(oneSite.getAttribute("createdTime"));
//			aSite.setID(oneSite.getAttribute("id"));
//			aSite.setSize(Long.parseLong(oneSite.getAttribute("size")));
//			aSite.setTitle(oneSite.getAttribute("title"));
//			aSite.setType(oneSite.getAttribute("type"));
			
			sites.add(aSite);
		}
		return sites.toArray(new Site[0]);
	}
	
	/**
	 * Will return a list of all sites in XML, including id, size, title etc.
	 * @return
	 * @throws RemoteException
	 */
	private String getAllSitesCollectionSizeInXml() throws RemoteException {
		ContentHostingServiceStub.GetAllSitesCollectionSize getAllSitesCollectionSize = new ContentHostingServiceStub.GetAllSitesCollectionSize();
		getAllSitesCollectionSize.setSessionid(sessionID);
		ContentHostingServiceStub.GetAllSitesCollectionSizeResponse response = stub.getAllSitesCollectionSize(getAllSitesCollectionSize);
		return response.getGetAllSitesCollectionSizeReturn();
	}
	
	
	/**
	 * Get the resources related to the collection or Virtual id or resource id,
	 * including their id and name etc. <Strong> A resource may be a real
	 * resource or a collection.</Strong>
	 * 
	 * @param id
	 *            of collection, or Virtual ID, or Resource ID.
	 * @return A list of resources.
	 * @throws RemoteException
	 *             Wrong id, wrong sessionID, etc.
	 * @throws ParserConfigurationException
	 *             Error reading the data, maybe you use a resource ID instead
	 *             of a collection ID.
	 * @throws JAXBException 
	 */
	public Resource[] getResources(String id) throws ParserConfigurationException, SAXException, IOException, JAXBException {
		String xml = getResourcesInXml(id);
		StringReader sr = new StringReader(xml);
		
        JAXBContext jc = JAXBContext.newInstance(SakaiList.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();

        SakaiList list = (SakaiList) unmarshaller.unmarshal(sr);
        return list.recList.toArray(new Resource[0]);
	}
	
	/**
	 * Get the collection related to Virtual id of this user,
	 * including their id and name etc.
	 * 
	 * @return A list of resources.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws RemoteException
	 *             Wrong id, wrong sessionID, etc.
	 * @throws ParserConfigurationException
	 *             Error reading the data, maybe you use a resource ID instead
	 *             of a collection ID.
	 * @throws JAXBException 
	 */
	public Resource[] getRootCollection() throws ParserConfigurationException, SAXException, IOException, JAXBException {
		return getResources(virtualRoot);
	}
	
	/**
	 * Get the resources related to the id, including their id and name etc. 
	 * 
	 * @param id of virtual root, collection, or resource.
	 * @return The XML String describing the resources.
	 * @throws RemoteException Wrong id, wrong sessionID, etc.
	 */
	private String getResourcesInXml(String id) throws RemoteException {
		ContentHostingServiceStub.GetResources getResources = new ContentHostingServiceStub.GetResources();
		getResources.setSessionid(sessionID);
		getResources.setId(id);
		ContentHostingServiceStub.GetResourcesResponse response = stub.getResources(getResources);
		return response.getGetResourcesReturn();
	}
	
	/**
	 * An Asyc version of {@link getContentData}. TODO test
	 * @param resourceID
	 * @return resource (like a pdf, a ppt, a mp3 etc.) encoded in base64 as a
	 *         String
	 * @throws RemoteException
	 *             Something went wrong: sessionID, resourceID etc.
	 */
	public void getContentData(String resourceID, EndEventHandler<String> handler ) throws RemoteException {
		class Handler extends ContentHostingServiceCallbackHandler{
			EndEventHandler<String> handler; 
			Handler(EndEventHandler<String> handler) {
				this.handler = handler;
			}
			
			@Override
			public void receiveResultgetContentData(ContentHostingServiceStub.GetContentDataResponse result) {
				handler.finishedWithoutError(result.getGetContentDataReturn());
			}
			@Override
			public void receiveErrorgetContentData(Exception e) {
				handler.equals(e);
			}
		};
		
		ContentHostingServiceStub.GetContentData getContentData = new ContentHostingServiceStub.GetContentData();
		getContentData.setSessionid(sessionID);
		getContentData.setResourceId(resourceID);
		
		Handler handler2 = new Handler(handler);//TODO
		stub.startgetContentData(getContentData, handler2);
	}
	/**
	 * This will return the resource (like a pdf, a ppt, a mp3 etc.) encoded in
	 * base64 as a String. The return could be huge if the resource is big.<br>
	 * You may use {@link SakaiBase64Decoder} to decode this String.
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
	 * Returns a Resource.
	 * 
	 * @param id
	 *            of the virtual root, a collection, or a resource.
	 * @return
	 * @throws JAXBException 
	 * @throws RemoteException
	 *             Something went wrong.
	 */
	public Resource getInfo(String id) throws ParserConfigurationException, SAXException, IOException, JAXBException {
		String xml = getInfoInXml(id);
		StringReader sReader = new StringReader(xml);
        JAXBContext jc = JAXBContext.newInstance(Resource.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Resource list = (Resource) unmarshaller.unmarshal(sReader);
        return list;
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
	 * text or encoded using Base64 flagged using the binary parameter.<br>
	 * Don't use this when uploading files. Use {@link #uploadFile} instead.<br>
	 * <strong>
	 * 	Be careful of the limitation on content's size allowed to be uploaded,
	 *  which is typically 20MB.
	 * </strong>
	 * 
	 * @param nameOfContent
	 *            of the resource to be added
	 * @param collectionID
	 *            of the collection it is to be added to (e.g. /group/mercury/)
	 * @param content
	 *            content in a string
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
	public boolean createContentItem(String nameOfContent, String collectionID,
			String content, String descrip, String mime, boolean isBinary)
			throws RemoteException {
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
	
	/**
	 * Add a resource to a given collection. The resource is passed either as
	 * text or encoded using Base64 flagged using the binary parameter.<br>
	 * <br>
	 * <strong>
	 * 	Be careful of the limitation on content's size allowed to be uploaded,
	 *  which is typically 20MB.
	 * </strong>
	 * 
	 * @param nameOfFile
	 *            of the resource to be added, can be different from the name of
	 *            file.
	 * @param collectionID
	 *            of the collection it is to be added to (e.g. /group/mercury/)
	 * @param file
	 *            File to be uploaded
	 * @param descrp
	 *            of the resource to be added
	 * @return true if successfully added. false if failed or some error
	 *         happened.
	 * @throws RemoteException
	 *             Something went wrong.
	 * @throws IOException
	 *             if an I/O error occurs reading from the stream
	 * @throws OutOfMemoryError
	 *             if an array of the required size cannot be allocated, for
	 *             example the file is larger that {@code 2GB}
	 * @throws SecurityException
	 *             In the case of the default provider, and a security manager
	 *             is installed, the {@link SecurityManager#checkRead(String)
	 *             checkRead} method is invoked to check read access to the
	 *             file.
	 * 
	 */
	public boolean uploadFile(String nameOfFile, String collectioinID, File file, String descrp) throws IOException {
		String base64 = SakaiBase64Decoder.encode2Base64(SakaiBase64Decoder.readFileAsByte(file));
		return createContentItem(nameOfFile, collectioinID, base64, descrp, MIMEUtil.getMIMETypeFrom(file), true);
	}
}
