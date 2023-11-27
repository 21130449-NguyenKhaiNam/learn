package view.menu;

/**
 * Định nghĩa các phương thức tạo loại item trong menu từng theo tài khoản
 */
public interface IFactoryMenu {

	ListMenu<ModelMenu> itemUser();

	ListMenu<ModelMenu> itemAdmin();
}
