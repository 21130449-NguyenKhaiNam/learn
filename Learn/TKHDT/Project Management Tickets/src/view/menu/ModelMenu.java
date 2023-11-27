package view.menu;

import java.awt.Image;

import javax.swing.ImageIcon;

import model.function.FunctionImg;

/**
 * Định nghĩa một phần tử menu
 */
public class ModelMenu {
	// Logo
	private Image icon;

	// Tên
	private String name;

	// Loại
	private MenuType type;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public ModelMenu(Image icon, String name, MenuType type) {
		this.icon = icon;
		this.name = name;
		this.type = type;
	}

	public static enum MenuType {
		TITLE, MENU, EMPTY
	}

	public MenuType getType() {
		return type;
	}

	public void setType(MenuType type) {
		this.type = type;
	}

	// Lấy hình ảnh theo một kích thước cố định
	public ImageIcon getImg() {
		// TODO Auto-generated method stub
		return FunctionImg.scaleImg(icon, 20, 20);
	}

}
