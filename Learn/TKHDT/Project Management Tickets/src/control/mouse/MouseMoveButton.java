package control.mouse;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.button.IButton;

/**
 * Nhận vào tác động của người dùng đến nút bấm
 */
public class MouseMoveButton extends MouseAdapter {
	private IButton btn;
	private Color hoverColor;

	/**
	 * @param btn
	 */
	public MouseMoveButton(IButton btn, Color color) {
		this.btn = btn;
		this.hoverColor = color;
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		btn.setColor(hoverColor);
	}

	@Override
	public void mouseExited(MouseEvent me) {
		btn.setColor(IButton.colorNormal);
	}

}
