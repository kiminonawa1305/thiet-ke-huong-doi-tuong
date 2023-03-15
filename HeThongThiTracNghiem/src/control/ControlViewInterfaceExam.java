package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.ViewInterfaceExam;

public class ControlViewInterfaceExam implements ActionListener {
	private ViewInterfaceExam interfaceExam;

	public ControlViewInterfaceExam(ViewInterfaceExam interfaceExam) {
		this.interfaceExam = interfaceExam;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		
		if(button.getActionCommand() == "Next") {
			interfaceExam.next();
			return;
		}
		
		if(button.getActionCommand() == "Submit") {
			interfaceExam.submit();
			return;
		}
		
		if(button.getActionCommand() == "Previous") {
			interfaceExam.previous();
			return;
		}
		
		for(int i = 1; i <= interfaceExam.getExam().getListQuestion().size(); i++) {
			if(button.getActionCommand().equals(i + "")) {
				interfaceExam.showQuestion(i);
			}
		}
	}

}
