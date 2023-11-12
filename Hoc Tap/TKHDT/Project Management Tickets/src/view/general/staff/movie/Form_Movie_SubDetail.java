package view.general.staff.movie;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import view.general.staff.LbImg;

/**
 * Giao diện hỗ trợ cho giao diện chi tiết về bộ phim
 */
public class Form_Movie_SubDetail extends JPanel {
	private Form_Movie_Detail parent;

	private Form_Movie_SubDetail_Head head;
	private Form_Movie_SubDetail_Main main;

	public Form_Movie_SubDetail(Form_Movie_Detail parent) {
		this.parent = parent;
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		head = new Form_Movie_SubDetail_Head(this);

		main = new Form_Movie_SubDetail_Main();

		this.setLayout(new BorderLayout(5, 5));
		add(head, BorderLayout.NORTH);
		add(main, BorderLayout.CENTER);
	}

	// Yêu cầu cập nhật khi nhận được phim
	public void updateMovie(LbImg item) {
		// TODO Auto-generated method stub
		head.updateMovie(item);
		main.updateMovie(item);
	}

	// Head yêu cầu thay đổi giao diện
	public void changeViewDetail(String text) {
		// TODO Auto-generated method stub
		main.changeViewDetail(text);
	}

	// Quay về giao diện chọn phim
	public void previousMovie(String name) {
		// TODO Auto-generated method stub
		parent.previousMovie(name);
	}
}
