package core.sakai.objects;

public class Resource {

	private String name,id,type,url;
	public Resource(String name, String id, String type, String url) {
		this.name = name;
		this.id = id;
		this.type = type;
		this.url = url;
	}
	public Resource() {
		this("unknow", "unknow", "unknow", "unknow");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return id;
	}
	public void setID(String id){
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type){ 
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url){
		this.url = url;
	}
	
	@Override
	public String toString() {
		return String.format("Name:%s, ID:%s, Type:%s, Url:%s",name,id,type,url);
	}
}
