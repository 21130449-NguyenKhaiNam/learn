package view.input;

import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import control.login.action.ActionSignIn;
import control.observer.Observer;
import control.observer.Subject;
import model.data.img.GetImage;
import model.info.IDataNameField;
import view.button.Button;
import view.field.FactoryField;
import view.field.IFactoryField;
import view.field.PasswordField;
import view.field.TextField;

/**
 * Cấu trúc của một form đăng nhập
 */
public class PanelFormInput extends JPanel implements Subject {
	// Nút đăng nhập
	private Button btnSignIn;

	// Chứa logo form đăng nhập
	private JLabel lbLogo;

	// Khởi tạo bằng mẫu factory
	private IFactoryField fatoryField;

	// Các đối tượng muốn nhận thông báo từ form
	private List<Observer> obs;

	private PasswordField txtPass;

	private TextField txtUser;

	public PanelFormInput() {
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		obs = new ArrayList<>();

		lbLogo = new JLabel();
		lbLogo.setIcon(new ImageIcon(GetImage.getImgInput(0)));
		lbLogo.setHorizontalAlignment(JLabel.CENTER);

		fatoryField = new FactoryField();

		ActionSignIn acSignIn = new ActionSignIn(this);

		txtPass = (PasswordField) getTxt(IDataNameField.PASS);
		txtPass.addKeyListener(acSignIn);

		txtUser = (TextField) getTxt(IDataNameField.USER);
		txtUser.addKeyListener(acSignIn);

		btnSignIn = new Button("Sign In");
		btnSignIn.addActionListener(acSignIn);

		GroupLayout thisLayout = new GroupLayout(this);
		this.setLayout(thisLayout);
		thisLayout.setHorizontalGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				thisLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(thisLayout
						.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(txtPass, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtUser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSignIn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lbLogo, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)).addGap(20, 20, 20)));
		thisLayout.setVerticalGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(thisLayout
				.createSequentialGroup().addGap(20, 20, 20).addComponent(lbLogo).addGap(20, 20, 20)
				.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
				.addComponent(btnSignIn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
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

	// Lấy trường thông tin nào
	public JTextField getTxt(String name) {
		return fatoryField.getField(name);
	}

	// Khi thoát thì form đăng nhập sẽ được khởi động lại
	public void logout() {
		// TODO Auto-generated method stub
		txtUser.setText("");
		txtPass.setText("");
		txtUser.grabFocus();
	}
}
