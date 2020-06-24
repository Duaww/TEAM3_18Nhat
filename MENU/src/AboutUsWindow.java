
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AboutUsWindow {

	public static void main(String[] args) {
		showwindow();

	}
	public static void showwindow ()
	{
		JFrame window = new JFrame ("About Us");
		window.setBackground(new Color(240, 248, 255));
				
				window.setBounds(100, 100, 420, 200);
				window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				window.getContentPane().setLayout(null);
				
				JTextArea Text = new JTextArea();
				Text.setBackground(new Color(240, 248, 255));
				Text.setFont(new Font("Tahoma", Font.PLAIN, 16));
				Text.setLineWrap(true);
				Text.setText("Đây là phần mềm Mã hóa và Giải mã.\r\n" + 
						"Các thành viên của dự án:\r\n" + 
						"	Trần Vĩnh Đạt: Phụ trách giao diện\r\n" + 
						"	Nguyễn Thanh Tính: Phụ trách thuật toán\r\n" + 
						"Liên lạc:\r\n" + 
						"	Trần Vĩnh Đạt: datvinhtran.dut@gmail.com");
				Text.setBounds(12, 13, 380, 127);
				Text.setEditable(false);
				Text.setEnabled(true);
				window.getContentPane().add(Text);
				window.setLocationRelativeTo(null);
				
				window.setVisible(true);
	}
}
