package control;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import core.sakai.objects.SakaiSite;

/**
 * This class uses <code>java.util.Timer</code>
 * to update all information about site, announcement, etc.
 * 
 */

public class UpdateTasker 
{
	private static ArrayList<Timer> timers = new ArrayList<Timer>();
	
	public static void startAnnouncementUpdater
	(final SakaiSite target, final AnnouncementAdd handler)
	{
		target.addAnnouncementHandler(handler);
		
		Timer annTimer = new Timer();
		annTimer.schedule
		(
			new TimerTask()
			{
				@Override
				public void run()
				{
					try
					{
						target.updataAnnouncement();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}, 10, 1000 * 6
		);
		
		timers.add(annTimer);
	}
	
	public static void startUpdateSites(SitesAdd handler)
	{
		Sites.addSitesAddHandler(handler);
		
		Timer siteTimer = new Timer();
		siteTimer.schedule
		(
			new TimerTask()
		{
			
			@Override
			public void run() 
			{
				try
				{
					Sites.updateSites();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		
		}, 10, 1000 * 60 * 1);
		
		timers.add(siteTimer);
		
	
	}
	
	public static void startResourceUpdater(final SakaiSite site, final ResourceAdd handler)
	{
		Timer resTimer = new Timer();
		
		resTimer.schedule
		(
			new TimerTask()
			{
				@Override
				public void run() 
				{
					try
					{
						Resources.updateSiteResource(site, handler);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
			}, 10, 1000 * 6
		);
		
		timers.add(resTimer);
	}
	
	
	public static void startAssignmentUpdater(final SakaiSite site, final AssignmentAdd handler)
	{
		Timer assTimer = new Timer();
		
		site.addAssignmentAddHandler(handler);
		assTimer.schedule
		(
			new TimerTask()
		{

			@Override
			public void run() 
			{
				try
				{
					site.updateAssignment();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
		}, 10, 1000 * 6);
		
		timers.add(assTimer);
	}
	
	public static void stopAllTaker()
	{
		for(Timer timer : timers)
		{
			timer.cancel();
		}
	}
}

//HAHAHA

