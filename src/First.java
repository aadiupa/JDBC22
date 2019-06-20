import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class First 
{
	
	public static void main(String[] args){

		try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Loaded");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assessment1", "root", "thbs");
		System.out.println("Connection is done");
		
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
}
