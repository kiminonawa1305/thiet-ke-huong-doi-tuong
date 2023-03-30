package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Exam;

public class PanelExam extends JPanel{
	private JButton buttonExam;
	private JTextField text;
	private ViewInterfaceExam interfaceExam;
	private ViewSystems viewSystems;
	
	public PanelExam(ViewSystems viewSystems) {
		this.viewSystems = viewSystems;
		this.init();
	}

	private void init() {
		this.setLayout(new BorderLayout());
		
		text = new JTextField();
		text.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
		buttonExam = new JButton("Bắt đầu thi!");
		buttonExam.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				startExam();
				
			}
		});
		
		this.add(text, BorderLayout.NORTH);
		this.add(buttonExam, BorderLayout.SOUTH);
	}
	
	public void startExam() {
		if(text.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã đề!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Exam exam = viewSystems.getExem(text.getText());
		if(exam == null) {
			JOptionPane.showMessageDialog(this, "Mã đề không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		interfaceExam = new ViewInterfaceExam(exam);
	}
}
