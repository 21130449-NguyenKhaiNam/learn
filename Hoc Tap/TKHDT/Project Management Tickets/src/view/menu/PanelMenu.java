package view.menu;

import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.mouse.EventMenuSelected;
import model.data.color.EnumColor;
import model.data.img.GetImage;
import model.data.size.EnumSize;
import model.function.FunctionImg;

/**
 * Giao diện menu chung
 */
public class PanelMenu extends JPanel {
	// Cấu trúc menu
	private JPanel panelMoving;
	
	// Danh sách các mục item
	private ListMenu<ModelMenu> listMenu;
	
	// Logo của menu
	private JLabel logo;
	
	// Sự kiện khi nhấn vào phần tử nào đó trên menu
	private EventMenuSelected event;

	public PanelMenu(ListMenu<ModelMenu> listMenu) {
		this.listMenu = listMenu;
		initComponents();
		init();
	}

	// Thêm sự kiện nhấn cho mennu
	public void addEventMenuSelected(EventMenuSelected event) {
		this.event = event;
		listMenu.addEventMenuSelected(this.event);
	}

	/**
	 * Them cac phan tu o menu
	 */
	private void init() {
		// TODO Auto-generated method stub
		setOpaque(false);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		logo = new JLabel();
		logo.setFont(new Font("sansserif", 1, 18));
		logo.setForeground(EnumColor.White.color);
		logo.setIcon(FunctionImg.scaleImg(GetImage.getImgMenu(0), 50, 50));
		logo.setText("STATISTICAL");

		panelMoving = new JPanel();
		panelMoving.setOpaque(false);

		listMenu.setOpaque(false);

		GroupLayout panelMovingLayout = new GroupLayout(panelMoving);
		panelMoving.setLayout(panelMovingLayout);
		panelMovingLayout.setHorizontalGroup(panelMovingLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelMovingLayout.createSequentialGroup().addContainerGap()
						.addComponent(logo, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE).addContainerGap()));
		panelMovingLayout.setVerticalGroup(panelMovingLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup().addGap(15, 15, 15)
						.addComponent(logo).addContainerGap()));

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(panelMoving, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(listMenu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(panelMoving, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(15, 15, 15).addComponent(listMenu, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)));
	}

	@Override
	protected void paintChildren(Graphics grphcs) {
		Graphics2D g2 = (Graphics2D) grphcs;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint g = new GradientPaint(0, 0, EnumColor.Focus1.color, 0, getHeight(), EnumColor.Focus2.color);
		g2.setPaint(g);
		g2.fillRoundRect(0, 0, EnumSize.ScreenWidth.size, EnumSize.ScreenHeight.size, 0, 0);
		super.paintChildren(grphcs);
	}
}
