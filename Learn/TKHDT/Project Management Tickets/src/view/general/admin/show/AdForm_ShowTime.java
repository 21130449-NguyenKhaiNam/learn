package view.general.admin.show;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.data.color.EnumColor;
import model.data.font.IDataFont;

public class AdForm_ShowTime extends JPanel {
	public AdForm_ShowTime() {
		this.setLayout(new BorderLayout());
		JLabel lb = new JLabel();
		lb.setText("Coming Soon");
		lb.setFont(IDataFont.BIG_TITLE);
		lb.setForeground(EnumColor.Text.color);
		lb.setHorizontalAlignment(JLabel.CENTER);
		this.add(lb, BorderLayout.CENTER);
	}
}
