package control.database;

import database.Database;

/**
 * Server khởi tạo các phần liên quan đến backend: Dữ liệu, ... Đúng thì server
 * chỉ liên hệ tới lớp kết nối database tuy nhiên để đơn giản việc quản lý trong
 * dữ án nhở nên loại bỏ bớt
 */
public class Server {
	// Cơ sở dữ liệu mô phỏng
	private Database database;

	/**
	 * @return the database
	 */
	public Database getDatabase() {
		return database;
	}

	/**
	 * 
	 */
	public Server() {
		database = new Database();
	}

}
