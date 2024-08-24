import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
public class Tests 
{
	public static void main(String[] args)
	{
		caesarEncryption();
	}
	
	//Task 1
	public static void generate100Passwords()
	{
		for(int i = 0; i < 100; i++)
		{
			System.out.println(PasswordGenerator.generatePassword());
		}
	}
	
	//Task 3
	public static void generate1000Passwords()
	{
		for(int i = 0; i < 1000; i++)
		{
			String strPwd = "";
			while(!PasswordGenerator.passwordCheck(strPwd))
			{
				char[] curPwd = PasswordGenerator.generatePassword();
				strPwd = new String(curPwd);
			}
			System.out.println(strPwd);
		}
	}
	
	//Task 4
	public static void testArray()
	{
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		System.out.println(Arrays.toString(arr));
		arr = ArrayHandler.addAtIndex(arr, 30, 20);
		arr = ArrayHandler.addAtIndex(arr, 30, -1);
		arr = ArrayHandler.addAtIndex(arr, 30, 8);
		System.out.println(Arrays.toString(arr) + "\n");
		
		int[] arr2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,0};
		arr2 = ArrayHandler.addAtIndex(arr2, 30, 19);
		System.out.println(Arrays.toString(arr2));	
		arr2 = ArrayHandler.addAtIndex(arr2, 32, 0);
		System.out.println("\n"+Arrays.toString(arr2));
		
		System.out.println();
		int[] arr3 = new int[0];
		arr3 = ArrayHandler.addAtIndex(arr3, 14, 0);
		System.out.println("\n"+Arrays.toString(arr3));
		
		System.out.println();
		int[] arr4 = new int[1];
		arr4 = ArrayHandler.addAtIndex(arr4, 14, 0);
		System.out.println("\n"+Arrays.toString(arr4));
		arr4 = ArrayHandler.addAtIndex(arr4, 25, 0);
		System.out.println("\n"+Arrays.toString(arr4));
		arr4 = ArrayHandler.addAtIndex(arr4, 50, 0);
		System.out.println("\n"+Arrays.toString(arr4));
		
		System.out.println();
		int[] arr5 = {1,2,3,0,4,5,6,0};
		arr5 = ArrayHandler.addAtIndex(arr5, 14, 1);
		System.out.println("\n"+Arrays.toString(arr5));
	}

	//Task 5
	public static void frequencyFile()
	{
		System.out.println(TextFrequency.getFrequency("text.txt"));
	}

	//Task 6
	public static void caesarEncryption()
	{
		System.out.print("How many keys?: ");
		Scanner input = new Scanner(System.in);
		
		int nrOfKeys = input.nextInt();
		int[] keys = new int[nrOfKeys];
		
		for(int i = 0; i < nrOfKeys; i++)
		{
			System.out.print("\nkey " + i + ": ");
			keys[i] = input.nextInt();
		}
		
		System.out.println("\nPlease input file name to encrypt: ");
		String fileName = input.next();
		input.close();
		
		String encryptedFileName = encrypt(fileName, nrOfKeys, keys);
		decrypt(encryptedFileName, nrOfKeys, keys);
		System.out.println("Finsihed");
		
		
	}
	//Encrypts data on a text file with the caesar method
	public static String encrypt(String fileName, int nrOfKeys, int[] keys)
	{
		Scanner scanFile = null;
		PrintWriter writer = null;
		try 
		{
			scanFile = new Scanner(new File(fileName));
			
			String encrypted = "";
			int key = 0;
			while(scanFile.hasNextLine())
			{
				char[] toEncrypt = scanFile.nextLine().toCharArray();
				for(int i = 0; i < toEncrypt.length; i++)
				{
					encrypted += Caesar.encrypt_character(toEncrypt[i], keys[key]);
					key++;
					if(key >= nrOfKeys) //Cycle the keys
					{
						key = 0;
					}
				}
				encrypted += "\n";
			}
			scanFile.close();
			writer = new PrintWriter("encrypted_"+fileName);
			writer.write(encrypted);
			writer.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		return "encrypted_"+fileName;
	}
	//Decrypts data on a text file with the caesar method
	public static void decrypt(String fileName, int nrOfKeys, int[] keys)
	{
		Scanner scanFile = null;
		PrintWriter writer = null;
		try 
		{
			scanFile = new Scanner(new File(fileName));
			
			String decrypted = "";
			int key = 0;
			while(scanFile.hasNextLine())
			{
				char[] toDecrypt = scanFile.nextLine().toCharArray();
				for(int i = 0; i < toDecrypt.length; i++)
				{
					decrypted += Caesar.decrypt_character(toDecrypt[i], keys[key]);
					key++;
					if(key >= nrOfKeys) //Cycle the keys
					{
						key = 0;
					}
				}
				decrypted += "\n";
			}
			scanFile.close();
			writer = new PrintWriter("decrypted_"+fileName);
			writer.write(decrypted);
			writer.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	/*Task 7
	Loads a list from a file and reads/adds/delete names from it*/
	public static void arrayList()
	{
		ArrayList<String> klassLista = ClassList.loadList("Klasslista.txt");
		
		System.out.println(ClassList.findName(klassLista, 2));
		System.out.println(ClassList.deleteName(klassLista, "Andersson Amanda"));
		System.out.println(ClassList.deleteName(klassLista, "Andersson "));
		System.out.println(klassLista.toString());
		System.out.println(ClassList.addToList(klassLista, "Andersson Amanda"));
		System.out.println(klassLista.toString());
		System.out.println(ClassList.addToList(klassLista, "Andersson Amanda"));
		System.out.println(ClassList.addToList(klassLista, "Indra Abc"));
		System.out.println(ClassList.addToList(klassLista, "Zindra Cba"));
		System.out.println(ClassList.addToList(klassLista, "Dandelion Dandy"));
		System.out.println(klassLista.toString());
		
	}
}
