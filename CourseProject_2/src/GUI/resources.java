package GUI;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.*;

public class resources extends JPanel{
	Image image;
	
	
	public resources(){
		

		
		image=Toolkit.getDefaultToolkit().getImage(resources.class.getResource("bg1.png"));
		
		}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	
	   
	   g.drawImage(image,0,0,null);
	repaint();
	}


}
