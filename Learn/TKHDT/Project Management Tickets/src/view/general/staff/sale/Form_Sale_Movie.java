package view.general.staff.sale;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import model.data.color.EnumColor;
import model.movie.InfoMovie;
import view.general.main.PanelBorder;
import view.general.staff.LbImg;

/**
 * Phần bán hàng cụ thể là phần chọn phim
 */
public class Form_Sale_Movie extends JPanel {
	// Một số chức năng class con không làm được
	private Form_Sale parent;

	// Giao diện toàn chương trình chọn phim
	private Form_Sale_SubMovie panelInfo;

	/**
	 * @return the panelInfo
	 */
	public Form_Sale_SubMovie getPanelInfo() {
		return panelInfo;
	}

	public Form_Sale_Movie(Form_Sale parent) {
		this.parent = parent;
		init();
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		panelInfo = new Form_Sale_SubMovie(parent);

		PanelBorder background = new PanelBorder();

		GroupLayout backgroundLayout = new GroupLayout(background);
		background.setLayout(backgroundLayout);
		backgroundLayout.setHorizontalGroup(backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(backgroundLayout.createSequentialGroup().addContainerGap()
						.addGroup(backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(
								panelInfo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		backgroundLayout
				.setVerticalGroup(backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(backgroundLayout.createSequentialGroup().addContainerGap()
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(panelInfo,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap()));

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(background,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(background,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
	}

	private void init() {
		// TODO Auto-generated method stub
		setBackground(EnumColor.Transparent.color);
	}

	public void next(String name) {
		parent.next(name);
	}

	public void updateMovieClick(InfoMovie info) {
		// TODO Auto-generated method stub
		LbImg lbImg = new LbImg(info, 200, 200);
		panelInfo.updateClickMovie(lbImg);
	}

}
