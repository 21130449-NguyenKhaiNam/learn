package view.general.staff.movie;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.data.color.EnumColor;
import model.data.font.IDataFont;
import view.field.TextArea;
import view.scroll.ScrollBar;

/**
 * Phần tử thời gian hiển thị trên màn hình
 */
public class CardTime extends JPanel {
	private JLabel head;
	private TextArea textArea;

	public CardTime(String day) {
		init();
		initComponents();
		setTitle(day);
	}

	public void setTitle(String text) {
		head.setText(text);
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setBackground(EnumColor.Focus1.color);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		this.setLayout(new BorderLayout());

		head = new JLabel("Day");
		head.setHorizontalAlignment(JLabel.CENTER);
		head.setFont(IDataFont.HEADING);

		textArea = new TextArea();
		JScrollPane scroll = new JScrollPane();
		scroll.setVerticalScrollBar(new ScrollBar());
		scroll.setHorizontalScrollBar(new ScrollBar());
		scroll.setViewportView(textArea);

		this.add(head, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
	}

	public String getTitle() {
		return head.getText();
	}

	public void setDate(String text) {
		textArea.setText(text);
	}

}
