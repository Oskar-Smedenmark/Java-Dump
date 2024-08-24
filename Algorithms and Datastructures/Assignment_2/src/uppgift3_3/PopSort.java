package uppgift3_3;

import java.util.Comparator;

public class PopSort implements Comparator<Land>
{

	//Sorts so the largest population is to the left and smallest to the right
	@Override
	public int compare(Land arg0, Land arg1) 
	{
		 int val = arg1.getPop() - arg0.getPop();
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
