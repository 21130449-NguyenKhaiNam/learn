package model.data.img;

import java.awt.Image;
import java.util.List;

/**
 * Lớp này sẽ hiện thực và tạo ra các hình ảnh, lý do phải có là vì để sử dụng
 * đường dẫn cơ động. Khi nén về jar sẽ không bị mất hình ảnh. Các bức ảnh được
 * lấy theo đúng thứ tự hiển thị trong thư mục bởi việc lấy bằng việc nhập vào
 * vẫn chưa tìm ra cách. Lý do các phương thức trong giống nhau nhưng không gom
 * chung là bởi mỗi một phương thức có cách xử lý riêng cho nó vd như: in ra
 * console, trả về bức ảnh khác, chỉ là ở đây để đơn giản nên xử dụng khá giống
 * nhau
 */
public class DataImage implements SourceImage {
	// Các thư mục ảnh đang có để sử dụng
	private String[] strPath = { "frame", "input", "dialog", "menu", "search" };

	public DataImage() {

	}

	@Override
	public Image IMG_FRAME(int ind) {
		// TODO Auto-generated method stub
		List<Image> imgs = mapImgs.get(strPath[0]);
		if (imgs == null || imgs.isEmpty())
			return imgError.get(0);
		return imgs.get(ind);
	}

	@Override
	public Image IMG_INPUT(int ind) {
		// TODO Auto-generated method stub
		List<Image> imgs = mapImgs.get(strPath[1]);
		if (imgs == null || imgs.isEmpty())
			return imgError.get(0);
		return imgs.get(ind);
	}

	@Override
	public Image IMG_DIALOG(int ind) {
		// TODO Auto-generated method stub
		List<Image> imgs = mapImgs.get(strPath[2]);
		if (imgs == null || imgs.isEmpty())
			return imgError.get(0);
		return imgs.get(ind);
	}

	@Override
	public Image IMG_MENU(int ind) {
		// TODO Auto-generated method stub
		List<Image> imgs = mapImgs.get(strPath[3]);
		if (imgs == null || imgs.isEmpty())
			return imgError.get(0);
		return imgs.get(ind);
	}

	@Override
	public Image IMG_SEARCH(int ind) {
		// TODO Auto-generated method stub
		List<Image> imgs = mapImgs.get(strPath[4]);
		if (imgs == null || imgs.isEmpty())
			return imgError.get(0);
		return imgs.get(ind);
	}

}
