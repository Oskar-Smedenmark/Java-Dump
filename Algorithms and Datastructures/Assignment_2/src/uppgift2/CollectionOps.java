package uppgift2;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionOps
{
	//Prints the collection within [] with commas
	public static <T> void print(Collection<T> l)
	{
		System.out.print("[");
		int iterator = 0;
		for(T t: l)
		{
			if(iterator == l.size()-1) //If we're on the last position don't print a comma
			{
				System.out.print(t.toString());
			}
			else
			{
				System.out.print(t.toString() + ",");
			}
			iterator++;
		}
		System.out.print("]\n");	
	}
	
	//Reverse the list and return it
	public static <T> List<T> reverse(List<T> l)
	{
		if(l.size() > 1)
		{
			T ele = l.remove(0);
			reverse(l);//If the list size is bigger than one call this function again
			l.add(ele);//Add the element currently in ele to the list
		}
		return l;
	}
}
