package model.data.img;

import java.awt.Image;

/**
 * Lấy ra các hình ảnh một cách chủ động mà không cần khởi tạo đối tượng
 */
public class GetImage {
	// Xử lý việc lấy dữ liệu từ database
	private static final SourceImage imgData = new DataImage();

	public GetImage() {
	}

	// Lấy ra img của chương trình
	public static final Image getImgFrame(int ind) {
		return imgData.IMG_FRAME(ind);
	}

	// Lấy img của input
	public static Image getImgInput(int ind) {
		// TODO Auto-generated method stub
		return imgData.IMG_INPUT(ind);
	}
	
	// Lấy img của dialog
	public static Image getImgDialog(int ind) {
		return imgData.IMG_DIALOG(ind);
	}
	
	// Lấy các bức ảnh báo lỗi
	public static Image getImgError(int ind) {
		return SourceImage.imgError.get(ind);
	}
	
	// Lấy img của menu
	public static Image getImgMenu(int ind) {
		return imgData.IMG_MENU(ind);
	}
	
	// Lấy img của search
	public static Image getImgSearch(int ind)  {
		return imgData.IMG_SEARCH(ind);
	}
}
