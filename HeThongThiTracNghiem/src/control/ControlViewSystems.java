package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.ViewSystems;

public class ControlViewSystems implements ActionListener{
	private ViewSystems systems;
	public ControlViewSystems(ViewSystems systems) {
		super();
		this.systems = systems;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		if(button.equals(systems.getCreateExamButton())) {
			systems.createExam();
		}
		
	}

}
