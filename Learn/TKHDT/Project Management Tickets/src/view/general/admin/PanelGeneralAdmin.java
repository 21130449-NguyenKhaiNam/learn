package view.general.admin;

import control.logout.action.ActionLogout;
import control.menu.adapter.AdapterMenu;
import control.mouse.EventMenuSelected;
import model.data.menu.DataNameMenuAdmin;
import model.management.general.AEmployee;
import model.movie.InfoMovie;
import view.general.main.APanelGeneral;
import view.menu.ModelMenu;

/**
 * Giao diện của admin
 */
public class PanelGeneralAdmin extends APanelGeneral {
	private FactoryFormAdmin factoryForm;
	private ActionLogout acLogout;

	public PanelGeneralAdmin(ActionLogout acLogout) {
		super(factoryMenu.itemAdmin());
		// TODO Auto-generated constructor stub
		this.acLogout = acLogout;
	}

	@Override
	public void addEventMenu() {
		// TODO Auto-generated method stub
		factoryForm = new FactoryFormAdmin();
		EventMenuSelected event = new EventMenuSelected() {
			private AdapterMenu menu;

			@Override
			public void selected(ModelMenu item) {
				// TODO Auto-generated method stub
				menu = new AdapterMenu();
				DataNameMenuAdmin data = menu.getDataAdmin();
				String name = item.getName();
				if (name.equals(data.getHome())) {
					setForm(factoryForm.getFormHome());
				} else if (name.equals(data.getRevenue())) {
					setForm(factoryForm.getFormRevenue());
				} else if (name.equals(data.getMovies())) {
					setForm(factoryForm.getFormMovie());
				} else if (name.equals(data.getShowTime())) {
					setForm(factoryForm.getFormShowTime());
				} else if (name.equals(data.getHistory())) {
					setForm(factoryForm.getFormHistory());
				} else if (name.equals(data.getLogout())) {
					acLogout.logout();
				}
			}
		};
		setForm(factoryForm.getFormHome());

		addEventMenu(event);
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof InfoMovie) {

		} else {
			factoryForm.updateEmployee(obj);
		}
	}

}
