package view.general.staff;

import javax.swing.JPanel;

import view.layout.WrapLayout;

/**
 * Dùng để chứa các phần tử nhưng có giao diện sẽ tự động đổ nếu các phần tử
 * tràn ra ngoài do đó cần kết hơp với scroll
 */
public class PanelItem extends JPanel {

	public PanelItem() {
		setOpaque(false);
		setLayout(new WrapLayout(WrapLayout.LEFT, 10, 10));
	}
}
