
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
				Text.setText("\t\t             ------------------------------------\r\n\t\t\tTh\u00F4ng tin nho\u0301m pha\u0301t tri\u00EA\u0309n \r\n\t\t             ------------------------------------\r\n       T\u00EAn \t\t         L\u01A1\u0301p\t\t  Phu\u0323 tra\u0301ch\t             Li\u00EAn la\u0323c\r\nTr\u00E2\u0300n Vi\u0303nh \u0110a\u0323t\t  18TCLC_Nh\u00E2\u0323t      Giao di\u00EA\u0323n, CSDL         datvinhtran.dut@gmail.com\r\nNguy\u00EA\u0303n Thanh Ti\u0301nh\t  18TCLC_Nh\u00E2\u0323t\t  Gia\u0309i thu\u00E2\u0323t             nguyentinh031220@gmail.com\r\n");
				Text.setBounds(12, 13, 380, 127);
				Text.setEditable(false);
				Text.setEnabled(true);
				window.getContentPane().add(Text);
				window.setLocationRelativeTo(null);
				
				window.setVisible(true);
	}
}
