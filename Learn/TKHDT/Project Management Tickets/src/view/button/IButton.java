package view.button;

import java.awt.Color;

import model.data.color.EnumColor;

/**
 * Định nghĩa các phương thức phải có khi tự viết lại button
 */
public interface IButton {
	// Màu sắc mặc định nếu không thay đổi màu
	Color colorNormal = EnumColor.Button.color;

	// Thiệt lập màu
	void setColor(Color color);

}
