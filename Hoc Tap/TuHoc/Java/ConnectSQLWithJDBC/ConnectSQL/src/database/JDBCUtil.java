package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import model.data.ManagementDB_URL;

public class JDBCUtil {
	/**
	 * Kết nối tới cơ sở dữ liệu
	 * 
	 * @throws SQLException
	 */
	public static Connection getConnect(int port, String dbName, String user, String password) {
		Connection connect = null;

		try {
			// Đăng ký thông tin để java biết sử dụng kết nối csdl
			Class.forName(ManagementDB_URL.JDBC_DRIVER);

			// Kết nối, tam thoi de ten he co so cung
			connect = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-3QRE0S7\\NK23:" + port + ";databaseName="
					+ dbName + ";user=" + user + ";password=" + password + ";encrypt=false");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return connect;
	}

	/**
	 * Thực hiện truy vấn
	 * 
	 * @param connect
	 * @param query
	 */
	public static void query(Connection connect, String query) {
		try {
			Statement st = connect.createStatement();
			st.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Ngắt kết nối
	 */
	public static void closeConnectio(Connection connect) {
		try {
			if (connect != null)
				connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
