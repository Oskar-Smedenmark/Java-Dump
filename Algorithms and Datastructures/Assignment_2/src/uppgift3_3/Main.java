package uppgift3_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		program();
	}
	
	public static void program()
	{
		int choice = 0;
		while(choice == 0) //Loops until a valid choice have been made
		{
			System.out.println("1. Sort by land name");
			System.out.println("2. Sort by land area");
			System.out.println("3. Sort by land population");
			System.out.print("Make a choice: ");
			Scanner input = new Scanner(System.in);
			choice = Integer.parseInt(input.next());
			if(choice != 1 && choice != 2 && choice != 3)
			{
				choice = 0;
			}
			else
			{
				input.close();
			}
		}
		switch(choice)
		{
		case 1:
			NameSort nameComp = new NameSort();
			writeCountriesSorted(nameComp, "Countries by name.txt");
			break;

		case 2:
			AreaSort areaComp = new AreaSort();
			writeCountriesSorted(areaComp, "Countries by area.txt");
			break;
			
		case 3:
			PopSort popComp = new PopSort();
			writeCountriesSorted(popComp, "Countries by population.txt");
			break;
		}

		System.out.println("Done!");
		
	}
	
	//Writes all the countries from the europa.txt file 
	public static void writeCountriesSorted(Comparator<Land> comp, String fileName)
	{
		Scanner fileScan = null;
		
		ArrayList<Land> lands = new ArrayList<Land>();
		
		try
		{
			fileScan = new Scanner(new File("europa.txt"));
			fileScan.nextLine();
			fileScan.nextLine();
			while(fileScan.hasNextLine()) //Splits the lines, creates a land object from the info and writes it to a file
			{
				String[] info = fileScan.nextLine().split(" |\t");
				lands.add(new Land(info[0], info[3], Integer.parseInt(info[1]), Double.parseDouble(info[2])));
			}
			fileScan.close();
			Collections.sort(lands, comp);
			PrintWriter printer = new PrintWriter(fileName);
			Iterator<Land> ite = lands.iterator();
			while(ite.hasNext())
			{
				printer.write(ite.next().toString() + "\r\n\r\n");
			}
			printer.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void test()
	{
		ArrayList<Land> lands = new ArrayList<Land>();
		Land sweden = new Land("Sweden", "Stockholm", 10000000, 450000);
		Land germany = new Land("Germany", "Berlin", 83000000, 357000);
		
		NameSort nameComp = new NameSort();
		AreaSort areaComp = new AreaSort();
		PopSort popComp = new PopSort();
		lands.add(sweden);
		lands.add(germany);
		printList(lands);
		
		Collections.sort(lands, nameComp);
		printList(lands);
		
		Collections.sort(lands, areaComp);
		printList(lands);

		Collections.sort(lands, popComp);
		printList(lands);
		
		Scanner fileScan = null;
		
		lands = new ArrayList<Land>();
		
		try
		{
			fileScan = new Scanner(new File("europa.txt"));
			fileScan.nextLine();
			fileScan.nextLine();
			while(fileScan.hasNextLine())
			{
				String[] info = fileScan.nextLine().split(" |\t");
				lands.add(new Land(info[0], info[3], Integer.parseInt(info[1]), Double.parseDouble(info[2])));
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}

		System.out.println("\n");
		
		Collections.sort(lands, nameComp);
		printList(lands);
		
		Collections.sort(lands, areaComp);
		printList(lands);

		Collections.sort(lands, popComp);
		printList(lands);
	}
	
	//Prints the list in a readable fashion in the console
	public static void printList(ArrayList<Land> a)
	{
		Iterator<Land> ite = a.iterator();
		while(ite.hasNext())
		{
			System.out.println("\n" + ite.next().toString());
		}
		System.out.println("\n");
	}
}
