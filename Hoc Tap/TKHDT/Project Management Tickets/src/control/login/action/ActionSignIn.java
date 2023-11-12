package control.login.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.account.ManagementAccount;
import model.info.IDataNameField;
import model.management.general.ManagementEmployee;
import view.dialog.EmptyDialog;
import view.dialog.ErrorDialog;
import view.field.PasswordField;
import view.field.TextField;
import view.input.PanelFormInput;

/**
 * Hành động liên quan đến form đăng nhập
 */
public class ActionSignIn extends KeyAdapter implements ActionListener {
	private PanelFormInput form;
	private ManagementAccount accounts;

	public ActionSignIn(PanelFormInput form) {
		this.form = form;
		accounts = new ManagementAccount();
	}

	// Sử dụng cho bàn phím
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		String key = KeyEvent.getKeyText(e.getKeyCode());
		if (key.equals("Enter"))
			signIn();
	}

	// Sử dụng cho nút bấm
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		signIn();
	}

	// Kiểm tra các vấn đề liên quan đến đăng nhập
	public void signIn() {
		// Trường thông tin
		TextField txtUser = (TextField) form.getTxt(IDataNameField.USER);
		PasswordField txtPass = (PasswordField) form.getTxt(IDataNameField.PASS);

		// Nội dung trong trường thông tin
		String user = txtUser.getText().trim();
		String pass = String.valueOf(txtPass.getPassword());

		// Kiểm tra trường nào bỏ trống
		boolean userEmpty = user.isEmpty();
		boolean passEmpty = pass.isEmpty();

		// Nếu có một trường thông tin trống
		if (userEmpty || passEmpty)
			ErrorDialog.show("It seems that you have entered incomplete content.");

		// Trường thông tin trống là user
		if (userEmpty) {
			txtUser.grabFocus();
			return;
		}

		// Trường thông tin trống là pass
		if (passEmpty) {
			txtPass.grabFocus();
			return;
		}

		// Lấy ra id nếu tồn tại tài khoản
		String id = accounts.getId(user, pass);
		if (id != null) {
			form.notifyAllList(ManagementEmployee.getEmployee(id));
		} else {
			// Không có tài khoản
			EmptyDialog.show("Not exist this account.");
		}
	}
}
