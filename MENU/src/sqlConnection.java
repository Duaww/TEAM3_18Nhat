import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class sqlConnection {
	Connection conn = null;
	public static Connection dbConnection () {
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager
					.getConnection("jdbc:sqlserver://DESKTOP-G2GES0F:1433;databaseName=CSDL;integratedSecurity=true");
			return conn;
		}catch (Exception e)
		{
			return null;
		}		
	}
}
