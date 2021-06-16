package Teachers.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Teachers.utility.myException;

public class GetConnection {
	public static Connection getConnection() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Driver driver=new com.mysql.cj.jdbc.Driver();
//			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college1?user=root&password=Kiccha@123");
			st = con.createStatement();

		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		} catch (SQLException e) {
			System.out.println("Statement error");
		}
		return con;
	}

	public static void closeConnection(ResultSet rs) throws myException {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			throw new myException("Error");
		}
	}

	public static void closeConnection(Statement st) throws myException {
		try {
			if (st != null) {
				st.close();
			}
		} catch (Exception e) {
			throw new myException("Error");
		}
	}

	public static void closeConnection(Connection con) throws myException {
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			throw new myException("Error");
		}
	}
}
