package model.management.general;

import java.util.List;

import model.data.employee.GetEmployee;

/**
 * Quản lý nhân viên
 */
public class ManagementEmployee {
	// Danh sách nhân viên
	private static List<AEmployee> employees = GetEmployee.getEmployees();

	// Lấy ra nhân viên theo id được truyền
	public static AEmployee getEmployee(String id) {
		// Thực hiện tìm nhân viên
		for (AEmployee aEmployee : employees)
			if (aEmployee.hasId(id))
				return aEmployee;

		return null;
	}
}
