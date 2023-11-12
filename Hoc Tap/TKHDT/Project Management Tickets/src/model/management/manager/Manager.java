package model.management.manager;

import java.awt.Image;
import java.util.List;

import model.info.Address;
import model.info.Date;
import model.info.EnumPosition;
import model.management.general.AEmployee;
import model.management.staff.Work;

/**
 * Một người quản lý
 */
public class Manager extends AEmployee {

	public Manager(
			Image img, String id, String name, EnumPosition position, double salary, Date dob, Address address,
			String email, String phone, List<Work> works) {
		super(img, id, name, position, salary, dob, address, email, phone, works);
		// TODO Auto-generated constructor stub
	}

	
	
}
