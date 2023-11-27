package model.data.employee;

import java.util.List;

import database.Database;
import model.management.general.AEmployee;
import model.management.manager.Manager;
import model.management.staff.Staff;

public interface SourceEmployee {
	List<Staff> staffs = Database.getStaffs();
	List<Manager> managers = Database.getManagers();

	List<AEmployee> getEmployees();

	List<Staff> getStaffs();

	List<Manager> getManagers();
}
