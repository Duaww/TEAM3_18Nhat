
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;


public class EncryptionWindow {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		initUI();
	}
	public static void initUI()
	{
		Date currentDate = new Date();
		SimpleDateFormat clockFormat = new SimpleDateFormat ("h:mm a");
		SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyy");
		
		JFrame window = new JFrame ("Encryption Box");
		window.getContentPane().setBackground(new Color(240, 248, 255));
		window.setBackground(new Color(240, 248, 255));
				
				window.setBounds(100, 100, 718, 324);
				window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				window.getContentPane().setLayout(null);
				
				JLabel TextLabel = new JLabel("Nh\u00E2\u0323p Text");
				TextLabel.setForeground(new Color(255, 0, 255));
				TextLabel.setFont(new Font("Cambria", Font.BOLD, 18));
				TextLabel.setBounds(12, 53, 96, 27);
				window.getContentPane().add(TextLabel);
				
				JTextArea Text1 = new JTextArea();
				Text1.setBackground(new Color(255, 235, 205));
				Text1.setForeground(new Color(184, 134, 11));
				Text1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				Text1.setLineWrap(true);
				Text1.setBounds(12, 80, 286, 170);
				window.getContentPane().add(Text1);
				
				JLabel lblMaHoa = new JLabel("MA\u0303 HO\u0301A");
				lblMaHoa.setForeground(new Color(255, 0, 0));
				lblMaHoa.setFont(new Font("Cambria", Font.BOLD, 20));
				lblMaHoa.setBounds(310, 13, 77, 27);
				window.getContentPane().add(lblMaHoa);
				
				JTextArea Text2 = new JTextArea();
				Text2.setEditable(false);
				Text2.setLineWrap(true);
				Text2.setForeground(new Color(184, 134, 11));
				Text2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				Text2.setBackground(new Color(255, 235, 205));
				Text2.setBounds(399, 80, 286, 170);
				window.getContentPane().add(Text2);
				
				JLabel EncryptedText = new JLabel("Text \u0111a\u0303 ma\u0303 ho\u0301a");
				EncryptedText.setForeground(Color.MAGENTA);
				EncryptedText.setFont(new Font("Cambria", Font.BOLD, 18));
				EncryptedText.setBounds(399, 53, 136, 27);
				window.getContentPane().add(EncryptedText);
				
				JButton EnBtn = new JButton("");
				EnBtn.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\Change3.png"));
				EnBtn.setForeground(new Color(255, 0, 0));
				EnBtn.setFont(new Font("Cambria", Font.PLAIN, 14));
				EnBtn.setBounds(310, 118, 77, 44);
				EnBtn.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						try 
						{
							String ques = Text1.getText();
							if(ques.equals("") == true)
							{
								JOptionPane.showMessageDialog(null, "Input is empty !");
								return;
							}
							// cut string
							String[] word = Handling.cutString(ques);
							String ans = "";
							for (String st : word) 
							{
								String res = "";
								// encrytion
								res = Handling.enCryptionFunction(st, res);
								// add word was encryted to new string
								ans = Handling.addString(ans, res);
							}
							Text2.setText(ans);
							
							//INSERT INTO DATABASE
							sqlConnection.INSERTintoDTB(dateFormat.format(currentDate), clockFormat.format(currentDate), "Encryption", Text1.getText(), Text2.getText());
							
						} catch (Exception e1) {
							System.out.println("Error!");
						}
					}
				});
				window.getContentPane().add(EnBtn);
				
				JButton ResetBtn = new JButton("Reset");
				ResetBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Text1.setText("");
						Text2.setText("");
					}
				});
				ResetBtn.setBounds(310, 175, 77, 25);
				window.getContentPane().add(ResetBtn);
				window.setLocationRelativeTo(null);
				
				window.setVisible(true);
	}
}
