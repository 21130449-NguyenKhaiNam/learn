package model.data.account;

import java.util.Map;

import database.Database;
import model.account.Account;

/**
 * Định nghĩa ra cá phương thức cần có khi lấy dữ liệu từ database liên quan đến
 * account
 */
public interface SourceAccount {
	// Ánh xạ của từng loại tài khoản, key - mã nhân viên, value - tài khoản của họ
	Map<String, Account> mapAccount = Database.getMapAccounts();

	// Lấy ra danh sách tài khoản
	Map<String, Account> getAccounts();
}
