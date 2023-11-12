package view.menu;

import control.menu.adapter.AdapterMenu;
import model.data.img.GetImage;
import model.data.menu.DataNameMenuAdmin;
import model.data.menu.DataNameMenuStaff;

/**
 * Hiện thực việc khởi tạo các phần tử trong menu của từng loại tài khoản, ở đây
 * là: user và admin
 */
public class FactoryMenu implements IFactoryMenu {
	private AdapterMenu menu;

	public FactoryMenu() {
		menu = new AdapterMenu();
	}

	@Override
	public ListMenu<ModelMenu> itemUser() {
		// TODO Auto-generated method stub
		ListMenu<ModelMenu> listMenu = new ListMenu<>();
		DataNameMenuStaff data = menu.getDataStaff();
		listMenu.addItem(new ModelMenu(GetImage.getImgMenu(1), data.getHome(), ModelMenu.MenuType.MENU));
		listMenu.addItem(new ModelMenu(GetImage.getImgMenu(2), data.getSale(), ModelMenu.MenuType.MENU));
		listMenu.addItem(new ModelMenu(GetImage.getImgMenu(3), data.getMovies(), ModelMenu.MenuType.MENU));
		listMenu.addItem(new ModelMenu(GetImage.getImgMenu(4), data.getShowTime(), ModelMenu.MenuType.MENU));
		listMenu.addItem(new ModelMenu(null, " ", ModelMenu.MenuType.EMPTY));

		listMenu.addItem(new ModelMenu(null, "Other", ModelMenu.MenuType.TITLE));
		listMenu.addItem(new ModelMenu(null, " ", ModelMenu.MenuType.EMPTY));
		listMenu.addItem(new ModelMenu(GetImage.getImgMenu(5), data.getHistory(), ModelMenu.MenuType.MENU));
		listMenu.addItem(new ModelMenu(GetImage.getImgMenu(7), data.getLogout(), ModelMenu.MenuType.MENU));
		listMenu.addItem(new ModelMenu(null, "", ModelMenu.MenuType.EMPTY));
		return listMenu;
	}

	@Override
	public ListMenu<ModelMenu> itemAdmin() {
		// TODO Auto-generated method stub
		ListMenu<ModelMenu> listMenu = new ListMenu<>();
		DataNameMenuAdmin data = menu.getDataAdmin();
		listMenu.addItem(new ModelMenu(GetImage.getImgMenu(1), data.getHome(), ModelMenu.MenuType.MENU));
		listMenu.addItem(new ModelMenu(GetImage.getImgMenu(3), data.getMovies(), ModelMenu.MenuType.MENU));
		listMenu.addItem(new ModelMenu(GetImage.getImgMenu(4), data.getShowTime(), ModelMenu.MenuType.MENU));
		listMenu.addItem(new ModelMenu(null, " ", ModelMenu.MenuType.EMPTY));

		listMenu.addItem(new ModelMenu(null, "Other", ModelMenu.MenuType.TITLE));
		listMenu.addItem(new ModelMenu(null, " ", ModelMenu.MenuType.EMPTY));
		listMenu.addItem(new ModelMenu(GetImage.getImgMenu(5), data.getHistory(), ModelMenu.MenuType.MENU));
		listMenu.addItem(new ModelMenu(GetImage.getImgMenu(6), data.getRevenue(), ModelMenu.MenuType.MENU));
		listMenu.addItem(new ModelMenu(GetImage.getImgMenu(8), data.getSetting(), ModelMenu.MenuType.MENU));
		listMenu.addItem(new ModelMenu(GetImage.getImgMenu(7), data.getLogout(), ModelMenu.MenuType.MENU));
		listMenu.addItem(new ModelMenu(null, "", ModelMenu.MenuType.EMPTY));
		return listMenu;
	}

}
