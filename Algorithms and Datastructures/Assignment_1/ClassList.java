import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class ClassList {
	
	//Loads a list of names into an ArrayList and returns it
	public static ArrayList<String> loadList(String filePath)
	{
		ArrayList<String> list = new ArrayList<String>();
		
		Scanner fileScan = null;
		
		try
		{
			fileScan = new Scanner(new File(filePath));
			while(fileScan.hasNextLine())
			{
				String line = fileScan.nextLine();
				String[] name = line.split(" |\t");
				list.add(name[1] + " " + name[0]);
			}
			fileScan.close();
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}

		System.out.println(list.toString());
		return list;
	}
	
	//Returns name from a given index
	public static String findName(ArrayList<String> list, int index)
	{
		return list.get(index);
	}
	
	//Deletes a name from the list if it exists
	public static boolean deleteName(ArrayList<String> list, String name)
	{
		boolean success = false;
		
		for(int i = 0; i < list.size(); i++)
		{
			if(name.equals(list.get(i)))
			{
				list.remove(i);
				success = true;
			}
		}
		return success;
	}
	
	//Adds a name to the list if it doesn't already exists and places it to keep the sort correct
	 public static boolean addToList(ArrayList<String> list, String name)
	 {
		 boolean success = false; //Successfully added name to list or not
		 boolean exists = false; //Name exists in list or not
		 
		 int desiredIndex = -1;
		 boolean foundIndex = false;
		 
		 for(int i = 0; i < list.size() && !exists; i++)
		 {
			 String curName = list.get(i);
			 int compVal = name.compareTo(curName);
			 if(compVal < 0 && !foundIndex)
			 {
				 //closest = compVal;
				 desiredIndex = i;
				 foundIndex = true;
			 }
			 if(compVal == 0)
			 {
				 exists = true;
			 }
		 }
		 if(!exists) //If the name already exists in the list
		 {
			 if(desiredIndex == -1)
			 {
				 desiredIndex = list.size();
			 }
			 list.add(desiredIndex, name);
			 success = true;
		 }
		 return success;
	 }
	
}
