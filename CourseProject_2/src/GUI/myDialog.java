package GUI;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class myDialog {
	public JFrame jf=new JFrame();
	
	JLabel back=new JLabel();
	JLabel jb1=new JLabel();
	JLabel jb2=new JLabel();
	Point loc = null;    Point tmp = null;    boolean isDragged = false; 
	myDialog(String a){
		jf.setLayout(null);
		jf.setUndecorated(true);
		back.setIcon(new ImageIcon(myDialog.class.getResource("ÌבÊ¾.png")));
		JLabel jl=new JLabel(a);
		jl.setFont(new Font(jl.getFont().getFontName(),jl.getFont().getStyle(),30));
		back.setBounds(0, 0, 402, 252);
		back.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) { isDragged = false;        
		}   
		public void mousePressed(java.awt.event.MouseEvent e) {  
			tmp = new Point(e.getX(), e.getY());  
			isDragged = true;  
		 }  });  
			back.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {  
				public void mouseDragged(java.awt.event.MouseEvent e) {             
					if(isDragged) {                
						loc = new Point(jf.getLocation().x + e.getX() - tmp.x,	jf.getLocation().y + e.getY() - tmp.y);  
						jf.setLocation(loc);        }}});
			jb1.setIcon(new ImageIcon(myDialog.class.getResource("a1.png")));
			jb2.setIcon(new ImageIcon(myDialog.class.getResource("a4.png")));
			jb1.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					jb1.setIcon(new ImageIcon(myDialog.class.getResource("a1.png")));
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					jb1.setIcon(new ImageIcon(myDialog.class.getResource("a2.png")));
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					jb1.setIcon(new ImageIcon(myDialog.class.getResource("a1.png")));
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					jb1.setIcon(new ImageIcon(myDialog.class.getResource("a3.png")));
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					jf.setVisible(false);
				}
			});
           jb2.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					jb2.setIcon(new ImageIcon(myDialog.class.getResource("a4.png")));
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					jb2.setIcon(new ImageIcon(myDialog.class.getResource("a5.png")));
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					jb2.setIcon(new ImageIcon(myDialog.class.getResource("a4.png")));
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					jb2.setIcon(new ImageIcon(myDialog.class.getResource("a6.png")));
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					jf.setExtendedState(JFrame.ICONIFIED);
				}
			});
		jl.setBounds(114, 104,260,61);
		jb1.setBounds(350, 0, 46, 44);
		jb2.setBounds(302, 0, 43, 43);
		jf.setBounds(673, 358, 402, 252);
	jf.add(jl);
	jf.add(jb1);
	jf.add(jb2);
		jf.add(back);
		jf.setVisible(true);
	
	}
	

}
