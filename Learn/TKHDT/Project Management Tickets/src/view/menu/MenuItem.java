package view.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.data.color.EnumColor;

/**
 * Phần tử item của menu
 */
public class MenuItem extends JPanel {
	// Hình ảnh
	private JLabel lbIcon;

	// Tên
	private JLabel lbName;

	// Có chọn
	private boolean selected;

	// Có di chuột vào
	private boolean over;

	public MenuItem(ModelMenu data) {
		init();
		initComponents();
		if (data.getType() == ModelMenu.MenuType.MENU) {
			lbIcon.setIcon(data.getImg());
			lbName.setText(data.getName());
		} else if (data.getType() == ModelMenu.MenuType.TITLE) {
			lbIcon.setText(data.getName());
			lbIcon.setFont(new Font("sansserif", 1, 12));
			lbName.setVisible(false);
		} else {
			lbName.setText(" ");
		}
	}

	private void init() {
		// TODO Auto-generated method stub
		setOpaque(false);
	}

	// Có đang chọn nó
	public void setSelected(boolean selected) {
		this.selected = selected;
		repaint();
	}

	// Có đang di chuột qua nó
	public void setOver(boolean over) {
		this.over = over;
		repaint();
	}

	private void initComponents() {
		lbIcon = new JLabel();
		lbIcon.setForeground(EnumColor.White.color);

		lbName = new JLabel();
		lbName.setForeground(EnumColor.White.color);
		lbName.setText("Menu Name");

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(lbIcon).addGap(18, 18, 18)
						.addComponent(lbName).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(lbIcon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(lbName, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE));
	}

	@Override
	protected void paintComponent(Graphics grphcs) {
		if (selected || over) {
			Graphics2D g2 = (Graphics2D) grphcs;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			if (selected) {
				g2.setColor(new Color(255, 255, 255, 80));
			} else {
				g2.setColor(new Color(255, 255, 255, 20));
			}
			g2.fillRoundRect(10, 0, getWidth() - 20, getHeight(), 5, 5);
		}
		super.paintComponent(grphcs);
	}

}
