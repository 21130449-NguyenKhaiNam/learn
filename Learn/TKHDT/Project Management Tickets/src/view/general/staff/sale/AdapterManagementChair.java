package view.general.staff.sale;

import java.util.ArrayList;
import java.util.List;

import model.movie.InfoMovie;

/**
 * Quản lý ở phía model và để view truy xuất
 */
public class AdapterManagementChair implements IAdapterManagementChair {
	private ManagementChair managementChair;

	public AdapterManagementChair() {
		managementChair = new ManagementChair();
	}

	@Override
	public List<String> getChairsUnSeat(InfoMovie info) {
		// TODO Auto-generated method stub
		List<String> re = new ArrayList<>();
		if (managementChair.hasInfo(info.getId())) {
			re = managementChair.getChairsUnSeat(info);
		} else {
			managementChair.addInfo(info);
		}
		return re;
	}

	@Override
	public void setClockChair(InfoMovie info, List<String> chairsUnSeat) {
		// TODO Auto-generated method stub
		String id = info.getId();
		if(!managementChair.hasInfo(id))
			managementChair.addInfo(info);
		managementChair.setChairsUnSeat(info, chairsUnSeat);
	}

}
