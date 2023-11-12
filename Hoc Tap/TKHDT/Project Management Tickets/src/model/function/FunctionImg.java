package model.function;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Có các chức năng đọc liên quan đến file (thường là ảnh trừ một số trường hợp
 * đặc biệt)
 */
public class FunctionImg {

	// Đọc toàn bộ ảnh trong thư mục
	public static List<Image> readImagesInFolder(String pathFolder) {
		List<Image> listImg = new ArrayList<>();
		// Đường dẫn chỉ bao gồm từ /C.. trở đi
		if (pathFolder.contains("file:"))
			pathFolder = pathFolder.replace("file:", "");
		try {
			// Đường dẫn đến thư mục chứa các tệp hình ảnh
			File folder = new File(pathFolder);

			// Lấy danh sách các tệp hình ảnh trong thư mục
			File[] listOfFiles = folder.listFiles();

			// Duyệt qua từng tệp hình ảnh và in ra thông tin của chúng
			for (File file : listOfFiles) {
				if (file.isFile() && isImageFile(file)) {
					BufferedImage image = ImageIO.read(file);
					listImg.add(image);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listImg;
	}

	// Kiểm tra xem một tệp có phải là tệp hình ảnh không
	public static boolean isImageFile(File file) {
		String extension = getFileExtension(file);
		if (extension != null) {
			return extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png")
					|| extension.equals("gif");
		}
		return false;
	}

	// Lấy đuôi tệp của một file
	public static String getFileExtension(File file) {
		String extension = null;
		String fileName = file.getName();
		int index = fileName.lastIndexOf(".");
		if (index > 0 && index < fileName.length() - 1) {
			extension = fileName.substring(index + 1).toLowerCase();
		}
		return extension;
	}

	// Tạo ra URL từ đường dẫn cùng cấp với obj
	public static URL getURLFromPathObj(Object obj, String name) {
		return obj.getClass().getClassLoader().getResource(name);
	}

	// Co giãn ảnh theo kích thước
	public static ImageIcon scaleImg(Image img, int k, int m) {
		BufferedImage image = (BufferedImage) img;
		int x = k;
		int y = m;
		int ix = image.getWidth();
		int iy = image.getHeight();
		int dx = 0, dy = 0;
		if (x / y > ix / iy) {
			dy = y;
			dx = dy * ix / iy;
		} else {
			dx = x;
			dy = dx * iy / ix;
		}
		return new ImageIcon(image.getScaledInstance(dx, dy, BufferedImage.SCALE_SMOOTH));
	}

}
