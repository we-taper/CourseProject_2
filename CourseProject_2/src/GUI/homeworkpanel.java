package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.HashMap;

import javax.jws.soap.SOAPBinding.Style;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import sun.font.FontScaler;
import core.sakai.objects.SakaiSite;
import core.sakai.objects.SakaiAssignment.SakaiAssignmentContent;

public class homeworkpanel extends JPanel{
    
	
	homeworkpanel(SakaiSite si){
		super();
		setLayout(null);
		setOpaque(false);	
		setBounds(0, 40, 1055, 733);
		HashMap<String, SakaiAssignmentContent> assignments = 
				si.getAllAssignments();
		JLabel bg=new JLabel();
		bg.setIcon(new ImageIcon(homeworkpanel.class.getResource("bg.png")));
		bg.setBounds(0, 0, 1055,37);
		
		int y=37;
		for(String str :assignments.keySet()){
			final SakaiAssignmentContent ass=assignments.get(str);
			final JLabel title=new JLabel("<HTML><U>"+ass.getTitle()+"</U></HTML>");
			JLabel iscomepleted=new JLabel();
			JLabel timecreated=new JLabel(ass.getTimeCreated().getDisplay());
			JLabel timelast=new JLabel(ass.getTimeLastModified().getDisplay());
			title.addMouseListener(new MouseListener() {
				
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
					title.setForeground(Color.black);
					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					title.setForeground(Color.red);
					setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					loginpanel.mainpanel.re.removeall();
				homeworkcontent js=	new homeworkcontent(ass);
				js.setBounds(0, 40, 1077,733);
					loginpanel.mainpanel.re.add(js);
					loginpanel.mainpanel.repaint();
					// TODO Auto-generated method stub
					
				}
			});
		title.setBounds(5,y,317,37);
		title.setFont(new Font(this.getFont().getFontName(),this.getFont().getStyle(),28));
		iscomepleted.setBounds(332, y, 181, 37);
		iscomepleted.setFont(new Font(this.getFont().getFontName(),this.getFont().getStyle(),28));
		timecreated.setBounds( 513, y,276,37);
		timecreated.setFont(new Font(this.getFont().getFontName(),this.getFont().getStyle(),28));
		timelast.setBounds(791, y, 1055-791, 37);
		timelast.setFont(new Font(this.getFont().getFontName(),this.getFont().getStyle(),28));
		add(title);
		add(iscomepleted); 
		add(timecreated);
		add(timelast);
		y=y+37;
		
			
		
			
			
		}
		add(bg);
	}

	
}
