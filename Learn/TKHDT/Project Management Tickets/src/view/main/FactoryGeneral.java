package view.main;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import control.logout.action.ActionLogout;
import model.info.IDataNameGeneral;
import view.general.admin.PanelGeneralAdmin;
import view.general.staff.PanelGeneralStaff;

/**
 * Tạo ra các general tương ứng
 */
public class FactoryGeneral implements IFactoryGeneral {
	// Ánh xạ theo tên
	private Map<String, JPanel> map;
	
	// Hành động thóat chương trình
	private ActionLogout acLogout;

	public FactoryGeneral(App app) {
		acLogout = new ActionLogout(app);
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		map = new HashMap<>();

		map.put(IDataNameGeneral.USER, new PanelGeneralStaff(acLogout));
		map.put(IDataNameGeneral.ADMIN, new PanelGeneralAdmin(acLogout));

	}

	@Override
	public JPanel getGeneral(String name) {
		// TODO Auto-generated method stub
		return map.get(name);
	}
}
