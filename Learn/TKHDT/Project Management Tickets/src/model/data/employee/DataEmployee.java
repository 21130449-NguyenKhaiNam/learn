package model.data.employee;

import java.util.ArrayList;
import java.util.List;

import model.management.general.AEmployee;
import model.management.manager.Manager;
import model.management.staff.Staff;

public class DataEmployee implements SourceEmployee {
	private List<AEmployee> employees;

	public DataEmployee() {
		employees = new ArrayList<>();
		for (Manager manager : managers) {
			employees.add(manager);
		}

		for (Staff staff : staffs) {
			employees.add(staff);
		}
	}

	@Override
	public List<AEmployee> getEmployees() {
		// TODO Auto-generated method stub
		return employees;
	}

	@Override
	public List<Staff> getStaffs() {
		// TODO Auto-generated method stub
		return staffs;
	}

	@Override
	public List<Manager> getManagers() {
		// TODO Auto-generated method stub
		return managers;
	}

}
