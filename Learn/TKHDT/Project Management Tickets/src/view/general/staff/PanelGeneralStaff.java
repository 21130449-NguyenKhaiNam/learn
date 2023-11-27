package view.general.staff;

import control.logout.action.ActionLogout;
import control.menu.adapter.AdapterMenu;
import control.mouse.EventMenuSelected;
import model.data.menu.DataNameMenuStaff;
import model.movie.InfoMovie;
import view.general.main.APanelGeneral;
import view.menu.ModelMenu;

/**
 * Giao diện chung về hệ thống mà nhân viên thấy
 */
@SuppressWarnings("serial")
public class PanelGeneralStaff extends APanelGeneral {
	private FactoryFormStaff factoryForm;
	private ActionLogout acLogout;
	@SuppressWarnings("unused")
	private int locationMovie = -1;
	private EventMenuSelected event;

	public PanelGeneralStaff(ActionLogout acLogout) {
		super(factoryMenu.itemUser());
		// TODO Auto-generated constructor stub
		this.acLogout = acLogout;
	}

	@Override
	public void addEventMenu() {
		// TODO Auto-generated method stub
		factoryForm = new FactoryFormStaff();
		event = new EventMenuSelected() {
			private AdapterMenu menu;

			@Override
			public void selected(ModelMenu item) {
				// TODO Auto-generated method stub
				menu = new AdapterMenu();
				DataNameMenuStaff data = menu.getDataStaff();
				String name = item.getName();
				if (name.equals(data.getHome())) {
					setForm(factoryForm.getFormHome());
				} else if (name.equals(data.getSale())) {
					locationMovie = 1;
					setForm(factoryForm.getFormSale());
				} else if (name.equals(data.getMovies())) {
					setForm(factoryForm.getFormMovies());
				} else if (name.equals(data.getShowTime())) {
					setForm(factoryForm.getFormShowTimes());
				} else if (name.equals(data.getHistory())) {
					setForm(factoryForm.getFormHistory());
				} else if (name.equals(data.getLogout())) {
					acLogout.logout();
				}
			}
		};
		factoryForm.getFormSale().registerFormTicket(factoryForm.getFormHistory());
		setForm(factoryForm.getFormHome());
		addEventMenu(event);
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof InfoMovie) {
//			factoryMenu.itemUser().setOverIndex(locationMovie);
			factoryForm.getFormSale().updateMovieClick(obj);
			setForm(factoryForm.getFormSale());
		} else {
			factoryForm.updateEmployee(obj);
		}
	}

}
