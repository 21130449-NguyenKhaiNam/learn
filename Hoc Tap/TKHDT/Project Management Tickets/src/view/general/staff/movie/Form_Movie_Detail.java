package view.general.staff.movie;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import view.general.main.PanelBorder;
import view.general.staff.LbImg;

/**
 * Giao diện chi tiết về một bộ phim
 */
public class Form_Movie_Detail extends JPanel {
	private Form_Movie_SubDetail panelDetail;

	private Form_Movie parent;

	public Form_Movie_Detail(Form_Movie parent) {
		this.parent = parent;
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		panelDetail = new Form_Movie_SubDetail(this);

		PanelBorder background = new PanelBorder();

		GroupLayout backgroundLayout = new GroupLayout(background);
		background.setLayout(backgroundLayout);
		backgroundLayout.setHorizontalGroup(backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(backgroundLayout.createSequentialGroup().addContainerGap()
						.addGroup(backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(
								panelDetail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		backgroundLayout
				.setVerticalGroup(backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(backgroundLayout.createSequentialGroup().addContainerGap()
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(panelDetail,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap()));

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(background,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(background,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
	}

	// Cập nhật thông tin chi tiết khi nhận được yêu cầu
	public void updateForDetail(LbImg item) {
		// TODO Auto-generated method stub
		panelDetail.updateMovie(item);
	}

	// Kêu phần tử cha chuyển về giao diện trước đó
	public void previousMovie(String name) {
		// TODO Auto-generated method stub
		parent.next(name);
	}

}
