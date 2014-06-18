package control;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import core.sakai.objects.SakaiSite;

public class UpdateTasker 
{
	public static ArrayList<Timer> timers = new ArrayList<Timer>();
	
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
//					new Timer().schedule(this, gap, gap);
				}
			}
		
		}, 10, 1000 * 60 * 30);
		
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
				
			}, 10, 1000 * 60 * 5
		);
	
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
//					new Timer().schedule(this, 0, 1000 * 60 * 5);
				}
			}
			
		}, 10, 1000 * 60 * 5);
		
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
