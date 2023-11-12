package model.data.employee;

import java.util.List;

import model.management.general.AEmployee;

public class GetEmployee {
	private static SourceEmployee employees = new DataEmployee();

	public static List<AEmployee> getEmployees() {
		return employees.getEmployees();
	}
}
