package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import control.ControlPanelMenuSanPham;
import model_beverage.Beverage;
import model_food.Food;

public class PanelMenuSanPham extends JPanel {
	private JButton buttonOptionDoAn, buttonOptionDoUong;
	private JPanel panelShowSanPham;
	private JScrollPane scrollPaneDoAn, scrollPaneDoUong;
	private List<Food> listFoods;
	private List<Beverage> listBeverages;
	private ControlPanelMenuSanPham control;

	public PanelMenuSanPham(List<Food> listFoods, List<Beverage> listBeverages) {
		this.listFoods = listFoods;
		this.listBeverages = listBeverages;
		this.init();
		this.event();
	}

	public JButton getButtonOptionDoAn() {
		return buttonOptionDoAn;
	}

	public JButton getButtonOptionDoUong() {
		return buttonOptionDoUong;
	}

	public void init() {
		this.setLayout(new BorderLayout(0, 0));
		control = new ControlPanelMenuSanPham(this);

		JPanel OptionSanPham = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		OptionSanPham.setBackground(new Color(228, 239, 231));
		this.add(OptionSanPham, BorderLayout.NORTH);

		buttonOptionDoAn = new JButton("Đồ ăn");
		buttonOptionDoAn.setBorder(null);
		buttonOptionDoAn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonOptionDoAn.setBackground(new Color(225, 230, 99));
		buttonOptionDoAn.setPreferredSize(new Dimension(150, 50));
		OptionSanPham.add(buttonOptionDoAn);

		buttonOptionDoUong = new JButton("Đồ uống");
		buttonOptionDoUong.setBorder(null);
		buttonOptionDoUong.setBackground(new Color(255, 255, 255));
		buttonOptionDoUong.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonOptionDoUong.setPreferredSize(new Dimension(150, 50));
		OptionSanPham.add(buttonOptionDoUong);

		panelShowSanPham = new JPanel(new CardLayout(0, 0));
		scrollPaneDoAn = new JScrollPane();
		panelShowSanPham.add("food", scrollPaneDoAn);
		createPanelListFood(listFoods);
		
		this.add(panelShowSanPham, BorderLayout.CENTER);

		scrollPaneDoUong = new JScrollPane();
		panelShowSanPham.add("beverage", scrollPaneDoUong);
		createPanelListBeverage(listBeverages);
	}

	public void event() {
		buttonOptionDoAn.addActionListener(control);
		buttonOptionDoUong.addActionListener(control);
	}

	public void createPanelListFood(List<Food> listFoods) {
		JPanel panelCenterDoAn = new JPanel(new FlowLayout(FlowLayout.LEFT, 45, 30));
		panelCenterDoAn.setPreferredSize(new Dimension(750, listFoods.size() * 200));
		panelCenterDoAn.setBackground(new Color(228, 239, 231));
		for (Food f : listFoods) {
			PanelDoAn food = new PanelDoAn(f);
			panelCenterDoAn.add(food);
		}

		scrollPaneDoAn.setViewportView(panelCenterDoAn);
	}

	public void createPanelListBeverage(List<Beverage> listBeverages) {
		JPanel panelCenterDoUong = new JPanel(new FlowLayout(FlowLayout.LEFT, 45, 30));
		panelCenterDoUong.setPreferredSize(new Dimension(750, listBeverages.size() * 200));
		panelCenterDoUong.setBackground(new Color(228, 239, 231));
		for (Beverage b : listBeverages) {
			PanelDoUong beverage = new PanelDoUong(b);
			panelCenterDoUong.add(beverage);
		}
		
		scrollPaneDoUong.setViewportView(panelCenterDoUong);
	}

	public void showMenuDoAn() {
		((CardLayout) panelShowSanPham.getLayout()).show(panelShowSanPham, "food");
		buttonOptionDoAn.setBackground(new Color(225, 230, 99));
		buttonOptionDoUong.setBackground(new Color(255, 255, 255));
	}

	public void showMenuDoUong() {
		((CardLayout) panelShowSanPham.getLayout()).show(panelShowSanPham, "beverage");
		buttonOptionDoUong.setBackground(new Color(225, 230, 99));
		buttonOptionDoAn.setBackground(new Color(255, 255, 255));
	}
}
