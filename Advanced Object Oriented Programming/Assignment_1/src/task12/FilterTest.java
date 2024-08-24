package task12;

public class FilterTest {
	
	public static String[] filter(String[] a, Filter f)
	{
		String[] accepted = new String[a.length];
		int numAcc = 0;
		for(int i = 0; i < a.length; i++)
		{
			accepted[i] = null;
			if(f.accept(a[i]))
			{
				accepted[i] = a[i];
				numAcc++;
			}
		}
		String[] finalAcc = new String[numAcc];
		int index = 0;
		for(int i = 0; i < accepted.length; i++)
		{
			if(accepted[i] != null)
			{
				finalAcc[index] = accepted[i];
				index++;
			}
		}
		
		return finalAcc;
	}
	
	public static void main(String[] args)
	{
		String[] arr = {"This is a long string", "shorter", "ok", "123", "four", "Woo", "yea", "Yeah"};
		String[] newArr = filter(arr, new MaxThreeFilter());
		for(int i = 0; i < newArr.length; i++)
		{
			System.out.println(newArr[i]);
		}
	}
}

