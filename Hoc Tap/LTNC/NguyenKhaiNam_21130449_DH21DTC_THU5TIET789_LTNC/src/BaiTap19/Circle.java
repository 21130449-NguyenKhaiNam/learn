package BaiTap19;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Circle extends JPanel{

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawOval(10,10,50,50);
	}
}
