import javax.swing.JOptionPane;

public class Handling 
{
	public static String[] cutString(String s)
	{
		String[] newString = s.split("\\s");
		return newString;
	}
	public static String enCryptionFunction(String s, String convert)
	{
		int n = s.length();
		for(int i = 0 ;i<n;i++)
		{
			if(i==0)
			{
				convert = convert + Integer.toString((int)s.charAt(i));
			}
			else if (i==1)
			{
				convert = convert + s.charAt(n-1);
			}
			else if(i==n-1)
			{
				convert = convert + s.charAt(1);
			}
			else
			{
				convert = convert + s.charAt(i);
			}
		}
		return convert;
	}
	public static String deCryptionFunction(String s, int left, String convert)
	{
		int n = s.length();
		for(int i= left;i<n;i++)
		{
			if(i==left)
			{
				convert = convert + s.charAt(n-1);
			}
			else if(i== n-1)
			{
				convert = convert + s.charAt(left);
			}
			else
			{
			 	convert = convert + s.charAt(i);
			}
		}
		return convert;
	}
	public static String addString(String result, String convert)
	{
		if(result=="")
		{
			result = result + convert;
		}
		else
		{
			result = result + " " + convert;
		}  
		return result;
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
	public static boolean checkFirstChar(char check)
	{
		if((int)check < 48 || (int)check>57)
		{
			JOptionPane.showMessageDialog(null, "Character must be a number");
			return false;
		}
		return true;
	}

        //char firstCharacter = Handling.convertToChar(add);
	public static  int index = -1; // Mark locations to swap
	public static char deCrytionFirstChar(String s)
	{
		String add = "";
		int n = s.length();
		for(int i=0;i<n;i++)
		{
			if((int)s.charAt(i) >= 48 && (int)s.charAt(i) <=57)
			{
				//limited of code ascii is 126 to convert
				if(Integer.parseInt(add + s.charAt(i)) > 126)
				{
					break;
				}
				else
				{
					add = add + s.charAt(i);
					index++;
				}
			}
		}
		return convertToChar(add);
	}
}
