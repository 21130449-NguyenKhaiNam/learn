package control.logout.action;

import view.main.App;

/**
 * Thoát khỏi chương trình
 */
public class ActionLogout {
	private App app;

	public ActionLogout(App app) {
		this.app = app;
	}

	// Thoát chương trình
	public void logout() {
		app.logout();
	}
}
