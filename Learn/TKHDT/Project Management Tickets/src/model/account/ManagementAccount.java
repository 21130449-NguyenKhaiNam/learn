package model.account;

import java.util.Map;

import model.data.account.GetAccount;
import model.management.general.AEmployee;

/**
 * Quản lý các thông tin về tài khoản
 */
public class ManagementAccount {
	// Ánh xạ tài khoản bằng id
	private Map<String, Account> mapAccount;

	public ManagementAccount() {
		mapAccount = GetAccount.getAccounts();
	}

	// Lấy ra id của tài khoản nếu có
	public String getId(String user, String pass) {
		// TODO Auto-generated method stub
		String re = null;

		// Thực hiện tìm id của tài khoản
		for (Map.Entry<String, Account> entry : mapAccount.entrySet())
			if (entry.getValue().isAccount(user, pass))
				re = entry.getKey();

		return re;
	}

}
