package control;

import java.io.File;

/**
 * <p>Interface provided for event on 
 * ResourceAdd.</p>
 * 
 * <p>Simulate Java Event hander.</p>
 */

public interface ResourceAdd 
{
	/**
	 * The call back function when newly added file is download 
	 * to the local storage, and user could access that resource 
	 * directly.
	 * 
	 * @param resource The resource which is added to site.
	 */
	
	public void resourceAdd(File resource);
}
