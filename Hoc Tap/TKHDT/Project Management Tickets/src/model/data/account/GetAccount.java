package model.data.account;

import java.util.Map;

import model.account.Account;

public class GetAccount {
	public static SourceAccount acc = new DataAccount();
	
	public static Map<String, Account> getAccounts() {
		return acc.getAccounts();
	}
}
