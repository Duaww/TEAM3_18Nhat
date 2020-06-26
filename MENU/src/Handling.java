import javax.swing.JOptionPane;

public class Handling 
{
	public static String[] cutString(String s)
	{
		String[] catChuoi = s.split("\\s");
		return catChuoi;
	}
	public static String enCryptionFunction(String ip, String res)
	{
		int n = ip.length();
		for(int i = 0 ;i<n;i++)
		{
			if(i==0)
			{
				res = res + Integer.toString((int)ip.charAt(i));
			}
			else if (i==1)
			{
				res = res + ip.charAt(n-1);
			}
			else if(i==n-1)
			{
				res = res + ip.charAt(1);
			}
			else
			{
				res = res + ip.charAt(i);
			}
		}
		return res;
	}
	public static String deCryptionFunction(String st, int left, String res)
	{
		int n = st.length();
		for(int i= left;i<n;i++)
		{
			if(i==left)
			{
				res = res + st.charAt(n-1);
			}
			else if(i== n-1)
			{
				res = res + st.charAt(left);
			}
			else
			{
			 	res = res + st.charAt(i);
			}
		}
		return res;
	}
	public static String addString(String ans, String res)
	{
		if(ans=="")
		{
			ans = ans + res;
		}
		else
		{
			ans = ans + " " + res;
		}  
		return ans;
	}
	public static char convertToChar(String number)
	{
		int convertToInt = Integer.parseInt(number);
		char convertToChar = 0;
		try {
			// character must begin to 33
				if(convertToInt < 33)
				{
					throw new Exception("-Can't decrypt character!! : "+convertToInt+"\n-The ascii code of "
							+ "the character must begin from 33");
				}
				else
				{
					convertToChar = (char)convertToInt;
					return convertToChar;
					
				}
		
		} catch (Exception e1) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e1.getMessage());
			return 0;
		}
	}
}
