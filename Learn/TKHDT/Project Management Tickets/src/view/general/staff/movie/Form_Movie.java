package view.general.staff.movie;

import java.awt.CardLayout;

import javax.swing.JPanel;

import model.data.color.EnumColor;
import view.general.staff.LbImg;
import view.layout.ICardLayout;

/**
 * Giao diện xem chi tiết về các bộ phim đồng thời cũng giúp quản lý xem các bộ
 * phim trong danh mục khác nhau
 */
public class Form_Movie extends JPanel implements ICardLayout {
	private CardLayout cardLayout;
	private Form_Movie_Detail panelDetail;
	private Form_SubMovie panelMovie;

	public Form_Movie() {
		init();
		initComponents();
	}

	private void init() {
		// TODO Auto-generated method stub
		setBackground(EnumColor.Transparent.color);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		panelMovie = new Form_SubMovie(this);

		panelDetail = new Form_Movie_Detail(this);

		cardLayout = new CardLayout();
		setLayout(cardLayout);

		add(panelMovie, "movie");
		add(panelDetail, "detail");
	}

	@Override
	public void next(String name) {
		// TODO Auto-generated method stub
		cardLayout.show(this, name);
	}

	@Override
	public void first() {
		// TODO Auto-generated method stub
		cardLayout.first(this);
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		this.cardLayout.next(this);
	}

	@Override
	public void previous() {
		// TODO Auto-generated method stub
		this.cardLayout.previous(this);
	}

	// Cập nhật bộ phim được chọn cho detail
	public void updateForDetail(LbImg item) {
		// TODO Auto-generated method stub
		panelDetail.updateForDetail(item);
		cardLayout.show(this, "detail");
	}

	public void filterMovie(String... type) {
		// TODO Auto-generated method stub
		panelMovie.filterMovie(type);
	}

}
