package view.general.main;

import view.general.main.home.Form_Home;

public abstract class AFactoryFormMain {
	protected Form_Home formHome = new Form_Home();

	/**
	 * @return the formHome
	 */
	public Form_Home getFormHome() {
		return formHome;
	}

	public abstract void updateEmployee(Object obj);

}
