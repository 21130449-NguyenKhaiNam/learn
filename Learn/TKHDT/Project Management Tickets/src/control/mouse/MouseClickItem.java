package control.mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.general.staff.IUpdateMovie;
import view.general.staff.LbImg;

/**
 * Xử lý việc cập nhật khi chọn phim
 */
public class MouseClickItem extends MouseAdapter {
	private IUpdateMovie main;

	public MouseClickItem(IUpdateMovie main) {
		this.main = main;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		LbImg item = (LbImg) e.getSource();
		main.updateClickMovie(item);
	}

}
