package baiTapTuan5.lab4;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class TriangleDrawing extends JFrame {
	StdTriangle t, t1;
	IsocelesTriangle it;

	public TriangleDrawing() {
		super("Draw triangles");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		TPanel tp = new TPanel();
		t = new StdTriangle(new Point(10, 10), new Point(150, 50), new Point(100, 75));
		it = new IsocelesTriangle(new Point(150, 100), new Point(240, 40), new Point(175, 150));
		t1 = new StdTriangle(new Point(150, 100), new Point(240, 40), new Point(175, 150));
		tp.addTriangle(t);
		tp.addTriangle(it);
		// tp.addTriangle(t1);
		getContentPane().add(tp);
		setSize(300, 200);
		setBackground(Color.white);
		setVisible(true);
	}

	public static void main(String[] arg) {
		new TriangleDrawing();
	}
}
