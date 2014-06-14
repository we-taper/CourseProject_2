package GUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.HashMap;

import javax.swing.*;

import control.LoginControl;
import control.Sites;
import core.sakai.objects.SakaiSite;

public class resources extends JPanel{
	Image image;
	
	public resources(){
		setLayout(null);
	 
		int x=0;
		HashMap<String, SakaiSite> sites = Sites.getAllSites();
		for(String str :sites.keySet()){
			if(str.equals("Citations Admin")||str.equals("Administration Workspace")||str.equals("Portfolio Admin")){
				
			}else {
				
			
			SakaiSite site=sites.get(str);
			mylabel ml=new mylabel(str,site);
			ml.setLocation(x, 5);
			x=x+15*str.length()+10;
			add(ml);
			}
			
		}


		
		
		
		}
	


}
