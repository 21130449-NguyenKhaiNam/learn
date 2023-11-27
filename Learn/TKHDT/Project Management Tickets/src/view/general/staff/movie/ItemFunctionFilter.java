package view.general.staff.movie;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Bộ lọc khi lựa chọn thông tin về phim
 */
public class ItemFunctionFilter extends JPanel {
	// Tên
	private String name;

	// Nội dung bộ lọc
	private JComboBox<String> filter;

	public ItemFunctionFilter(String name, String[] listFilter) {
		this.name = name;
		this.filter = new JComboBox<>(listFilter);
		init();
		initComponents();
	}

	private void init() {
		// TODO Auto-generated method stub
		setOpaque(false);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setLayout(new BorderLayout(10, 10));

		JLabel lbName = new JLabel(name);

		filter.setName(name);

		add(lbName, BorderLayout.WEST);
		add(filter, BorderLayout.CENTER);
	}

	public void setInfoFilter(List<String> list) {
		filter.removeAllItems();
		for (String str : list)
			filter.addItem(str);
		filter.setSelectedIndex(-1);
		filter.addItem("");
	}

	public void setAction(ActionListener ac) {
		// TODO Auto-generated method stub
		filter.addActionListener(ac);
	}
}
