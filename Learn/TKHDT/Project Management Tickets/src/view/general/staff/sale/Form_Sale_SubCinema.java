package view.general.staff.sale;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;

import control.observer.Observer;
import model.data.size.EnumSize;

/**
 * Giao diện hỗ trợ cho phòng chiếu
 */
public class Form_Sale_SubCinema extends JPanel {
	private Form_Sale main;
	private Form_Sale_SubCinema_Room center;
	private Form_Sale_SubCinema_Head head;
	private Form_Sale_Function bottom;

	public Form_Sale_SubCinema(Form_Sale main) {
		this.main = main;

		init();
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setLayout(new BorderLayout(10, 10));

		head = new Form_Sale_SubCinema_Head();

		center = new Form_Sale_SubCinema_Room();

		bottom = new Form_Sale_Function(main);

		this.add(head, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.SOUTH);

	}

	private void init() {
		// TODO Auto-generated method stub
		setOpaque(false);
	}

	// Thiết lập những ghế không ngồi được
	public void setUnSeat(List<String> chairsUnSeat) {
		// TODO Auto-generated method stub
		center.setUnSeat(chairsUnSeat);
	}

	// Khóa chọn những ghế đã chọn
	public List<String> clockChairs() {
		// TODO Auto-generated method stub
		return center.clockChairs();
	}

	// Có chọn ghế
	public boolean isChooseChair() {
		// TODO Auto-generated method stub
		return center.isChooseChair();
	}

	public int getNumStudent() {
		// TODO Auto-generated method stub
		return head.getNumSudent();
	}

}
