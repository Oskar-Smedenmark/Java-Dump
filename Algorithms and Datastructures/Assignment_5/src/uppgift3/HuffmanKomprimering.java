package uppgift3;

//Du får (om du vill) ändra strukturen i klassen Huffman genom att lägga till metoder eller 
//variabler. Observera att variablerna och metoderna i klassen är static.

import java.util.*;
import java.io.*;

class HuffmanKomprimering {

	private static ArrayList<HuffmanTree> theForest;
	private static int[] freqs;
	private static String[] codes;
	private static int setSize;

	private static void readFile(String filename) {

		// läser in ett tecken i taget från filen (-1 motsvarar EndOfFile) som ascii
		// på platsen i arrayen som motsvarar tecknet adderas 1, freqs[ascii]++;
		Scanner file = null;
		try {
			file = new Scanner(new File(filename));
			while (file.hasNext()) {
				String line = file.nextLine();
				for(int i = 0; i < line.length(); i++)
				{
					int chr = (int)line.charAt(i);
					freqs[chr]++;
				}
			}
			file.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private static void makeTree() {
		// skapar Huffman träd med ascii-kod i noden och frekvensen som vikt
		// lägger till trädet in theForest
		for (int i = 0; i < freqs.length; i++) {
			if (freqs[i] > 0) {
				theForest.add(new HuffmanTree(i, freqs[i]));
			}
		}
		while(theForest.size() > 1) //Until we only have one tree keep merging the smallest ones
		{
			Collections.sort(theForest);
			HuffmanTree t1 = theForest.remove(0);
			HuffmanTree t2 = theForest.remove(0);
			HuffmanTree tree = new HuffmanTree(t1,t2);
			theForest.add(tree);
		}
	}

	private static void makeCods() {

		// använder metoden codes() fšr din slutliga HT. Metoden finns definierad i klassen HuffmanTree. Undersšk den. 
		theForest.get(0).codes(codes); //creates the codes and adds the to the codes array
	}

	private static void showResults() {
		theForest.get(0).printInOrder(freqs, codes); //Uses a recursive method in HuffmanTree I made
	}

	private static void makeFile() {
		// anvŠnd stringTobyte fšr att bygga den komprimerade filen.
		FileOutputStream stream = null;
		try
		{			 
			stream = new FileOutputStream(new File("compressed.txt"));
			String code = "";
			for (int i = 0; i < freqs.length; i++) //adds the codes into one long string
			{
				if (freqs[i] > 0) {
					code += codes[i];
				}
			}
			if(code.length()%8 != 0) //Check if the string is divisible by 8 if not add zeroes to the end until it is
			{
				for(int i = 0; i < code.length()/8;i++)
				{
					code += "0";
				}
			}
			for(int i = 0; i < code.length()-8; i += 8) //Write the bytes by dividing the code into eights
			{
				String codeSnip = code.substring(i, i+8);
				stream.write(stringTobyte(codeSnip));
			}
			stream.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}

//metoden tar som argument en strŠng (11000111) och konvertera den till byte
//anvŠnd metoden fšr att konvertera dina koder till byte som skall sedan sparas till filen. 

	public static byte stringTobyte(String s) {
 		byte b = 0;
		if (s.length() != 8) {
			throw new RuntimeException("The string representation of the byte in not of proper length!");
		}
		for (int i = 0; i < 8; i++) {
			if (s.charAt(i) == '1')
				b |= (1 << (7 - i));

		}
		return b;
	}

	public static void main(String[] a) {
		setSize = 256; // så många olika tecken.
		freqs = new int[setSize];
		codes = new String[setSize];
		theForest = new ArrayList();
		Scanner scan = new Scanner(System.in);
		System.out.println("Ange filens namn");
		String fileName = scan.next();
		readFile(fileName);
		makeTree();
		makeCods();
		showResults();
		makeFile();
	}
}