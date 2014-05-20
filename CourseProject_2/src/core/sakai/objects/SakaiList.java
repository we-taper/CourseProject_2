package core.sakai.objects;

import java.util.List;

import javax.xml.bind.annotation.*;

/**
 * Bind List with XML
 * @author we.taper
 *
 */
@XmlRootElement(name="list")
@XmlAccessorType(XmlAccessType.FIELD)
public class SakaiList {


//    @XmlElementWrapper(name="Families")
    @XmlElement(name="resource")
    public List<Resource> recList;

}
