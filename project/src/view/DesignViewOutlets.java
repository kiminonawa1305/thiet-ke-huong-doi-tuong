package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import control.ControlViewOutlets;
import model_beverage.Beverage;
import model_beverage.Soda;
import model_food.Food;
import model_food.FriedChicken;
import model_system.Date;
import model_system.Employee;
import model_system.Outlets;

public class DesignViewOutlets extends JFrame {
	private Outlets outlets;
	private PanelQLNV panelQLNV;
	private PanelMenuSanPham panelMenuSanPham;
	private JPanel contentPane, panelCenter;
	private List<JButton> listButtonMainMenu = new ArrayList<>();
	private JButton buttonQLNV, buttonHoaDon, buttonDoanhThu, buttonMenu;
	private ControlViewOutlets control;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		List<Food> listFoods = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			listFoods.add(new FriedChicken(""));
		}

		List<Beverage> listBeverages = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			listBeverages.add(new Soda(""));
		}

		List<Employee> emplyees = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			emplyees.add(new Employee(i + "", "Ten " + i, new Date("13/05/2003"), "gioi tinh", "dia chi " + i,
					"sdt " + i, i, new Date("25/3/2023")));
		}

		Outlets outlets = new Outlets("a", "a", "abc", "lamnguyen1305");
		outlets.setListBeverage(listBeverages);
		outlets.setListFood(listFoods);
		outlets.setEmployees(emplyees);
		DesignViewOutlets frame = new DesignViewOutlets(outlets);
	}

	/**
	 * Create the frame.
	 */
	public DesignViewOutlets(Outlets outlets) {
		this.outlets = outlets;
		this.init();
		this.event();
		this.setVisible(true);
	}

	public JButton getButtonQLNV() {
		return buttonQLNV;
	}

	public JButton getButtonHoaDon() {
		return buttonHoaDon;
	}

	public JButton getButtonMenu() {
		return buttonMenu;
	}

	public JButton getButtonDoanhThu() {
		return buttonDoanhThu;
	}

	public Outlets getOutlets() {
		return outlets;
	}

	/**
	 * 
	 */
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(0, 0, 1740,
				930);
		contentPane = new JPanel(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setResizable(false);

		control = new ControlViewOutlets(this);

		JPanel menuWest = new JPanel();
		menuWest.setBackground(new Color(6, 68, 32));
		menuWest.setPreferredSize(new Dimension(200, 10));

		contentPane.add(menuWest, BorderLayout.WEST);
		SpringLayout sl_menuWest = new SpringLayout();
		menuWest.setLayout(sl_menuWest);

		Logo logo = new Logo("D:\\Tai_lieu_hoc_tap\\ThietKeHuongDoiTuong\\Code\\project\\logo.png");
		sl_menuWest.putConstraint(SpringLayout.NORTH, logo, 21, SpringLayout.NORTH, menuWest);
		sl_menuWest.putConstraint(SpringLayout.WEST, logo, 22, SpringLayout.WEST, menuWest);
		sl_menuWest.putConstraint(SpringLayout.SOUTH, logo, 170, SpringLayout.NORTH, menuWest);
		sl_menuWest.putConstraint(SpringLayout.EAST, logo, -28, SpringLayout.EAST, menuWest);
		logo.setBackground(new Color(255, 255, 255));
		logo.setPreferredSize(new Dimension(50, 50));
		menuWest.add(logo);

		JPanel menu = new JPanel();
		sl_menuWest.putConstraint(SpringLayout.NORTH, menu, 32, SpringLayout.SOUTH, logo);
		sl_menuWest.putConstraint(SpringLayout.WEST, menu, 0, SpringLayout.WEST, menuWest);
		sl_menuWest.putConstraint(SpringLayout.SOUTH, menu, -125, SpringLayout.SOUTH, menuWest);
		sl_menuWest.putConstraint(SpringLayout.EAST, menu, 0, SpringLayout.EAST, menuWest);
		menu.setBackground(new Color(180, 231, 191));
		FlowLayout fl_menu = (FlowLayout) menu.getLayout();
		fl_menu.setVgap(0);
		fl_menu.setHgap(0);
		menu.setPreferredSize(new Dimension(150, 10));
		menuWest.add(menu);

		buttonMenu = new JButton("Menu");
		buttonMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonMenu.setBorder(null);
		buttonMenu.setBackground(new Color(116, 187, 131));
		buttonMenu.setPreferredSize(new Dimension(200, 50));
		menu.add(buttonMenu);
		listButtonMainMenu.add(buttonMenu);

		buttonHoaDon = new JButton("Hóa đơn");
		buttonHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonHoaDon.setBorder(null);
		buttonHoaDon.setBackground(new Color(180, 231, 191));
		buttonHoaDon.setPreferredSize(new Dimension(200, 50));
		menu.add(buttonHoaDon);
		listButtonMainMenu.add(buttonHoaDon);

		buttonQLNV = new JButton("Quản lý nhân viên");
		buttonQLNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonQLNV.setBackground(new Color(180, 231, 191));
		buttonQLNV.setBorder(null);
		buttonQLNV.setPreferredSize(new Dimension(200, 50));
		menu.add(buttonQLNV);
		listButtonMainMenu.add(buttonQLNV);

		buttonDoanhThu = new JButton("Doanh thu");
		buttonDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonDoanhThu.setBackground(new Color(180, 231, 191));
		buttonDoanhThu.setBorder(null);
		buttonDoanhThu.setPreferredSize(new Dimension(200, 50));
		menu.add(buttonDoanhThu);
		listButtonMainMenu.add(buttonDoanhThu);

		panelCenter = new JPanel(new CardLayout(0, 0));
		panelCenter.setBackground(new Color(228, 239, 231));
		contentPane.add(panelCenter, BorderLayout.CENTER);

		panelMenuSanPham = new PanelMenuSanPham(outlets.getListFood(), outlets.getListBeverage());
		panelCenter.add("menu_sp", panelMenuSanPham);

		JPanel panelHoaDon = new JPanel();
		panelCenter.add("hoa_don", panelHoaDon);

		JPanel panelDoanhThu = new JPanel();
		panelCenter.add("doanh_thu", panelDoanhThu);

		panelQLNV = new PanelQLNV(outlets.getEmployees(), outlets.getPass());
		panelQLNV.setBackground(new Color(228, 239, 231));
		panelCenter.add("qlnv", panelQLNV);
	}

	public void event() {
		buttonMenu.addActionListener(control);
		this.buttonHoaDon.addActionListener(control);
		this.buttonDoanhThu.addActionListener(control);
		this.buttonQLNV.addActionListener(control);
	}

	public void showMenuSanPham() {
		((CardLayout) panelCenter.getLayout()).show(panelCenter, "menu_sp");
		setBackgroundForButtonManiMenuIsSelect(buttonMenu);
		panelQLNV.close();
	}

	public void showHoaDon() {
		((CardLayout) panelCenter.getLayout()).show(panelCenter, "hoa_don");
		setBackgroundForButtonManiMenuIsSelect(buttonHoaDon);
		panelQLNV.close();
	}

	public void showQLNV() {
		((CardLayout) panelCenter.getLayout()).show(panelCenter, "qlnv");
		setBackgroundForButtonManiMenuIsSelect(buttonQLNV);
		panelQLNV.close();
	}

	public void showDoanhThu() {
		((CardLayout) panelCenter.getLayout()).show(panelCenter, "doanh_thu");
		setBackgroundForButtonManiMenuIsSelect(buttonDoanhThu);
		panelQLNV.close();
	}

	public void setBackgroundForButtonManiMenuIsSelect(JButton button) {
		for (JButton b : listButtonMainMenu) {
			if (button.equals(b)) {
				b.setBackground(new Color(116, 187, 131));
			} else {
				b.setBackground(new Color(180, 231, 191));
			}
		}
	}

}
