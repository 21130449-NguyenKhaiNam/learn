package control.movie;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import model.data.color.EnumColor;

public class ActionChair implements ActionListener {
	private Color[] colors = { EnumColor.UnSeated.color, EnumColor.Seated.color, EnumColor.ClickChair.color };

	public ActionChair() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		Color color = btn.getBackground();
		if (color == colors[0]) {
			btn.setBackground(colors[2]);
			btn.setSelected(true);
		} else if (color == colors[2]) {
			btn.setBackground(colors[0]);
			btn.setSelected(false);
		}
	}

}
