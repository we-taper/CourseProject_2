package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import core.sakai.objects.SakaiSite;


public class resourcelabel extends JLabel{
	public SakaiSite site;
	boolean isclicked=false;
	public resourcelabel(String name, SakaiSite si) {
		
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
				try {
					control.Resources.createResources(site);
					System.out.println(site.getTitle());
				
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				loginpanel.mainpanel.jr.removeAll();
				loginpanel.mainpanel.jr.add(new JScrollPane(new Jresourcepanel(new File("Resources\\group\\"+site.getId()))));
				loginpanel.mainpanel.jr.revalidate();
				loginpanel.mainpanel.jr.repaint();
				for(int i = 0;i < loginpanel.mainpanel.rs.mylabels.size(); i ++){
					loginpanel.mainpanel.rs.mylabels.get(i).isclicked=false;
					loginpanel.mainpanel.rs.mylabels.get(i).setOpaque(false);
					loginpanel.mainpanel.rs.mylabels.get(i).setForeground(Color.black);
					
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
