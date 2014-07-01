package core.sakai.objects;

import java.io.Serializable;

public class SakaiTime implements Serializable{
	private long time;
	private String display;
	
	public long getTime() {
		return time;
	}
	public void setTime(long t) {
		time = t;
	}
	
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String s){
		display = s;
	}
}
