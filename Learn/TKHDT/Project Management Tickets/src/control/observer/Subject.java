package control.observer;

/**
 * Tổ chức quản lý thông báo thông tin đến các đối tượng đăng ký
 */
public interface Subject {
	// Đăng ký nhận thông báo
	void register(Observer com);

	// Rời nhận thông báo
	void remove(Observer com);

	// Thông báo tới toàn thể đối tượng đăng ký nhận thông báo
	void notifyAllList(Object obj);
}
