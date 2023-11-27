package view.menu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

import control.mouse.EventMenuSelected;
import control.mouse.MouseMenu;

/**
 * Nơi chứa các phần tử item trong menu
 */
public class ListMenu<E extends Object> extends JList<E> {

	// Mặc định chung
	private final DefaultListModel model;

	// Có chọn
	private int selectedIndex = 0;

	// Có di chuyển chuột qua
	private int overIndex = -1;

	// Sự kiện khi nhấn sẽ thay đổi giao diện trên general
	private EventMenuSelected event;

	/**
	 * @return the model
	 */
	public DefaultListModel getModel() {
		return model;
	}

	/**
	 * @param selectedIndex the selectedIndex to set
	 */
	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
		
	}

	/**
	 * @return the overIndex
	 */
	public int getOverIndex() {
		return overIndex;
	}

	/**
	 * @param overIndex the overIndex to set
	 */
	public void setOverIndex(int overIndex) {
		this.overIndex = overIndex;
	}

	/**
	 * @return the event
	 */
	public EventMenuSelected getEvent() {
		return event;
	}

	public ListMenu() {
		model = new DefaultListModel();
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setModel(model);
		MouseMenu<E> mouseMenu = new MouseMenu<>(this);
		addMouseListener(mouseMenu);
		addMouseMotionListener(mouseMenu);
	}

	@Override
	public ListCellRenderer<? super E> getCellRenderer() {
		return new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected,
					boolean focus) {
				ModelMenu data;
				if (o instanceof ModelMenu) {
					data = (ModelMenu) o;
				} else {
					data = new ModelMenu(null, o + "", ModelMenu.MenuType.EMPTY);
				}
				MenuItem item = new MenuItem(data);
				item.setSelected(selectedIndex == index);
				item.setOver(overIndex == index);
				return item;
			}

		};
	}

	/**
	 * Thêm phần tử cho menu
	 */
	public void addItem(ModelMenu data) {
		model.addElement(data);
	}

	// Thêm sự kiện nhấn trên menu thay đổi trên general
	public void addEventMenuSelected(EventMenuSelected event) {
		this.event = event;
	}

}
