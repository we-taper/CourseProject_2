package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import sun.security.krb5.internal.Ticket;
import core.sakai.objects.SakaiAssignment.SakaiAssignmentContent;

public class homeworkcontent extends JPanel{
	public homeworkcontent(SakaiAssignmentContent ass) {
		
	String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setLayout(new GridLayout(1,1));
		JLabel t1=new JLabel("<html>\n作业标题:&nbsp  &nbsp "+ass.getTitle()+"<br>"+"截止日期:&nbsp &nbsp    "+ass.getTimeLastModified().getDisplay()+"<br><br>作业内容:<br>"
		                  +ass.getInstructions());
		
		t1.setVerticalAlignment(SwingConstants.TOP);
		
  
		t1.setFont(new Font("微软雅黑",Font.PLAIN,26));
	
	 
		
		
	
		
		add(t1);
	

repaint();
		// TODO Auto-generated constructor stub
	}
	
	

}
