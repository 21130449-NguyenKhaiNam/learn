package BaiTap19;

import java.awt.*;

import javax.swing.JPanel;

public class SquareFill extends JPanel{

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.PINK);
		g.fillRect(20,20,80,30);
	}

}
