package view.field;

import javax.swing.JTextArea;

/**
 * Điều chỉnh khu vực hiển thị văn bản dài. Nếu vượt quá ký tự tối đa nó sẽ tự
 * động đổ xuống dòng, giúp hạn chế việc mất nội dung khi đổ thông thường
 */
public class TextArea extends JTextArea {

	public TextArea() {
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		setEditable(false);
		setLineWrap(true);
	}

}
