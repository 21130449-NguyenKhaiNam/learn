package view.layout;

/**
 * Các lớp muốn sử dụng card layout thì implements interface này để biết các
 * phương thức phải thực hiện
 */
public interface ICardLayout {
	// Chuyển tới phần tử kế nêú ở cuối chuyển về đầu
	void next();
	
	// Di chuyển về phần tử trước đó
	void previous();
	
	//Di chuyển về phần tử đầu tiên
	void first();
	
	// Di chuyển tới layout được chỉ định
	void next(String nameLayout);
}
