package view.general.staff.sale;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import control.observer.Observer;
import control.observer.Subject;
import model.movie.InfoMovie;
import model.ticket.Ticket;

/**
 * Giao diện hỗ trợ phần chọn vé
 */
public class Form_Sale_SubTicket extends JPanel implements Subject {

	private Form_Sale_SubTicket_Head head;	
	private Form_Sale_SubTicket_Body body;
	private Form_Sale_SubTicket_Footer footer;

	private List<Observer> obs;

	private Ticket ticket;

	public Form_Sale_SubTicket() {
		initConponents();
	}

	private void initConponents() {
		// TODO Auto-generated method stub
		obs = new ArrayList<>();

		setLayout(new BorderLayout());

		head = new Form_Sale_SubTicket_Head();
		this.register(head);

		body = new Form_Sale_SubTicket_Body();
		this.register(body);

		footer = new Form_Sale_SubTicket_Footer();
		this.register(footer);

		add(head, BorderLayout.NORTH);
		add(body, BorderLayout.CENTER);
		add(footer, BorderLayout.SOUTH);
	}

	@Override
	public void register(Observer com) {
		// TODO Auto-generated method stub
		obs.add(com);
	}

	@Override
	public void remove(Observer com) {
		// TODO Auto-generated method stub
		obs.remove(com);
	}

	@Override
	public void notifyAllList(Object obj) {
		// TODO Auto-generated method stub
		ticket = (Ticket) obj;
		for (Observer ob : obs)
			ob.update(ticket);
	}

	public void setTicket() {
		// TODO Auto-generated method stub
		ticket.setCheck(true);
		notifyAllList(ticket);
	}
}
