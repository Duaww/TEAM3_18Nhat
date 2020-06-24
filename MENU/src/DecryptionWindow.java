
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
		showwindow();

	}
	public static void showwindow()
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
				
				JTextArea Text1 = new JTextArea();
				Text1.setBackground(new Color(255, 235, 205));
				Text1.setForeground(new Color(184, 134, 11));
				Text1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				Text1.setLineWrap(true);
				Text1.setBounds(12, 80, 286, 170);
				window.getContentPane().add(Text1);
				
				JLabel lblGiaiMa = new JLabel("GIA\u0309I MA\u0303");
				lblGiaiMa.setForeground(new Color(255, 0, 0));
				lblGiaiMa.setFont(new Font("Cambria", Font.BOLD, 20));
				lblGiaiMa.setBounds(310, 13, 77, 27);
				window.getContentPane().add(lblGiaiMa);
				
				JTextArea Text2 = new JTextArea();
				Text2.setEditable(false);
				Text2.setLineWrap(true);
				Text2.setForeground(new Color(184, 134, 11));
				Text2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				Text2.setBackground(new Color(255, 235, 205));
				Text2.setBounds(399, 80, 286, 170);
				window.getContentPane().add(Text2);
				
				JLabel DecryptedText = new JLabel("Text \u0111a\u0303 gia\u0309i ma\u0303");
				DecryptedText.setForeground(Color.MAGENTA);
				DecryptedText.setFont(new Font("Cambria", Font.BOLD, 18));
				DecryptedText.setBounds(399, 53, 136, 27);
				window.getContentPane().add(DecryptedText);
				
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
							try {
								if(Text1.getText().equals(""))
								{
									throw new Exception("Hãy nhập gì đó!");
								}
							} catch (Exception e2) {
								// TODO: handle exception
								JOptionPane.showMessageDialog(null,e2.getMessage());
								return;
							}
        					String[] word = ques.split("\\s");
        					String ans = "";
        					
        					for (String st : word) 
        					{
        						//character must be a number 
        						if((int)st.charAt(0) < 48 || (int)st.charAt(0)>57)
        						{
        							Text2.setText("Invalid Input");
        							JOptionPane.showMessageDialog(null, "Cannot decrypt this word : "+st+"\nCharacter must be a number");
        							return;
        						}
            					String add = "";
            					int index = -1;
            					String res = "";
            					for(int i=0;i<st.length();i++)
           						{
            						if((int)st.charAt(i)>=48 && (int)st.charAt(i)<=57)
            						{
            							// limited of code ascii is 126 to translate
            							if(Integer.parseInt(add + st.charAt(i)) > 126)
            							{
            								break;
            							}
            							else
            							{
            								add = add + st.charAt(i);
            								index++;
            							}
            						}
            					}
            					int converToInt = Integer.parseInt(add);
            					char convertToChar = 0;
            					try {
            						// character must begin to 33
            							if(converToInt < 33)
            							{
            								throw new Exception("Can't decrypt character!! : "+converToInt+"\nThe ascii code of "
            										+ "the character must begin from 33");
            							}
            							else
            							{
            								convertToChar = (char)converToInt;
            							}

            					} catch (Exception e1) {
            						JOptionPane.showMessageDialog(null, e1.getMessage());
            						Text2.setText("Invalid Input");
            						return;
            					}

            					res = res + convertToChar; 
            					for(int i= index+1;i<st.length();i++)
            					{
                					if(i==index+1)
                					{
                    					res = res + st.charAt(st.length()-1);
                					}
                					else if(i== st.length()-1)
                					{
                    					res = res + st.charAt(index+1);
                					}
                					else
                					{
                   				 		res = res + st.charAt(i);
                					}
            					}
            					if(ans=="")
            					{
                					ans = ans + res;
            					}
            					else
            					{
               	 					ans = ans + " " + res;
								}
								
								
                        }
        					Text2.setText(ans);
							Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
							Connection conn = DriverManager
									.getConnection("jdbc:sqlserver://DESKTOP-G2GES0F:1433;databaseName=CSDL;integratedSecurity=true");
							Statement sm = conn.createStatement();
							sm.executeUpdate("INSERT INTO Accesstimes " + "VALUES" + "(" 
												+ "'" + dateFormat.format(currentDate) + "'" 
												+ "," + "'" + clockFormat.format(currentDate) + "'" 
												+ "," + "'Decryption'," + "N'" + Text1.getText() + "'"
												+ "," + "N'" + Text2.getText() + "'" + ")");
						} catch (Exception e1) {
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
