package model.data.account;

import java.util.Map;

import model.account.Account;

/**
 * Hiện thực việc lấy dữ liệu từ database
 */
public class DataAccount implements SourceAccount {

	@Override
	public Map<String, Account> getAccounts() {
		// TODO Auto-generated method stub
		return mapAccount;
	}

}
