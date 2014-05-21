package core.sakai.objects;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="assignment_collection")
public class SakaiAssignmentCollection {

	private List<SakaiAssignment> assignment;
	public void setAssignment(List<SakaiAssignment> s){
		assignment = s;
	}
	public List<SakaiAssignment> getAssignment() {
		return assignment;
	}
}
