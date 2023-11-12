package model.account;

import java.util.Objects;

/**
 * Định dạng của một tài khoản
 */
public class Account {
	// Thông tin đăng nhập - ở đây bao gồm luôn cả admin và user thông thường
	private String user;

	// Mật khẩu
	private String pass;

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	public Account(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}

	// Kiểm tra có đúng tài khoản
	public boolean isAccount(String oUser, String oPass) {
		// TODO Auto-generated method stub
		return user.equals(oUser) && pass.equals(oPass);
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Account other = (Account) obj;
//		return Objects.equals(pass, other.pass) && Objects.equals(user, other.user);
//	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return user + " - " + pass;
	}

}
