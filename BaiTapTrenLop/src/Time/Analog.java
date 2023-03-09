package Time;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
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
		Graphics2D g2d = (Graphics2D) g;

		Point toaDoKiemGio = new Point();
		Point toaDoKiemPhut = new Point();
		Point toaDoKiemGiay = new Point();
		// Chuyển đổi đơn vị độ sang radian
		double gocXoayKiemGio = Math.toRadians(this.hour * 15 - 90);
		double gocXoayKiemPhut = Math.toRadians(this.minute * 6 - 90);
		double gocXoayKiemGiay = Math.toRadians(this.second * 6 - 90);

		// Tính khoảng cách từ tâm đến điểm trên đường tròn
		toaDoKiemGio.x = (int) Math.round(200 + 140 * Math.cos(gocXoayKiemGio));
		toaDoKiemGio.y = (int) Math.round(200 + 140 * Math.sin(gocXoayKiemGio));
		toaDoKiemPhut.x = (int) Math.round(200 + 155 * Math.cos(gocXoayKiemPhut));
		toaDoKiemPhut.y = (int) Math.round(200 + 155 * Math.sin(gocXoayKiemPhut));
		toaDoKiemGiay.x = (int) Math.round(200 + 170 * Math.cos(gocXoayKiemGiay));
		toaDoKiemGiay.y = (int) Math.round(200 + 170 * Math.sin(gocXoayKiemGiay));

		g2d.setStroke(new BasicStroke(4));

		// Vẽ mặt đồng hồ.
		g2d.setColor(Color.BLACK);
		g2d.drawOval(10, 10, 390, 390);

		g2d.setColor(Color.black);
		// Vẽ kim giây.
		g2d.drawLine(200, 200, toaDoKiemGiay.x, toaDoKiemGiay.y);
		g2d.drawLine(200, 200, toaDoKiemPhut.x, toaDoKiemPhut.y);
		g2d.drawLine(200, 200, toaDoKiemGio.x, toaDoKiemGio.y);
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
