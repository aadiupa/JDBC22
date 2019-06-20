import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDB {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Successfully Loaded");
		} catch (Exception e) {
		}
	}

	public void getConn() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assessment1", "root", "thbs");
			st = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void isClose() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException s) {
			}
		}
	}
}