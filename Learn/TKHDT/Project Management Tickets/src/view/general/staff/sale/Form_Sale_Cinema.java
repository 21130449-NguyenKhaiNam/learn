package view.general.staff.sale;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import model.info.Info;
import model.movie.InfoMovie;
import model.movie.Movie;
import model.ticket.Ticket;
import view.general.main.PanelBorder;

/**
 * Giao diện chọn ghế của phần sale
 */
public class Form_Sale_Cinema extends JPanel {
	private Form_Sale main;

	private Form_Sale_SubCinema subCinema;

	private IAdapterManagementChair adapterChair;

	private InfoMovie info;

	public Form_Sale_Cinema(Form_Sale main) {
		this.main = main;
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		subCinema = new Form_Sale_SubCinema(main);

		adapterChair = new AdapterManagementChair();

		PanelBorder background = new PanelBorder();

		GroupLayout backgroundLayout = new GroupLayout(background);
		background.setLayout(backgroundLayout);
		backgroundLayout.setHorizontalGroup(backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(backgroundLayout.createSequentialGroup().addContainerGap()
						.addGroup(backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(
								subCinema, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		backgroundLayout
				.setVerticalGroup(backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(backgroundLayout.createSequentialGroup().addContainerGap()
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(subCinema,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap()));

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(background,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(background,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
	}

	// Cập nhật lịch sử ghế đã chọn của bộ phim
	public void updateChairs(Info info) {
		this.info = (InfoMovie) info;
		List<String> chairsUnSeat = adapterChair.getChairsUnSeat(this.info);
		subCinema.setUnSeat(chairsUnSeat);
	}

	// Khóa lại những ghế đã chọn không thể chỉnh sửa
	public void clockChairs() {
		// TODO Auto-generated method stub
		List<String> chairsUnSeat = subCinema.clockChairs();
		adapterChair.setClockChair(info, chairsUnSeat);
	}

	// Đã có ghế nào được hconj chưa
	public boolean isChooseChair() {
		// TODO Auto-generated method stub
		return subCinema.isChooseChair();
	}

	// Cập nhật thông tin ghế được chọn cho phần sale
	public void updateTicket() {
		// TODO Auto-generated method stub
		Movie m = info.getMovie();
		Ticket ticket = new Ticket(info.getId(), LocalDate.now() + " " + LocalTime.now(), m.getName(),
				info.getShowTimes().get(info.getCurrentTime()), "A", subCinema.clockChairs(), m.getPrice(),
				subCinema.getNumStudent(), 0);
		ticket.setCheck(false);
		main.getTicket().updateTicket(ticket);
	}

}
