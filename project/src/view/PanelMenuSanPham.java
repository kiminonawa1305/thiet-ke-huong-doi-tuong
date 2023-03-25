package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import control.ControlPanelMenuSanPham;
import model_beverage.Beverage;
import model_beverage.CondimentDecorator;
import model_food.BanhMi;
import model_food.Barbecue;
import model_food.Cheese;
import model_food.Food;
import model_food.FoodDecorator;
import model_food.Foods;
import model_food.FriedChicken;
import model_system.Size;

public class PanelMenuSanPham extends JPanel {
	private JButton buttonOptionDoAn, buttonOptionDoUong;
	private JPanel panelShowSanPham;
	private JScrollPane scrollPaneDoAn, scrollPaneDoUong;
	private List<Food> listFoods;
	private List<Beverage> listBeverages;
	private List<FoodDecorator> listToppingFood;
	private List<CondimentDecorator> listToppingBeverage;
	private ControlPanelMenuSanPham control;
	private JButton buttonOrder;
	private JButton buttonCancel;
	private JFrame framechon;

	public PanelMenuSanPham(List<Food> listFoods, List<Beverage> listBeverages, List<FoodDecorator> listToppingFood,
			List<CondimentDecorator> listToppingBeverage) {
		this.listFoods = listFoods;
		this.listBeverages = listBeverages;
		this.listToppingBeverage = listToppingBeverage;
		this.listToppingFood = listToppingFood;
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
		buttonOptionDoUong.setBackground(new Color(250, 241, 230));
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

		JComboBox<String> comboBoxToppingFood = new JComboBox();
		JComboBox<String> comboBoxToppingBeverage = new JComboBox();
		for(FoodDecorator decorator : this.listToppingFood) {
			comboBoxToppingFood.addItem(decorator.getName());
		}
		
		framechon = new JFrame();
		framechon.setSize(800, 135);
		framechon.setResizable(false);
		framechon.setLocationRelativeTo(null);
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
			food.getChon().addActionListener(control);
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
		buttonOptionDoUong.setBackground(new Color(250, 241, 230));
	}

	public void showMenuDoUong() {
		((CardLayout) panelShowSanPham.getLayout()).show(panelShowSanPham, "beverage");
		buttonOptionDoUong.setBackground(new Color(225, 230, 99));
		buttonOptionDoAn.setBackground(new Color(250, 241, 230));
	}

	public void chonDoAn(JButton button) {
		if(!framechon.isVisible()) {
			for (Food food : listFoods) {
				if (food.note().equals(button.getActionCommand())) {
					this.showTuyChinh(food);
				}
			}
		}
	}

	public void showTuyChinh(Food food) {
		JPanel contentPane = new JPanel(new FlowLayout(FlowLayout.LEADING, 25, 15));

		JLabel labelTenSP = new JLabel(food.note());
		labelTenSP.setPreferredSize(new Dimension(200, 30));
		labelTenSP.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(labelTenSP);
		
		JComboBox<Size> comboBoxSize = null;
		Size[] options = {Size.SMALL, Size.MEDIUM, Size.LARGE};
		if(((Foods) food).hasSize()) {
			comboBoxSize = new JComboBox<>(options);
		}else {
			DefaultComboBoxModel<Size> modelComboBox = new DefaultComboBoxModel<>(options);
			comboBoxSize = new JComboBox<>(modelComboBox);

			// Khóa chức năng xổ xuống của JComboBox
			comboBoxSize.setFocusable(false);
			comboBoxSize.setRenderer(new DefaultListCellRenderer() {
			    @Override
			    public void paint(Graphics g) {
			        setPreferredSize(new Dimension(0, 0)); // Đặt kích thước của renderer về 0
			        super.paint(g);
			    }
			});

			// Đặt giá trị mặc định cho JComboBox
			comboBoxSize.setSelectedItem(options[1]);
		}
		contentPane.add(comboBoxSize);
		
		SpinnerNumberModel model = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		JSpinner soLuong = new JSpinner(model);
		soLuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		soLuong.setPreferredSize(new Dimension(75, 30));
		contentPane.add(soLuong);

		List<FoodDecorator> listToppingFood = new ArrayList<>();
		listToppingFood.add(new Cheese(null));
		listToppingFood.add(new Barbecue(null));
		JComboBox<String> comboBoxToppingFood = new JComboBox();
		for(FoodDecorator decorator : listToppingFood) {
			comboBoxToppingFood.addItem(decorator.getName());
		}
		comboBoxToppingFood.setPreferredSize(new Dimension(150, 30));
		contentPane.add(comboBoxToppingFood);

		JPanel panelOptionOrder = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 3));
		panelOptionOrder.setPreferredSize(new Dimension(150, 70));
		contentPane.add(panelOptionOrder);

		JButton buttonOrder = new JButton("Đặt");
		buttonOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonOrder.setBackground(Color.GREEN);
		buttonOrder.setPreferredSize(new Dimension(100, 30));
		JButton buttonCancel = new JButton("Hủy");
		buttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonCancel.setBackground(Color.RED);
		buttonCancel.setPreferredSize(new Dimension(100, 30));

		panelOptionOrder.add(buttonOrder);

		panelOptionOrder.add(buttonCancel);

		framechon.setContentPane(contentPane);
		framechon.setVisible(true);
	}
}
