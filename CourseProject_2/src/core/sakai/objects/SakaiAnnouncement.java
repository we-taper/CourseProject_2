package core.sakai.objects;

import java.util.Date;
import java.util.List;

public class SakaiAnnouncement {

	private String announcementId;
	private List<SakaiResource> attachments;
	private String body;
	private String createdByDisplayName;
	private Date createdOn;
	private String id;
	private String siteId;
	private String siteTitle;
	private String title;
	private String entityReference;
	private String entityURL;
	private String entityId;
	public String getAnnouncementId() {
		return announcementId;
	}
	public void setAnnouncementId(String announcementId) {
		this.announcementId = announcementId;
	}
	public List<SakaiResource> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<SakaiResource> attachments) {
		this.attachments = attachments;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getCreatedByDisplayName() {
		return createdByDisplayName;
	}
	public void setCreatedByDisplayName(String createdByDisplayName) {
		this.createdByDisplayName = createdByDisplayName;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getSiteTitle() {
		return siteTitle;
	}
	public void setSiteTitle(String siteTitle) {
		this.siteTitle = siteTitle;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEntityReference() {
		return entityReference;
	}
	public void setEntityReference(String entityReference) {
		this.entityReference = entityReference;
	}
	public String getEntityURL() {
		return entityURL;
	}
	public void setEntityURL(String entityURL) {
		this.entityURL = entityURL;
	}
	public String getEntityId() {
		return entityId;
	}
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
	public String getEntityTitle() {
		return entityTitle;
	}
	public void setEntityTitle(String entityTitle) {
		this.entityTitle = entityTitle;
	}
	private String entityTitle;
	
	@Override
	public String toString() {
		return "SakaiAnnouncement [getAnnouncementId()=" + getAnnouncementId()
				+ ", getAttachments()=" + getAttachments() + ", getBody()="
				+ getBody() + ", getCreatedByDisplayName()="
				+ getCreatedByDisplayName() + ", getCreatedOn()="
				+ getCreatedOn() + ", getId()=" + getId() + ", getSiteId()="
				+ getSiteId() + ", getSiteTitle()=" + getSiteTitle()
				+ ", getTitle()=" + getTitle() + ", getEntityReference()="
				+ getEntityReference() + ", getEntityURL()=" + getEntityURL()
				+ ", getEntityId()=" + getEntityId() + ", getEntityTitle()="
				+ getEntityTitle() + "]";
	}
}
