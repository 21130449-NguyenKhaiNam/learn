package view.dialog;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import model.data.color.EnumColor;
import model.data.size.EnumSize;

/**
 * Tạo nền cho dialog
 */
public class BackgroundDialog extends JPanel {

	public BackgroundDialog() {
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		setOpaque(false);
		setBackground(EnumColor.White.color);
		setForeground(EnumColor.Text.color);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int w = getWidth();
		int h = getHeight();
		int x = 0;
		int y = EnumSize.HeightTitle.size;
		int iconSpace = 7;
		int totalIconSpace = iconSpace * 2;
		int iconSize = y * 2;
		int iconX = (w - (iconSize + totalIconSpace)) / 2;
		int iconY = 0;
		Area area = new Area(new Rectangle2D.Double(x, y, w, h - y));
		area.subtract(new Area(
				new Ellipse2D.Double(iconX, iconY - iconSpace, iconSize + totalIconSpace, iconSize + totalIconSpace)));
		area.add(new Area(new Ellipse2D.Double(iconX + iconSpace, 0, iconSize, iconSize)));
		g2.setColor(getBackground());
		g2.fill(area);
		g2.dispose();
		super.paintComponent(g);
	}

}
