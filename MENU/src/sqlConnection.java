import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class sqlConnection {
	static Connection conn = null;
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
	public static void INSERTintoDTB (String a, String b, String c, String d, String e) throws SQLException
	{
		Statement sm = dbConnection().createStatement();
		sm.executeUpdate("INSERT INTO Accesstimes VALUES ('"
						+ a + "', '" 
						+ b + "', '"
						+ c + "', N'"
					    + d + "', N'"
					    + e + "')");
	}
}
