package view.general.staff.sale;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JSeparator;

import control.observer.Observer;
import model.ticket.Ticket;

public class Form_Sale_SubTicket_Body extends JPanel implements Observer {
	private PanelItemInvoice item;

	public Form_Sale_SubTicket_Body() {
		init();
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		JSeparator separatorTop = new JSeparator();
		JSeparator separatorBottom = new JSeparator();

		setLayout(new BorderLayout(2, 2));

		JPanel center = new JPanel();
		center.setOpaque(false);
		center.setLayout(new GridLayout(0, 1, 5, 5));

		item = new PanelItemInvoice();
		center.add(item);

		add(separatorTop, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(separatorBottom, BorderLayout.SOUTH);
	}

	private void init() {
		// TODO Auto-generated method stub
		setOpaque(false);
	}

	public void updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		Ticket ticket = (Ticket) obj;
		if (!ticket.isCheck()) {
			item.updateTicket(ticket);
		}
	}
}
