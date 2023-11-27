package model.data.img;

import java.awt.Image;
import java.util.List;
import java.util.Map;

import javax.swing.Icon;

import database.Database;

/**
 * Interface naỳ định nghĩa ra các loại hình ảnh sẽ có trong chương trình
 */
public interface SourceImage {
	List<Image> imgError = Database.getImgError();
	
	// Ánh xạ mỗi thư mục là list hình ảnh của nó, việc null hay không thì database sẽ giải quyết
	Map<String, List<Image>> mapImgs = Database.getMapImg();

	// Img cửa sổ
	Image IMG_FRAME(int ind);

	// Img của trang input
	Image IMG_INPUT(int ind);
	
	// Img của dialog - thông báo trên màn hình
	Image IMG_DIALOG(int ind);
	
	// Img của menu
	Image IMG_MENU(int ind);

	// Img của search
	Image IMG_SEARCH(int ind);
}
