package view.general.staff.sale;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import control.observer.Observer;
import model.data.size.EnumSize;
import model.ticket.Ticket;
import view.general.main.PanelBorder;
import view.scroll.ScrollBar;

/**
 * Giao diện phần vé
 */
public class Form_Sale_Ticket extends JPanel {
	private Form_Sale parent;
	private Form_Sale_SubTicket subTicket;

	public Form_Sale_Ticket(Form_Sale parent) {
		this.parent = parent;
		init();
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		subTicket = new Form_Sale_SubTicket();
		subTicket.setBorder(new LineBorder(new Color(0, 0, 0)));

		PanelBorder background = new PanelBorder();

		int sizeTicket = (int) subTicket.getPreferredSize().getWidth();

		GroupLayout backgroundLayout = new GroupLayout(background);
		backgroundLayout.setHorizontalGroup(backgroundLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(backgroundLayout.createSequentialGroup()
						.addGap((EnumSize.ScreenWidth.size - EnumSize.WidthMenu.size - sizeTicket) / 2)
						.addComponent(subTicket, sizeTicket, sizeTicket, sizeTicket)));
		backgroundLayout.setVerticalGroup(backgroundLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(backgroundLayout.createSequentialGroup().addContainerGap().addComponent(subTicket,
						GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		background.setLayout(backgroundLayout);

		Form_Sale_Function function = new Form_Sale_Function(parent);

		JScrollPane scroll = new JScrollPane();
		scroll.setVerticalScrollBar(new ScrollBar());
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setViewportView(background);

		setLayout(new BorderLayout());
		add(scroll, BorderLayout.CENTER);
		add(function, BorderLayout.SOUTH);
	}

	private void init() {
		// TODO Auto-generated method stub
		setOpaque(false);
	}

	// Cập nhật ghế chọn cho phần vé
	public void updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		subTicket.notifyAllList(ticket);
	}

	public void addFormRegisterTicket(Observer ob) {
		subTicket.register(ob);
	}

	public void setTicket() {
		// TODO Auto-generated method stub
		subTicket.setTicket();
	}

}
