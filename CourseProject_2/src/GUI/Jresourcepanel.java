package GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import core.sakai.objects.SakaiSite;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

public class Jresourcepanel extends JPanel {
	public Jresourcepanel(final File file) {
		super();
		
	String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	


		

		setOpaque(false);

		int y = 39;
		int n=1;
		
			File[] filelist= file.listFiles();
		
		final JLabel returnLabel = new JLabel("           "+file.getPath());
		returnLabel.setIcon(new ImageIcon(Jresourcepanel.class
				.getResource("return.png")));
		returnLabel.setBounds(0, 0, 1000, 38);
		returnLabel.setFont(new Font(this.getFont().getFontName(), this
				.getFont().getStyle(), 28));
		returnLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				returnLabel.setIcon(new ImageIcon(Jresourcepanel.class
						.getResource("return.png")));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				returnLabel.setIcon(new ImageIcon(Jresourcepanel.class
						.getResource("return2.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				boolean a=false;
			try{System.out.println("aaa");
				file.getParent();
			a=true;
			
			}
			catch(Exception c){
				a=false;
				System.out.println("aaa");
				
			}if(file.getName().equals("group"))
			{}else{
				
				removeAll();
				setLayout(new GridLayout(1, 1));
				add(new Jresourcepanel(file.getParentFile()));
				revalidate();}
			
			

			}
		});
		add(returnLabel);
		for (final File f : filelist) {
			if (f.isFile()) {
				final JLabel filelJLabel1 = new JLabel(f.getName());

				filelJLabel1.setBounds(5, y, 1000, 37);
				filelJLabel1.setFont(new Font(this.getFont().getFontName(),
						this.getFont().getStyle(), 28));
				filelJLabel1.setIcon(new ImageIcon(Jresourcepanel.class
						.getResource("file2.png")));
				filelJLabel1.setForeground(Color.black);
				filelJLabel1.addMouseListener(new MouseListener() {

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
						// TODO Auto-generated method stub
						filelJLabel1.setForeground(Color.black);
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						filelJLabel1.setForeground(Color.gray);
					}

					@Override
					public void mouseClicked(MouseEvent arg0) {
						// TODO Auto-generated method stub
						try {
							Runtime.getRuntime().exec("cmd /c "+f.getAbsolutePath());
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				add(filelJLabel1);
				n=n+1;
			} else {
				final JLabel filelJLabel2 = new JLabel(f.getName());
				filelJLabel2.setBounds(5, y, 317, 37);
				filelJLabel2.setFont(new Font(this.getFont().getFontName(),
						this.getFont().getStyle(), 28));
				filelJLabel2.setIcon(new ImageIcon(Jresourcepanel.class
						.getResource("file.png")));
				filelJLabel2.setForeground(Color.black);
				filelJLabel2.addMouseListener(new MouseListener() {

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
						filelJLabel2.setForeground(Color.black);
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {

						filelJLabel2.setForeground(Color.gray);
					}

					@Override
					public void mouseClicked(MouseEvent arg0) {
						removeAll();
						setLayout(new GridLayout(1,1));
						add(new Jresourcepanel(f));
						revalidate();
						// TODO Auto-generated method stub

					}
				});
				add(filelJLabel2);
n=n+1;
			}
			y = y + 37;
		}
		if(n>19){
setLayout(new GridLayout(n,1));}
		else{
			setLayout(null);
		}
		// TODO Auto-generated constructor stub
	}
}
