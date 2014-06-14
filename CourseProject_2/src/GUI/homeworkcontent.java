package GUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import sun.security.krb5.internal.Ticket;
import core.sakai.objects.SakaiAssignment.SakaiAssignmentContent;

public class homeworkcontent extends JPanel{
	public homeworkcontent(SakaiAssignmentContent ass) {
		
	setOpaque(false);
		setLayout(new GridLayout(1,1));
		
		JTextArea t1=new JTextArea(ass.getInstructions());

		t1.setFont(new Font("±κΏ¬Με",Font.PLAIN,36));
		t1.setLineWrap(true);
		t1.setWrapStyleWord(true);
		
		
	
		
		add(t1);
	

repaint();
		// TODO Auto-generated constructor stub
	}
	
	

}
