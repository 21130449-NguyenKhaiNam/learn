package view.general.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import control.mouse.EventMenuSelected;
import control.observer.Observer;
import model.data.color.EnumColor;
import model.data.size.EnumSize;
import view.menu.FactoryMenu;
import view.menu.IFactoryMenu;
import view.menu.ListMenu;
import view.menu.ModelMenu;
import view.menu.PanelMenu;

/**
 * Định nghĩa chung về giao diện cho cả user và admin
 */
public abstract class APanelGeneral extends JPanel implements Observer {
	// Giao diện về menu
	private PanelMenu panelMenu;

	// Giao diện tương tác chính
	private JPanel panelMain;

	// Vẽ viền giao diện
	private PanelBorder panelBorder;

	// Tùy đối tượng sẽ có cách tạo menu khác nhau
	protected static IFactoryMenu factoryMenu = new FactoryMenu();

	public APanelGeneral(ListMenu<ModelMenu> menu) {
		this.panelMenu = new PanelMenu(menu);
		init();
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		panelBorder = new PanelBorder();

		// Header
		PanelHeader header = new PanelHeader();
		header.register(this);
		header.setPreferredSize(
				new Dimension(EnumSize.ScreenWidth.size - EnumSize.WidthMenu.size, EnumSize.HeightTitle.size));

		// Main
		panelMain = new JPanel();
		panelMain.setOpaque(false);
		panelMain.setLayout(new BorderLayout());

		panelBorder.setBackground(EnumColor.BackgroundFade.color);

		// Cấu trúc của chương trình
		GroupLayout panelBorderLayout = new GroupLayout(panelBorder);
		panelBorder.setLayout(panelBorderLayout);
		panelBorderLayout.setHorizontalGroup(panelBorderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelBorderLayout.createSequentialGroup()
						.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(panelBorderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(header, GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
								.addGroup(panelBorderLayout
										.createSequentialGroup().addGap(6, 6, 6).addComponent(panelMain,
												GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap()))));
		panelBorderLayout.setVerticalGroup(panelBorderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
				.addGroup(panelBorderLayout.createSequentialGroup()
						.addComponent(header, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(panelMain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		// Thêm đối tượng vào chương trình chính
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(panelBorder,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(panelBorder,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		addEventMenu();
	}

	// Tự cấu hình việc nhấn phần tử nào hiển thị layout nào
	public abstract void addEventMenu();

	private void init() {
		// TODO Auto-generated method stub
		setBackground(new Color(0, 0, 0, 0));
	}

	/**
	 * Cập nhật lại tùy lựa chọn sẽ hiển thị giao diện đó
	 */
	public void setForm(JComponent com) {
		panelMain.removeAll();
		panelMain.add(com);
		panelMain.repaint();
		panelMain.revalidate();
	}

	// Thêm sự kiện bấm nút thay đổi form cho menu
	public void addEventMenu(EventMenuSelected event) {
		this.panelMenu.addEventMenuSelected(event);
	}

}
