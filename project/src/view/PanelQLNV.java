package view;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import control.ControlPanelQLNV;
import model_system.Date;
import model_system.Employee;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

public class PanelQLNV extends JPanel {
	private ControlPanelQLNV control;
	private JTextField passwordField;
	private JButton buttonEye;
	private JPanel panelPasswordField, panelShowListNV;
	private JTextField textFieldID, textFieldHoTen, textFieldNgaySinh, textFieldDiaChi, textFieldSDT,
			textFieldLuongCoBan, textFieldNgayBD, textFieldSearchName, textFieldSearchID, textFieldSearchSDT;
	private JButton buttonLuu, buttonSearch;
	private Font fontLabel = new Font("Times New Roman", Font.BOLD, 20),
			fontInf = new Font("Times New Roman", Font.PLAIN, 15);
	private JComboBox<String> comboBoxGioiTinh;
	private List<Employee> listEmployees;
	private String pass;
	private JButton buttonDangNhap;
	private JScrollPane scrollPane;
	private JPanel that;

	/**
	 * Create the panel.
	 */
	public PanelQLNV(List<Employee> listEmployees, String pass) {
		this.pass = pass;
		this.listEmployees = listEmployees;
		this.init();
		this.event();
//		this.add(that);
	}
	

	public JButton getButtonEyes() {
		return buttonEye;
	}

	public JButton getButtonLuu() {
		return buttonLuu;
	}

	public JButton getButtonSearch() {
		return buttonSearch;
	}

	public JButton getButtonDangNhap() {
		return buttonDangNhap;
	}

	public void init() {
//		this = new JPanel();
		this.setLayout(new CardLayout());
		this.setBackground(new Color(228, 239, 231));

		control = new ControlPanelQLNV(this);

		JPanel panelPassword = new JPanel();
		this.add("pass", panelPassword);
		SpringLayout sl_panelPassword = new SpringLayout();
		panelPassword.setLayout(sl_panelPassword);

		JLabel labelPass = new JLabel("Nhập mật khẩu");
		sl_panelPassword.putConstraint(SpringLayout.NORTH, labelPass, 248, SpringLayout.NORTH, panelPassword);
		sl_panelPassword.putConstraint(SpringLayout.WEST, labelPass, -933, SpringLayout.EAST, panelPassword);
		sl_panelPassword.putConstraint(SpringLayout.SOUTH, labelPass, 358, SpringLayout.NORTH, panelPassword);
		sl_panelPassword.putConstraint(SpringLayout.EAST, labelPass, -453, SpringLayout.EAST, panelPassword);
		labelPass.setHorizontalTextPosition(SwingConstants.CENTER);
		labelPass.setHorizontalAlignment(SwingConstants.CENTER);
		labelPass.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panelPassword.add(labelPass);

		panelPasswordField = new JPanel(new BorderLayout(0, 0));
		panelPasswordField.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		sl_panelPassword.putConstraint(SpringLayout.NORTH, panelPasswordField, 6, SpringLayout.SOUTH, labelPass);
		sl_panelPassword.putConstraint(SpringLayout.WEST, panelPasswordField, 532, SpringLayout.WEST, panelPassword);
		sl_panelPassword.putConstraint(SpringLayout.SOUTH, panelPasswordField, 166, SpringLayout.NORTH, labelPass);
		sl_panelPassword.putConstraint(SpringLayout.EAST, panelPasswordField, -346, SpringLayout.EAST, panelPassword);
		panelPassword.add(panelPasswordField);

		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setPreferredSize(new Dimension(595, 19));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPasswordField.add(passwordField, BorderLayout.WEST);

		buttonDangNhap = new JButton("Đăng Nhập");
		sl_panelPassword.putConstraint(SpringLayout.NORTH, buttonDangNhap, 17, SpringLayout.SOUTH, panelPasswordField);

		buttonEye = new JButton("M");
		buttonEye.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonEye.setHorizontalAlignment(SwingConstants.CENTER);
		buttonEye.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonEye.setPreferredSize(new Dimension(50, 50));
		panelPasswordField.add(buttonEye, BorderLayout.EAST);
		sl_panelPassword.putConstraint(SpringLayout.WEST, buttonDangNhap, -837, SpringLayout.EAST, panelPassword);
		sl_panelPassword.putConstraint(SpringLayout.SOUTH, buttonDangNhap, -404, SpringLayout.SOUTH, panelPassword);
		sl_panelPassword.putConstraint(SpringLayout.EAST, buttonDangNhap, -548, SpringLayout.EAST, panelPassword);
		buttonDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelPassword.add(buttonDangNhap);

		// Phân show
		JPanel panelShowQLNV = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 30));
		panelShowQLNV.setBackground(new Color(228, 239, 231));
		this.add("show", panelShowQLNV);

		JPanel panelFrameShowListNV = new JPanel(new BorderLayout());
		panelFrameShowListNV.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		panelFrameShowListNV.setPreferredSize(new Dimension(1450, 650));
		panelFrameShowListNV.setBackground(Color.ORANGE);
		panelFrameShowListNV.setBorder(
				new TitledBorder(null, "Danh sách nhân viên", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelShowQLNV.add(panelFrameShowListNV);

		JPanel panelSearch = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 1));
		panelSearch.setBorder(new TitledBorder("Tìm kiếm"));
		panelSearch.setPreferredSize(new Dimension(10, 75));
		panelSearch.setBackground(Color.GRAY);
		panelFrameShowListNV.add(panelSearch, BorderLayout.NORTH);

		FlowLayout fl_panelTextFieldSearch = new FlowLayout(FlowLayout.LEFT);
		JPanel panelTextFieldSearch = new JPanel(fl_panelTextFieldSearch);
		panelTextFieldSearch.setOpaque(false);
		panelTextFieldSearch.setPreferredSize(new Dimension(1180, 45));
		panelSearch.add(panelTextFieldSearch);

		textFieldSearchID = new JTextField();
		textFieldSearchID.setBorder(new TitledBorder("ID nhân viên"));
		textFieldSearchID.setPreferredSize(new Dimension(7, 35));
		textFieldSearchID.setColumns(20);
		panelTextFieldSearch.add(textFieldSearchID);

		textFieldSearchName = new JTextField();
		textFieldSearchName.setBorder(new TitledBorder("Họ tên"));
		textFieldSearchName.setPreferredSize(new Dimension(7, 35));
		panelTextFieldSearch.add(textFieldSearchName);
		textFieldSearchName.setColumns(20);

		textFieldSearchSDT = new JTextField();
		textFieldSearchSDT.setBorder(new TitledBorder("Số điện thoại"));
		textFieldSearchSDT.setPreferredSize(new Dimension(7, 35));
		textFieldSearchSDT.setColumns(20);
		panelTextFieldSearch.add(textFieldSearchSDT);

		JPanel panelButtonSearch = new JPanel();
		panelButtonSearch.setOpaque(false);
		FlowLayout flowLayout_3 = (FlowLayout) panelButtonSearch.getLayout();
		flowLayout_3.setHgap(10);
		panelButtonSearch.setPreferredSize(new Dimension(200, 45));
		panelSearch.add(panelButtonSearch);

		buttonSearch = new JButton("Tìm kiếm");
		buttonSearch.setFont(new Font("Times New Roman", Font.BOLD, 17));
		buttonSearch.setForeground(Color.WHITE);
		buttonSearch.setBackground(new Color(6, 68, 32));
		buttonSearch.setPreferredSize(new Dimension(150, 35));
		panelButtonSearch.add(buttonSearch);

		JPanel panelListNV = new JPanel(new BorderLayout());
		panelFrameShowListNV.add(panelListNV, BorderLayout.CENTER);

		JPanel panelLaybel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 2));
		panelLaybel.setPreferredSize(new Dimension(10, 35));
		panelLaybel.setBackground(new Color(6, 68, 32));
		panelListNV.add(panelLaybel, BorderLayout.NORTH);

		JLabel labelID = new JLabel("ID NV");
		labelID.setHorizontalAlignment(SwingConstants.CENTER);
		labelID.setFont(fontLabel);
		labelID.setForeground(Color.WHITE);
		labelID.setPreferredSize(new Dimension(100, 30));
		panelLaybel.add(labelID);

		JLabel labelTen = new JLabel("Họ tên");
		labelTen.setHorizontalAlignment(SwingConstants.CENTER);
		labelTen.setFont(fontLabel);
		labelTen.setForeground(Color.WHITE);
		labelTen.setPreferredSize(new Dimension(200, 30));
		panelLaybel.add(labelTen);

		JLabel labelNgaySinh = new JLabel("Ngày sinh");
		labelNgaySinh.setHorizontalAlignment(SwingConstants.CENTER);
		labelNgaySinh.setFont(fontLabel);
		labelNgaySinh.setForeground(Color.WHITE);
		labelNgaySinh.setPreferredSize(new Dimension(100, 30));
		panelLaybel.add(labelNgaySinh);

		JLabel labelGioiTInh = new JLabel("Giới tính");
		labelGioiTInh.setHorizontalAlignment(SwingConstants.CENTER);
		labelGioiTInh.setFont(fontLabel);
		labelGioiTInh.setForeground(Color.WHITE);
		labelGioiTInh.setPreferredSize(new Dimension(100, 30));
		panelLaybel.add(labelGioiTInh);

		JLabel labelDiaChi = new JLabel("Địa chỉ");
		labelDiaChi.setHorizontalAlignment(SwingConstants.CENTER);
		labelDiaChi.setFont(fontLabel);
		labelDiaChi.setForeground(Color.WHITE);
		labelDiaChi.setPreferredSize(new Dimension(200, 30));
		panelLaybel.add(labelDiaChi);

		JLabel labelSDT = new JLabel("Số điện thoại");
		labelSDT.setHorizontalAlignment(SwingConstants.CENTER);
		labelSDT.setFont(fontLabel);
		labelSDT.setForeground(Color.WHITE);
		labelSDT.setPreferredSize(new Dimension(150, 30));
		panelLaybel.add(labelSDT);

		JLabel labelLuongCB = new JLabel("Lương cơ bản");
		labelLuongCB.setHorizontalAlignment(SwingConstants.CENTER);
		labelLuongCB.setFont(fontLabel);
		labelLuongCB.setForeground(Color.WHITE);
		labelLuongCB.setPreferredSize(new Dimension(125, 30));
		panelLaybel.add(labelLuongCB);

		JLabel labelNgayBD = new JLabel("Ngày bắt đầu");
		labelNgayBD.setHorizontalAlignment(SwingConstants.CENTER);
		labelNgayBD.setFont(fontLabel);
		labelNgayBD.setForeground(Color.WHITE);
		labelNgayBD.setPreferredSize(new Dimension(125, 30));
		panelLaybel.add(labelNgayBD);

		JLabel labelTuyChinh = new JLabel("Tùy chỉnh");
		labelTuyChinh.setHorizontalAlignment(SwingConstants.CENTER);
		labelTuyChinh.setFont(fontLabel);
		labelTuyChinh.setForeground(Color.WHITE);
		labelTuyChinh.setPreferredSize(new Dimension(200, 30));
		panelLaybel.add(labelTuyChinh);

		scrollPane = new JScrollPane();
		panelListNV.add(scrollPane, BorderLayout.CENTER);
		createListNV();
		scrollPane.setViewportView(panelShowListNV);
		
		JPanel panelThongTinNhanVien = new JPanel(new FlowLayout(FlowLayout.LEFT, 25, 0));
		panelThongTinNhanVien.setBorder(
				new TitledBorder(null, "Thông tin nhân viên", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelThongTinNhanVien.setPreferredSize(new Dimension(1450, 150));
		panelThongTinNhanVien.setBackground(new Color(192, 192, 192));
		panelShowQLNV.add(panelThongTinNhanVien);

		JPanel panelLayThongTin = new JPanel();
		panelLayThongTin.setOpaque(false);
		FlowLayout fl_panelLayThongTin = (FlowLayout) panelLayThongTin.getLayout();
		fl_panelLayThongTin.setVgap(8);
		fl_panelLayThongTin.setHgap(25);
		fl_panelLayThongTin.setAlignment(FlowLayout.LEFT);
		panelLayThongTin.setPreferredSize(new Dimension(1200, 110));
		panelThongTinNhanVien.add(panelLayThongTin);

		textFieldID = new JTextField(20);
		textFieldID.setPreferredSize(new Dimension(250, 40));
		textFieldID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldID.setBorder(new TitledBorder("ID nhân viên"));
		panelLayThongTin.add(textFieldID);

		textFieldHoTen = new JTextField(20);
		textFieldHoTen.setPreferredSize(new Dimension(1500, 40));
		textFieldHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldHoTen.setBorder(new TitledBorder("Họ tên"));
		panelLayThongTin.add(textFieldHoTen);

		textFieldNgaySinh = new JTextField(20);
		textFieldNgaySinh.setPreferredSize(new Dimension(1500, 40));
		textFieldNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldNgaySinh.setBorder(new TitledBorder("Ngày sinh"));
		panelLayThongTin.add(textFieldNgaySinh);

		comboBoxGioiTinh = new JComboBox<>();
		comboBoxGioiTinh.setBorder(new TitledBorder("Giới tính"));
		comboBoxGioiTinh.setPreferredSize(new Dimension(271, 40));
		panelLayThongTin.add(comboBoxGioiTinh);

		textFieldDiaChi = new JTextField(20);
		textFieldDiaChi.setPreferredSize(new Dimension(10, 40));
		textFieldDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldDiaChi.setBorder(new TitledBorder("Địa chỉ"));
		panelLayThongTin.add(textFieldDiaChi);

		textFieldSDT = new JTextField(20);
		textFieldSDT.setPreferredSize(new Dimension(10, 40));
		textFieldSDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldSDT.setBorder(new TitledBorder("Số điện thoại"));
		panelLayThongTin.add(textFieldSDT);

		textFieldLuongCoBan = new JTextField(20);
		textFieldLuongCoBan.setPreferredSize(new Dimension(10, 40));
		textFieldLuongCoBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldLuongCoBan.setBorder(new TitledBorder("Lương cơ bản"));
		panelLayThongTin.add(textFieldLuongCoBan);

		textFieldNgayBD = new JTextField(20);
		textFieldNgayBD.setPreferredSize(new Dimension(10, 40));
		textFieldNgayBD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldNgayBD.setBorder(new TitledBorder("Ngày bắt đầu"));
		panelLayThongTin.add(textFieldNgayBD);

		String[] sex = { "Nam", "Nữ", "Khác" };
		JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 25));
		panelButton.setOpaque(false);
		panelButton.setPreferredSize(new Dimension(160, 110));
		panelThongTinNhanVien.add(panelButton);

		buttonLuu = new JButton("Lưu");
		buttonLuu.setForeground(new Color(255, 255, 255));
		buttonLuu.setFont(new Font("Times New Roman", Font.BOLD, 30));
		buttonLuu.setBackground(Color.decode("#064420"));
		buttonLuu.setPreferredSize(new Dimension(125, 55));
		panelButton.add(buttonLuu);
	}

	public void event() {
		this.buttonEye.addActionListener(control);
		this.buttonDangNhap.addActionListener(control);
		this.buttonSearch.addActionListener(control);
		this.buttonLuu.addActionListener(control);
	}

	public void actionButtonEye(JButton button) {
		if (button.equals(buttonEye)) {
			if (this.passwordField instanceof JPasswordField) {
				this.showPass();
			} else {
				this.hiddenPass();
			}
		}
	}

	public void showPass() {
		panelPasswordField.remove(passwordField);
		this.passwordField = new JTextField(passwordField.getText());
		passwordField.setBorder(null);
		passwordField.setPreferredSize(new Dimension(595, 19));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPasswordField.add(passwordField, BorderLayout.WEST);
		this.validate();
	}

	public void hiddenPass() {
		panelPasswordField.remove(passwordField);
		this.passwordField = new JPasswordField(passwordField.getText());
		passwordField.setBorder(null);
		passwordField.setPreferredSize(new Dimension(595, 19));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPasswordField.add(passwordField, BorderLayout.WEST);
		this.validate();
	}

	public void createListNV() {
		panelShowListNV = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 10));
		panelShowListNV.setPreferredSize(new Dimension(1400, listEmployees.size() * 50));
		for (Employee employee : this.listEmployees) {
			JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 14, 0));
			panel.setBackground(new Color(250, 241, 230));
			panel.setPreferredSize(new Dimension(1430, 50));
			panelShowListNV.add(panel);

			JLabel lb1 = new JLabel(employee.getId());
			lb1.setHorizontalAlignment(SwingConstants.CENTER);
			lb1.setFont(fontInf);
			lb1.setPreferredSize(new Dimension(100, 48));
			panel.add(lb1);

			JLabel lb2 = new JLabel(employee.getName());
			lb2.setHorizontalAlignment(SwingConstants.CENTER);
			lb2.setFont(fontInf);
			lb2.setPreferredSize(new Dimension(200, 48));
			panel.add(lb2);

			JLabel lb3 = new JLabel(employee.getBirthDate().toString());
			lb3.setHorizontalAlignment(SwingConstants.CENTER);
			lb3.setFont(fontInf);
			lb3.setPreferredSize(new Dimension(100, 48));
			panel.add(lb3);

			JLabel lb4 = new JLabel(employee.getSex());
			lb4.setHorizontalAlignment(SwingConstants.CENTER);
			lb4.setFont(fontInf);
			lb4.setPreferredSize(new Dimension(100, 48));
			panel.add(lb4);

			JLabel lb5 = new JLabel(employee.getAddress());
			lb5.setHorizontalAlignment(SwingConstants.CENTER);
			lb5.setFont(fontInf);
			lb5.setPreferredSize(new Dimension(200, 48));
			panel.add(lb5);

			JLabel lb6 = new JLabel(employee.getNumberPhone());
			lb6.setHorizontalAlignment(SwingConstants.CENTER);
			lb6.setFont(fontInf);
			lb6.setPreferredSize(new Dimension(150, 48));
			panel.add(lb6);

			JLabel lb7 = new JLabel(employee.getBaseSalary() + "");
			lb7.setHorizontalAlignment(SwingConstants.CENTER);
			lb7.setFont(fontInf);
			lb7.setPreferredSize(new Dimension(125, 48));
			panel.add(lb7);

			JLabel lb8 = new JLabel(employee.getDateStart().toString());
			lb8.setHorizontalAlignment(SwingConstants.CENTER);
			lb8.setFont(fontInf);
			lb8.setPreferredSize(new Dimension(125, 48));
			panel.add(lb8);

			JPanel panelTuyChinh = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 2));
			panelTuyChinh.setOpaque(false);
			panelTuyChinh.setPreferredSize(new Dimension(200, 48));
			panelTuyChinh.setFont(fontLabel);
			panelTuyChinh.setForeground(Color.WHITE);
			panel.add(panelTuyChinh);

			JButton buttonSua = new JButton();
			buttonSua.setActionCommand("sua	" + employee.getId());
			buttonSua.setPreferredSize(new Dimension(45, 45));
			panelTuyChinh.add(buttonSua);

			JButton buttonXoa = new JButton();
			buttonXoa.setActionCommand("xoa	" + employee.getId());
			buttonXoa.setPreferredSize(new Dimension(45, 45));
			panelTuyChinh.add(buttonXoa);
		}
	}
	
	public void xoaNhanVien(JButton button) {
		for (Employee employee : this.listEmployees) {
			if (employee.equalsID(button.getActionCommand().split("	")[1])) {
				this.listEmployees.remove(employee);
			}
		}
		
		createListNV();
		scrollPane.setViewportView(panelShowListNV);
	}

	public void suaNhanVien() {
//		for (Employee employee : this.listEmployees) {
//			if (employee.equalsID(button.getActionCommand())) {
//				this.listEmployees.remove(employee);
//			}
//		}
	}

	public void themNhanVien() {
		try {
			this.listEmployees.add(new Employee(this.textFieldID.getText(), this.textFieldHoTen.getText(),
					new Date(this.textFieldNgaySinh.getText()), (String) this.comboBoxGioiTinh.getSelectedItem(),
					this.textFieldDiaChi.getText(), this.textFieldSDT.getText(),
					Double.parseDouble(this.textFieldLuongCoBan.toString()), new Date(this.textFieldNgayBD.getText())));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), "Lỗi sai kiểu dữ liệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
		
		createListNV();
		scrollPane.setViewportView(panelShowListNV);
	}

	public void dangNhap() {
		if (this.passwordField.getText().equals(this.pass)) {
			((CardLayout) this.getLayout()).show(this, "show");
			this.passwordField.setText("");
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "Sai mật khẩu", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void close() {
		((CardLayout) this.getLayout()).show(this, "pass");
	}
}
