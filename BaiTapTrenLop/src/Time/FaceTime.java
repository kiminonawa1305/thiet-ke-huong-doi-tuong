package Time;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSeparator;

public class FaceTime extends JFrame implements ActionListener {
	private JButton button_display;
	private Digital digital;
	private Analog analog;
	private Time time;

	public FaceTime() throws InterruptedException {
		this.init();
		this.event();
		this.setVisible(true);
		time.run();
	}

	public void init() {
		this.setTitle("Frame display watch");
		this.setSize(1000, 700);
//		this.getContentPane().setBackground(Color.black);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		time = new Time(new Date());
		digital = new Digital(time);
		analog = new Analog(time);
		this.getContentPane().add(digital, BorderLayout.EAST);
		this.getContentPane().add(analog, BorderLayout.WEST);
		digital.setVisible(false);
		analog.setVisible(false);

		button_display = new JButton("Display");
		this.getContentPane().add(button_display, BorderLayout.SOUTH);
	}

	public void display(){
		digital.setVisible(true);
		analog.setVisible(true);
	}
	
	public void event() {
		button_display.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		if (button == this.button_display) {
			this.display();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		FaceTime frame = new FaceTime();
	}

}
