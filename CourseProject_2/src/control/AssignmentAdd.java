package control;

import core.sakai.objects.SakaiAssignment.SakaiAssignmentContent;

/**
 * <p>Interface provided for event on 
 * AssignmentAdd.</p>
 * 
 * <p>Simulate Java Event hander.</p>
 */
public interface AssignmentAdd 
{
	/**
	 * The call back function when a <code>SakaiAssignmentContent</code> is added
	 * to specific site. 
	 * 
	 * @param assignment The assignment object which is added.
	 */
	public void newAssignment(SakaiAssignmentContent assignment);
}
