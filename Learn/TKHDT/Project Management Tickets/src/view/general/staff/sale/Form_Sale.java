package view.general.staff.sale;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.observer.Observer;
import control.observer.Subject;
import model.data.size.EnumSize;
import model.movie.InfoMovie;
import view.dialog.ErrorDialog;
import view.layout.ICardLayout;
import view.layout.IDataLayout;

/**
 * Giao diện bán vé xem phim
 */
public class Form_Sale extends JPanel implements ICardLayout {
	private CardLayout cardLayout;

	// Các form có trong phần bán vé
	private Form_Sale_Movie form_movie;
	private Form_Sale_Cinema form_cinema;
	private Form_Sale_Ticket form_ticket;

	// Layout đang đứng
	private int locationLayout;

	// Đếm số layout có trong chương trình
	private int countLayout;

	/**
	 * @return the locationLayout
	 */
	public int getLocationLayout() {
		return locationLayout;
	}

	/**
	 * @return the countLayout
	 */
	public int getCountLayout() {
		return countLayout;
	}

	/**
	 * @return the form_movie
	 */
	public Form_Sale_Movie getMovies() {
		return form_movie;
	}

	/**
	 * @return the form_cinema
	 */
	public Form_Sale_Cinema getCinema() {
		return form_cinema;
	}

	/**
	 * @return the form_ticket
	 */
	public Form_Sale_Ticket getTicket() {
		return form_ticket;
	}

	public Form_Sale() {
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		// Mặc định vị trí đứng là layout chọn phim
		locationLayout = 1;
		countLayout = 0;

		cardLayout = IDataLayout.CARD_LAYOUT;
		this.setLayout(cardLayout);

		form_movie = new Form_Sale_Movie(this);

		form_cinema = new Form_Sale_Cinema(this);

		form_ticket = new Form_Sale_Ticket(this);

		this.add(form_movie);
		++countLayout;
		this.add(form_cinema);
		++countLayout;
		this.add(form_ticket);
		++countLayout;
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		this.cardLayout.next(this);
		// Nếu ở vị trí cuối cùng thì khởi động lại biến đếm vị trí đứng
		locationLayout = locationLayout == countLayout ? 1 : ++locationLayout;
	}

	@Override
	public void previous() {
		// TODO Auto-generated method stub
		this.cardLayout.previous(this);
		--locationLayout;
	}

	@Override
	public void first() {
		// TODO Auto-generated method stub
		this.cardLayout.first(this);
		locationLayout = 1;
	}

	@Override
	public void next(String nameLayout) {
		// TODO Auto-generated method stub
		// Bởi vì nếu nhảy bất kỳ thì locationLayout không hoạt động được
		ErrorDialog.show();
	}

	public void registerFormTicket(Observer ob) {
		form_ticket.addFormRegisterTicket(ob);
	}

	public void updateMovieClick(Object obj) {
		InfoMovie info = (InfoMovie) obj;
		form_movie.updateMovieClick(info);
		first();
	}

}
