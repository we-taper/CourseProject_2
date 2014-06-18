package GUI;
import java.awt.*;
import java.util.HashMap;

import javax.swing.*;

import control.Sites;
import core.sakai.objects.SakaiSite;

public class JhomeworkPanel extends JPanel{
	Image image;
	
	public JhomeworkPanel(){
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
		int x=0;
		//setBounds(0, 0, 1055, 36);
		HashMap<String, SakaiSite> sites = Sites.getAllSites();

		for(String str :sites.keySet()){
			if(str.equals("Citations Admin")||str.equals("Administration Workspace")||str.equals("Portfolio Admin")){
				
			}else {
				
			
			SakaiSite site=sites.get(str);
			mylabel ml=new mylabel(str,site);
			
		//	ml.setLocation(x, 5);
		//	x=x+ml.size().width+10;
			add(ml);
			}

		}
	

		
		
		}
	
////	public void removeall(){
//		this.removeAll();
//		setLayout(null);
//		 
//		int x=0;
//		HashMap<String, SakaiSite> sites = Sites.getAllSites();
//	
//		for(String str :sites.keySet()){
//			if(str.equals("Citations Admin")||str.equals("Administration Workspace")||str.equals("Portfolio Admin")){
//				
//			}else {
//				
//			
//			SakaiSite site=sites.get(str);
//			mylabel ml=new mylabel(str,site);
//			
//			ml.setLocation(x, 5);
//			x=x+ml.size().width+10;
//			add(ml);
//			}

//		}
	
		
//	}
				


}
