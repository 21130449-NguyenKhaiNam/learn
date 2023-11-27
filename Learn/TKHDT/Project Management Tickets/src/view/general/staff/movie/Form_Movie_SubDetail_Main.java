package view.general.staff.movie;

import java.awt.CardLayout;

import javax.swing.JPanel;

import view.general.staff.LbImg;
import view.layout.ICardLayout;

/**
 * Giao diện trung tâm cho phần chi tiết bộ phim
 */
public class Form_Movie_SubDetail_Main extends JPanel implements ICardLayout {
	private CardLayout cardLayout;

	private Form_Movie_SubDetail_Overview overview;
	private Form_Movie_SubDetail_Time showTime;

	public Form_Movie_SubDetail_Main() {
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		overview = new Form_Movie_SubDetail_Overview();

		showTime = new Form_Movie_SubDetail_Time();

		cardLayout = new CardLayout();

		this.setLayout(cardLayout);

		this.add(overview, "overview");
		this.add(showTime, "showtimes");
	}

	// Yêu cầu các phần tử tương ứng cập nhật thông tin về bộ phim được chọn
	public void updateMovie(LbImg item) {
		// TODO Auto-generated method stub
		overview.updateMovie(item);
		showTime.updateMovie(item);
	}

	// Thay đổi giao diện khi được yêu cầu
	public void changeViewDetail(String nameLayout) {
		// TODO Auto-generated method stub
		next(nameLayout);
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub

	}

	@Override
	public void previous() {
		// TODO Auto-generated method stub

	}

	@Override
	public void first() {
		// TODO Auto-generated method stub

	}

	@Override
	public void next(String nameLayout) {
		// TODO Auto-generated method stub
		this.cardLayout.show(this, nameLayout);
	}
}
