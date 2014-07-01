package control;
import core.sakai.objects.SakaiAnnouncement;

/**
 * <p>Interface provided for event on 
 * AnnouncementAdd.</p>
 * 
 * <p>Simulate Java Event hander.</p>
 */
public interface AnnouncementAdd 
{
	
	
	/**
	 * The call back function when a <code>SakaiAnnouncement</code>
	 * is added to a specific site.
	 * 
	 * @param announcement The new Announcement which is added.
	 */
	
	
	public void newAnnouncement(SakaiAnnouncement announcement);
		
}
