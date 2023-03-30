package baiTapTuan5.lab4;

import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

public class TPanel extends JPanel {
	Vector triangles;

	public TPanel() {
		triangles = new Vector();
	}

	public void addTriangle(Triangle t) {
		triangles.addElement(t);
	}

	public void paint(Graphics g) {
		for (int i = 0; i < triangles.size(); i++) {
			Triangle tngl = (Triangle) triangles.elementAt(i);
			tngl.draw(g);
		}
	}
}
