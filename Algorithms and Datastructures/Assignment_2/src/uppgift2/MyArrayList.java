package uppgift2;
import java.util.*;
public class MyArrayList<AnyType> implements Iterable<AnyType> 
{
	 private AnyType [] list;
	 private int count;
	 
	 @SuppressWarnings("unchecked")
	public MyArrayList()
	{
		 list = (AnyType []) new Object[10];
		 count=0;
	}
	  
	
	public MyArrayList(int initialCapacity)
	{
		list =(AnyType [])new Object[initialCapacity];
	}
	
	/*Appends the specified element to the end of this list.*/
	
	@SuppressWarnings("unchecked")
	public boolean add(AnyType o)
	{
		if(o == null)
		{
			return false;
		}
		for(int i = 0; i < list.length; i++)
		{
			if(list[i] == null)
			{
				list[i] = o;
				count++;
				return true;
			}
		}
		int lastIndex = list.length;
		AnyType[] newList =  (AnyType[]) new Object[list.length*2];
		for(int i = 0; i < list.length; i++)
		{
			newList[i] = list[i];
		}
		list = newList;
		list[lastIndex] = o;
		count++;
		return true;
	}
	
	/** tests if the specified element is a component of this list*/
	public boolean contains(AnyType o)
	{
		if(o == null)
		{
			return false;
		}
		for(int i = 0; i < count; i++)
		{
			if(o.equals(list[i]))
			{
				return true;
			}
		}
		return false;
	}
	/** returns the component at the specified index*/
	public AnyType get(int index) throws IndexOutOfBoundsException
	{
		if(index >= count || index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		return list[index];
	}
	
	/** Search for the first occurrence of the given argument testing for the equality using
	equals method*/
	public int indexOf(AnyType o)
	{
		for(int i = 0; i < count; i++)
		{
			if(o.equals(list[i]))
			{
				return i;
			}
		}
		return -1;
	}
			
	/** tests if this list has no components*/
	public boolean isEmpty()
	{
		return count == 0;
	}
	/** removes the first occurrence of the specified element in this list
	if the list contains the */
	public boolean remove(AnyType o)
	{
		for(int i = 0; i < count; i++)
		{
			if(list[i].equals(o))
			{
				list[i] = null;
				for(int j = i; j < count-1; j++)
				{
					list[j] = list[j+1];
				}
				count--;
				return true;
			}
		}
		return false;
	}
	/** returns the number of components in this list*/
	public int size()
	{
		return count;
	}
	/** returns an array containing all elements in this list in the correct order*/
	public Object [] toArray()
	{
		if(count == 0)
		{
			return null;
		}
		Object[] newArr = new Object[count];
		for(int i = 0; i < count; i++)
		{		
			newArr[i] = list[i];
		}
		return newArr;
	}
	
	public Iterator<AnyType> iterator()
	{
	 // return object ArrayListIterator 
		ArrayListIterator<AnyType> ali = new ArrayListIterator<AnyType>(list, count);
		
		return ali;
	}

	//Returns a String representation of the objects in the list
	public String toString()
	{
		String res = "[";
		boolean done = false;
		for(int i = 0; i < list.length && !done; i++)
		{
			if(list[i] != null && i != list.length-1 && list[i+1] != null)
			{
				res += list[i].toString() + ", ";
			}
			else
			{
				res += list[i].toString();
				done = true;
			}
		}
		res += "]\n";
		return res;
	}
}