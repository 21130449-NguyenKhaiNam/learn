package view.general.admin.history;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.data.color.EnumColor;
import model.data.font.IDataFont;

/**
 * Giao diện ghi lại lịch sử thanh toán
 */
public class AdForm_History extends JPanel {

	public AdForm_History() {
		this.setLayout(new BorderLayout());
		JLabel lb = new JLabel();
		lb.setText("Coming Soon");
		lb.setFont(IDataFont.BIG_TITLE);
		lb.setForeground(EnumColor.Text.color);
		lb.setHorizontalAlignment(JLabel.CENTER);
		this.add(lb, BorderLayout.CENTER);
	}

}
