package view.main;

import javax.swing.JPanel;

/**
 * Để frame sử dụng lấy ra các general tương ứng mà nó muốn
 */
public interface IFactoryGeneral {

	// Lấy general dựa vào tên
	JPanel getGeneral(String name);

}
