package GUI;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.ScrollPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.URL;

import javax.swing.*;

import org.kohsuke.rngom.digested.DMixedPattern;

public class mainpanel extends JFrame {

	JLabel jl=new JLabel();
	JLabel jl1=new JLabel();
	JLabel jl2=new JLabel();
	JLabel jl3=new JLabel();
	JLabel jl4=new JLabel();
	JLabel jb1=new JLabel();
	JLabel jb2=new JLabel();
	public static JhomeworkPanel re=new JhomeworkPanel();
	 


	public static JPanel jp=new JPanel();
   public static resourcesite rs=new resourcesite();
   public JPanel jr=new JPanel();
   public announcementsite as=new announcementsite();
   public JPanel ap=new JPanel();
//public SchedulePane acPane;
	Point loc = null;    Point tmp = null;    boolean isDragged = false; 
	public mainpanel(){
		
		super();
		Container co=getContentPane();
		setLayout(null);
		setUndecorated(true);
	String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jl.setIcon(new ImageIcon(mainpanel.class.getResource("background.png")));
		jl1.setIcon(new ImageIcon(mainpanel.class.getResource("通知1.png")));
		jl2.setIcon(new ImageIcon(mainpanel.class.getResource("作业1.png")));
		jl3.setIcon(new ImageIcon(mainpanel.class.getResource("资源1.png")));
		jl4.setIcon(new ImageIcon(mainpanel.class.getResource("日程1.png")));
		jb1.setIcon(new ImageIcon(mainpanel.class.getResource("subtract1.png")));
		jb2.setIcon(new ImageIcon(mainpanel.class.getResource("cross1.png")));
		re.setVisible(false);
		re.setOpaque(false);
	    re.setBounds(247, 100, 1055, 36);
	  add(re);
	  jp.setVisible(false);
	 jp.setOpaque(false);
	 jp.setBounds(252, 137, 1055, 760);
	 jp.setLayout(null);
	 add(jp);
	  jr.setVisible(false);
	jr.setLayout(new GridLayout(1,1));
	  jr.setBounds(252, 137, 1055, 730);
	  
	add(jr);
	rs.setVisible(false);
	rs.setOpaque(false);
	rs.setBounds(247, 100, 1055, 36);
	add(rs);
	as.setVisible(true);
	as.setOpaque(false);
	as.setBounds(247, 100, 1055, 36);
	add(as);
	ap.setVisible(true);
	ap.setOpaque(false);
	ap.setLayout(null);
	ap.setBounds(252, 137, 1055, 730);
	add(ap);
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
//				acPane = new SchedulePane();
//				acPane.setVisible(false);
//				acPane.setBounds(252, 137, 1055, 730);
//				add(acPane);
//				acPane.setVisible(false);
				as.setVisible(true);
				ap.setVisible(true);
				jr.setVisible(false);
				rs.setVisible(false);
			re.setVisible(false);
	   	jp.setVisible(false);
	   	repaint();
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
				as.setVisible(false);
				ap.setVisible(false);
				jr.setVisible(false);
				rs.setVisible(false);
			re.setVisible(true);
//			acPane.setVisible(false);
	   	jp.setVisible(true);
			repaint();
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
				as.setVisible(false);
				ap.setVisible(false);
				// TODO Auto-generated method stub
				rs.setVisible(true);
				re.setVisible(false);
				jp.setVisible(false);
//				acPane.setVisible(false);
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
//				acPane.setVisible(true);
				ap.setVisible(false);
				// TODO Auto-generated method stub
				rs.setVisible(false);
				re.setVisible(false);
				jp.setVisible(false);
//				acPane.setVisible(false);
				jr.setVisible(false);
				repaint();
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
