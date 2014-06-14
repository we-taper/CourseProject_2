package GUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import sun.security.krb5.internal.Ticket;
import core.sakai.objects.SakaiAssignment.SakaiAssignmentContent;

public class homeworkcontent extends JPanel{
	public homeworkcontent(SakaiAssignmentContent ass) {
		
	   setOpaque(true);
		setLayout(new GridLayout(1,1));
		
		JLabel t1=new JLabel("<html>\n作业标题:    "+ass.getTitle()+"<br>"+"截止日期:    "+ass.getTimeLastModified().getDisplay()+"<br>作业内容:<br>"
		                  +ass.getInstructions());
       t1.setOpaque(true);
		t1.setFont(new Font("微软雅黑",Font.PLAIN,26));
	
		t1.setOpaque(true);
		
		
	
		
		add(t1);
	

repaint();
		// TODO Auto-generated constructor stub
	}
	
	

}
