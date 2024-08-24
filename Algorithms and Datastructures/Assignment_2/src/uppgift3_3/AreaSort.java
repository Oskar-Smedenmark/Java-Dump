package uppgift3_3;

import java.util.Comparator;

public class AreaSort implements Comparator<Land>
{

	//Sorts so the largest area is to the left and smallest to the right
	@Override
	public int compare(Land arg0, Land arg1) 
	{
		 double val = arg1.getArea() - arg0.getArea();
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
		 return (int)val;
	}
	
}
