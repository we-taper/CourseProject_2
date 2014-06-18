package GUI;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.URL;

import javax.swing.*;

public class mainpanel extends JFrame {

	JLabel jl=new JLabel();
	JLabel jl1=new JLabel();
	JLabel jl2=new JLabel();
	JLabel jl3=new JLabel();
	JLabel jl4=new JLabel();
	JLabel jb1=new JLabel();
	JLabel jb2=new JLabel();
	public static JhomeworkPanel re=new JhomeworkPanel();
	
	public Jresourcepanel jr=new Jresourcepanel(new File("f:\\"));
	Point loc = null;    Point tmp = null;    boolean isDragged = false; 
	public mainpanel(){
		super();
		Container co=getContentPane();
		setLayout(null);
		setUndecorated(true);
		jl.setIcon(new ImageIcon(mainpanel.class.getResource("background.png")));
		jl1.setIcon(new ImageIcon(mainpanel.class.getResource("通知1.png")));
		jl2.setIcon(new ImageIcon(mainpanel.class.getResource("作业1.png")));
		jl3.setIcon(new ImageIcon(mainpanel.class.getResource("资源1.png")));
		jl4.setIcon(new ImageIcon(mainpanel.class.getResource("日程1.png")));
		jb1.setIcon(new ImageIcon(mainpanel.class.getResource("subtract1.png")));
		jb2.setIcon(new ImageIcon(mainpanel.class.getResource("cross1.png")));
		re.setVisible(false);
		re.setOpaque(false);
	    re.setBounds(252, 100, 1055, 770);
	  add(re);
	  jr.setVisible(false);
	
	    jr.setBounds(252, 100, 1055, 770);
	  add(jr);
		jb1.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				setExtendedState(JFrame.ICONIFIED);
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
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				jl1.setIcon(new ImageIcon(mainpanel.class.getResource("通知1.png")));
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				
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
				jr.setVisible(false);
			
			re.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				jl2.setIcon(new ImageIcon(mainpanel.class.getResource("作业2.png")));
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				jl2.setIcon(new ImageIcon(mainpanel.class.getResource("作业1.png")));
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				
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
				re.setVisible(false);
				jr.setVisible(true);
				repaint();
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				jl3.setIcon(new ImageIcon(mainpanel.class.getResource("资源2.png")));
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				jl3.setIcon(new ImageIcon(mainpanel.class.getResource("资源1.png")));
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				
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
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				jl4.setIcon(new ImageIcon(mainpanel.class.getResource("日程1.png")));
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				
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
						loc = new Point(getLocation().x + e.getX() - tmp.x,	getLocation().y + e.getY() - tmp.y);  
						setLocation(loc);        }}});
		jl.setBounds(0, 0, 1442, 902);
		jl1.setBounds(38,105,128,128);
		jl2.setBounds(38,305,128,128);
		jl3.setBounds(38,505,128,128);
		jl4.setBounds(38,705,128,128);
		jb1.setBounds(1230,0,50,50);
		jb2.setBounds(1290,0,54,52);
		
		setVisible(true);
		
		setBounds(160,60,1352,902);
	
		
		add(jl1);
		add(jl2);
		add(jl3);
		add(jl4);
		
		
		
		add(jb1);
		add(jb2);
		add(jl);
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   new mainpanel();
	}

}
