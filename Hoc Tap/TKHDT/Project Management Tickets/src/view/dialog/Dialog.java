package view.dialog;

import java.awt.Image;

import model.data.img.GetImage;
import view.main.App;

/**
 * Định nghĩa các quy chuẩn chung về dialog
 */
public class Dialog {
	protected static MessageDialog dialog;
	
	public static void createDialgo(App app) {
		dialog = new MessageDialog(app);
	}

	// Thiết lập hình ảnh nếu lớp con muốn
	public static void setImg(Image img) {
		if (img == null) {
			dialog.setLogo(GetImage.getImgDialog(0));
		} else {
			dialog.setLogo(img);
		}

	}
	
	public static void show() {
		dialog.showMessage("Title", "Message");
	}

	public static void show(String txt) {
		dialog.showMessage("Title", txt);
	}

}
