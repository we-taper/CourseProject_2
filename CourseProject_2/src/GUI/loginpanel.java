package GUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.HashMap;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.axis2.AxisFault;
import org.xml.sax.SAXException;

import control.Sites;
import core.sakai.objects.SakaiSite;
public class loginpanel {
	public JFrame jf=new JFrame();
	public JLabel jl=new JLabel();
	public JLabel jl1=new JLabel();
	public JLabel jl2=new JLabel();
	public static mainpanel mainpanel;
	Point loc = null;    Point tmp = null;    boolean isDragged = false; 
	public static JTextField jt1=new JTextField(10);
	public static JPasswordField jt2=new JPasswordField(10);
	URL url1=loginpanel.class.getResource("登录1.png");
	Icon icon1=new ImageIcon(url1);
	URL url2=loginpanel.class.getResource("登录2.png");
	Icon icon2=new ImageIcon(url2);
	URL url3=loginpanel.class.getResource("登录3.png");
	Icon icon3=new ImageIcon(url3);
	URL url4=loginpanel.class.getResource("退出1.png");
	Icon icon4=new ImageIcon(url4);
	URL url5=loginpanel.class.getResource("退出2.png");
	Icon icon5=new ImageIcon(url5);
	URL url6=loginpanel.class.getResource("退出3.png");
	Icon icon6=new ImageIcon(url6);
	public loginpanel(){
		jf.setLayout(null);
		jf.setUndecorated(true);
		URL urldenlu=loginpanel.class.getResource("登录界面.jpg");
		Icon icon=new ImageIcon(urldenlu);
		jl.setIcon(icon);
		
		jl.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) { isDragged = false;        
		}   
		public void mousePressed(java.awt.event.MouseEvent e) {  
			tmp = new Point(e.getX(), e.getY());  
			isDragged = true;  
		 }  });  
			jl.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {  
				public void mouseDragged(java.awt.event.MouseEvent e) {             
					if(isDragged) {                
						loc = new Point(jf.getLocation().x + e.getX() - tmp.x,	jf.getLocation().y + e.getY() - tmp.y);  
						jf.setLocation(loc);        }}});
			jl1.setIcon(icon1);
			jl1.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
					String password=new String(jt2.getPassword());
					try{control.LoginControl.login(jt1.getText(),password);
						
						jf.setVisible(false);
						 mainpanel=new mainpanel();
						 HashMap<String, SakaiSite> sites = Sites.getAllSites();
						 for(String str :sites.keySet()){
								if(str.equals("Citations Admin")||str.equals("Administration Workspace")||str.equals("Portfolio Admin")){
									
								}else {
									
								
								SakaiSite site=sites.get(str);
							control.Resources.createResources(site);
								
								}
								
							}
					}
				
					catch(Exception e){
						new myDialog("用户名或密码不正确");
						
					}
					// TODO Auto-generated method stub
 
				
				}
				public void mouseEntered(MouseEvent arg0) {
					jl1.setIcon(icon2);
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					jl1.setIcon(icon1);
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					jl1.setIcon(icon3);
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					jl1.setIcon(icon2);
					// TODO Auto-generated method stub
					
				}});
			jl2.setIcon(icon4);
			jl2.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					System.exit(0);
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					jl2.setIcon(icon5);
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					jl2.setIcon(icon4);
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					jl2.setIcon(icon6);
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					jl2.setIcon(icon5);
					
				}});
			
			jt1.setFont(new Font(jt1.getFont().getFontName(),jt1.getFont().getStyle(), 26));
			jt2.setFont(new Font(jt2.getFont().getFontName(),jt2.getFont().getStyle(), 26));
			jt1.setBounds(126, 559, 200, 30);
			jt2.setBounds(419, 559, 200, 30);
			jl1.setBounds(650, 559, 91, 30);
			jl2.setBounds(765, 559, 91, 30);
			jf.setBounds(300,100,915,602);
			jl.setBounds(0, 0, 915, 602);
			
			jf.setVisible(true);
			jf.add(jt1);
			jf.add(jt2);
			jf.add(jl1);
			jf.add(jl2);
			jf.add(jl);
			
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   new loginpanel();
	}

}
