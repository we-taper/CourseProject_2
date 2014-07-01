package GUI;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import control.Sites;
import core.sakai.objects.SakaiSite;

public class announcementsite extends JPanel {
	ArrayList<announcementlabel> mylabels=new ArrayList<announcementlabel>();
	public announcementsite() {
		FlowLayout flowLayout=new FlowLayout();
		setLayout(flowLayout);
		flowLayout.setAlignment(FlowLayout.LEADING);
String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HashMap<String, SakaiSite> sites = Sites.getAllSites();
		for(String str :sites.keySet()){
			if(str.equals("Citations Admin")||str.equals("Administration Workspace")||str.equals("Portfolio Admin")){
				
			}else {
				
			
			SakaiSite site=sites.get(str);
		announcementlabel ml=new announcementlabel(str,site);
			mylabels.add(ml);
	
			
			}
			
		}
	
	for(announcementlabel ml:mylabels){
			add(ml);
	}
		
		
		}
}
