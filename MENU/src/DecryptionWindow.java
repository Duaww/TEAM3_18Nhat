
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class DecryptionWindow {

	public static void main(String[] args) {
		initUI();

	}
	public static void initUI()
	{
		Date currentDate = new Date();
		SimpleDateFormat clockFormat = new SimpleDateFormat ("h:mm a");
		SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyy");
		
		JFrame window = new JFrame ("Decryption Box");
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
				
				JTextArea TextInput = new JTextArea();
				TextInput.setBackground(new Color(255, 235, 205));
				TextInput.setForeground(new Color(184, 134, 11));
				TextInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
				TextInput.setLineWrap(true);
				TextInput.setBounds(12, 80, 286, 170);
				window.getContentPane().add(TextInput);
				
				JLabel lblGiaiMa = new JLabel("GIA\u0309I MA\u0303");
				lblGiaiMa.setForeground(new Color(255, 0, 0));
				lblGiaiMa.setFont(new Font("Cambria", Font.BOLD, 20));
				lblGiaiMa.setBounds(310, 13, 77, 27);
				window.getContentPane().add(lblGiaiMa);
				
				JTextArea TextOutput = new JTextArea();
				TextOutput.setEditable(false);
				TextOutput.setLineWrap(true);
				TextOutput.setForeground(new Color(184, 134, 11));
				TextOutput.setFont(new Font("Tahoma", Font.PLAIN, 15));
				TextOutput.setBackground(new Color(255, 235, 205));
				TextOutput.setBounds(399, 80, 286, 170);
				window.getContentPane().add(TextOutput);
				
				JLabel DecryptedText = new JLabel("Text \u0111a\u0303 gia\u0309i ma\u0303");
				DecryptedText.setForeground(Color.MAGENTA);
				DecryptedText.setFont(new Font("Cambria", Font.BOLD, 18));
				DecryptedText.setBounds(399, 53, 136, 27);
				window.getContentPane().add(DecryptedText);
				
				JButton EnBtn = new JButton("");
				EnBtn.setIcon(new ImageIcon("Change3.png"));
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
							String ques = TextInput.getText();
							if(ques.equals("") == true)
							{
								JOptionPane.showMessageDialog(null, "Input is empty");
								return;
							}
							// cut string
							String[] word = Handling.cutString(ques);
							String ans = "";
							for (String st : word)
							{
								//character must be a number
								if(Handling.checkFirstChar(st.charAt(0)) == false)
								{
									return;
								}
								String res = "";
								// decryption first character
								char firstCharacter = Handling.deCrytionFirstChar(st);
								if(firstCharacter == 0)
								{
									return;
								}
								res = res + firstCharacter;
								// decryption another character
								res = Handling.deCryptionFunction(st, Handling.index+1, res);
								// add new word to new string
								ans = Handling.addString(ans, res);
								// set location = -1 to begin the next word
								Handling.index = -1;
							 }
							TextOutput.setText(ans);
							//INSERT INTO DATABASE
							//sqlConnection.INSERTintoDTB(dateFormat.format(currentDate), clockFormat.format(currentDate), "Decryption", Text1.getText(), Text2.getText());   

						} 
						catch (Exception e1) 
						{
							
						}
					}
				});
				window.getContentPane().add(EnBtn);
				
				JButton ResetBtn = new JButton("Reset");
				ResetBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TextInput.setText("");
						TextOutput.setText("");
					}
				});
				ResetBtn.setBounds(310, 175, 77, 25);
				window.getContentPane().add(ResetBtn);
				window.setLocationRelativeTo(null);
				
				window.setVisible(true);
	}
}
