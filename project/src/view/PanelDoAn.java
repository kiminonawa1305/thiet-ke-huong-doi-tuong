package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model_food.Food;
import model_food.Foods;
import model_system.Size;

public class PanelDoAn extends JPanel {
	private Food food;

	public PanelDoAn(Food food) {
		this.food = food;
		this.init();
	}

	public void init() {
		this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		this.setPreferredSize(new Dimension(200, 250));
		this.setLayout(new BorderLayout(0, 0));

		JPanel panelInfCafe = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelInfCafe.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		panelInfCafe.setPreferredSize(new Dimension(10, 50));
		this.add(panelInfCafe, BorderLayout.SOUTH);

		JLabel labelTen = new JLabel("Tên: " + food.note());
		labelTen.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		labelTen.setOpaque(true);
		labelTen.setForeground(Color.white);
		labelTen.setPreferredSize(new Dimension(200, 25));
		labelTen.setBackground(Color.decode("#064420"));
		panelInfCafe.add(labelTen);

		JLabel labelGia = null;
		if (!((Foods) food).hasSize()) {
			labelGia = new JLabel("Giá: " + food.cost());
		} else {
			labelGia = new JLabel("Giá: " + food.cost() * Size.SMALL.getPercent() + " / "
					+ food.cost() * Size.MEDIUM.getPercent() + " / " + food.cost() * Size.LARGE.getPercent());
		}
		labelGia.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		labelGia.setPreferredSize(new Dimension(200, 25));
		labelGia.setOpaque(true);
		labelGia.setForeground(Color.white);
		labelGia.setBackground(Color.decode("#064420"));
		panelInfCafe.add(labelGia);

		JLabel image = new JLabel();
		image.setPreferredSize(new Dimension(150, 155));
		image.setIcon(new ImageIcon(((Foods) food).getUrlImage()));
		this.add(image, BorderLayout.NORTH);

		JButton datHangCafe = new JButton("Đặt");
		datHangCafe.setPreferredSize(new Dimension(100, 25));
		this.add(datHangCafe, BorderLayout.EAST);

		JButton themToppingCafe = new JButton("Thêm");
		themToppingCafe.setPreferredSize(new Dimension(100, 25));
		this.add(themToppingCafe, BorderLayout.WEST);
	}
}
