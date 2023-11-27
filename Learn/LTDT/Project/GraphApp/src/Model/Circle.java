package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Circle extends JPanel {
	private String name;
	private int r;
	private boolean click;

	/**
	 * 
	 */
	public Circle(String name) {
		this.name = name;
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		r = PanelDraw.r;
		click = false;
		this.setOpaque(false);
		this.setBackground(new Color(0,0,0,125));
		this.setBorder(BorderFactory.createEmptyBorder());
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (click) {
			g2.setColor(Color.RED);
			g2.fillOval(0, 0, r, r);
		} else {
			g2.setColor(Color.BLUE);
			g2.drawOval(0, 0, r, r);
		}

		int size = r + 1;
		g2.setColor(Color.BLACK);

		g2.drawString(name, (size - g2.getFont().getSize() + 5) / 2, (size + g2.getFont().getSize() - 2) / 2);
	}

	public boolean isCircle(int x, int y) {
		return getX() <= x && x <= getX() + getWidth() && getY() <= y && y <= getY() + getHeight();
	}

	/**
	 * @param click the click to set
	 */
	public void setClick(boolean click) {
		this.click = click;
		this.repaint();
	}

}
