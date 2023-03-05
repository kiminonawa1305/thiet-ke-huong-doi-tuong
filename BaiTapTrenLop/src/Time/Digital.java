package Time;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Digital extends JPanel implements Observer {
	private int hour, second, minute;
	private JLabel label;

	public Digital(Observable observable){
		observable.addObserver(this);
		this.init();
	}

	public void init(){
		label = new JLabel(toString());
		label.setFont(new Font(Font.DIALOG, Font.BOLD, 100));
		this.add(label);
	}
	
	@Override
	public String toString() {
		return hour + ":" + minute + ":" + second;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Time) {
			Time time = (Time) o;
			this.second = time.getSecond();
			this.minute = time.getMinute();
			this.hour = time.getHour();
			this.label.setText(toString());
		}
	}
	
	

	public static void main(String[] args) throws InterruptedException {
		Time time = new Time(new Date());
		Digital watch = new Digital(time);
	}
}
