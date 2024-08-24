package uppgift_3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Searchs {
	
	public static void main(String[] args)
	{
		searches();
		
	}
	
	//Searches for x in a linear fashion and returns the position of x or -1 if x does not exist in the array
	public static int linearSearch(int[] a, int x)
	{
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] == x)
			{
				return i;
			}
		}
		return -1;
	}
	
	//Searches for x in a sorted integer array and returns position of x or -1 if x does not exist in the array
	public static int binarySearch(int[] a, int x)
	{
		int max = a.length;
		int min = 0;
		int size = a.length;
		while(size > 1)
		{
			int index = (int)((max - min)/2+min);
			if(a[index] < x)
			{
				min = index;
			}
			else if(a[index] > x)
			{
				max = index;
			}
			else
			{
				return index;
			}
			
			size /= 2;
		}
		return -1;
	}
	
	//Creates an array with a given size and fills it with random integers between min and max
	public static int [] createArray( int size, int min, int max)
	{
		int[] a = new int[size];
		for(int i = 0; i < size; i++)
		{
			a[i] = randomInterval(min,max);
		}
		return a;
	}
	
	//Returns a random integer between a minimum and a maximum
	public static int randomInterval(int min, int max)
	{
		return min + (int)(Math.random()*((max-min)+1));
	}
	
	/*Tests how long it takes to use linear search and binary search for a randomly generated array,
	 * writes the results into two different files called "Linear searches.txt" and "Binary searches.txt"*/
	public static void searches()
	{
		int arraySize = 100000;
		int min = 1;
		int max = 1000;
		int[] arr = createArray(arraySize, min, max);
		int searchedNum = randomInterval(min, max);
		String binary = ""; //To be written to the files
		String linear = "";
		for(int i = 0; i < 10; i++)
		{
			Long start = System.nanoTime();
			linearSearch(arr, searchedNum);
			Long end = System.nanoTime();
			linear += i + ": " + (end-start)/1000000.0 + "ms\r\n";
			
			Arrays.sort(arr);
			start = System.nanoTime();
			binarySearch(arr, searchedNum);
			end = System.nanoTime();
			binary += i + ": " + (end-start)/1000000.0 + "ms\r\n";
			
			arr = createArray(arraySize, min, max);
			searchedNum = randomInterval(min, max);
		}
		try
		{
			PrintWriter linearWriter = new PrintWriter("Linear searches.txt");
			linearWriter.write(linear);
			linearWriter.close();
			PrintWriter binaryWriter = new PrintWriter("Binary searches.txt");
			binaryWriter.write(binary);
			binaryWriter.close();
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}	
}
