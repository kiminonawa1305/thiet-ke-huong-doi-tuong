package Time;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Analog extends JPanel implements Observer {
	BufferedImage image;
	private int hour, second, minute;

	public Analog(Observable observable) {
		this.setPreferredSize(new Dimension(400, 400));
		observable.addObserver(this);
	}

	public int[] timToaDoGiay() {
		int re[] = new int[2];

		// Tọa độ tâm
		int cx = 200;
		int cy = 200;

		// Tọa độ điểm trên đường tròn
		int x1 = 200;
		int y1 = 20;
//		System.out.println(cx + ", " + cy + "; " + x1 + ", " + y1);

		// Chuyển đổi đơn vị độ sang radian
		double angleInRadians = Math.toRadians(this.second*6 - 90);

		// Tính khoảng cách từ tâm đến điểm trên đường tròn
		double r = Math.sqrt(Math.pow(cx - x1, 2) + Math.pow(cy - y1, 2));

		// Tọa độ đỉnh thứ hai
		int x2 = (int) Math.round(cx + r * Math.cos(angleInRadians));
		int y2 = (int) Math.round(cy + r * Math.sin(angleInRadians));

		// In kết quả
//		System.out.println("Tọa độ của đỉnh thứ hai tại góc: " + angle + " là: (" + x2 + ", " + y2 + ")");

		re[0] = x2;
		re[1] = y2;

		return re;
	}
	
	public int[] timToaDoPhut() {
		int re[] = new int[2];

		// Tọa độ tâm
		int cx = 200;
		int cy = 200;

		// Tọa độ điểm trên đường tròn
		int x1 = 200;
		int y1 = 40;
//		System.out.println(cx + ", " + cy + "; " + x1 + ", " + y1);

		// Chuyển đổi đơn vị độ sang radian
		double angleInRadians = Math.toRadians(this.minute*6 - 90);

		// Tính khoảng cách từ tâm đến điểm trên đường tròn
		double r = Math.sqrt(Math.pow(cx - x1, 2) + Math.pow(cy - y1, 2));

		// Tọa độ đỉnh thứ hai
		int x2 = (int) Math.round(cx + r * Math.cos(angleInRadians));
		int y2 = (int) Math.round(cy + r * Math.sin(angleInRadians));

		// In kết quả
//		System.out.println("Tọa độ của đỉnh thứ hai tại góc: " + angle + " là: (" + x2 + ", " + y2 + ")");

		re[0] = x2;
		re[1] = y2;

		return re;
	}
	
	public int[] timToaDoGio() {
		int re[] = new int[2];

		// Tọa độ tâm
		int cx = 200;
		int cy = 200;

		// Tọa độ điểm trên đường tròn
		int x1 = 200;
		int y1 = 60;
//		System.out.println(cx + ", " + cy + "; " + x1 + ", " + y1);

		// Chuyển đổi đơn vị độ sang radian
		double angleInRadians = Math.toRadians(this.hour*6 - 90);

		// Tính khoảng cách từ tâm đến điểm trên đường tròn
		double r = Math.sqrt(Math.pow(cx - x1, 2) + Math.pow(cy - y1, 2));

		// Tọa độ đỉnh thứ hai
		int x2 = (int) Math.round(cx + r * Math.cos(angleInRadians));
		int y2 = (int) Math.round(cy + r * Math.sin(angleInRadians));

		// In kết quả
//		System.out.println("Tọa độ của đỉnh thứ hai tại góc: " + angle + " là: (" + x2 + ", " + y2 + ")");

		re[0] = x2;
		re[1] = y2;

		return re;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Time) {
			Time time = (Time) o;
			this.second = time.getSecond();
			this.minute = time.getMinute();
			this.hour = time.getHour();
		}
	}
	
	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.fillOval(0, 0, 400, 400);
		int toaDoGiay[] = this.timToaDoGiay();
		int toaDoPhut[] = this.timToaDoPhut();
		int toaDoGio[] = this.timToaDoGio();
		g.setColor(Color.black);
		g.drawLine(200, 200, toaDoGiay[0], toaDoGiay[1]);
		g.drawLine(200, 200, toaDoPhut[0], toaDoPhut[1]);
		g.drawLine(200, 200, toaDoGio[0], toaDoGio[1]);
		this.repaint();
	}

	public static void main(String[] args) throws InterruptedException {
		Time time = new Time(new Date());
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.black);

		Analog panel = new Analog(time);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		time.run();
	}

}
