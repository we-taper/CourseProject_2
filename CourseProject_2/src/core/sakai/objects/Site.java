package core.sakai.objects;
public class Site {
	private String id,title,createdBy,createdTime,type;
	private long size;
	public Site() {
		this("Unknow");
	}
	public Site(String id) {
		this(id,"Unset");
	}
	public Site(String id, String title) {
		//TODO null --> name
		this(id,title,null,null,0,null);
	}
	public Site(String id, String title, String createdBy, String createdTime, long size, String type) {
		this.id = id;
		this.title = title;
		this.createdBy = createdBy;
		this.createdTime = id;
		this.size = size;
		this.type = type;
	}
	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String s) {
		this.createdBy = s;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String s) {
		this.createdTime = s;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long s) {
		this.size = s;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType(){
		return type;
	}
	
	@Override
	public String toString() {
		//TODO update this.
		return "Title:"+getTitle()+","
				+"ID:"+getID()+","
				+"Type:"+getType()+","
				+"CreatedBy:"+getCreatedBy()+","
				+"CreatedTime:"+getCreatedTime();
	}
}