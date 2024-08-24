package uppgift_2;

import java.util.*;
import java.io.*;

public class LgerProgram {
	static Scanner scan = new Scanner(System.in);
	static ItemList inStore = new ItemList();
	static ItemList outStore = new ItemList();
	static long nr = 1111111111;

	public static void main(String[] args) {
		try {
			Scanner filescan = new Scanner(new File("Verktyg.txt"));
			while (filescan.hasNext())
				System.out.println(filescan.next());
			filescan.close();
		}

		catch (IOException ex) {
			System.out.println("Filen finns inte");
		}
		printMenu();
		int choice = scan.nextInt();
		scan.nextLine();

		while (choice != 0) {
			dispatch(choice);
			printMenu();
			choice = scan.nextInt();
			scan.nextLine();
		}
		dispatch(0);
	}

	public static String getRFID() {
		return "" + nr++;

	}

	public static void dispatch(int choice) {
		switch (choice) {
		case 0:
			System.out.println("EXIT");
			Item[] toolsInStore = inStore.toArray();
			String strTools = "";
			for(int i = 0; i < toolsInStore.length; i++)
			{
				strTools += toolsInStore[i].toString() + "\r\n";
			}
			Item[] toolsOutStore = outStore.toArray();
			for(int i = 0; i < toolsOutStore.length; i++)
			{
				strTools += toolsOutStore[i].toString() + "\r\n";
			}
			try 
			{
				PrintWriter waresPrinter = new PrintWriter("Tools.txt");
				waresPrinter.write(strTools);
				waresPrinter.close();
			} 
			catch (FileNotFoundException e1) 
			{
				e1.printStackTrace();
			}
			
			System.exit(0);
			break;

		case 1: { //Fill the warehouse with items from a file
			Scanner fileScanner = null;
			try
			{
				System.out.print("File name with extension: ");
				fileScanner = new Scanner(new File(scan.nextLine())); //File to load tools from
				String line = "";
				while(fileScanner.hasNextLine())
				{
					line = fileScanner.nextLine();
					
					inStore.addSort(new Item(line, getRFID())); //Add them sorted
				}
				fileScanner.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			break;
		}
		case 2: { //Display all the items currently in the store
			inStore.printList();
			break;
		}
		case 3: { //Display all the items currently borrowed
			outStore.printList();
			break;
		}

		case 4: { //Borrow an item
			System.out.print("Item ID: ");
			String inId = scan.nextLine();
			if(inStore.find(inId)) //Check if item exists
			{
				Calendar calendar = Calendar.getInstance();
				Date newDate = calendar.getTime();
				
				Item ret = inStore.remove(inId);
				ret.setDeliverDate(newDate);
				
				outStore.addSort(ret);
			}
			else
			{
				System.out.println("Item does not exist");
			}
			break;
		}
		case 5: { //Return a borrowed item
			System.out.print("Item ID: ");
			String inId = scan.nextLine();
			if(outStore.find(inId)) //Check if item exists
			{
				Item ret = outStore.remove(inId);
				ret.setDeliverDate(null);
				inStore.addSort(ret);
			}
			else
			{
				System.out.println("Item does not exist");
			}
			break;
		}

		case 6: {//Prints the items that are searched
			System.out.print("Item name or item ID: ");
			inStore.printItems(scan.nextLine());
			break;
		}

		default:
			System.out.println("Sorry, invalid choice");
		}
	}

	// ----------------------------
	// Skriver ut användar meny
	// ----------------------------
	public static void printMenu() {
		System.out.println("\n  Welcome");
		System.out.println("   ====");
		System.out.println("0: Exit");
		System.out.println("1: Setup Store");
		System.out.println("2: Tools In Store");
		System.out.println("3: Tools Borrowed");
		System.out.println("4: Borrow Tool");
		System.out.println("5: Return Tool");
		System.out.println("6: Search For Tool");

		System.out.print("\nEnter your choice: ");
	}
}

/*
 * Exempel hur man läser från fil. try{ Scanner filescan=new Scanner(new
 * File("Verktyg.txt")); while( filescan.hasNext()) System.out.println(
 * filescan.next()); }
 * 
 * catch(IOException ex){System.out.println("Filen finns inte");
 */