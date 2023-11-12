package view.general.staff;

import javax.swing.JLabel;

import model.function.FunctionImg;
import model.info.Info;

/**
 * Các phần tử chỉ hiển thị hình ảnh nhưng vẫn muốn giữ thông tin thì lớp này
 * giúp làm điều đó. Các phần tử đó phải implements Info và khi sử dụng hiển thị
 * trên màn hình thì phải xài class này đồng thời khai báo ra kích thước ảnh
 * muốn hiện
 */
public class LbImg extends JLabel {
	// Nội dung phần tử đó
	private Info info;

	public Info getInfo() {
		return info.getInfo();
	}

	public LbImg(Info info, int w, int h) {
		this.info = info;
		// Chỉ hiển thị ra mỗi hình ảnh nhưng bên trong vẫn giữ nội dung
		setIcon(FunctionImg.scaleImg(info.getImg(), w, h));
	}

}
