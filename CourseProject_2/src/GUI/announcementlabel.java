package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import core.sakai.objects.SakaiSite;

public class announcementlabel extends JLabel{

		public SakaiSite site;
		boolean isclicked=false;
		public  announcementlabel(String name ,SakaiSite si) {
			
			super(name);
			int width=0;
			site=si;
		
			setFont(new Font(this.getFont().getFontName(),this.getFont().getStyle(),28));
			
			
			addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					if(isclicked){}else {
						
					
					
					setOpaque(false);
					setForeground(Color.black);
					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));}
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					if(isclicked){}else {
						
					
					setOpaque(true);
					setBackground(Color.GRAY);
					setForeground(Color.white);
					setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));}
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
				
							
							loginpanel.mainpanel.ap.removeAll();
							loginpanel.mainpanel.ap.add(new announcementpanel(site));
							loginpanel.mainpanel.ap.revalidate();
							loginpanel.mainpanel.ap.repaint();
						
					
					
				
					for(int i = 0;i < loginpanel.mainpanel.as.mylabels.size(); i ++){
						loginpanel.mainpanel.as.mylabels.get(i).isclicked=false;
						loginpanel.mainpanel.as.mylabels.get(i).setOpaque(false);
						loginpanel.mainpanel.as.mylabels.get(i).setForeground(Color.black);
						
					}

					isclicked=true;
					setOpaque(true);
					setBackground(Color.GRAY);
					setForeground(Color.white);
					
				
					
					// TODO Auto-generated method stub
					
				}
				
			}
			);
		}


}
