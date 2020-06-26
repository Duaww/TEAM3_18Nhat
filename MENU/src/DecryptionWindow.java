
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
        						if((int)st.charAt(0) < 48 || (int)st.charAt(0)>57)
        						{
        							Text2.setText("-cannot decrypt this word : "+st+"\n -Character must be a number");
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
            					// decrytion first character
            					char firstCharacter = Handling.convertToChar(add);
            					if(firstCharacter == 0)
            					{
            						return;
            					}
            					res = res + firstCharacter; 
            					// decrytion another character
            					res = Handling.deCryptionFunction(st, index+1, res);
            					// add new word to new string 
            					ans = Handling.addString(ans, res);		
                            }
        					Text2.setText(ans);  
        					
        					//INSERT INTO DATABASE
							sqlConnection.INSERTintoDTB(dateFormat.format(currentDate), clockFormat.format(currentDate), "Decryption", Text1.getText(), Text2.getText());   
							
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
