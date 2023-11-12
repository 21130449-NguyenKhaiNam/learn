package BaiTap19;

import java.awt.*;

import javax.swing.JPanel;

public class CircleFill extends JPanel{

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.fillOval(10,10,50,50);
	}

}
