package view.field;

import java.awt.Color;

import model.data.color.EnumColor;

/**
 * Các phương thức mà một trường nên có
 */
public interface IField {
	// Chiều cao để hiển thị thông tin bổ sung
	int spaceHelperText = 15;

	// Màu của đường viền khi hover
	Color lineColor = EnumColor.Focus1.color;

	// Thay đổi tên tiêu đề
	void setLabelText(String labelText);

	// Người dùng có đang bấm
	void setMouseOver(boolean mouseOver);

}
