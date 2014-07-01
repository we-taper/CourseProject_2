Sakai Entity API Summary
==============================

Examples
-----------------

Login:

<http://localhost:8080/direct/session?_username=admin&_password=admin>

See pages:

<http://localhost:8080/direct/site/mercury/pages>

Access to group information:

<http://localhost:8080/direct/site/mercury?group>

Topic of a site:

<http://localhost:8080/direct/topic?site=mercury>

Information on a site:

<http://localhost:8080/direct/site?_id=mercury>

<http://localhost:8080/direct/site/mercury>

<http://learning.sustc.edu.cn/direct/site?_id=7ba242f6-b728-478b-a126-431aafbde62e>

<http://learning.sustc.edu.cn/direct/site/7ba242f6-b728-478b-a126-431aafbde62e>

Announcement

http://learning.sustc.edu.cn/direct/announcement/site/7ba242f6-b728-478b-a126-431aafbde62e.xml?n=20&d=100

http://learning.sustc.edu.cn/direct/announcement/7ba242f6-b728-478b-a126-431aafbde62e:main:9642ebce-af25-4f43-b29d-b502afcf5a8a.xml

Assignment

http://localhost:8080/direct/assignment/deepLink/mercury/a04e98ad-f233-4ff4-95b3-13653d1b3ed2.xml

http://localhost:8080/direct/assignment/deepLinkWithPermissions/mercury/a04e98ad-f233-4ff4-95b3-13653d1b3ed2.xml


announcement

---------------------

<http://learning.sustc.edu.cn/direct/announcement/describe>

显示指定站点的通知（包括合并的通知），或者指定用户的所有通知，同时还包括公开通知和系统公告。链接地址中有2个可选参数：‘n’表示返回通知的总数，‘d’表示通知距今的天数。如果没有设置参数，将使用工具配置中的参数，或者将使用默认值(n=3，d=10)。例如 /announcements/site/mercury.json?n=20&d=100将获取最近100天内，最多20条通知。

###Operation 

GET, POST, PUT, DELETE

###Custom Actions


message : list (GET) : [/announcement/message] (xml) (json)

site : list (GET) : [/announcement/site] (xml) (json)

获取指定站点的通知。如果您未登录，您只能看到此站点的公开通知。

motd : list (GET) : [/announcement/motd] (xml) (json)

只获取系统公告

msg : list (GET) : [/announcement/msg] (xml) (json)
通过内部通知服务使用的路径获取通知。/msg/{siteId}/{channelId}/{announcementId}

user : list (GET) : [/announcement/user] (xml) (json)

获取指定站点的通知。如果您未登录，您只能看到系统公告。


assignment 
-------------------------

<http://learning.sustc.edu.cn/direct/assignment/describe>

作业

###Operation 

GET

###Custom Actions


site : list (GET) : [/assignment/site] (xml) (json) (form)

获取站点的作业。
deepLink : list (GET) : [/assignment/deepLink] (xml) (json) (form)

此操作获取作业的引用，返回当前用户的URL。请求的URL格式如下：/direct/assignment/deepLinks/{assignment_ref}

deepLinkWithPermissions : list (GET) : [/assignment/deepLinkWithPermissions] (xml) (json) (form)

此操作获取作业的引用，以及allowReadAssignment，allowAddAssignment，allowSubmitAssignment的布尔值并返回相关的URL。请求的URL格式如下：/direct/assignment/deepLinks/{assignment_ref}，另加上以下参数： {bool_allowRead}，{bool_allowAdd}， {bool_allowSubmit}

annc : list (GET) : [/assignment/annc] (xml) (json) (form)

此操作获取作业的引用，并返回用于通知集成的作业信息。作业信息包括作业对象，内容，作业id，作业标题，作业URL。请求的URL格式如下：/direct/assignment/annc/{assignment_ref}，另需加上参数 {messageId}


basiclti-events
-------------------

<http://learning.sustc.edu.cn/direct/basiclti-events/describe>
None


chat-channel
-----------------------
在站点中，聊天频道代表一个聊天室

###Operation 

GET,POST,PUT,DELETE

###Custom Actions

listen : edit (PUT) : [/chat-channel/:ID:/listen] 


chat-message
---------------------

<http://learning.sustc.edu.cn/direct/chat-message/describe>

每条消息表示聊天室中的一条信息


###Operation 

GET,POST

###Custom Actions


forum
-------------------

<http://learning.sustc.edu.cn/direct/forum/describe>

###Operation 

None

###Custom Actions

None


forum_message
-------------------

###Operation 

GET,POST,PUT,DELETE

###Custom Actions

topic : list (GET) : [/forum_message/topic]
markread : new (POST) : [/forum_message/markread]
private : list (GET) : [/forum_message/private] 


forum_topic
------------------

<http://learning.sustc.edu.cn/direct/forum_topic/describe>

###Operation 

None

###Custom Actions

None


gradebook
---------------

<http://learning.sustc.edu.cn/direct/gradebook/describe>

###Operation 

GET

###Custom Actions

None


lessonbuilder
-----------------

http://learning.sustc.edu.cn/direct/lessonbuilder/describe

###Operation 

GET,POST

###Custom Actions

None


matrixcell
----------------

<http://learning.sustc.edu.cn/direct/matrixcell/describe>

###Operation 

GET

###Custom Actions

canUserAccessWizardPageAndLinkedArtifcact : * : [/matrixcell/canUserAccessWizardPageAndLinkedArtifcact]


membership
--------------

<learning.sustc.edu.cn/direct/membership/describe>

Represents a user's membership in a location (site, group, etc.) in the system, works with the site/group entities and the user entities. In the documentation below, a membership ID is a string in the form USER_ID::LOCATION_REFERENCE (e.g., "aaronz::site:mySiteId").

###Operation 

GET,POST,PUT,DELETE

###Custom Actions


site : * : [/membership/site] (html) (xml) (json) (form)

The URL format is "/membership/site/:SITE_ID:".
(GET) will return all memberships in the specified site.
(POST) will add one or more site memberships via an array of "userSearchValues" request parameters (each of which is a user ID, user EID, or email address), along with a "memberRole" string (default for joinable site memberships is the default joiner role) and "active" Boolean value (default is true). Response headers may include "x-warning-not-found" (for a list of invalid userSearchValues) and "x-warning-already-members" (for a list of userSearchValues which were already site members).

unjoin : new (POST) : [/membership/unjoin]

Allows a user without permissions in a site to unjoin from it, works with the current user only: /membership/unjoin/site/siteId

join : new (POST) : [/membership/join]

Allows a user without permissions in a site to join it, works with the current user only: /membership/join/site/siteId

group : * : [/membership/group] (html) (xml) (json) (form)

The URL format is "/membership/group/:groupId:"

(GET) will return all memberships for a group.

(POST) will update user group membership. Mandatory POST Parameters: 'userIds' a comma separated list of users (eid or id). 'action' can have values: update, add or remove. If update, replace the current membership with the provided list. If add, add the list to the existing membership, if remove, remove the list from the existing membership.

my
-------------------

<http://learning.sustc.edu.cn/direct/my/describe>

一系列链接地址，通过这些地址可以直接链接到Profile2中定义的地址。

###URL Redirects

1)   /my/profile/{userUuid} ==> calculated destination

重定向到指定用户的个人资料首页

2)   /my/profile ==> calculated destination

重定向到当前用户的个人资料首页

3)   /my/messages/{thread} ==> calculated destination

重定向到当前用户消息页面中的指定消息

4)   /my/messages ==> calculated destination

重定向到当前用户的消息页面

5)   /my/connections ==> calculated destination

重定向到当前用户的好友页面

6)   /my/wall/{userUuid} ==> calculated destination

7)   /my/wall/{userUuid}/{wallItemId} ==> calculated destination

poll
---------------

<http://learning.sustc.edu.cn/direct/poll/describe>

显示调查（单个问题），相关投票，相关选项

###Operation 

GET,POST,PUT,DELETE

###URL Redirects

1)   /poll/{pollId}/vote ==> /direct/poll-vote{dot-extension}

获取指定调查的所有投票

2)   /poll/{pollId}/option ==> /direct/poll-option{dot-extension}

获取指定调查的所有选项

3)   /poll/site/{siteId} ==> /direct/poll{dot-extension}

获取在指定站点中当前用户能进行的调查

poll-option
------------------

<http://learning.sustc.edu.cn/direct/poll-option/describe>

表示调查中的一个选项

###Operation 

GET,POST,PUT,DELETE

###Custom Actions

None


poll-vote
----------------

<http://learning.sustc.edu.cn/direct/poll-vote/describe>

表示用户在调查中的投票

###Operation 

GET,POST

###Custom Actions

vote : new (POST) : [/poll-vote/vote] 


portal-chat
----------------

<http://learning.sustc.edu.cn/direct/portal-chat/describe>

Presents an HTTP interface onto Sakai's portal chat system.

###Operation 

POST

###Custom Actions


latestData : show (GET) : [/portal-chat/:ID:/latestData] (txt) (json)

The URL format is "/direct/portal-chat/ANYTHING/latestData.json?online=true&siteId=SITEID".

Grabs all the latest data for the currently logged in user. This operation will also optionally set the heartbeat for the current user.

If you don't want to show up in chattable lists, pass false for online and you'll be hidden from others. The latestData operation retrieves your connections, your messages, and, if you specify a siteId parameter, the list of users currently in that site.

ping : show (GET) : [/portal-chat/:ID:/ping] (txt) (json)

The URL format is "/direct/portal-chat/USERTOPING/ping" where USERTOPING is a Sakai user id.

Returns the string "success" if an email is successfully sent to the user.



profile
------------------

<http://learning.sustc.edu.cn/direct/profile/describe>

显示一个用户的个人资料。由于用户可以自定义用户资料各部分的访问权限，所以返回的信息将根据请求的用户不同而不同。


###Operation 

GET

###Custom Actions

 formatted : show (GET) : [/profile/:ID:/formatted] (html) (xml) (json)

ignoreFriendRequest : show (GET) : [/profile/:ID:/ignoreFriendRequest] (html) (xml) (json)

requestFriend : show (GET) : [/profile/:ID:/requestFriend] (html) (xml) (json)

image : show (GET) : [/profile/:ID:/image] (html) (xml) (json)

获取一个用户的个人资料照片。如果照片有缩略图，可以在请求后面添加“/thumb”来获取(/profile/USER/image/thumb)；如果没有缩略图，将返回原图可以添加siteId作为参数来进行站点权限检查(/profile/USER/image?siteId={siteid} 或 /profile/USER/image/thumb?siteId={siteid}) 返回照片的二进制格式。如果没有照片或照片不允许访问，则返回默认照片。如果用户或设定的siteId无效，将返回401。如果照片存在，将总是会返回，可能是上传的照片，也可能是一个链接(取决于系统的设置，具体请查看Profile2 sakai.properties)。您可以直接使用img标签 <img src="/profile/USER/image[/thumb]" />，这总会显示一些内容。请不要设定任何返回格式，如.xml。

connections : show (GET) : [/profile/:ID:/connections] (html) (xml) (json)

返回一个用户的好友列表。如果没有好友，将返回一个空列表；如果您无权查看此用户的好友列表，或此用户是无效帐号，将返回一个错误(404)。

removeFriend : show (GET) : [/profile/:ID:/removeFriend] (html) (xml) (json)

confirmFriendRequest : show (GET) : [/profile/:ID:/confirmFriendRequest] (html) (xml) (json)

friendStatus : show (GET) : [/profile/:ID:/friendStatus] (html) (xml) (json)


profile-events
-------------------

<http://learning.sustc.edu.cn/direct/profile-events/describe>

允许想站点统计工具发送有关工具使用情况的匿名报告。此处暂无用户界面。

###Operation 

None

###Custom Actions

None

profile-message
------------------

<http://learning.sustc.edu.cn/direct/profile-message/describe>


允许访问Profile2信息系统

###Operation

GET

###Custom Actions

None

profile-status 
-----------------------

<http://learning.sustc.edu.cn/direct/profile-status/describe>

显示用户状态。

###Operation 

GET,POST,PUT

###Custom Actions

None


sam_pub
--------------

<http://learning.sustc.edu.cn/direct/sam_pub/describe>


###Operation 

GET

###Custom Actions

None

search
-------------

<http://learning.sustc.edu.cn/direct/search/describe>


###Operation 

GET

###Custom Actions

None


server-config
---------------------

<http://learning.sustc.edu.cn/direct/server-config/describe>

Represents settings in the server configuration

###Operation 

GET

###Custom Actions


values : list (GET) : [/server-config/values] (xml) (html) (json)

names : list (GET) : [/server-config/names] (xml) (html) (json)

servers : list (GET) : [/server-config/servers] (xml) (html) (json)

Get the list of serverIds in the current Sakai cluster


session
------------------

Represents a user or system session which is currently active, inactive sessions or information about inactive sessions cannot be accessed, the session is effectively immutable and removing it is the same as deactivating it, updating simply has the effect of refreshing it so it will not timeout

###Operation 

GET,POST,PUT,DELETE

###Custom Actions


current : list (GET) : [/session/current] (html) (xml) (json) (form)

Retrieves the current session for the current request

site
------------------

Represents a site (a collection of users and tools) in the Sakai system

###Operation 

GET,POST,PUT,DELETE

###Custom Actions


userPerms : show (GET) : [/site/:ID:/userPerms] (xml) (json) (html) (form)

Allows the retrieval of the current user's permissions within the specified site using a url like /site/:SITEID:/userPerms[/:PREFIX], where PREFIX allows the caller to limit the returned permissions to a subset. For example, the url '/direct/site/XYZ/userPerms/calendar.json' would return the calendar permissions of the current user in the site 'XYZ'. Missing the PREFIX off would result in the permissions for all the tools in the site being returned.

setPerms : edit (PUT) : [/site/:ID:/setPerms]

Allows the setting of the permissions for the specified site by posting to the url /site/:SITEID:/setPerms. This is done by passing a set of post parameters where the key takes the form of 'ROLEID:FUNCTION' and the value is a boolean 'true' or 'false'. For example, passing the parameter 'maintain:blog.post.create=true' would switch the blog.post.create function on for the maintain role in the specified site.

perms : show (GET) : [/site/:ID:/perms] (xml) (json) (html) (form)

Allows the retrieval of the permissions for the specified site using a url like /site/:SITEID:/perms[/:PREFIX].json, where PREFIX allows the caller to limit the returned permissions to a subset. For example, the url '/direct/site/XYZ/perms/calendar.json' would return the calendar permissions for each role in the site 'XYZ'. Missing the PREFIX off would result in the permissions for all the tools in the site being returned.

pages : show (GET) : [/site/:ID:/pages] (xml) (json) (html) (form)

Allows retrieval of all pages and tools in a site, use "props" (true/false, default false) to include page properties, use "config" (true/false, default false) to include tool configurations

exists : show (GET) : [/site/:ID:/exists] (xml) (json) (html) (form)

Returns an empty 200 if the site exists, and a failure (possibly 404) if it does not.

Note that you can also check this by simply using the show view of a site but that returns the site information as well so this is faster

role : * : [/site/role] (xml) (json) (html) (form)

group : * : [/site/group] (xml) (json) (html) (form)

Allows access to group information directly using a url like: /site/siteId/group/groupId For membership actions use the Membership Provider

(GET) /direct/site/siteid/group/groupid - gets metadata for group but not membership.

(POST) /direct/site/siteid/group/groupid - updates metadata for group but not membership.

(PUT) /direct/site/siteid/group - create a new group in the site (returns group id). Parameters include title, description, optionally initial list of members.

(DELETE) /direct/site/siteid/group/groupid - delete an existing group in the site.


sitestats-metrics
------------------------------

<http://learning.sustc.edu.cn/direct/sitestats-metrics/describe>


提供当前服务器节点的站点统计事件聚合举证。

###Operation 

GET

###Custom Actions

 get-events-processed-per-sec : list (GET) : [/sitestats-metrics/get-events-processed-per-sec] (html) (xml) (json)

获取每秒处理事件的平均数量。

get-events-generated-per-sec : list (GET) : [/sitestats-metrics/get-events-generated-per-sec] (html) (xml) (json)

获取Sakai平均每秒生成的事件数量。

is-idle : list (GET) : [/sitestats-metrics/is-idle] (html) (xml) (json)

检查时间聚合其是否空闲（队列中没有待处理事件并且没有正在处理的事件）。

get-average-time-event-processing-per-event : list (GET) : [/sitestats-metrics/get-average-time-event-processing-per-event] (html) (xml) (json)

获取处理每个事件所使用的平均时间（毫秒）。

get-time-ellapsed-since-reset : list (GET) : [/sitestats-metrics/get-time-ellapsed-since-reset] (html) (xml) (json)

获取从上次启动或重设后经过的时间（毫秒）。

get-total-events-processed : list (GET) : [/sitestats-metrics/get-total-events-processed] (html) (xml) (json)

获取所有处理的事件数量。

get-queue-size : list (GET) : [/sitestats-metrics/get-queue-size] (html) (xml) (json)

返回等待队列中的事件数量。

get-time-spent-processing-events : list (GET) : [/sitestats-metrics/get-time-spent-processing-events] (html) (xml) (json)

获取用在事件处理上的所有时间（毫秒）。

get-reset-time : list (GET) : [/sitestats-metrics/get-reset-time] (html) (xml) (json)

获取从上次启动或重设后的时间。

reset-all-metrics : list (GET) : [/sitestats-metrics/reset-all-metrics] (html) (xml) (json)

重置所有矩阵。

get-all-metrics : list (GET) : [/sitestats-metrics/get-all-metrics] (html) (xml) (json)

获取所有矩阵。

sitestats-report
----------------------------

<http://learning.sustc.edu.cn/direct/sitestats-report/describe>

###Operation 

GET

###Custom Actions

None

synopticmsgcntritem
------------------------------

<http://learning.sustc.edu.cn/direct/synopticmsgcntritem/describe>

###Operation 

GET,POST,PUT,DELETE

###Custom Actions

None

topic
--------------------

<http://learning.sustc.edu.cn/direct/topic/describe>

###Operation 

GET,POST,PUT,DELETE

###Custom Actions

site : list (GET) : [/topic/site] (html) (xml) (json)

forum : list (GET) : [/topic/forum] (html) (xml) (json)

private : list (GET) : [/topic/private] (html) (xml) (json)

tutorial
------------

<http://learning.sustc.edu.cn/direct/tutorial/describe>

###Operation 

GET,PUT,POST,DELETE

###Custom Actions

None

url
-----------------

<http://learning.sustc.edu.cn/direct/url/describe>

An entity provider to allow shortening of URLs via the ShortenedUrlService

###Operation 

GET

###Custom Actions

None

user
-------------------

<http://learning.sustc.edu.cn/direct/user/describe>

Represents a user in the system, user data is effectively immutable and removing users cannot override externally provided users

###Operation 

GET,POST,PUT,DELETE

###Custom Actions


exists : show (GET) : [/user/:ID:/exists] (xml) (json) (form)

Check if a userId exists (will check by eid and then id unless 'id=userId' is used), return 200 if exists and some failure code like 400 if not

current : list (GET) : [/user/current] (xml) (json) (form)

Get the current user if there is one


userPrefs
--------------------

<http://learning.sustc.edu.cn/direct/userPrefs/describe>

###Operation 

GET,POST,PUT,DELETE

###Custom Actions

saveDivState : edit (PUT) : [/userPrefs/:ID:/saveDivState] 

validation
------------------------

<http://learning.sustc.edu.cn/direct/validation/describe>


###Operation 

None

###Custom Actions

None


###Operation 

GET

###Custom Actions

None


###Operation 

GET

###Custom Actions

None


###Operation 

GET

###Custom Actions

None


###Operation 

GET

###Custom Actions

None
