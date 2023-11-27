package view.main;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;

import control.observer.Observer;
import model.data.img.GetImage;
import model.info.IDataNameGeneral;
import model.management.general.AEmployee;
import view.input.PanelInput;
import view.layout.ICardLayout;
import view.layout.IDataLayout;

/**
 * Tạo ra giao diện chương trình chính
 */
public class App extends JFrame implements Observer, ICardLayout {
	// Vật chứa trong frame
	private Container con;

	// Layout giúp chuyển đổi giữa các giao diện
	private CardLayout cardLayout;

	// Khởi tạo các general
	private IFactoryGeneral factoryGeneral;

	// Phần đăng nhập
	private PanelInput input;

	public App() {
		init();
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub

		factoryGeneral = new FactoryGeneral(this);

		con = this.getContentPane();

		cardLayout = IDataLayout.CARD_LAYOUT;

		con.setLayout(cardLayout);

		input = new PanelInput();
		input.register(this);
		input.register((Observer) factoryGeneral.getGeneral(IDataNameGeneral.ADMIN));
		input.register((Observer) factoryGeneral.getGeneral(IDataNameGeneral.USER));

		con.add(input, IDataNameGeneral.INPUT);
		con.add(factoryGeneral.getGeneral(IDataNameGeneral.ADMIN), IDataNameGeneral.ADMIN);
		con.add(factoryGeneral.getGeneral(IDataNameGeneral.USER), IDataNameGeneral.USER);

		this.setVisible(true);
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setTitle(IDataNameGeneral.TITLE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setIconImage(GetImage.getImgFrame(0));
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		// Tùy loại general: admin, staff thì hiển thị
		if (obj instanceof AEmployee) {
			AEmployee employee = (AEmployee) obj;
			next(employee.isAdmin() ? IDataNameGeneral.ADMIN : IDataNameGeneral.USER);
		}
	}

	// Yêu cầu thoát chương trình
	public void logout() {
		// TODO Auto-generated method stub
		input.logout();
		first();
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		this.cardLayout.next(con);
	}

	@Override
	public void previous() {
		// TODO Auto-generated method stub
		this.cardLayout.previous(con);
	}

	@Override
	public void first() {
		// TODO Auto-generated method stub
		this.cardLayout.first(con);
	}

	@Override
	public void next(String nameLayout) {
		// TODO Auto-generated method stub
		this.cardLayout.show(con, nameLayout);
	}

}
