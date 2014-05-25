package taper.util;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * @deprecated test only
 */
@SuppressWarnings("serial")
public class DownloadTaskTest extends JFrame implements PropertyChangeListener{

	public static void main(String[] args) {
		new DownloadTaskTest();
	}
	
	JButton button = new JButton();
	public DownloadTaskTest() {
		String downloadURL, saveDirectory;
		downloadURL = "http://www.math.ucla.edu/~pskoufra/M115A-Notation.pdf";
		saveDirectory = "D:\\";
		final DownloadTask downloadTask = new DownloadTask(downloadURL, saveDirectory);
		downloadTask.addPropertyChangeListener(this);
		
		button.setText("click me");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				downloadTask.execute();
			}
		});
		add(button);
		
		
		
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("progress")){
			System.out.println("Progress:"+evt.getNewValue());
		}
	}


}
