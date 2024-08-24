package exercise8_new;
public class MaxThree extends Filter {

	@Override
	boolean accept(String text) {
			if(text.length() <= 3) { 
				return true;
			}
			else return false;
	}
	
	
	public static void main(String[] args)
	{
		String[] test = {"123","321","4231","123456","1","32","5"};
		Filter lessThan3 = new MaxThree();
		test = lessThan3.filter(test);
		
		for(int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}
	}
	
}
