package view.card;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import model.data.color.EnumColor;
import model.data.img.GetImage;

/**
 * Hiển thị của card trên màn hình
 */
public class Card extends JPanel {
	// Các nội dung có trên card
	private JLabel lbDescription;
	private JLabel lbIcon;
	private JLabel lbTitle;
	private JLabel lbValues;

	// màu đổ trên nền
	private Color color1;
	private Color color2;

	public Card() {
		init();
		initComponents();
	}

	private void init() {
		// TODO Auto-generated method stub
		setOpaque(false);
	}

	public void setData(InfoCard data) {
		lbIcon.setIcon(data.getIcon());
		lbTitle.setText(data.getTitle());
		lbValues.setText(data.getValues());
		lbDescription.setText(data.getDescription());
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		color1 = new Color(142, 142, 250);
		color2 = new Color(123, 123, 245);

		lbIcon = new JLabel();
		lbTitle = new JLabel();
		lbValues = new JLabel();
		lbDescription = new JLabel();

		lbIcon.setIcon(new ImageIcon(GetImage.getImgError(0)));

		lbTitle.setFont(new Font("sansserif", 1, 20));
		lbTitle.setHorizontalAlignment(JLabel.CENTER);
		lbTitle.setForeground(EnumColor.White.color);
		lbTitle.setText("Title");

		lbValues.setFont(new Font("sansserif", 1, 18));
		lbValues.setHorizontalAlignment(JLabel.CENTER);
		lbValues.setForeground(EnumColor.White.color);
		lbValues.setText("Values");

		lbDescription.setFont(new Font("sansserif", 1, 16));
		lbDescription.setHorizontalAlignment(JLabel.CENTER);
		lbDescription.setForeground(EnumColor.White.color);
		lbDescription.setText("Description");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 3));
		panel.setOpaque(false);
		panel.add(lbTitle);
		panel.add(lbValues);
		panel.add(lbDescription);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(lbIcon, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(lbIcon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

	}

	@Override
	protected void paintComponent(Graphics grphcs) {
		Graphics2D g2 = (Graphics2D) grphcs;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint g = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
		g2.setPaint(g);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		g2.setColor(new Color(255, 255, 255, 50));
		g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
		g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
		super.paintComponent(grphcs);
	}
}
