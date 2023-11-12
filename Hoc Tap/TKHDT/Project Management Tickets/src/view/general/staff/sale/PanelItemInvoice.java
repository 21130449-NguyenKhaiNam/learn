package view.general.staff.sale;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.data.font.IDataFont;
import model.ticket.Ticket;
import view.field.TextArea;

public class PanelItemInvoice extends JPanel {
	private JLabel lbName;
	private JLabel lbTime;
	private JLabel lbNumRoom;
	private TextArea lbChair;

	public PanelItemInvoice() {
		init();
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		// The loai (2D, 3D), ten, so tuoi xem
		lbName = new JLabel();
		lbName.setText("Name movie");

		lbTime = new JLabel();
		lbTime.setText("0 : 0 : 0");

		JLabel lbRoom = new JLabel();
		lbRoom.setText("Room");
		lbRoom.setFont(IDataFont.MEDIUM_TITLE);
		lbRoom.setHorizontalAlignment(JLabel.CENTER);

		lbNumRoom = new JLabel();
		lbNumRoom.setText("0");
		lbNumRoom.setHorizontalAlignment(JLabel.CENTER);

		lbChair = new TextArea();
		lbChair.setBorder(null);
		lbChair.setBackground(getBackground());
		lbChair.setText("Chair");
		lbChair.setFont(IDataFont.MEDIUM_TITLE);

		JPanel info = new JPanel();
		info.setLayout(new BorderLayout());

		JPanel infoRoom = new JPanel();
		infoRoom.setLayout(new BorderLayout());

		infoRoom.add(lbRoom, BorderLayout.NORTH);
		infoRoom.add(lbNumRoom, BorderLayout.CENTER);

		JPanel panelShow = new JPanel();
		panelShow.setLayout(new GridLayout(1, 0));
		panelShow.add(lbTime);
		panelShow.add(infoRoom);

		info.add(panelShow, BorderLayout.NORTH);
		info.add(lbChair, BorderLayout.CENTER);

		setLayout(new BorderLayout());

		add(lbName, BorderLayout.NORTH);
		add(info, BorderLayout.CENTER);
	}

	private void init() {
		// TODO Auto-generated method stub
		setOpaque(false);
	}

	public void updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		lbName.setText(ticket.getNameMovie());
		lbTime.setText(ticket.getTime().getTime());
		lbNumRoom.setText(ticket.getRoom() + "");
		lbChair.setText("Chair: " + ticket.getChairsToString());
	}

}
