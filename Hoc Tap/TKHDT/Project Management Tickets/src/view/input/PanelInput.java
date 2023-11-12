package view.input;

import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

import control.observer.Observer;
import control.observer.Subject;

/**
 * Giao diện đăng nhập
 */
public class PanelInput extends JPanel implements Observer, Subject {
	// Background chứa các đường gợn sóng
	private BackgroundInput background;

	// Tạo ra cấu trúc login
	private JPanel panelLogin;

	// Tạo ra cấu trúc form đăng nhập
	private PanelFormInput panelForm;

	// Các phần tử muốn nhận thông tin từ input
	private List<Observer> obs;

	public PanelInput() {
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		obs = new ArrayList<>();

		background = new BackgroundInput();

		panelForm = new PanelFormInput();
		panelForm.register(this);

		panelLogin = new JPanel();

		// Cấu trúc toàn bộ chương trình login
		GroupLayout panelLoginLayout = new GroupLayout(panelLogin);
		panelLogin.setLayout(panelLoginLayout);
		panelLoginLayout.setHorizontalGroup(panelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelLoginLayout
						.createSequentialGroup().addContainerGap(427, Short.MAX_VALUE).addComponent(panelForm,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(428, Short.MAX_VALUE)));
		panelLoginLayout.setVerticalGroup(panelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelLoginLayout
						.createSequentialGroup().addContainerGap(63, Short.MAX_VALUE).addComponent(panelForm,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(233, Short.MAX_VALUE)));

		// Thêm đường gợn sóng
		background.add(panelLogin);

		// Thêm vào ứng dụng chính
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(background,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(background,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		notifyAllList(obj);
	}

	@Override
	public void register(Observer com) {
		// TODO Auto-generated method stub
		obs.add(com);
	}

	@Override
	public void remove(Observer com) {
		// TODO Auto-generated method stub
		obs.remove(com);
	}

	@Override
	public void notifyAllList(Object obj) {
		// TODO Auto-generated method stub
		for (Observer ob : obs)
			ob.update(obj);
	}

	// Hoạt động khi người dùng thoát
	public void logout() {
		// TODO Auto-generated method stub
		panelForm.logout();
	}
}
