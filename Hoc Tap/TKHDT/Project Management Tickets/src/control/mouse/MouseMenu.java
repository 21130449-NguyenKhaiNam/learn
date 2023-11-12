package control.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

import view.menu.ListMenu;
import view.menu.ModelMenu;

/**
 * Các chức năng với chuột trên menu
 */
public class MouseMenu<E extends Object> implements MouseListener, MouseMotionListener {
	// Danh sách các phần tử được áp dụng
	private ListMenu<E> listMenu;

	public MouseMenu(ListMenu<E> listMenu) {
		this.listMenu = listMenu;
	}

	@Override
	public void mousePressed(MouseEvent me) {
		if (SwingUtilities.isLeftMouseButton(me)) {
			int index = listMenu.locationToIndex(me.getPoint());
			Object o = listMenu.getModel().getElementAt(index);
			if (o instanceof ModelMenu) {
				ModelMenu menu = (ModelMenu) o;
				if (menu.getType() == ModelMenu.MenuType.MENU) {
					listMenu.setSelectedIndex(index);
					EventMenuSelected event = listMenu.getEvent();
					if (event != null) {
						event.selected(menu);
					}
				}
			} else {
				listMenu.setSelectedIndex(index);
			}
			listMenu.repaint();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		listMenu.setOverIndex(-1);
		listMenu.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent me) {
		int index = listMenu.locationToIndex(me.getPoint());
		if (index != listMenu.getOverIndex()) {
			Object o = listMenu.getModel().getElementAt(index);
			if (o instanceof ModelMenu) {
				ModelMenu menu = (ModelMenu) o;
				if (menu.getType() == ModelMenu.MenuType.MENU) {
					listMenu.setOverIndex(index);
				} else {
					listMenu.setOverIndex(-1);
				}
				listMenu.repaint();
			}
		}
	}

}
