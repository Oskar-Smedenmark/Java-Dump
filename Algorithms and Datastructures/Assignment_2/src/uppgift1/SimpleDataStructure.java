package uppgift1;

public class SimpleDataStructure
{
	private String [] friends;
	private int counter;
	
	public SimpleDataStructure()
	{
		friends= new String[5]; 
		counter=0;
	}
	/*Appends the other friend name to the end of this
	list.*/
	public boolean add(String other)
	{
		if(counter == friends.length)
		{
			doubleArr();
		}
		friends[counter] = other;
		counter++;
		return true;
	}
	/** returns the name at the specified index*/ 
	public String get(int index) throws ArrayIndexOutOfBoundsException
	{
		if(index >= counter || index < 0)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		return friends[index];
	}
	/** removes the first occurrence of the specified element
	in this list if the list contains the name*/
	public boolean remove( String name)
	{
		for(int i=0;i<counter; i++)
		{
			if(friends[i].equals(name))
			{
				friends[i] = null;
				for(int j = i; j < counter-1; j++)
				{
					friends[j] = friends[j+1];
				}
				friends[counter-1] = null;
				counter--;
				return true;
			}
		}
		return false;
	}
	/** prints all names in the array friends*/ 
	public void printFriends()
	{
		for(int i=0;i<counter; i++)
			System.out.print(friends[i]+ " " );
		System.out.println();
	}
	
	public boolean addSort(String namn)
	{
		if(counter == friends.length)
		{
			doubleArr();
		}
		for(int i = 0; i < counter; i++)
		{
			if(namn.compareTo(friends[i]) < 0)
			{				
				for(int j = counter-1; j >= i; j--)
				{
					friends[j+1] = friends[j];
				}
				friends[i] = namn;
				counter++;
				return true;
			}
		}
		friends[counter] = namn;
		counter++;
		return true;
	}
	
	public int size()
	{
		return counter;
	}
	private void doubleArr()
	{
		String[] arr = new String[friends.length*2];
		for(int i = 0; i < friends.length; i++)
		{
			arr[i] = friends[i];
		}
		friends = arr;
	}
	public static void main( String [] arg)
	{
		SimpleDataStructure myfriends = new SimpleDataStructure();
		myfriends.add("Calle");
		myfriends.add("Carlson");
		myfriends.add("Cirre");
		myfriends.add("Oskar");
		myfriends.add("Jonte");
		myfriends.printFriends();
		try
		{
		myfriends.get(23);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		myfriends.remove("Carlson");
		myfriends.printFriends();
		myfriends.addSort("Carlson");
		myfriends.addSort("Garlson");
		myfriends.addSort("Arne");

		myfriends.printFriends();
	}
}