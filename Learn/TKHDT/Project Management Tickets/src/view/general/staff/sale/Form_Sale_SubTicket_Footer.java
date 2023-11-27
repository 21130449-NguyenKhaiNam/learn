package view.general.staff.sale;

import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import control.observer.Observer;
import model.ticket.Ticket;

/**
 * Phần cuối của giao diện vé
 */
public class Form_Sale_SubTicket_Footer extends JPanel implements Observer {
	private PanelItemFooterVoice itemCountStudent;
	private PanelItemFooterVoice itemCost;
	private PanelItemFooterVoice itemNote;

	public Form_Sale_SubTicket_Footer() {
		init();
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		itemCountStudent = new PanelItemFooterVoice();

		itemCost = new PanelItemFooterVoice();

		itemNote = new PanelItemFooterVoice();

		List<PanelItemFooterVoice> list = Arrays.asList(itemCountStudent, itemCost, itemNote);
		setLayout(new GridLayout(0, 1, 2, 2));

		for (PanelItemFooterVoice item : list) {
			add(item);
		}
	}

	private void init() {
		// TODO Auto-generated method stub
		setOpaque(false);
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		Ticket ticket = (Ticket) obj;
		if (!ticket.isCheck()) {
			itemCountStudent.setContent("Student", ticket.getNumSt() + "");
			itemCost.setContent("Total", ticket.getPrice() + "");
			itemNote.setContent("NO GIVE BACK!!!");
		}
	}
}
