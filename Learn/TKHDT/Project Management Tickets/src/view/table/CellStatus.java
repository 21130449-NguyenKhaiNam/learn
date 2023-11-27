package view.table;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.info.EnumStatusType;

/**
 * Đây là com đặc biệt được thêm vào trong bảng vì không thể vẽ trực tiếp
 */
public class CellStatus extends JPanel {

	private TableStatus status;

	public CellStatus(EnumStatusType type) {
		initComponents();
		status.setType(type);
	}

	private void initComponents() {

		status = new TableStatus();

		setBackground(new Color(255, 255, 255));

		status.setHorizontalAlignment(SwingConstants.CENTER);
		status.setText("Table Status");

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(10, Short.MAX_VALUE)
								.addComponent(status, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(10, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(8, 8, 8)
						.addComponent(status, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE).addGap(8, 8, 8)));
	}

}
