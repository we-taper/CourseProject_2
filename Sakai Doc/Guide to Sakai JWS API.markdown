Guide to Sakai JWS API
===========================

Assignments.jws
----------------------------

###getAssignmentsForContext

Get the assignment.

**Parms:**

+ Session ID
+ context (e.g. site id: mercury)

**Returns:** All the assignments.

Example:

1. Using:

		<sessionid xsi:type="xsd:string">9253cea6-3546-40fa-9d80-559964857363</sessionid>
		<context xsi:type="xsd:string">mercury</context>

	Return:

		<getAssignmentsForContextReturn xsi:type="xsd:string">&lt;?xml version="1.0" encoding="UTF-8"?>
		&lt;assignments>&lt;assignment closeTime="2014-09-12 17:00:00 CST" dueTime="2014-08-12 17:00:00 CST" gradeType="1" id="403d28b4-e152-463d-a615-972db97d34d3" openTime="2014-05-05 12:00:00 CST" title="A test assign"/>&lt;/assignments></getAssignmentsForContextReturn>

	Translated into Web:

		<?xml version="1.0" encoding="UTF-8"?> <assignments><assignment closeTime="2014-09-12 17:00:00 CST" dueTime="2014-08-12 17:00:00 CST" gradeType="1" id="403d28b4-e152-463d-a615-972db97d34d3" openTime="2014-05-05 12:00:00 CST" title="A test assign"/></assignments>


###getSubmissionsForAssignment

Get the submission information for given assignment id.

**Parms:**

+ Session ID
+ Assignments ID

**Returns:** The submission.

Example:

1. Using:

		<sessionId xsi:type="xsd:string">3f37632c-6a5d-463d-bf17-7548beae4353</sessionId>
		<assignmentId xsi:type="xsd:string">403d28b4-e152-463d-a615-972db97d34d3</assignmentId>

	Returns:

		<getSubmissionsForAssignmentReturn xsi:type="xsd:string"><![CDATA[<?xml version="1.0" encoding="UTF-8"?>
		<submissions><submission feedback-comment="" feedback-text="" grade="" status="没有提交的作业" submitted-text="" submitter-id="admin"/><submission attachment-url="http://localhost:8080/access/content/attachment/mercury/Assignments/53f77675-7b21-4767-a972-f32e87d791d9/1.png" feedback-comment="&lt;p>  This is admin's comment on test's submission.&lt;/p>" feedback-text="&lt;p>  This is my submission(by test). &lt;strong>Bold&lt;/strong>&lt;/p>&#xa; &lt;p>   &lt;/p>&#xa; &lt;p>   &lt;/p>" grade="A-" status="已返还的" submitted-text="&lt;p>  This is my submission(by test). &lt;strong>Bold&lt;/strong>&lt;/p>&#xa; &lt;p>   &lt;/p>&#xa; &lt;p>   &lt;/p>" submitter-id="aebfd943-4e81-481f-bfbc-f27c9f7cc88a"/></submissions>]]></getSubmissionsForAssignmentReturn>






ContentHosting.jws
----------------------------


###getVirtualRoot

**Parm:** SessionID

get something called *"virtual root"* which can be used to have further information about what the user can get from Sakai.

A example return:

	Virtual-Root-Identifier
	
###getSiteCollectionSize

Get the size of the root collection (total content size on the site).

**Parm:** 

+ SessionID, 
+ context(the site context)
	+ Can be the ID of a site.

**Returns:** the size of the collection in thousands of bytes or -1 if failure.

Example return:

1. Using "/group/mercury"

	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	   <soapenv:Body>
	      <ns1:getSiteCollectionSizeResponse soapenv:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" xmlns:ns1="http://DefaultNamespace">
	         <getSiteCollectionSizeReturn href="#id0"/>
	      </ns1:getSiteCollectionSizeResponse>
	      <multiRef id="id0" soapenc:root="0" soapenv:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" xsi:type="xsd:long" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/">-1</multiRef>
	   </soapenv:Body>
	</soapenv:Envelope>

2. Using:"mercury" (I get "mecury" from **getAllSitesCollectionSize**)

	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	   <soapenv:Body>
	      <ns1:getSiteCollectionSizeResponse soapenv:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" xmlns:ns1="http://DefaultNamespace">
	         <getSiteCollectionSizeReturn href="#id0"/>
	      </ns1:getSiteCollectionSizeResponse>
	      <multiRef id="id0" soapenc:root="0" soapenv:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" xsi:type="xsd:long" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/">6314</multiRef>
	   </soapenv:Body>
	</soapenv:Envelope>

###getAllSitesCollectionSize

**Parm:** SessionID

Will return a list of all sites in XML, including *id*, *size*, *title* etc. E.g.:

	<list><site createdBy="admin" createdTime="2014-4-27 下午3:36" id="~admin" size="0" title="Administration Workspace" type=""/><site createdBy="admin" createdTime="2014-4-27 下午3:36" id="!admin" size="-1" title="Administration Workspace" type=""/><site createdBy="admin" createdTime="2014-4-27 下午3:36" id="citationsAdmin" size="0" title="Citations Admin" type="project"/><site createdBy="admin" createdTime="2014-4-27 下午3:36" id="!gateway" size="0" title="Gateway" type=""/><site createdBy="admin" createdTime="2014-4-27 下午3:36" id="!urlError" size="0" title="Invalid URL" type=""/><site createdBy="test" createdTime="2014-4-30 下午8:24" id="~aebfd943-4e81-481f-bfbc-f27c9f7cc88a" size="0" title="My Workspace" type=""/><site createdBy="admin" createdTime="2014-4-27 下午3:36" id="!user" size="0" title="My Workspace" type=""/><site createdBy="admin" createdTime="2014-4-27 下午3:36" id="PortfolioAdmin" size="116" title="Portfolio Admin" type="portfolioAdmin"/><site createdBy="admin" createdTime="2014-4-27 下午3:36" id="!error" size="0" title="Site Unavailable" type=""/><site createdBy="admin" createdTime="2014-4-27 下午3:36" id="mercury" size="6314" title="mercury site" type=""/><site createdBy="admin" createdTime="2014-4-27 下午3:36" id="!worksite" size="0" title="worksite" type=""/></list>]]>


###getResources

**Parm:** SessionID and ID(of **virtual root**, collection, or resource.)

Get the resources' id and name etc.

An example return (using Virtual Root Id):

	<list><resource><id>/group/PortfolioAdmin/</id><name>Portfolio Admin</name><type>collection</type><url>http://localhost:8080/access/content/group/PortfolioAdmin/</url></resource><resource><id>/group/mercury/</id><name/><type>collection</type><url>http://localhost:8080/access/content/group/mercury/</url></resource></list>]]>

See, inside XML there is **id** for resource like "/group/mercury/".

Another example return (using above resource id):

	<list><resource><id>/group/mercury/NameInCreTopFInMercury/</id><name>NameInCreTopFInMercury</name><type>collection</type><url>http://localhost:8080/access/content/group/mercury/NameInCreTopFInMercury/</url></resource><resource><id>/group/mercury/NameInCreFolderInMercury/</id><name>NameInCreFolderInMercury</name><type>collection</type><url>http://localhost:8080/access/content/group/mercury/NameInCreFolderInMercury/</url></resource><resource><id>/group/mercury/氘原子光谱讲.pdf</id><name>氘原子光谱讲.pdf</name><type>resource</type><url>http://localhost:8080/access/content/group/mercury/%E6%B0%98%E5%8E%9F%E5%AD%90%E5%85%89%E8%B0%B1%E8%AE%B2.pdf</url></resource><resource><id>/group/mercury/1111.png</id><name>LC Circuit (show name).png</name><type>resource</type><url>http://localhost:8080/access/content/group/mercury/1111.png</url></resource><resource><id>/group/mercury/基础生命科学_chapter8.pdf</id><name>基础生命科学_chapter8.pdf</name><type>resource</type><url>http://localhost:8080/access/content/group/mercury/%E5%9F%BA%E7%A1%80%E7%94%9F%E5%91%BD%E7%A7%91%E5%AD%A6_chapter8.pdf</url></resource><resource><id>/group/mercury/Environmental signal integration by a modular AND gate.pdf</id><name>中文Environmental signal integration by a modular AND gate.pdf</name><type>resource</type><url>http://localhost:8080/access/content/group/mercury/Environmental%20signal%20integration%20by%20a%20modular%20AND%20gate.pdf</url></resource></list>]]>
	
Yet another example return (using: /group/mercury/氘原子光谱讲.pdf):

	<list><resource><id>/group/mercury/氘原子光谱讲.pdf</id><name>氘原子光谱讲.pdf</name><type>resource</type><url>http://localhost:8080/access/content/group/mercury/%E6%B0%98%E5%8E%9F%E5%AD%90%E5%85%89%E8%B0%B1%E8%AE%B2.pdf</url></resource></list>]]>

Another (using: /group/citationsAdmin/)

	&lt;?xml version="1.0" encoding="UTF-8"?>&lt;list/>


###getConData

**Parm:** SessionID, ResourceID

This will return the resource (like a pdf, a ppt, a mp3 etc.) encoded in base64 as a String. The return could be huge if the resource is big.

An example:

+ Using:

		<sessionid xsi:type="xsd:string">f88f6f04-53a3-404f-b790-2b03ee32baa2</sessionid>
		<resourceId xsi:type="xsd:string">/group/mercury/1.png</resourceId>

+ Return:

 		<getContentDataReturn xsi:type="xsd:string">iVBORw0KGgoAAAANSUhEUgAAAAsAAAAJCAIAAABrBkF6AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAABRSURBVChTjY7BEUAxBAUdlaE8jRhluOpAeb4Z/sQt2ZM3+0ggbzw33F1Eei52nEZlgHNvx+dXIoKIaq+p2cxaTWPrBhFbTUNVx/wwc6vbPzI/T4LjYsg4OhwAAAAASUVORK5CYII=</getContentDataReturn>


###getInfo

**Parm:** SessionID, ID (of the virtual root, a collection, or a resource)

Returns an empty string if no resources in this collection or an XML list of resource ids, names, and types.

Example:

1. Using:"/group/mercury"

		<getInfoReturn xsi:type="xsd:string">org.sakaiproject.exception.IdUnusedException : null</getInfoReturn>

2. Using:"Virtual-Root-Identifier"

		<resource><id>Virtual-Root-Identifier</id><name>Federated Collections</name><type>collection</type></resource>]]>

3. Using:"/group/mercury/氘原子光谱讲.pdf"

		<resource><id>/group/mercury/氘原子光谱讲.pdf</id><name>氘原子光谱讲.pdf</name><type>resource</type><url>http://localhost:8080/access/content/group/mercury/%E6%B0%98%E5%8E%9F%E5%AD%90%E5%85%89%E8%B0%B1%E8%AE%B2.pdf</url></resource>]]>

4. Using:

		<sessionid xsi:type="xsd:string">74ab1252-5c15-4b4b-b13e-3ee7d40c8f9d</sessionid>
		<id xsi:type="xsd:string">/group/ContextInCreTopF/NameInCreTopF/</id>

	Returns:

		<resource><id>/group/ContextInCreTopF/NameInCreTopF/</id><name>NameInCreTopF</name><type>collection</type><url>http://localhost:8080/access/content/group/ContextInCreTopF/NameInCreTopF/</url></resource>]]>


###createTopFolder

Create a root collection for a site given it's context.

**Parm:**

+ Session ID
+ Context
+ Name

**Returns:**

The id of the new collection. "failure" if failed (May caused by outdated authentication).

Examples:

1. Using:

		<sessionId xsi:type="xsd:string">60ed3deb-f818-467d-94f4-af5ff891f5dc</sessionId>
		<context xsi:type="xsd:string">ContextInCreTopF</context>
		<name xsi:type="xsd:string">NameInCreTopF</name>

	Return:

		<createTopFolderReturn xsi:type="xsd:string">/group/ContextInCreTopF/NameInCreTopF/</createTopFolderReturn>

2. Using:

		<sessionId xsi:type="xsd:string">f88f6f04-53a3-404f-b790-2b03ee32baa2</sessionId>
		<context xsi:type="xsd:string">mercury</context>
		<name xsi:type="xsd:string">NameInCreTopFInMercury</name>

	Returns:

		<createTopFolderReturn xsi:type="xsd:string">/group/mercury/NameInCreTopFInMercury/</createTopFolderReturn>




###createFolder

Create a collection for a site given it's id (with path). TODO: Add a message notifying the Resource tool that a collection.has been created.

**Parms:**

+ Session ID
+ CollectionID
+ Name (name of folder)

**Return:** The id of the new collection. "failure" if failed.

Example:

1. Using:

		<sessionid xsi:type="xsd:string">74ab1252-5c15-4b4b-b13e-3ee7d40c8f9d</sessionid>
		<collectionId xsi:type="xsd:string">/group/ContextInCreTopF</collectionId>
		<name xsi:type="xsd:string">NameInCreFolder</name>

	Returns:

		<createFolderReturn xsi:type="xsd:string">/group/ContextInCreTopFNameInCreFolder/</createFolderReturn>

2. Using(a bit different from Ex.1, great difference in result!!):

		<sessionid xsi:type="xsd:string">74ab1252-5c15-4b4b-b13e-3ee7d40c8f9d</sessionid>
		<collectionId xsi:type="xsd:string">/group/ContextInCreTopF/</collectionId>
		<name xsi:type="xsd:string">NameInCreFolder</name>

	Return:

		<createFolderReturn xsi:type="xsd:string">/group/ContextInCreTopF/NameInCreFolder/</createFolderReturn>

3. Using:

		<sessionid xsi:type="xsd:string">f88f6f04-53a3-404f-b790-2b03ee32baa2</sessionid>
		<collectionId xsi:type="xsd:string">/group/mercury/</collectionId>
		<name xsi:type="xsd:string">NameInCreFolderInMercury</name>

	Returns:

		<createFolderReturn xsi:type="xsd:string">/group/mercury/NameInCreFolderInMercury/</createFolderReturn>

4. Using (**Again, little difference result in big difference!!**):

		<sessionid xsi:type="xsd:string">f88f6f04-53a3-404f-b790-2b03ee32baa2</sessionid>
		<collectionId xsi:type="xsd:string">/group/mercury</collectionId>
		<name xsi:type="xsd:string">NameInCreFolderInMercury</name>

	Returns:

		<createFolderReturn xsi:type="xsd:string">/group/mercuryNameInCreFolderInMercury/</createFolderReturn>


###createContentItem

Add a resource to a given collection. The resource is passed either as text or encoded using Base64 flagged using the binary parameter. TODO: Add a message notifying the Resource tool that a resource has been added to a collection.

**Param:**

+ sessionid - a valid sessionid
+ name - of the resource to be added
+ collectionId - of the collection it is to be added to (e.g. /group/mercury/)
+ contentMime - content string
+ description - of the resource to be added
+ type - the type of the content, in MIME style (e.g. image/png for png files)
+ binary - if true, content is encoded using Base64, if false content is assumed to be text.

Returns:

+ 'Success' or 'Failure'

Example:

1. Using:

		<sessionid xsi:type="xsd:string">f88f6f04-53a3-404f-b790-2b03ee32baa2</sessionid>
		<name xsi:type="xsd:string">NameInCreConItem</name>
		<collectionId xsi:type="xsd:string">/group/mercury/</collectionId>
		<contentMime xsi:type="xsd:string">iVBORw0KGgoAAAANSUhEUgAAAAsAAAAJCAIAAABrBkF6AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAABRSURBVChTjY7BEUAxBAUdlaE8jRhluOpAeb4Z/sQt2ZM3+0ggbzw33F1Eei52nEZlgHNvx+dXIoKIaq+p2cxaTWPrBhFbTUNVx/wwc6vbPzI/T4LjYsg4OhwAAAAASUVORK5CYII=</contentMime>
		<description xsi:type="xsd:string">DescriptionOfFile: An image in png.</description>
		<type xsi:type="xsd:string">image/png</type>
		<binary xsi:type="xsd:boolean">true</binary>

	Returns:

		<createContentItemReturn xsi:type="xsd:string">success</createContentItemReturn>



Portfolio.jws
------------------

Skipped. Since I don't know about portfolios.







SakaiLogin.jws
--------------------

###Login & Logout

Used to login and logout of Sakai. Self-evident. Both use a *sessionid* String to identify users.

*Note:* There are two IDs for a user: User's ID and another inner ID. The user's ID is used for identification outside Sakai, which is used as the parameter here. The other inner ID is used inside Sakai.

###LoginToServe

Almost the same as login, will return an extra String appended to the *sessionid* containing some information about the serve's location as in(source code):

	public String loginToServer(String id,String pw) throws AxisFault {
    	return login(id, pw) + "," + serverConfigurationService.getString("webservices.directurl", serverConfigurationService.getString("serverUrl"));
    }

Example Return:

	<loginToServerReturn xsi:type="xsd:string">b04c37ab-71f9-49b8-85be-4bb6b9707241,http://localhost:8080</loginToServerReturn>



SakaiSigning.jws
----------------------

*Note*: Most methods here are not enabled by default and hence I know nothing about their function.

###getsession(Object)

Don't know. Not enabled by default.

###hex2byte

Will transform HEX value into `byte[]` array. Result is coded from binary to Base64.


SakaiScript.jws
----------------------------

###changeUserEmail

**Parms:**

+ sessionid - the id of a valid session
+ eid - the login username (ie jsmith26) of the user you want to edit
+ email - the updated email address for the user

**Returns:** success or exception message.
Example:

1. Using:

		<sessionid xsi:type="xsd:string">0db3920e-1404-477c-8acf-4fd1eee0d3e2</sessionid>
		<eid xsi:type="xsd:string">admin</eid>
		<email xsi:type="xsd:string">abc@abc.com</email>

	Return:

		<changeUserEmailReturn xsi:type="xsd:string">success</changeUserEmailReturn>

###getAllSitesForUser

**Parms:**

+ Session ID
+ user ID (optional)

**Returns:** XML document listing all sites user has read or write access based on their session id, including My Workspace sites.

Example:

1. Using:

		<sessionid xsi:type="xsd:string">0db3920e-1404-477c-8acf-4fd1eee0d3e2</sessionid>

Returns:

		<getAllSitesForUserReturn xsi:type="xsd:string"><![CDATA[<?xml version="1.0" encoding="UTF-8"?>
		<list><item><siteId>!admin</siteId><siteTitle>Administration Workspace</siteTitle></item><item><siteId>citationsAdmin</siteId><siteTitle>Citations Admin</siteTitle></item><item><siteId>PortfolioAdmin</siteId><siteTitle>Portfolio Admin</siteTitle></item><item><siteId>mercury</siteId><siteTitle>mercury site</siteTitle></item><item><siteId>~admin</siteId><siteTitle>Administration Workspace</siteTitle></item></list>]]></getAllSitesForUserReturn>


2. Using:

		<sessionid xsi:type="xsd:string">0db3920e-1404-477c-8acf-4fd1eee0d3e2</sessionid>
		<userid xsi:type="xsd:string">admin</userid>

Returns:

		<getAllSitesForUserReturn xsi:type="xsd:string"><![CDATA[<?xml version="1.0" encoding="UTF-8"?>
		<list><item><siteId>!admin</siteId><siteTitle>Administration Workspace</siteTitle></item><item><siteId>citationsAdmin</siteId><siteTitle>Citations Admin</siteTitle></item><item><siteId>PortfolioAdmin</siteId><siteTitle>Portfolio Admin</siteTitle></item><item><siteId>mercury</siteId><siteTitle>mercury site</siteTitle></item><item><siteId>~admin</siteId><siteTitle>Administration Workspace</siteTitle></item></list>]]></getAllSitesForUserReturn>


###getGroupsInSite

Get list of groups in a site

Example:

1. Using:

		<sessionid xsi:type="xsd:string">0db3920e-1404-477c-8acf-4fd1eee0d3e2</sessionid>
		<siteid xsi:type="xsd:string">mercury</siteid>

Returns:

		<getGroupsInSiteReturn xsi:type="xsd:string">&lt;?xml version="1.0" encoding="UTF-8"?>
		&lt;list/></getGroupsInSiteReturn>

###getUserEmail

Get a user's email address based on their session id

**Parms:** Session ID

**Returns:** User's email address.

Ex:

1.Using:

		<sessionid xsi:type="xsd:string">0db3920e-1404-477c-8acf-4fd1eee0d3e2</sessionid>

	Or,

		<sessionid xsi:type="xsd:string">0db3920e-1404-477c-8acf-4fd1eee0d3e2</sessionid>
		<userid xsi:type="xsd:string">admin</userid>

Returns:

		<getUserEmailReturn xsi:type="xsd:string">abc@abc.com</getUserEmailReturn>

###getUserId()

Gets the user ID associated with the sessionid

**Pamrs:** sessionid

###getUserId()

Gets the user ID for a given eid.

**Parms:** sessionid, eid

1. Using:

		<sessionid xsi:type="xsd:string">0db3920e-1404-477c-8acf-4fd1eee0d3e2</sessionid>
		<eid xsi:type="xsd:string">admin</eid>

Returns:

		<getUserIdReturn xsi:type="xsd:string">admin</getUserIdReturn>

###getUserType

Get a user's type (for their account)

**Parameters:**

+ sessionid - the id of a valid session
+ userid - the userid of the person you want the type for

**Returns:**

+ type if set or blank

Ex:

1. Using:

		<sessionid xsi:type="xsd:string">0db3920e-1404-477c-8acf-4fd1eee0d3e2</sessionid>
		<userid xsi:type="xsd:string">test</userid>

Returns:

		<getUserTypeReturn xsi:type="xsd:string" xsi:nil="true"/>
		</ns1:getUserTypeResponse>

###isSiteJoinable

Get a site's joinable status

Example:

1. Using

		<sessionid xsi:type="xsd:string">0db3920e-1404-477c-8acf-4fd1eee0d3e2</sessionid>
		<siteid xsi:type="xsd:string">mercury</siteid>

Returns:

		<ns1:isSiteJoinableResponse soapenv:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" xmlns:ns1="http://DefaultNamespace">
		 <isSiteJoinableReturn href="#id0"/>
		</ns1:isSiteJoinableResponse>
		<multiRef id="id0" soapenc:root="0" soapenv:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" xsi:type="xsd:boolean" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/">true</multiRef>


ShortenedUrl.jws
-------------------

Methods here will have effect unless the ShortenedUrlService in `sakai.properties` has been configured. So I skipped it.