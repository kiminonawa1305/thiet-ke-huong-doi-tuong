package view;

import javax.swing.*;


public class PanelCreateExam extends JPanel{
	private JButton option1, option2, option3;
	private JPanel panel1, panel2, panel3;
	
	public PanelCreateExam() {
		this.init();
	}
	
	public void init() {
		option1 = new JButton("Create Random By Topic");
		option2 = new JButton("Create Random By Topic And Level");
		option3 = new JButton("Create Form Exam Themes");
	}
}
