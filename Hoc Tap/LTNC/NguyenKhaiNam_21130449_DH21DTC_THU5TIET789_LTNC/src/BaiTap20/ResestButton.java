package BaiTap20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResestButton extends JPanel implements ActionListener{
	private Layout view;
	private JButton resest;

	public ResestButton(Layout view) {
		this.view = view;
		resest = new JButton("Resest");
		resest.addActionListener(this);
		this.add(resest);
		this.setBackground(Color.BLUE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		view.lamMoiVe();
	}
}
