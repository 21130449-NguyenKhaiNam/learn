package view.general.staff.sale;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import control.movie.ActionChair;
import model.data.color.EnumColor;

/**
 * Giao diện phòng chiếu
 */
public class Form_Sale_SubCinema_Room extends JPanel {

	// Dãy bên trái
	private String[][] chairLeft = { { "A1", "A2" }, { "B1", "B2" }, { "C1", "C2" }, { "D1", "D2" }, { "E1", "E2" },
			{ "F1", "F2" }, { "G1", "G2" }, { "H1", "H2" }, { "I1", "I2" }, { "J1", "J2" } };

	// Dãy ở giữa
	private String[][] chairCenter = { { "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10", "A11", "A12" },
			{ "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "B11", "B12" },
			{ "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12" },
			{ "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "D11", "D12" },
			{ "E3", "E4", "E5", "E6", "E7", "E8", "E9", "E10", "E11", "E12" },
			{ "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10", "F11", "F12" },
			{ "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10", "G11", "G12" },
			{ "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "H11", "H12" },
			{ "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10", "I11", "I12" },
			{ "J3", "J4", "J5", "J6", "J7", "J8", "J9", "J10", "J11", "J12" } };

	// Dãy bên phải
	private String[][] chairRight = { { "A13", "A14" }, { "B13", "B14" }, { "C13", "C14" }, { "D13", "D14" },
			{ "E13", "E14" }, { "F13", "F14" }, { "G13", "G14" }, { "H13", "H14" }, { "I13", "I14" },
			{ "J13", "J14" } };

	// Tổng hợp các dãy để thêm vào chương trình
	private String[][][] managementChair = { chairLeft, chairCenter, chairRight };

	private List<BtnChair> infoChairs;

	public Form_Sale_SubCinema_Room() {
		init();
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		infoChairs = new ArrayList<>();

		setLayout(new BorderLayout());

		Font font = new Font("sansserif", 1, 18);

		JLabel lbHead = new JLabel();
		lbHead.setText("SCREEN");
		lbHead.setHorizontalAlignment(JLabel.CENTER);
		lbHead.setFont(font);
		lbHead.setForeground(EnumColor.Black.color);

		JPanel head = new JPanel();
		head.setBackground(EnumColor.Focus5.color);
		head.setLayout(new CardLayout());
		head.add(lbHead);

		JPanel center = new JPanel();
		center.setLayout(new BorderLayout(10, 10));
		center.setOpaque(false);

		String[] location = { BorderLayout.WEST, BorderLayout.CENTER, BorderLayout.EAST };

		ActionChair acChair = new ActionChair();
		for (int i = 0; i < managementChair.length; i++) {
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(managementChair[i].length, managementChair[i][i].length, 2, 2));
			for (int j = 0; j < managementChair[i].length; j++) {
				for (int k = 0; k < managementChair[i][j].length; k++) {
					BtnChair infoChair = new BtnChair(new Chair(managementChair[i][j][k]));
					infoChair.addActionListener(acChair);
					infoChair.setSelected(false);
					infoChairs.add(infoChair);
					panel.add(infoChair);
				}
			}
			center.add(panel, location[i]);
		}

		JPanel bottom = new JPanel();
		bottom.setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 10));
		bottom.setOpaque(false);

		JPanel panelSeat = new JPanel();
		panelSeat.setLayout(new BorderLayout(2, 2));
		panelSeat.setOpaque(false);
		JPanel colorSeat = new JPanel();
		colorSeat.setBackground(EnumColor.Seated.color);
		colorSeat.setPreferredSize(new Dimension(20, 20));
		JLabel lbSeat = new JLabel();
		lbSeat.setText("Seated");
		lbSeat.setFont(font);
		panelSeat.add(colorSeat, BorderLayout.WEST);
		panelSeat.add(lbSeat, BorderLayout.CENTER);

		JPanel panelUnSeat = new JPanel();
		panelUnSeat.setLayout(new BorderLayout(2, 2));
		panelUnSeat.setOpaque(false);
		JPanel colorUnseat = new JPanel();
		colorUnseat.setBackground(EnumColor.UnSeated.color);
		colorUnseat.setPreferredSize(new Dimension(20, 20));
		JLabel lbUnSeat = new JLabel();
		lbUnSeat.setText("Un Seated");
		lbUnSeat.setFont(font);
		panelUnSeat.add(colorUnseat, BorderLayout.WEST);
		panelUnSeat.add(lbUnSeat, BorderLayout.CENTER);

		JPanel panelChooseChair = new JPanel();
		panelChooseChair.setLayout(new BorderLayout(2, 2));
		panelChooseChair.setOpaque(false);
		JPanel colorChooseChair = new JPanel();
		colorChooseChair.setBackground(EnumColor.ClickChair.color);
		colorChooseChair.setPreferredSize(new Dimension(20, 20));
		JLabel lbChooseChair = new JLabel();
		lbChooseChair.setText("Choose");
		lbChooseChair.setFont(font);
		panelChooseChair.add(colorChooseChair, BorderLayout.WEST);
		panelChooseChair.add(lbChooseChair, BorderLayout.CENTER);

		bottom.add(panelSeat);
		bottom.add(panelUnSeat);
		bottom.add(panelChooseChair);

		this.add(head, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.SOUTH);
	}

	private void init() {
		// TODO Auto-generated method stub
		setOpaque(false);
	}

	public void setUnSeat(List<String> chairsUnSeat) {
		// TODO Auto-generated method stub
		for (BtnChair chair : infoChairs) {
			String id = chair.getChair().getName();
			if (chairsUnSeat.contains(id)) {
				chair.setEnabled(false);
				chair.setBackground(EnumColor.Seated.color);
			} else {
				chair.setEnabled(true);
				chair.setBackground(EnumColor.UnSeated.color);
			}
			chair.setSelected(false);
		}
	}

	public List<String> clockChairs() {
		// TODO Auto-generated method stub
		List<String> clock = new ArrayList<>();
		for (BtnChair chair : infoChairs) {
			if (chair.isSelected() && chair.getBackground() != EnumColor.Seated.color) {
				String id = chair.getChair().getName();
				clock.add(id);
			}
		}
		return clock;
	}

	public boolean isChooseChair() {
		// TODO Auto-generated method stub
		for (BtnChair chair : infoChairs) {
			if (chair.getBackground() == EnumColor.ClickChair.color) {
				return true;
			}
		}
		return false;
	}

}
