package view.general.main.home;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.lang.ProcessHandle.Info;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import control.observer.Observer;
import model.data.color.EnumColor;
import model.data.font.IDataFont;
import model.function.FunctionImg;
import model.management.general.AEmployee;
import model.management.staff.Work;
import view.card.Card;
import view.card.InfoCard;
import view.general.main.PanelBorder;
import view.scroll.ScrollBar;
import view.table.Table;

/**
 * Giao diện thể hiện thông tin cơ bản của các nhân viên, cũng là giao diện
 * chính khi mới vừa đăng nhập vào sẽ thấy của nhân viên đó
 */
public class Form_Home extends JPanel {
	private Table table;
	private Card card;

	/**
	 * @param listTale the listTale to set
	 */
	public void setListTale(String[] listTale) {
		table.setListTable(listTale.length - 1);
		table.setModel(new DefaultTableModel(null, listTale) {
			boolean[] canEdit = new boolean[listTale.length];

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
	}

	public Form_Home() {
		init();
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub

		card = new Card();

		JLayeredPane panel = new JLayeredPane();
		panel.setLayout(new GridLayout(1, 0, 10, 0));
		panel.add(card);

		JLabel titleTable = new JLabel();
		titleTable.setFont(IDataFont.HEADING); 
		titleTable.setForeground(new Color(127, 127, 127));
		titleTable.setText("Working");

		JScrollPane spTable = new JScrollPane();
		spTable.setBorder(BorderFactory.createEmptyBorder());
		spTable.setVerticalScrollBar(new ScrollBar());
		spTable.getVerticalScrollBar().setBackground(Color.WHITE);
		spTable.getViewport().setBackground(Color.WHITE);

		table = new Table();

		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);

		spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
		spTable.setViewportView(table);

		PanelBorder panelBorder = new PanelBorder();
		panelBorder.setBackground(EnumColor.White.color);

		GroupLayout panelBorderLayout = new GroupLayout(panelBorder);
		panelBorder.setLayout(panelBorderLayout);

		panelBorderLayout
				.setHorizontalGroup(panelBorderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(panelBorderLayout.createSequentialGroup().addGap(20, 20, 20)
								.addGroup(panelBorderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(panelBorderLayout.createSequentialGroup().addComponent(titleTable)
												.addGap(0, 0, Short.MAX_VALUE))
										.addComponent(spTable))
								.addContainerGap()));
		panelBorderLayout.setVerticalGroup(panelBorderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelBorderLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(titleTable)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(spTable, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE).addGap(20, 20, 20)));

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(20, 20, 20)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(panelBorder, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(panel, GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
								.addGap(20, 20, 20)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(20, 20, 20)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(20, 20, 20)
				.addComponent(panelBorder, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGap(20, 20, 20)));
	}

	private void init() {
		// TODO Auto-generated method stub
		setBackground(EnumColor.BackgroundFade.color);
	}

	// Thêm nội dung vào bảng
	public void addRow(Object[] objs) {
		table.addRow(objs);
	}

	public void clearTable() {
		this.table.clearTable();
	}

	public void setData(InfoCard data) {
		card.setData(data);
	}

}
