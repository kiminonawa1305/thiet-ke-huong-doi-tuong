package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.PanelMenuSanPham;

public class ControlPanelMenuSanPham implements ActionListener {
	private PanelMenuSanPham panelMenu;

	public ControlPanelMenuSanPham(PanelMenuSanPham panelMenu) {
		super();
		this.panelMenu = panelMenu;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		
		if (button.equals(panelMenu.getButtonOptionDoAn())) {
			panelMenu.showMenuDoAn();
		}

		if (button.equals(panelMenu.getButtonOptionDoUong())) {
			panelMenu.showMenuDoUong();
		}
	}

}
