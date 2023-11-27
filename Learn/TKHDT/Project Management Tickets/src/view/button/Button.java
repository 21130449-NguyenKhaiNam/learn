package view.button;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import control.mouse.MouseMoveButton;
import model.data.color.EnumColor;

/**
 * Tạo ra một đối tượng nút bấm để sử dụng chung.
 */
public class Button extends JButton implements IButton {

	public Button(String text) {
		setText(text);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		setContentAreaFilled(false);
		setBorder(new EmptyBorder(5, 0, 5, 0));
		setColor(colorNormal);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setFocusable(false);
		addMouseListener(new MouseMoveButton(this, EnumColor.Focus1.color));
	}

	@Override
	protected void paintComponent(Graphics grphcs) {
		int width = getWidth();
		int height = getHeight();
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = img.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(getBackground());
		g2.fillRoundRect(0, 0, width, height, 5, 5);
		g2.dispose();
		grphcs.drawImage(img, 0, 0, null);
		super.paintComponent(grphcs);
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		setBackground(color);
		repaint();
	}

}
