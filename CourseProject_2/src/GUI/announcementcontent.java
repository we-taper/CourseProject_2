package GUI;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import core.sakai.objects.SakaiAnnouncement;

public class announcementcontent extends JPanel{
	public announcementcontent(SakaiAnnouncement ass) {
	
	String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	
	try {
		UIManager.setLookAndFeel(lookAndFeel);
	} catch (ClassNotFoundException | InstantiationException
			| IllegalAccessException | UnsupportedLookAndFeelException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	setLayout(new GridLayout(1,1));
	JLabel t1=new JLabel("<html>\n����:&nbsp  &nbsp "+ass.getTitle()+"<br>"+"����ʱ��:&nbsp &nbsp    "+ass.getCreatedOn().toString()+"<br>����:&nbsp &nbsp"+
	               ass.getCreatedByDisplayName()+"<br><br>����:<br>"
	                  +ass.getBody());
	
	t1.setVerticalAlignment(SwingConstants.TOP);
	

	t1.setFont(new Font("΢���ź�",Font.PLAIN,26));

 
	
	

	
	add(t1);


repaint();
	
}}

