package baiTapTuan5.lab4;

import java.awt.Graphics;
import java.awt.Point;

public class StdTriangle extends Triangle {
	public StdTriangle(Point a, Point b, Point c) {
		super(a, b, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Point draw2ndLine(Graphics g, Point a, Point b) {
		g.drawLine(a.x, a.y, b.x, b.y);
		return b;
	}
}
