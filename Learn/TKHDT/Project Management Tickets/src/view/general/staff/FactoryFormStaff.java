package view.general.staff;

import model.function.FunctionImg;
import model.management.general.AEmployee;
import model.management.staff.Work;
import view.card.InfoCard;
import view.general.main.AFactoryFormMain;
import view.general.staff.history.Form_History;
import view.general.staff.movie.Form_Movie;
import view.general.staff.sale.Form_Sale;
import view.general.staff.show.Form_ShowTimes;

/**
 * Khởi tạo các giá trị cho staff: Tạo list table, cập nhật giá trị cho home,...
 */
public class FactoryFormStaff extends AFactoryFormMain {
	private Form_Sale formSale;
	private Form_Movie formMovies;
	private Form_ShowTimes formShowTimes;
	private Form_History formHistory;

	/**
	 * @return the formHistory
	 */
	public Form_History getFormHistory() {
		return formHistory;
	}

	/**
	 * @return the formSale
	 */
	public Form_Sale getFormSale() {
		return formSale;
	}

	/**
	 * @return the formMovies
	 */
	public Form_Movie getFormMovies() {
		return formMovies;
	}

	/**
	 * @return the formShowTimes
	 */
	public Form_ShowTimes getFormShowTimes() {
		return formShowTimes;
	}

	public FactoryFormStaff() {
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		// Khởi tạo list trên bảng: ngày đi làm, vị trí làm, trạng thái hoàn thành
		formHome.setListTale(new String[] { "Date", "Location", "Status" });

		formSale = new Form_Sale();

		formMovies = new Form_Movie();

		formShowTimes = new Form_ShowTimes();

		formHistory = new Form_History();
	}

	@Override
	public void updateEmployee(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof AEmployee) {
			formHome.clearTable();
			AEmployee employee = (AEmployee) obj;
			if (!employee.isAdmin()) {
				InfoCard info = new InfoCard(FunctionImg.scaleImg(employee.getImg(), 200, 200), employee.getName(),
						employee.getId() + " - " + "Phone: " + employee.getPhone(), employee.getPosition().name());
				formHome.setData(info);
				for (Work w : employee.getWorks()) {
					formHome.addRow(new Object[] { w.getDate().toString(), w.getLocation(), w.getStatus() });
				}
			}
			formHistory.setEmCurr(employee);
		}
	}

}
