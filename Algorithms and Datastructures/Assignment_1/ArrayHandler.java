public class ArrayHandler {
	
	//Adds value x to the specified index in array a and doubles array a if insufficient space
	public static int[] addAtIndex(int[] a, int x, int index)
	{
		if(index >= a.length || index < 0)
		{
			System.out.println("\nIndex out of bounds.");
		}
		else
		{
			int temp = a[index]; //Value to move to the right
			a[index] = x;
			if(index + 1 <= a.length)
			{
				if(index + 1 < a.length && a[index + 1] == 0) // In case the value to the right is zero
				{
					a[index + 1] = temp;
				}
				else
				{
					if(temp != 0)
					{
						if(a[a.length-1] != 0) //If the right most value is zero don't double the size
						{
							a = doubleSize(a);
						}
						for(int i = a.length-2; i > index; i--)
						{
							a[i + 1] = a[i];
						}
						a[index + 1] = temp;
					}
				}
			}
		}
		return a;
	}
	
	//Doubles the size of the array and returns the new array
	private static int[] doubleSize(int[] a)
	{
		int[] arr = new int[a.length*2];
		for(int i = 0; i < a.length; i++)
		{
			arr[i] = a[i];
		}
		for(int i = a.length; i < arr.length; i++)
		{
			arr[i] = 0;
		}
		return arr;
	}
}
