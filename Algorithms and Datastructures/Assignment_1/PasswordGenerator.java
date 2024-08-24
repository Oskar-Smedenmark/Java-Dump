//Oskar Andersson
//Generates passwords and tests if they are in an accepted format
public class PasswordGenerator
{
	//Generates a password between 8 and 12 characters long
	public static char[] generatePassword()
	{
		int len = (int)(Math.random()*5+8);
		char[] pwd = new char[len];
		for(int i = 0; i < len; i++)
		{
			int type = (int)(Math.random()*3);
			switch(type)
			{
			case 0://0-9
				pwd[i] = (char)((int)(Math.random()*10)+48);
				break;
				
			case 1://A-Z
				pwd[i] = (char)((int)(Math.random()*26)+65);
				break;
				
			case 2://a-z
				pwd[i] = (char)((int)(Math.random()*26)+97);
				break;
			}
		}
		return pwd;
	}
	
	//Checks if a password contains at least one big/small character and also at least one number
	public static boolean passwordCheck(String password)
	{
		return (password.length() >= 8 && password.length() <= 12 && password.matches("(.*)[a-z](.*)") && password.matches("(.*)[A-Z](.*)") && password.matches("(.*)[0-9](.*)")); //Checks if the password contains atleast one of big and small characters and also numbers
	}
}