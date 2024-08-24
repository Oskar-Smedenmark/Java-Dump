package uppgift3_3;

import java.util.Comparator;

public class NameSort implements Comparator<Land>
{

	//Sorts in alphabetical order
	@Override
	public int compare(Land arg0, Land arg1) 
	{
		 int val = arg0.getName().compareTo(arg1.getName());
		 if(val < 0)
		 {
			 val = -1;
		 }
		 else if(val > 0)
		 {
			 val = 1;
		 }
		 else
		 {
			 val = 0;
		 }
		 return val;
	}
	
}
