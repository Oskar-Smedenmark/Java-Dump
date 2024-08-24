package uppgift1;

public class Recursives {

	public static void main(String[] args)
	{
		print(10);
		
		System.out.println(palindrom("RADAR"));
		
		System.out.println(power(2,31)-1);
	}
	
	/**
	 * Prints the numbers 0 - n
	 * @param n the number to count to
	 */
	public static void print(int n)
	{
		if(n >= 0)
		{
			print(n-1);
			System.out.println(n);
		}
	}
	
	/**
	 * Checks if a word is a palindrom or not
	 * @param word the word to check
	 * @return true if the word is a palindrom false otherwise
	 */
	public static boolean palindrom(String word)
	{
		boolean res = false;
		if(word.length() > 1 && word.charAt(0) == word.charAt(word.length()-1))
		{
			String newWord = word.substring(1, word.length()-1);
			res = palindrom(newWord);
		}
		else if(word.length() <= 1)
		{
			res = true;
		}
		return res;
	}
	
	/**
	 * Calculates the power of a number
	 * @param base the base
	 * @param exp the exponent
	 * @return the result
	 */
	public static int power(int base, int exp)
	{
		int res = base;
		if(exp == 0)
		{
			return 1;
		}
		if(exp > 1)
		{
			res *= power(res, exp-1);
		}
		return res;
	}
}
