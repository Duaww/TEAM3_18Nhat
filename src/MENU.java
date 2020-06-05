import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MENU {

	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MENU window = new MENU();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MENU() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBounds(100, 100, 400, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblPhnMmMa = new JLabel("PH\u00C2\u0300N M\u00CA\u0300M MA\u0303 HO\u0301A VA\u0300 GIA\u0309I MA\u0303");
		lblPhnMmMa.setForeground(Color.RED);
		lblPhnMmMa.setFont(new Font("Cambria", Font.BOLD, 20));
		lblPhnMmMa.setBounds(49, 13, 295, 62);
		frame.getContentPane().add(lblPhnMmMa);
		
		JButton EncryptionBtn = new JButton("Ma\u0303 Ho\u0301a");
		EncryptionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		EncryptionBtn.setIcon(null);
		EncryptionBtn.setBackground(new Color(240, 248, 255));
		EncryptionBtn.setForeground(new Color(0, 128, 0));
		EncryptionBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EncryptionBtn.setBounds(84, 145, 219, 31);
		frame.getContentPane().add(EncryptionBtn);
		
		JButton DecryptionBtn = new JButton("Gia\u0309i Ma\u0303");
		DecryptionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		DecryptionBtn.setForeground(new Color(0, 128, 0));
		DecryptionBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DecryptionBtn.setBackground(new Color(240, 248, 255));
		DecryptionBtn.setBounds(84, 189, 219, 31);
		frame.getContentPane().add(DecryptionBtn);
		
		JButton HistoryBtn = new JButton("Li\u0323ch S\u01B0\u0309");
		HistoryBtn.setForeground(new Color(0, 128, 0));
		HistoryBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		HistoryBtn.setBackground(new Color(240, 248, 255));
		HistoryBtn.setBounds(84, 233, 219, 31);
		frame.getContentPane().add(HistoryBtn);
		
		JButton AboutUsBtn = new JButton("Nha\u0300 Pha\u0301t Tri\u00EA\u0309n");
		AboutUsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AboutUsBtn.setForeground(new Color(0, 128, 0));
		AboutUsBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AboutUsBtn.setBackground(new Color(240, 248, 255));
		AboutUsBtn.setBounds(84, 277, 219, 31);
		frame.getContentPane().add(AboutUsBtn);
		
		JButton ExitBtn = new JButton("Thoa\u0301t");
		ExitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		ExitBtn.setForeground(new Color(0, 128, 0));
		ExitBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ExitBtn.setBackground(new Color(240, 248, 255));
		ExitBtn.setBounds(84, 321, 219, 31);
		frame.getContentPane().add(ExitBtn);
		
		JLabel LogoLabel = new JLabel("");
		Image img = new ImageIcon (this.getClass().getResource("/ITFLogo2.jpg")).getImage();
		LogoLabel.setIcon(new ImageIcon(img));
		LogoLabel.setBounds(167, 71, 50, 50);
		frame.getContentPane().add(LogoLabel);
		
		frame.setVisible(true);
	}
}
