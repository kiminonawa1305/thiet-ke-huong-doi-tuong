package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
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

import control.ControlPanelMenuSanPham;
import model_beverage.Beverage;
import model_beverage.BeverageDecorator;
import model_beverage.Beverages;
import model_food.Food;
import model_food.FoodDecorator;
import model_food.Foods;
import model_system.Bill;
import model_system.Size;

public class PanelMenuSanPham extends JPanel {
	private JButton buttonOptionDoAn, buttonOptionDoUong;
	private JPanel panelShowSanPham;
	private JScrollPane scrollPaneDoAn, scrollPaneDoUong;
	private List<Food> listFoods;
	private List<Beverage> listBeverages;
	private List<FoodDecorator> listToppingFood;
	private List<BeverageDecorator> listToppingBeverage;
	private ControlPanelMenuSanPham control;
	private JButton buttonOrder;
	private JButton buttonCancel;
	private JFrame framechon;
	private Food foodOrder;
	private Beverage beverageOrder;
	private Size[] options;
	private JComboBox<Size> comboBoxSize;
	private JComboBox<String> comboBoxToppingFood, comboBoxToppingBeverage;
	private SpinnerNumberModel model;
	private JSpinner soLuong;
	private Bill bill;

	public PanelMenuSanPham(List<Food> listFoods, List<Beverage> listBeverages, List<FoodDecorator> listToppingFood,
			List<BeverageDecorator> listToppingBeverage) {
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

	public JPanel getPanelShowSanPham() {
		return panelShowSanPham;
	}

	public JScrollPane getScrollPaneDoAn() {
		return scrollPaneDoAn;
	}

	public JScrollPane getScrollPaneDoUong() {
		return scrollPaneDoUong;
	}

	public List<Food> getListFoods() {
		return listFoods;
	}

	public List<Beverage> getListBeverages() {
		return listBeverages;
	}

	public List<FoodDecorator> getListToppingFood() {
		return listToppingFood;
	}

	public List<BeverageDecorator> getListToppingBeverage() {
		return listToppingBeverage;
	}

	public ControlPanelMenuSanPham getControl() {
		return control;
	}

	public JButton getButtonOrder() {
		return buttonOrder;
	}

	public JButton getButtonCancel() {
		return buttonCancel;
	}

	public JFrame getFramechon() {
		return framechon;
	}

	public Food getFoodOrder() {
		return foodOrder;
	}

	public Beverage getBeverageOrder() {
		return beverageOrder;
	}

	public Size[] getOptions() {
		return options;
	}

	public JComboBox<Size> getComboBoxSize() {
		return comboBoxSize;
	}

	public JComboBox<String> getComboBoxToppingFood() {
		return comboBoxToppingFood;
	}

	public JComboBox<String> getComboBoxToppingBeverage() {
		return comboBoxToppingBeverage;
	}

	public SpinnerNumberModel getModel() {
		return model;
	}

	public JSpinner getSoLuong() {
		return soLuong;
	}

	public void init() {
		this.setLayout(new BorderLayout(0, 0));
		control = new ControlPanelMenuSanPham(this);

		JPanel OptionSanPham = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		OptionSanPham.setBackground(new Color(228, 239, 231));
		this.add(OptionSanPham, BorderLayout.NORTH);

		buttonOptionDoAn = new JButton("Đồ ăn");
		buttonOptionDoAn.setName("");
		buttonOptionDoAn.setBorder(null);
		buttonOptionDoAn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonOptionDoAn.setBackground(new Color(225, 230, 99));
		buttonOptionDoAn.setPreferredSize(new Dimension(150, 50));
		OptionSanPham.add(buttonOptionDoAn);

		buttonOptionDoUong = new JButton("Đồ uống");
		buttonOptionDoUong.setName("");
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

		framechon = new JFrame();
		framechon.setSize(800, 135);
		framechon.setResizable(false);
		framechon.setLocationRelativeTo(null);
		framechon.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		buttonOrder = new JButton("Đặt");
		buttonOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonOrder.setBackground(Color.GREEN);
		buttonOrder.setPreferredSize(new Dimension(100, 30));
		buttonOrder.setName("");

		buttonCancel = new JButton("Hủy");
		buttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonCancel.setBackground(Color.RED);
		buttonCancel.setPreferredSize(new Dimension(100, 30));
		buttonCancel.setName("");

		this.options = new Size[3];
		options[0] = Size.MEDIUM;
		options[1] = Size.SMALL;
		options[2] = Size.LARGE;

		model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		soLuong = new JSpinner(model);
		soLuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		soLuong.setPreferredSize(new Dimension(75, 30));

		this.comboBoxToppingFood = new JComboBox();
		comboBoxToppingFood.addItem("");
		for (FoodDecorator decorator : this.listToppingFood) {
			comboBoxToppingFood.addItem(decorator.getName());
		}
		this.comboBoxToppingFood.setPreferredSize(new Dimension(150, 30));

		this.comboBoxToppingBeverage = new JComboBox();
		comboBoxToppingBeverage.addItem("");
		for (BeverageDecorator decorator : this.listToppingBeverage) {
			comboBoxToppingBeverage.addItem(decorator.getName());
		}
		this.comboBoxToppingBeverage.setPreferredSize(new Dimension(150, 30));

		bill = new Bill();
	}

	public void event() {
		buttonOptionDoAn.addActionListener(control);
		buttonOptionDoUong.addActionListener(control);
		buttonOrder.addActionListener(control);
		buttonCancel.addActionListener(control);
	}

	public void createPanelListFood(List<Food> listFoods) {
		JPanel panelCenterDoAn = new JPanel(new FlowLayout(FlowLayout.LEFT, 39, 30));
		panelCenterDoAn.setPreferredSize(new Dimension(750, (listBeverages.size() / 6 + 1) * 280));
		panelCenterDoAn.setBackground(new Color(228, 239, 231));
		for (Food f : listFoods) {
			PanelDoAn food = new PanelDoAn(f);
			food.getChon().addActionListener(control);
			panelCenterDoAn.add(food);
		}

		scrollPaneDoAn.setViewportView(panelCenterDoAn);
	}

	public void createPanelListBeverage(List<Beverage> listBeverages) {
		JPanel panelCenterDoUong = new JPanel(new FlowLayout(FlowLayout.LEFT, 39, 30));
		panelCenterDoUong.setPreferredSize(new Dimension(750, (listBeverages.size() / 6 + 1) * 200));
		panelCenterDoUong.setBackground(new Color(228, 239, 231));
		for (Beverage b : listBeverages) {
			PanelDoUong beverage = new PanelDoUong(b);
			beverage.getChon().addActionListener(control);
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
		if (!framechon.isVisible()) {
			for (Food food : listFoods) {
				if (((Foods) food).getName().equals(button.getActionCommand())) {
					this.showTuyChinhDoAn(food);
					foodOrder = food;
					return;
				}
			}
		}
	}

	// Show frame tiến hành chọn và đặt món.
	public void showTuyChinhDoAn(Food food) {
		JPanel contentPane = new JPanel(new FlowLayout(FlowLayout.LEADING, 25, 15));

		JLabel labelTenSP = new JLabel(((Foods) food).getName());
		labelTenSP.setPreferredSize(new Dimension(200, 30));
		labelTenSP.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(labelTenSP);

		if (((Foods) food).hasSize()) {
			comboBoxSize = new JComboBox<>(options);
		} else {
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

		soLuong.setModel(model);
		contentPane.add(soLuong);

		contentPane.add(comboBoxToppingFood);

		JPanel panelOptionOrder = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 3));
		panelOptionOrder.setPreferredSize(new Dimension(150, 70));
		contentPane.add(panelOptionOrder);

		panelOptionOrder.add(buttonOrder);

		panelOptionOrder.add(buttonCancel);

		buttonOrder.setName("datDoAn");

		framechon.setContentPane(contentPane);
		framechon.setVisible(true);
	}

	public void datDoAn() {
		((Foods) foodOrder).setSize((Size) this.comboBoxSize.getSelectedItem());

		if (!((String) this.comboBoxToppingFood.getSelectedItem()).equals("")) {
			for (FoodDecorator decorator : listToppingFood) {
				if (decorator.getName().equals((String) this.comboBoxToppingBeverage.getSelectedItem())) {
					foodOrder = decorator.setFood(foodOrder);
				}
			}
		}

		bill.addBeverage(beverageOrder, (int) this.soLuong.getValue());
		System.out.println(bill.getTotalBill());
		foodOrder = null;
		framechon.setVisible(false);
	}

	public void chonDoUong(JButton button) {
		if (!framechon.isVisible()) {
			for (Beverage beverage : listBeverages) {
				if (((Beverages) beverage).getName().equals(button.getActionCommand())) {
					this.showTuyChinhDoUong(beverage);
					beverageOrder = beverage;
					return;
				}
			}
		}
	}

	// Show frame tiến hành chọn và đặt món.
	public void showTuyChinhDoUong(Beverage beverage) {
		JPanel contentPane = new JPanel(new FlowLayout(FlowLayout.LEADING, 25, 15));

		JLabel labelTenSP = new JLabel(((Beverages) beverage).getName());
		labelTenSP.setPreferredSize(new Dimension(200, 30));
		labelTenSP.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(labelTenSP);

		comboBoxSize = new JComboBox<>(options);
		contentPane.add(comboBoxSize);

		soLuong.setModel(model);
		contentPane.add(soLuong);

		contentPane.add(comboBoxToppingBeverage);

		JPanel panelOptionOrder = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 3));
		panelOptionOrder.setPreferredSize(new Dimension(150, 70));
		contentPane.add(panelOptionOrder);

		panelOptionOrder.add(buttonOrder);

		panelOptionOrder.add(buttonCancel);

		buttonOrder.setName("datDoUong");

		framechon.setContentPane(contentPane);
		framechon.setVisible(true);
	}

	public void datDoUong() {
		((Beverages) beverageOrder).setSize((Size) this.comboBoxSize.getSelectedItem());

		if (!((String) this.comboBoxToppingBeverage.getSelectedItem()).equals("")) {
			System.out.println("run");
			for (BeverageDecorator decorator : listToppingBeverage) {
				if (decorator.getName().equals((String) this.comboBoxToppingBeverage.getSelectedItem())) {
					beverageOrder = decorator.setBeverage(beverageOrder);
				}
			}
		}

		bill.addBeverage(beverageOrder, (int) this.soLuong.getValue());
		System.out.println(bill.getTotalBill());
		beverageOrder = null;
		framechon.setVisible(false);
	}

	public void huy() {
		foodOrder = null;
		beverageOrder = null;
		framechon.setVisible(false);
	}
}
