package uppgift2;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class TreeSetTask {

	public static void main(String[] args)
	{
		TreeSet<String> words = new TreeSet<String>();
		Scanner file = null;
		
		try
		{
			file = new Scanner(new File("Test.txt"));
			
			while(file.hasNextLine())
			{
				String line = file.nextLine();
				String[] sWords = line.split(" |\t");
				for(int i = 0; i < sWords.length; i++)
				{
					words.add(sWords[i]);
				}
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	
		Iterator<String> ite = words.iterator();
		while(ite.hasNext())
		{
			System.out.println(ite.next());
		}
		//Den skriver ut orden i asciitabellens ordning
		//Den gör detta eftersom TreeSet implementerar SortedSet vilket innebär att elementen sorteras efter deras
		//naturliga sortering, vilket i strängars fall är Asciitabellens ordning.
	}
}
