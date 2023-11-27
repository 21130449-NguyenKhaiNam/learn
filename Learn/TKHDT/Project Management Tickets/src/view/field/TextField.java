package view.field;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.mouse.MouseMoveField;
import model.data.color.EnumColor;

public class TextField extends JTextField implements IField {
	private boolean mouseOver = false;
	private String labelText = "Label";

	public TextField() {
		init();

	}

	private void init() {
		// TODO Auto-generated method stub
		setLabelText("User name");
		setBorder(new EmptyBorder(20, 3, 23, 3));
		setSelectionColor(new Color(76, 204, 255));
		addMouseListener(new MouseMoveField(this));
	}

	@Override
	public void paint(Graphics grphcs) {
		super.paint(grphcs);
		Graphics2D g2 = (Graphics2D) grphcs;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
		int width = getWidth();
		int height = getHeight();
		if (mouseOver) {
			g2.setColor(lineColor);
		} else {
			g2.setColor(new Color(150, 150, 150));
		}
		g2.fillRect(2, height - spaceHelperText - 1, width - 4, 1);
		createHintText(g2);
		g2.dispose();
	}

	private void createHintText(Graphics2D g2) {
		Insets in = getInsets();
		g2.setColor(new Color(150, 150, 150));
		FontMetrics ft = g2.getFontMetrics();
		Rectangle2D r2 = ft.getStringBounds(labelText, g2);
		double height = getHeight() - in.top - in.bottom;
		double textY = (height - r2.getHeight()) / 2;
		double size;
		size = 18;
		g2.drawString(labelText, in.right, (int) (in.top + textY + ft.getAscent() - size));
	}

	@Override
	public void setMouseOver(boolean mouseOver) {
		// TODO Auto-generated method stub
		this.mouseOver = mouseOver;
		repaint();
	}

	@Override
	public void setLabelText(String labelText) {
		// TODO Auto-generated method stub
		this.labelText = labelText;
	}

}
