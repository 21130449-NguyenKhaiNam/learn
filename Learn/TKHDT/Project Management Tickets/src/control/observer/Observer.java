package control.observer;

/**
 * Các lớp con khi nhận được thông tin từ một lớp là implements Subject thì
 * sẽ cập nhật tùy theo nó muốn
 */
public interface Observer {
	// Khi nhận được thông báo thì cập nhật việc gì đó
	void update(Object obj);

}
