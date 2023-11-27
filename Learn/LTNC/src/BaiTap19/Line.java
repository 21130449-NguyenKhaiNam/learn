package BaiTap19;

import java.awt.*;

import javax.swing.*;

public class Line extends JPanel{
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.drawLine(15,15,80,80);
	}

}
