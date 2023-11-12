package view.field;

import javax.swing.JTextField;

/**
 * Lấy các trường ghi
 */
public interface IFactoryField {
	// Lấy trường ghi hiện có 2 loại: thông thường và mật khẩu
	JTextField getField(String name);
}
