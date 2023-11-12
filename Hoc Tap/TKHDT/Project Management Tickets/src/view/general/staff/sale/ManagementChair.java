package view.general.staff.sale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.movie.InfoMovie;
import model.movie.ShowTime;

/**
 * Quản lý ghế của các bộ phim và khung giờ
 */
public class ManagementChair {
	// id - gio - ghe
	private Map<String, Map<String, List<String>>> map;

	public ManagementChair() {
		map = new HashMap<>();
	}

	// Có tồn tại thông tin về bộ phim này
	public boolean hasInfo(String id) {
		// TODO Auto-generated method stub
		return map.containsKey(id);
	}

	// Lấy ra những ghế không ngồi được trong thời gian của phim này
	public List<String> getChairsUnSeat(InfoMovie info) {
		// TODO Auto-generated method stub
		String id = info.getId();
		String currentTime = info.getShowTimes().get(info.getCurrentTime()).getTime();
		return map.get(id).get(currentTime);
	}

	// Thêm thông tin ghế về phim
	public void addInfo(InfoMovie info) {
		// TODO Auto-generated method stub
		String id = info.getId();
		List<ShowTime> times = info.getShowTimes();
		Map<String, List<String>> m = new HashMap<>();
		for (ShowTime showTime : times) {
			m.put(showTime.getTime(), new ArrayList<>());
		}
		map.put(id, m);
	}

	// Thiết lập ghế không ngồi được cho phim
	public void setChairsUnSeat(InfoMovie info, List<String> chairsUnSeat) {
		// TODO Auto-generated method stub
		String id = info.getId();
		String currentTime = info.getShowTimes().get(info.getCurrentTime()).getTime();
		map.get(id).get(currentTime).addAll(chairsUnSeat);
	}

}
