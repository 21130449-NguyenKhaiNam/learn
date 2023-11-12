package view.dialog;

/**
 * Là một dang thông báo lỗi
 */
public class ErrorDialog extends Dialog {
	private static String name = "Error";

	public static void show() {
		setImg(null);
		dialog.showMessage(name, "Hmm maybe have a bug");
	}

	public static void show(String txt) {
		setImg(null);
		dialog.showMessage(name, txt);
	}

}
