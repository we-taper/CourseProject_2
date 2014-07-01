package control;
import core.sakai.objects.SakaiSite;

/**
 * <p>Interface provided for event on 
 * SiteAdd.</p>
 * 
 * <p>Simulate Java Event hander.</p>
 */
public interface SitesAdd 
{
	/**
	 * Call back function when new site is added.
	 *  
	 * @param newSite The new site which is added.
	 */
	public void siteAdd(SakaiSite newSite);
}
