package view.general.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

/**
 * Vẽ ra viền và cũng có thể là phần tử chứa trung gian của các giao diện khác
 */
public class PanelBorder extends JPanel {
	public PanelBorder() {
		init();
		initComponents();
	}

	private void init() {
		// TODO Auto-generated method stub
		setOpaque(false);
	}

	private void initComponents() {
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 361, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 197, Short.MAX_VALUE));
	}

	@Override
	protected void paintComponent(Graphics grphcs) {
		Graphics2D g2 = (Graphics2D) grphcs;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(getBackground());
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
		super.paintComponent(grphcs);
	}
}
