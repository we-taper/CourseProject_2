package GUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import sun.security.krb5.internal.Ticket;
import core.sakai.objects.SakaiAssignment.SakaiAssignmentContent;

public class homeworkcontent extends JPanel{
	public homeworkcontent(SakaiAssignmentContent ass) {
		
   
		setLayout(new GridLayout(1,1));
		
		JLabel t1=new JLabel("<html>\n��ҵ����:&nbsp  &nbsp "+ass.getTitle()+"<br>"+"��ֹ����:&nbsp &nbsp    "+ass.getTimeLastModified().getDisplay()+"<br><br>��ҵ����:<br>"
		                  +ass.getInstructions());
		t1.setVerticalAlignment(SwingConstants.TOP);
  
		t1.setFont(new Font("΢���ź�",Font.PLAIN,26));
	
	
		
		
	
		
		add(t1);
	

repaint();
		// TODO Auto-generated constructor stub
	}
	
	

}
