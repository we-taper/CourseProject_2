package GUI;




import java.awt.Container;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.*;

public class mainpanel  {
	JFrame jf=new JFrame();
	JLabel jl=new JLabel();
	JLabel jl1=new JLabel();
	JLabel jl2=new JLabel();
	JLabel jl3=new JLabel();
	JLabel jl4=new JLabel();
	JLabel jb1=new JLabel();
	JLabel jb2=new JLabel();
	
	Point loc = null;    Point tmp = null;    boolean isDragged = false; 
	public mainpanel(String sessionID){
		Container co=jf.getContentPane();
		jf.setLayout(null);
		jf.setUndecorated(true);
		jl.setIcon(new ImageIcon(mainpanel.class.getResource("background.png")));
		jl1.setIcon(new ImageIcon(mainpanel.class.getResource("通知1.png")));
		jl2.setIcon(new ImageIcon(mainpanel.class.getResource("作业1.png")));
		jl3.setIcon(new ImageIcon(mainpanel.class.getResource("资源1.png")));
		jl4.setIcon(new ImageIcon(mainpanel.class.getResource("日程1.png")));
		jb1.setIcon(new ImageIcon(mainpanel.class.getResource("subtract1.png")));
		jb2.setIcon(new ImageIcon(mainpanel.class.getResource("cross1.png")));
		jb1.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				jf.setExtendedState(JFrame.ICONIFIED);
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				jb1.setIcon(new ImageIcon(mainpanel.class.getResource("subtract3.png")));
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				jb1.setIcon(new ImageIcon(mainpanel.class.getResource("subtract1.png")));
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				jb1.setIcon(new ImageIcon(mainpanel.class.getResource("subtract2.png")));
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				jb1.setIcon(new ImageIcon(mainpanel.class.getResource("subtract3.png")));
				// TODO Auto-generated method stub
				
			}});
		jb2.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jb2.setIcon(new ImageIcon(mainpanel.class.getResource("cross3.png")));
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jb2.setIcon(new ImageIcon(mainpanel.class.getResource("cross1.png")));
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				jb2.setIcon(new ImageIcon(mainpanel.class.getResource("cross2.png")));
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				jb2.setIcon(new ImageIcon(mainpanel.class.getResource("cross3.png")));
				// TODO Auto-generated method stub
				
			}});
		jl1.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				jl1.setIcon(new ImageIcon(mainpanel.class.getResource("通知2.png")));
			jf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				jl1.setIcon(new ImageIcon(mainpanel.class.getResource("通知1.png")));
				jf.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		jl2.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				jl2.setIcon(new ImageIcon(mainpanel.class.getResource("作业2.png")));
				jf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				jl2.setIcon(new ImageIcon(mainpanel.class.getResource("作业1.png")));
				jf.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		jl3.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				jl3.setIcon(new ImageIcon(mainpanel.class.getResource("资源2.png")));
				jf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				jl3.setIcon(new ImageIcon(mainpanel.class.getResource("资源1.png")));
				jf.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		jl4.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				jl4.setIcon(new ImageIcon(mainpanel.class.getResource("日程2.png")));
				jf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				jl4.setIcon(new ImageIcon(mainpanel.class.getResource("日程1.png")));
				jf.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
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
		jl.setBounds(0, 0, 1442, 902);
		jl1.setBounds(38,105,128,128);
		jl2.setBounds(38,305,128,128);
		jl3.setBounds(38,505,128,128);
		jl4.setBounds(38,705,128,128);
		jb1.setBounds(1230,0,50,50);
		jb2.setBounds(1290,0,54,52);
		
		jf.setVisible(true);
		
		jf.setBounds(160,60,1352,902);
		resources re=new resources();
		re.setOpaque(true);
	re.setBounds(252, 100, 1055, 770);
		jf.add(jl1);
		jf.add(jl2);
		jf.add(jl3);
		jf.add(jl4);
		
		
		jf.add(re);
		jf.add(jb1);
		jf.add(jb2);
		jf.add(jl);
		
		
	}

}
