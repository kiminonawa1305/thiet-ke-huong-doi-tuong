package view;

import java.awt.BorderLayout;
import java.time.chrono.JapaneseChronology;
import java.util.List;
import java.util.Random;

import javax.swing.*;

import control.ControlViewSystems;
import model.CreateFormExamThemes;
import model.Exam;
import model.Systems;

public class ViewSystems extends JFrame{
	private JButton createExamButton;
	private JLabel idExamLabel;
	private JPanel contentPane;
	private Systems systems;
	
	public ViewSystems() {
		this.init();
		this.setVisible(true);
	}
	
	public JButton getCreateExamButton() {
		return createExamButton;
	}

	public JLabel getIdExamLabel() {
		return idExamLabel;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void init() {
		this.setTitle("Hệ thống thi trắc nghiệm xin chào!");
		this.setSize(500, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		systems = new Systems();
	
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		
		createExamButton = new JButton("Tạo đề thi của bạn!");
		createExamButton.addActionListener(new ControlViewSystems(this));
	
		contentPane.add(createExamButton);
		this.setContentPane(contentPane);
	}
	
	public void createExam() {
		Random random = new  Random();
		String id = random.nextInt(0, 99999999) + "";
		Exam exam = new Exam(id, null, null, new CreateFormExamThemes());
		
		exam.createExam(systems);
		JOptionPane.showMessageDialog(this,id, "Mã đề thi của bạn là: ", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void chooseOptionCreate() {
		
	}
	
	public static void main(String[] args) {
		ViewSystems test = new ViewSystems();
	}
}
