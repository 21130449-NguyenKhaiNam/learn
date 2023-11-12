package view.general.admin;

import model.function.FunctionImg;
import model.management.general.AEmployee;
import model.management.staff.Work;
import view.card.InfoCard;
import view.general.admin.history.AdForm_History;
import view.general.admin.movie.AdForm_Movie;
import view.general.admin.revenue.AdForm_Revenue;
import view.general.admin.setting.AdForm_Setting;
import view.general.admin.show.AdForm_ShowTime;
import view.general.main.AFactoryFormMain;

/**
 * Khởi tạo các giá trị cho admin: Tạo list table, cập nhật giá trị cho home,...
 */
public class FactoryFormAdmin extends AFactoryFormMain {
	private AdForm_History formHistory;
	private AdForm_Movie formMovie;
	private AdForm_Revenue formRevenue;
	private AdForm_Setting formSetting;
	private AdForm_ShowTime formShowTime;

	/**
	 * @return the formHistory
	 */
	public AdForm_History getFormHistory() {
		return formHistory;
	}

	/**
	 * @return the formMovie
	 */
	public AdForm_Movie getFormMovie() {
		return formMovie;
	}

	/**
	 * @return the formRevenue
	 */
	public AdForm_Revenue getFormRevenue() {
		return formRevenue;
	}

	/**
	 * @return the formSetting
	 */
	public AdForm_Setting getFormSetting() {
		return formSetting;
	}

	/**
	 * @return the formShowTime
	 */
	public AdForm_ShowTime getFormShowTime() {
		return formShowTime;
	}

	public FactoryFormAdmin() {
		initComponent();
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		// Cập nhật list table cho admin: Ngày truy cập
		formHome.setListTale(new String[] { "Date", "" });

		formHistory = new AdForm_History();

		formMovie = new AdForm_Movie();

		formRevenue = new AdForm_Revenue();

		formSetting = new AdForm_Setting();

		formShowTime = new AdForm_ShowTime();
	}

	@Override
	public void updateEmployee(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof AEmployee) {
			formHome.clearTable();
			AEmployee employee = (AEmployee) obj;
			if (employee.isAdmin()) {
				InfoCard info = new InfoCard(FunctionImg.scaleImg(employee.getImg(), 200, 200), employee.getName(),
						employee.getId() + " - " + "Phone: " + employee.getPhone(), employee.getPosition().name());
				formHome.setData(info);
				for (Work w : employee.getWorks()) {
					formHome.addRow(new Object[] { w.getDate().toString(), null });
				}
			}
		}
	}
}
