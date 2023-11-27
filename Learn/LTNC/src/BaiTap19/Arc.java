package BaiTap19;

import java.awt.*;

import javax.swing.JPanel;

public class Arc extends JPanel{

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillArc(10,10,30,100,10,50);
	}
	
	

}
