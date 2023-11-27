package control.mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.field.IField;

/**
 * Cho biết khi nào người dùng di chuyển vào trường dữ liệu
 */
public class MouseMoveField extends MouseAdapter{
	private IField textField;

	/**
	 * @param textField
	 */
	public MouseMoveField(IField textField) {
		this.textField = textField;
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		textField.setMouseOver(true);
	}

	@Override
	public void mouseExited(MouseEvent me) {
		textField.setMouseOver(false);
	}

}
