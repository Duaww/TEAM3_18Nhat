import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JLabel;


public class HistoryWindow {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		showwindow();
	}
	public static void showwindow() throws SQLException
	{
		JFrame frame;
		JTable table;
		Connection conn = null;
		conn = sqlConnection.dbConnection();
		Statement sm = conn.createStatement();
		frame = new JFrame("History");
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBackground(new Color(240, 248, 255));
		
		frame.setBounds(100, 100, 518, 375);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 53, 476, 262);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		ResultSet rs;
		try {
			rs = sm.executeQuery("Select * from Accesstimes order by [Date] asc, [Time] asc");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			JLabel lb = new JLabel("Li\u0323ch S\u01B0\u0309");
			lb.setForeground(new Color(255, 0, 0));
			lb.setFont(new Font("Cambria", Font.BOLD, 20));
			lb.setBounds(204, 13, 102, 27);
			frame.getContentPane().add(lb);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
