package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * @author noobjava
 * @blog http://noobjava.javaeye.com/
 */
public class VersionUtil {
	private Map<String, String> feaMap = null;
	private Point oldP; // ��һ������,�϶�����ʱ��
	private TipWindow tw = null; // ��ʾ��
	private ImageIcon img = null;// ͼ�����
	private JLabel imgLabel = null; // ����ͼƬ��ǩ
	private JPanel headPan = null;
	private JPanel feaPan = null;
	private JPanel btnPan = null;
	private JLabel title = null;
	private JLabel head = null;
	private JLabel close = null;// �رհ�ť
	private JTextArea feature = null;
	private JScrollPane jfeaPan = null;
	private JLabel releaseLabel = null;
	private JLabel update = null;
	private SimpleDateFormat sdf = null;

	{
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	public VersionUtil(String title, String subTitle, String displayContent)
	{
		init(title, subTitle, displayContent);
		handle();
		tw.setAlwaysOnTop(true);
		tw.setUndecorated(true);
		tw.setResizable(false);
		tw.setVisible(true);
		tw.run();
	}
	
	public void init(String contentTitle, String subTitle, String displayContent) {
		
		feaMap = new HashMap<String, String>();
		feaMap.put("name", subTitle);
		feaMap.put("release", sdf.format(new Date()));
		feaMap.put("feature", displayContent);

		// �½�300x220����Ϣ��ʾ��
		tw = new TipWindow(300, 220);
		img = new ImageIcon("bg_u_all.gif");
		imgLabel = new JLabel(img);
		// ���ø������Ĳ����Լ�����пؼ��ı߽�
		headPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		feaPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		btnPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		title = new JLabel(contentTitle);
		head = new JLabel(feaMap.get("name"));
		close = new JLabel(" x");// �رհ�ť
		feature = new JTextArea(feaMap.get("feature"));
		jfeaPan = new JScrollPane(feature);
		releaseLabel = new JLabel(feaMap.get("release"));
		update = new JLabel();

		// �������������Ϊ͸�������򿴲�������ͼƬ
//		((JPanel) tw.getContentPane()).setOpaque(false);
//		headPan.setOpaque(false);
//		feaPan.setOpaque(false);
//		btnPan.setOpaque(false);

		// ����JDialog����������ͼƬ
		tw.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		headPan.setPreferredSize(new Dimension(300, 60));

		// ������ʾ��ı߿�,��Ⱥ���ɫ
		tw.getRootPane().setBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));

		title.setPreferredSize(new Dimension(260, 26));
		title.setVerticalTextPosition(JLabel.CENTER);
		title.setHorizontalTextPosition(JLabel.CENTER);
		title.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		title.setForeground(Color.black);

		close.setFont(new Font("Arial", Font.BOLD, 15));
		close.setPreferredSize(new Dimension(20, 20));
		close.setVerticalTextPosition(JLabel.CENTER);
		close.setHorizontalTextPosition(JLabel.CENTER);
		close.setCursor(new Cursor(12));
		close.setToolTipText("�ر�");

		head.setPreferredSize(new Dimension(250, 35));
		head.setVerticalTextPosition(JLabel.CENTER);
		head.setHorizontalTextPosition(JLabel.CENTER);
		head.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		head.setForeground(Color.blue);

		feature.setEditable(false);
		feature.setForeground(Color.BLACK);
		feature.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		// �����ı����Զ�����
		feature.setLineWrap(true);
		feature.setBackground(Color.WHITE);

		jfeaPan.setPreferredSize(new Dimension(250, 80));
		jfeaPan.setBorder(null);
		jfeaPan.setBackground(Color.black);

		releaseLabel.setForeground(Color.DARK_GRAY);
		releaseLabel.setFont(new Font("΢���ź�", Font.PLAIN, 12));

		// Ϊ�������ı��򣬰�Ӹ��յ�JLabel������������ȥ
		JLabel jsp = new JLabel();
		jsp.setPreferredSize(new Dimension(300, 25));

		update.setPreferredSize(new Dimension(110, 30));
		// ���ñ�ǩ�������
		update.setCursor(new Cursor(12));

		headPan.add(title);
		headPan.add(close);
		headPan.add(head);

		feaPan.add(jsp);
		feaPan.add(jfeaPan);
		feaPan.add(releaseLabel);

//		btnPan.add(update);

		tw.add(headPan, BorderLayout.NORTH);
		tw.add(feaPan, BorderLayout.CENTER);
		tw.add(btnPan, BorderLayout.SOUTH);

	}
	
	
	public VersionUtil() {
		init();
		handle();
		tw.setAlwaysOnTop(true);
		tw.setUndecorated(true);
		tw.setResizable(false);
		tw.setVisible(true);
		tw.run();
	}

	public void init() {
		
		feaMap = new HashMap<String, String>();
		feaMap.put("name", "This is subtitle");
		feaMap.put("release", sdf.format(new Date()));
		feaMap.put("feature",
				"Some deatil content \nanother line");

		// �½�300x220����Ϣ��ʾ��
		tw = new TipWindow(300, 220);
		img = new ImageIcon("bg_u_all.gif");
		imgLabel = new JLabel(img);
		// ���ø������Ĳ����Լ�����пؼ��ı߽�
		headPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		feaPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		btnPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		title = new JLabel("This is title");
		head = new JLabel(feaMap.get("name"));
		close = new JLabel(" x");// �رհ�ť
		feature = new JTextArea(feaMap.get("feature"));
		jfeaPan = new JScrollPane(feature);
		releaseLabel = new JLabel(feaMap.get("release"));
		update = new JLabel();

		// �������������Ϊ͸�������򿴲�������ͼƬ
//		((JPanel) tw.getContentPane()).setOpaque(false);
//		headPan.setOpaque(false);
//		feaPan.setOpaque(false);
//		btnPan.setOpaque(false);

		// ����JDialog����������ͼƬ
		tw.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		headPan.setPreferredSize(new Dimension(300, 60));

		// ������ʾ��ı߿�,��Ⱥ���ɫ
		tw.getRootPane().setBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));

		title.setPreferredSize(new Dimension(260, 26));
		title.setVerticalTextPosition(JLabel.CENTER);
		title.setHorizontalTextPosition(JLabel.CENTER);
		title.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		title.setForeground(Color.black);

		close.setFont(new Font("Arial", Font.BOLD, 15));
		close.setPreferredSize(new Dimension(20, 20));
		close.setVerticalTextPosition(JLabel.CENTER);
		close.setHorizontalTextPosition(JLabel.CENTER);
		close.setCursor(new Cursor(12));
		close.setToolTipText("�ر�");

		head.setPreferredSize(new Dimension(250, 35));
		head.setVerticalTextPosition(JLabel.CENTER);
		head.setHorizontalTextPosition(JLabel.CENTER);
		head.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		head.setForeground(Color.BLACK);

		feature.setEditable(false);
		feature.setForeground(Color.BLACK);
		feature.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		feature.setBackground(new Color(184, 230, 172));
		// �����ı����Զ�����
		feature.setLineWrap(true);
		feature.setBackground(Color.WHITE);
		
		jfeaPan.setPreferredSize(new Dimension(250, 80));
		jfeaPan.setBorder(null);
		jfeaPan.setBackground(Color.black);

		releaseLabel.setForeground(Color.WHITE);
		releaseLabel.setFont(new Font("����", Font.PLAIN, 12));

		// Ϊ�������ı��򣬰�Ӹ��յ�JLabel������������ȥ
		JLabel jsp = new JLabel();
		jsp.setPreferredSize(new Dimension(300, 25));

		update.setPreferredSize(new Dimension(110, 30));
		// ���ñ�ǩ�������
		update.setCursor(new Cursor(12));

		headPan.add(title);
		headPan.add(close);
		headPan.add(head);

		feaPan.add(jsp);
		feaPan.add(jfeaPan);
		feaPan.add(releaseLabel);

//		btnPan.add(update);

		tw.add(headPan, BorderLayout.NORTH);
		tw.add(feaPan, BorderLayout.CENTER);
		tw.add(btnPan, BorderLayout.SOUTH);

	}
	
	

	public void handle() {
		// Ϊ���°�ť������Ӧ���¼�
		update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(tw, "лл���ټ�");
				tw.close();
			}

			public void mouseEntered(MouseEvent e) {
				update.setBorder(BorderFactory.createLineBorder(Color.gray));
			}

			public void mouseExited(MouseEvent e) {
				update.setBorder(null);
			}
		});
		// ��������϶��¼�
		title.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				Point newP = new Point(e.getXOnScreen(), e.getYOnScreen());
				int x = tw.getX() + (newP.x - oldP.x);
				int y = tw.getY() + (newP.y - oldP.y);
				tw.setLocation(x, y);
				oldP = newP;

			}
		});
		// ��갴��ʱ��ʼ����,���϶�ʱ������
		title.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				oldP = new Point(e.getXOnScreen(), e.getYOnScreen());
			}
		});

		// ���Ͻǹرհ�ť�¼�
		close.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tw.close();
			}

			public void mouseEntered(MouseEvent e) {
				close.setBorder(BorderFactory.createLineBorder(Color.gray));
			}

			public void mouseExited(MouseEvent e) {
				close.setBorder(null);
			}
		});

	}

	public static void main(String args[]) {
		new VersionUtil();
	}

}