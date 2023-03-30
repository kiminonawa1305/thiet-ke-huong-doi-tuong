package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import view.ViewSystems;

public class ControlViewSystems implements ActionListener{
	private ViewSystems systems;
	public ControlViewSystems(ViewSystems systems) {
		super();
		this.systems = systems;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("nhan");
		if(e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
			
			if(button.equals(systems.getCreateExamButton())) {
//				systems.createExam();
			}
		}
		
		if(e.getSource() instanceof JMenuItem) {
			JMenuItem menuItem = (JMenuItem) e.getSource();
			
			if(menuItem.equals(systems.getItemExam())) {
				systems.openFrameExam();
			}
		}
		
	}

}
