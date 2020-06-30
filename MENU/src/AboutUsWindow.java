
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AboutUsWindow {

	public static void main(String[] args) {
		initUI();

	}
	public static void initUI ()
	{
		JFrame window = new JFrame ("About Us");
		window.setBackground(new Color(240, 248, 255));
				
				window.setBounds(100, 100, 701, 210);
				window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				window.getContentPane().setLayout(null);
				
				JTextArea Text = new JTextArea();
				Text.setBackground(new Color(240, 248, 255));
				Text.setFont(new Font("Tahoma", Font.PLAIN, 16));
				Text.setLineWrap(true);
				Text.setText("                                             ------------------------------------\r\n" + 
						"			    Thông tin nhóm phát triển \r\n" + 
						"                                             ------------------------------------\r\n" + 
						"       Tên                          Lớp                 Phụ trách	              Liên lạc\r\n" + 
						"Trần Vĩnh Đạt           18TCLC_Nhật      Giao diện, CSDL         datvinhtran.dut@gmail.com\r\n" + 
						"Nguyễn Thanh Tính   18TCLC_Nhật          Giải thuật            nguyentinh031220@gmail.com\r\n" + 
						"");
				Text.setBounds(12, 13, 659, 137);
				Text.setEditable(false);
				Text.setEnabled(true);
				window.getContentPane().add(Text);
				window.setLocationRelativeTo(null);
				
				window.setVisible(true);
	}
}
