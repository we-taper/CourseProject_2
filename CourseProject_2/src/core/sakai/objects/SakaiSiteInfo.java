package core.sakai.objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="site")
public class SakaiSiteInfo {
	private String id,title,createdBy,createdTime,type;
	private long size;
	public SakaiSiteInfo() {
		this("Unknow");
	}
	public SakaiSiteInfo(String id) {
		this(id,"Unset");
	}
	public SakaiSiteInfo(String id, String title) {
		//TODO null --> name
		this(id,title,null,null,0,null);
	}
	public SakaiSiteInfo(String id, String title, String createdBy, String createdTime, long size, String type) {
		this.id = id;
		this.title = title;
		this.createdBy = createdBy;
		this.createdTime = id;
		this.size = size;
		this.type = type;
	}
	
	@XmlAttribute(name="id")
	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
	}

	@XmlAttribute(name="createdBy")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String s) {
		this.createdBy = s;
	}

	@XmlAttribute(name="createdTime")
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String s) {
		this.createdTime = s;
	}

	@XmlAttribute(name="size")
	public long getSize() {
		return size;
	}
	public void setSize(long s) {
		this.size = s;
	}
	
	@XmlAttribute(name="title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@XmlAttribute(name="type")
	public void setType(String type) {
		this.type = type;
	}
	public String getType(){
		return type;
	}
	@Override
	public String toString() {
		return "SakaiSite [getID()=" + getID() + ", getCreatedBy()="
				+ getCreatedBy() + ", getCreatedTime()=" + getCreatedTime()
				+ ", getSize()=" + getSize() + ", getTitle()=" + getTitle()
				+ ", getType()=" + getType() + "]";
	}

}