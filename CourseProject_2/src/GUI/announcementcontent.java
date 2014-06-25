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
	JLabel t1=new JLabel("<html>\n标题:&nbsp  &nbsp "+ass.getTitle()+"<br>"+"发布时间:&nbsp &nbsp    "+ass.getCreatedOn().toString()+"<br>作者:&nbsp &nbsp"+
	               ass.getCreatedByDisplayName()+"<br><br>内容:<br>"
	                  +ass.getBody());
	
	t1.setVerticalAlignment(SwingConstants.TOP);
	

	t1.setFont(new Font("微软雅黑",Font.PLAIN,26));

 
	
	

	
	add(t1);


repaint();
	
}}

