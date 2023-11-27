package control.menu.adapter;

import model.data.menu.DataNameMenuAdmin;
import model.data.menu.DataNameMenuStaff;

/**
 * Là trung gian kết nối giữa view và model
 */
public class AdapterMenu {
	// Dữ liệu của các bảng tên trên menu
	private DataNameMenuStaff dataStaff;
	private DataNameMenuAdmin dataAdmin;

	/**
	 * @return the data
	 */
	public DataNameMenuStaff getDataStaff() {
		return dataStaff;
	}

	/**
	 * @return the dataAdmin
	 */
	public DataNameMenuAdmin getDataAdmin() {
		return dataAdmin;
	}

	public AdapterMenu() {
		dataStaff = new DataNameMenuStaff();
		dataAdmin = new DataNameMenuAdmin();
	}

}
