package view.general.staff.sale;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;

import model.data.color.EnumColor;

/**
 * Định nghĩa về đối tượng ghế hiển thị trên giao diện
 */
public class BtnChair extends JButton {
	private Chair chair;

	/**
	 * @return the chair
	 */
	public Chair getChair() {
		return chair;
	}

	public BtnChair(Chair chair) {
		this.chair = chair;
		init();
		iniComponents();
	}

	private void iniComponents() {
		// TODO Auto-generated method stub
		setFont(new Font("sansserif", 1, 14));
		setText(chair.getName());
	}

	private void init() {
		// TODO Auto-generated method stub
		setBackground(EnumColor.UnSeated.color);
		setFocusable(false);
		setBorderPainted(false);
	}

}
