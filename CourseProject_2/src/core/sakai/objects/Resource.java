package core.sakai.objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class bind the XML into Java class.
 * @author we.taper
 *
 */
@XmlRootElement(name="resource")

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
	
	@XmlElement(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name="id")
	public String getID() {
		return id;
	}
	public void setID(String id){
		this.id = id;
	}
	
	@XmlElement(name="type")
	public String getType() {
		return type;
	}
	public void setType(String type){ 
		this.type = type;
	}
	
	@XmlElement(name="url")
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
