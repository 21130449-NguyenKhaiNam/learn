package view.general.staff.history;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import control.observer.Observer;
import database.Database;
import model.data.color.EnumColor;
import model.data.font.IDataFont;
import model.management.general.AEmployee;
import model.ticket.Ticket;
import view.general.main.PanelBorder;
import view.scroll.ScrollBar;
import view.table.Table;

/**
 * Giao diện ghi lại lịch sử thanh toán
 */
public class Form_History extends JPanel implements Observer {
	private Map<String, List<String[]>> map;
	private Table table;
	private AEmployee emCurr;

	public Form_History() {
		init();
		initComponents();
	}

	public void setEmCurr(AEmployee emCurr) {
		this.emCurr = emCurr;
		updateHistory(null);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		map = new HashMap<>();

		JLabel titleTable = new JLabel();
		titleTable.setFont(IDataFont.HEADING);
		titleTable.setForeground(new Color(127, 127, 127));
		titleTable.setText("History");

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

		String[] listTale = { "Date", "Movie", "Price" };

		table.setListTable(-1);
		table.setModel(new DefaultTableModel(null, listTale) {
			boolean[] canEdit = new boolean[listTale.length];

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

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
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(panelBorder,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(panelBorder,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		updateStaff(Database.getStaffs());
	}

	private void init() {
		// TODO Auto-generated method stub
		setOpaque(false);
	}

	public void updateStaff(List<?> ems) {
		for (Object em : ems) {
			AEmployee ae = (AEmployee) em;
			map.put(ae.getId(), new ArrayList<>());
		}
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method
		Ticket ticket = (Ticket) obj;
		// Vé được đảm bảo xuất ra chưa
		if (ticket.isCheck()) {
			updateHistory(ticket);
		}
	}

	public void updateHistory(Ticket ticket) {
		table.clearTable();
		List<String[]> listStrs = map.get(emCurr.getId());
		if (ticket != null) {
			listStrs.add(new String[] { ticket.getDate(), ticket.getNameMovie(), ticket.getPrice() + "" });
		}
		for (String[] strings : listStrs) {
			table.addRow(strings);
		}
	}
}
