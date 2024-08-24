package task12;

public class MaxThreeFilter implements Filter
{

	public boolean accept(String x) {
		return x.length() <= 3;
	}
	
}