package model.info;

import java.awt.Image;

/**
 * Định nghĩa chung cho các lớp biểu thị thông tin trạng thái của đối tượng
 */
public interface Info {
	// Lấy hình ảnh
	Image getImg();

	// Trả về đối tượng đang sử dụng
	Info getInfo();

}
