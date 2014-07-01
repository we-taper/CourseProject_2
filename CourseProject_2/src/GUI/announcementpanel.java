package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import control.Sites;
import core.sakai.objects.SakaiAnnouncement;
import core.sakai.objects.SakaiSite;
import core.sakai.objects.SakaiSubmission;


public class announcementpanel extends JPanel{
	public announcementpanel(SakaiSite site)  {
		super();
		setLayout(null);
		setOpaque(false);	
		setBounds(0, 0, 1055, 733);
		JLabel bg=new JLabel();
		bg.setIcon(new ImageIcon(homeworkpanel.class.getResource("bg2.png")));
		bg.setBounds(0, 0, 1055,37);
	String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int y=37;
		
		HashMap<String,SakaiAnnouncement> Announcements=site.getAllAnnouncements();
		for(String str:Announcements.keySet()){
			final SakaiAnnouncement announcement=Announcements.get(str);
			
		
		
		
		final JLabel title=new JLabel("<HTML><U>"+announcement.getTitle()+"</U></HTML>");
		JLabel author=new JLabel(announcement.getCreatedByDisplayName());
		JLabel timecreated=new JLabel(announcement.getCreatedOn().toString());
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
				loginpanel.mainpanel.ap.removeAll();
				loginpanel.mainpanel.ap.setLayout(null);
		   announcementcontent js=	new announcementcontent(announcement);
			JScrollPane jScrollPane=new JScrollPane(js);
			jScrollPane.setBounds(0, 0, 1055,730);
			
				loginpanel.mainpanel.ap.add(jScrollPane);
				loginpanel.mainpanel.ap.repaint();
				loginpanel.mainpanel.ap.revalidate();
				
			}
			});
		title.setBounds(5,y,438,37);
		title.setFont(new Font(this.getFont().getFontName(),this.getFont().getStyle(),28));
		author.setBounds(444, y, 302, 37);
		author.setFont(new Font(this.getFont().getFontName(),this.getFont().getStyle(),28));
		timecreated.setBounds(747, y,309,37);
		timecreated.setFont(new Font(this.getFont().getFontName(),this.getFont().getStyle(),28));
		add(title);
		add(author);
		add(timecreated);
		y=y+37;}
		 add(bg);
	}

}
