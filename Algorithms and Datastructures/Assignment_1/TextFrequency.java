//Takes a textfile, reads all the lines and returns a string formatted as a table with the frequency and amount of the letters/symbols used.
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class TextFrequency 
{
	public static String getFrequency(String filePath)
	{		
		String frequency = "";
		Scanner scan = null;
		
		int[] amountOfChars = new int[127];
		int totalChars = 0; //Used for percentage calculation
		
		DecimalFormat format = new DecimalFormat("#.00");
		
		try
		{
			scan = new Scanner(new File(filePath));
			
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				for(int i = 0; i < line.length(); i++)
				{
					amountOfChars[(int)line.charAt(i)]++;
					totalChars++;
				}
			}
			scan.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		frequency = "Bokstav 	Antal	 	freq\n";
		for(int i = 0; i < amountOfChars.length; i++) //Format the table with the data
		{
			if(amountOfChars[i] > 0)
			{
				frequency += (char)i + "		" + amountOfChars[i] + "		" + ((format.format((double)amountOfChars[i]/totalChars*100))) + "%\n";
			}
		}
		return frequency;
	}
}
