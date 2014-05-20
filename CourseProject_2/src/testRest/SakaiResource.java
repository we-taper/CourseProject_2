package testRest;

import java.io.IOException;
import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import taper.util.XMLUtil;

/**
 * This class bind the XML into Java class.
 * @author we.taper
 *
 */
public class SakaiResource {
	public static void main(String[] args) throws JAXBException, ParserConfigurationException, SAXException, IOException {
        JAXBContext jc = JAXBContext.newInstance(SakaiList.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        String xmlString = "<list><resource><id>/group/PortfolioAdmin/</id><name>Portfolio Admin</name><type>collection</type><url>http://localhost:8080/access/content/group/PortfolioAdmin/</url></resource><resource><id>/group/mercury/</id><name/><type>collection</type><url>http://localhost:8080/access/content/group/mercury/</url></resource></list>";
        
        JAXBElement<SakaiList> list_ = unmarshaller.unmarshal(XMLUtil.loadXMLFromString(xmlString).getFirstChild(), SakaiList.class);
        SakaiList list = list_.getValue();
//        SakaiList fosterHome = (SakaiList) unmarshaller.unmarshal(new File("src/nov18/input.xml"));
        Iterator<SakaiResource> iterator = list.recList.iterator();
        while(iterator.hasNext()) {
        	System.out.println(iterator.next());
        }

	}
    @XmlElement(name="id")
    public String id;

    @XmlElement(name="name")
    public String name;

    @XmlElement(name="type")
    public String type;

    @XmlElement(name="url")
    public String url;
    
    public String toString() {
    	return id+" "+name+" "+type+" "+url+".";
    }
}
