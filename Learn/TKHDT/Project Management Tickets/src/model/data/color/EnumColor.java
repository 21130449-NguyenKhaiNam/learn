package model.data.color;

import java.awt.Color;

/**
 * Các thông số về màu hay sử dụng
 */
public enum EnumColor {
	Button(new Color(124, 215, 245)), Seated(new Color(52, 44, 44)), UnSeated(new Color(189, 63, 46)),
	Choose(new Color(215, 44, 138)), Border(new Color(79, 112, 173)), BackgroundFade(new Color(242, 242, 242)),
	White(new Color(255, 255, 255)), Focus1(Color.decode("#1CB5E0")), Focus2(Color.decode("#000046")),
	Focus3(new Color(38, 170, 241)), Focus4(new Color(124, 215, 245)), Focus5(new Color(183, 233, 248)),
	Black(Color.BLACK), Text(Color.decode("#202124")), Transparent(new Color(0, 0, 0, 0)),
	ClickChair(Color.decode("#dbdbdb"));

	public Color color;

	/**
	 * @param c
	 */
	private EnumColor(Color c) {
		this.color = c;
	}

}
