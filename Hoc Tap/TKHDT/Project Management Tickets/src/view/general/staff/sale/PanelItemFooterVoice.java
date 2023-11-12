package view.general.staff.sale;

import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.data.font.IDataFont;

/**
 * Phần tử ở cuối hóa đơn
 */
public class PanelItemFooterVoice extends JPanel {
	private JLabel lbRight;
	private JLabel lbLeft;
	private List<JLabel> list;

	public PanelItemFooterVoice() {
		init();
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		lbLeft = new JLabel();
		lbLeft.setHorizontalAlignment(JLabel.LEFT);

		lbRight = new JLabel();
		lbRight.setHorizontalAlignment(JLabel.RIGHT);

		list = Arrays.asList(lbLeft, lbRight);

		for (JLabel lb : list)
			lb.setFont(IDataFont.MEDIUM_TITLE);

		this.setLayout(new GridLayout(1, 0));
		add(lbLeft);
		add(lbRight);
	}

	private void init() {
		// TODO Auto-generated method stub
		setOpaque(false);
	}

	// Thêm nội dung bình thường: 2 phía
	public void setContent(String name, String total) {
		resestItem();
		lbLeft.setText(name + ": ");
		lbRight.setText(total);
	}

	// Thêm nội dung kiểu ghi chú: 1 phía
	public void setContent(String note) {
		resestItem();
		lbLeft.setText("*Note: " + note);
		lbLeft.setHorizontalAlignment(JLabel.CENTER);
		lbLeft.setFont(IDataFont.MIN_TITLE);
		lbRight.setVisible(false);
		this.remove(lbRight);
	}

	// Khởi tạo lại các phần tử
	private void resestItem() {
		lbLeft.setHorizontalAlignment(JLabel.LEFT);

		lbRight.setHorizontalAlignment(JLabel.RIGHT);

		for (JLabel lb : list) {
			lb.setFont(IDataFont.MEDIUM_TITLE);
			lb.setVisible(true);
		}

		this.setLayout(new GridLayout(1, 0));
		add(lbLeft);
		add(lbRight);
	}
}
