package view.table;

import java.awt.Color;
import java.awt.Component;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import model.info.EnumStatusType;

/**
 * Tự định nghĩa ra một bảng riêng
 */
public class Table extends JTable {
	// Điểm kết thúc của bạn
	private int endIndex;

	public Table() {

	}

	public void setListTable(int endIndex) {
		this.endIndex = endIndex;
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		setShowHorizontalLines(true);
		setGridColor(new Color(230, 230, 230));
		setRowHeight(40);
		getTableHeader().setReorderingAllowed(false);
		getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i,
					int i1) {
				TableHeader header = new TableHeader(o + "");
				if (i1 == endIndex) {
					header.setHorizontalAlignment(JLabel.CENTER);
				}
				return header;
			}
		});
		setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1,
					int i, int i1) {
				if (endIndex + 1 > 1 && i1 != endIndex || endIndex < 0) {
					Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
					com.setBackground(Color.WHITE);
					setBorder(noFocusBorder);
					if (selected) {
						com.setForeground(new Color(15, 89, 140));
					} else {
						com.setForeground(new Color(102, 102, 102));
					}
					return com;
				} else {
					EnumStatusType type = (EnumStatusType) o;
					CellStatus cell = new CellStatus(type);
					return cell;
				}
			}
		});
	}

	// Thêm dòng vào bảng
	public void addRow(Object[] row) {
		if (row.length == endIndex + 1 || endIndex < 0) {
			DefaultTableModel model = (DefaultTableModel) getModel();
			model.addRow(row);
		} else {
			System.out.println("So dong nhap vao khong hop le");
		}
	}

	// Dọn sạch thông tin trên bảng
	public void clearTable() {
		// TODO Auto-generated method stub
		DefaultTableModel model = (DefaultTableModel) getModel();
		model.setRowCount(0);
	}
}
