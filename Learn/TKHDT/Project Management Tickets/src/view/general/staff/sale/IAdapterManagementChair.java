package view.general.staff.sale;

import java.util.List;

import model.movie.InfoMovie;

/**
 * Các phương thức tương tác từ view tới model về ghế
 */
public interface IAdapterManagementChair {

	List<String> getChairsUnSeat(InfoMovie info);

	void setClockChair(InfoMovie info, List<String> chairsUnSeat);

}
