package GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

public class Jresourcepanel extends JPanel {
	public Jresourcepanel(final File file) {
		super();
		
		setLayout(null);
		setOpaque(false);

		int y = 39;
		File[] filelist = file.listFiles();
		final JLabel returnLabel = new JLabel();
		returnLabel.setIcon(new ImageIcon(Jresourcepanel.class
				.getResource("return.png")));
		returnLabel.setBounds(0, 0, 60, 38);
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
				removeAll();
				setLayout(new GridLayout(1, 1));
				add(new Jresourcepanel(file.getParentFile()));
				revalidate();

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

						System.out.println("dddd"+f.getAbsolutePath());
						filelJLabel1.setForeground(Color.gray);
						try {
							Runtime.getRuntime().exec(f.getAbsolutePath());
							System.out.println("dddd"+f.getAbsolutePath());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					@Override
					public void mouseClicked(MouseEvent arg0) {
						// TODO Auto-generated method stub
						try {
							Runtime.getRuntime().exec(f.getAbsolutePath());
							System.out.println(f.getAbsolutePath());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				add(filelJLabel1);
			} else {
				final JLabel filelJLabel2 = new JLabel(f.getName());
				filelJLabel2.setBounds(5, y, 317, 37);
				filelJLabel2.setFont(new Font(this.getFont().getFontName(),
						this.getFont().getStyle(), 28));
				filelJLabel2.setIcon(new ImageIcon(Jresourcepanel.class
						.getResource("file.png")));

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
						// TODO Auto-generated method stub
						filelJLabel2.setForeground(Color.red);
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub

						System.out.println("dddd"+f.getAbsolutePath());
						filelJLabel2.setForeground(Color.red);
					}

					@Override
					public void mouseClicked(MouseEvent arg0) {
						removeAll();
						setLayout(new GridLayout(1, 1));
						add(new Jresourcepanel(f));
						revalidate();
						// TODO Auto-generated method stub

					}
				});
				add(filelJLabel2);

			}
			y = y + 37;
		}

		// TODO Auto-generated constructor stub
	}
}
