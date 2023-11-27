package main;

import java.awt.EventQueue;
import java.util.Map;

import control.database.Server;
import database.Database;
import model.account.Account;
import view.dialog.Dialog;
import view.dialog.EmptyDialog;
import view.dialog.ErrorDialog;
import view.main.App;

/**
 * Đúng ra việc tạo và khởi chạy nằm ở nơi khác nhau tuy nhiên để đơn giản trong
 * quản lý bởi chương trình nhở nên viết chung. Lớp này sẽ khởi tạo ra server và
 * giao diện ứng dụng. Xem thêm về các lơp để biết chi tiết
 */
public class RunApp {

	// Khởi tạo hệ thống
	public RunApp() {
		// Khởi chạy server lấy dữ liệu database, img, ...
		new Server();

		// Khởi chạy giao diện
		App app = new App();
		
		// Khởi tạo dialog
		Dialog.createDialgo(app);

		// Thông báo nếu có vấn đề ở database
		if (!Database.isCorrect()) {
			EmptyDialog.show("Looks like there's a problem with the database");
			return;
		}
		
		// Từ phần này trở đi chỉ để test
		Map<String, Account> accounts = Database.getMapAccounts();
		String txt = "Đây là các tài khoản để test, ngăn cách bởi dấu \' ; \': \n";
		for (Map.Entry<String, Account> entry : accounts.entrySet()) {
			Account val = entry.getValue();
			txt += val + "; ";
		}
		Dialog.show(txt);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new RunApp();
				} catch (Exception e) {
					ErrorDialog.show(e.getMessage());
				}
			}
		});
	}
}
