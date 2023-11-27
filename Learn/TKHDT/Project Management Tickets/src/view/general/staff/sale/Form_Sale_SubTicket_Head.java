package view.general.staff.sale;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import control.observer.Observer;
import model.data.font.IDataFont;
import model.data.img.GetImage;
import model.function.FunctionImg;
import model.ticket.Ticket;

public class Form_Sale_SubTicket_Head extends JPanel implements Observer {
	private JLabel lbHeadRightName;
	private JLabel lbHeadRightDate;

	public Form_Sale_SubTicket_Head() {
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		JPanel logo = new JPanel();
		JLabel img = new JLabel();
		img.setIcon(FunctionImg.scaleImg(GetImage.getImgFrame(0), 50, 50));
		JPanel logoTitle = new JPanel();
		logoTitle.setLayout(new GridLayout(0, 1, 10, 10));
		JLabel lbTitle = new JLabel();
		lbTitle.setFont(IDataFont.TITLE);
		lbTitle.setText("Object-oriented design Group 10");
		JLabel lbSologan = new JLabel();
		lbSologan.setFont(IDataFont.MIN_TITLE);
		lbSologan.setText("Sologan is sologan");
		logoTitle.add(lbTitle);
		logoTitle.add(lbSologan);
		logo.setLayout(new BorderLayout(5, 5));
		logo.add(img, BorderLayout.WEST);
		logo.add(logoTitle, BorderLayout.CENTER);

		JPanel title = new JPanel();
		title.setLayout(new GridLayout(1, 2, 5, 5));

		JLabel headLeft = new JLabel();
		headLeft.setHorizontalAlignment(JLabel.LEFT);
		headLeft.setFont(IDataFont.HEADING);
		headLeft.setText("Invoice");

		JPanel panelHeadRight = new JPanel();
		panelHeadRight.setLayout(new GridLayout(0, 1, 2, 2));

		lbHeadRightName = new JLabel();
		lbHeadRightName.setHorizontalAlignment(JLabel.RIGHT);
		lbHeadRightName.setFont(IDataFont.MIN_TITLE);
		lbHeadRightName.setText("#Invoice");

		lbHeadRightDate = new JLabel();
		lbHeadRightDate.setHorizontalAlignment(JLabel.RIGHT);
		lbHeadRightDate.setFont(IDataFont.MIN_TITLE);
		lbHeadRightDate.setText("Date: 0 - 0 - 0");

		panelHeadRight.add(lbHeadRightName);
		panelHeadRight.add(lbHeadRightDate);

		title.add(headLeft);
		title.add(panelHeadRight);

		setLayout(new GridLayout(0, 1, 5, 5));

		add(logo);
		add(title);
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		Ticket ticket = (Ticket) obj;
		if (!ticket.isCheck()) {
			lbHeadRightName.setText("#" + ticket.getId());
			lbHeadRightDate.setText("Date: " + ticket.getDate());
		}
	}
}
