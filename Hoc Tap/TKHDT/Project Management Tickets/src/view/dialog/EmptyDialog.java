package view.dialog;

import model.data.img.GetImage;

/**
 * Thông báo về việc không tìm thấy
 */
public class EmptyDialog extends Dialog {
	public static void show() {
		setImg(GetImage.getImgDialog(1));
		dialog.showMessage("Empty", "The issue you are looking for may not exist");
	}
	
	public static void show(String txt) {
		setImg(GetImage.getImgDialog(1));
		dialog.showMessage("Empty", txt);
	}
}
