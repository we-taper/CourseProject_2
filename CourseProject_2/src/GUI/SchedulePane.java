package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jdesktop.swingx.JXMonthView;
import org.jdesktop.swingx.calendar.DateSelectionModel.SelectionMode;

import control.Sites;
import core.sakai.objects.SakaiAnnouncement;
import core.sakai.objects.SakaiSite;

public class SchedulePane extends JPanel {

	static final boolean DEBUG = true;
	Map<Date, String> schedules = new HashMap<Date, String>();
	JXMonthView monthView = new JXMonthView();
	JEditorPane information = new JEditorPane();
	JScrollPane inforPane;
	String initialText = "Nothing to Display";
	Collection<SakaiAnnouncement> announcements;
	int CALENDAR_WIDTH = 585, CALENDAR_HIGHT = 373,
			PANEL_WIDTH = 585, PANEL_HIGHT = 526;
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy:MM:dd");
	
	class ShowSize implements ComponentListener {
	    public void componentResized(ComponentEvent e){
	    	String size = e.getComponent().getSize().toString();
	    	String name = e.getComponent().getClass().toString();
	    	System.out.println("Name:"+name+" Size:"+size+"\n");
	    };
	    public void componentMoved(ComponentEvent e){
	    };

	    public void componentShown(ComponentEvent e){};
	    public void componentHidden(ComponentEvent e){};
	}
	
	
	public SchedulePane() {
		initMap();
		setLayout(new BorderLayout());

		monthView.setPreferredColumnCount(1);
		monthView.setPreferredRowCount(1);
		monthView.setOpaque(false);
		monthView
				.setPreferredSize(new Dimension(CALENDAR_WIDTH, CALENDAR_HIGHT));
		if(DEBUG){
			monthView.addComponentListener(new ShowSize());
		}
		monthView.setSelectionMode(SelectionMode.SINGLE_SELECTION);
		monthView.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				updateInfo(monthView.getSelectionDate());
			}
		});

		information.setEditable(false);
		information.setContentType("text/html");
		inforPane = new JScrollPane(information);
		inforPane.setPreferredSize(new Dimension(CALENDAR_WIDTH, PANEL_HIGHT - CALENDAR_HIGHT));

		updateMap();
		
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HIGHT ));
		if(DEBUG){
			addComponentListener(new ShowSize());
		}
		add(monthView, BorderLayout.CENTER);
		add(inforPane, BorderLayout.SOUTH);
	}


	private void initMap() {
		HashMap<String, SakaiSite> sites= Sites.getAllSites();
		for(SakaiSite s:sites.values() ){
			announcements.addAll(s.getAllAnnouncements().values()); 
		}
	}
	private void updateMap()  {
		for(SakaiAnnouncement s: announcements) {
			schedules.put(s.getCreatedOn(), s.getBody());
		}
	}

	private void updateInfo(Date date) {
		for(Date days: schedules.keySet()) {
			if(isSameDay(days, date)){
				information.setText(schedules.get(days).toString());
			}else{
				information.setText(initialText);
			}
		}
	}

	private boolean isSameDay(Date one, Date another) {
		String thisTime = format.format(one);
		String anotherTime = format.format(another);
		return thisTime.equals(anotherTime);
	}
	
//	private String readFIleasStr(File f) throws IOException {
//		StringBuffer sb = new StringBuffer();
//		Object[] os = Files.readAllLines(f.toPath(), Charset.forName("UTF-8"))
//				.toArray();
//		for (Object o : os) {
//			sb.append(o.toString());
//		}
//		return sb.toString();
//	}
	@Deprecated
	public static void main(String[] args) {

		JFrame jf = new JFrame();
		jf.setLayout(new BorderLayout());
		jf.getContentPane().add(new SchedulePane(), BorderLayout.CENTER);
		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}