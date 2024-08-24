package lecture5;

public class TestSignal1 {

	public static void main(String[] args) {
		Signal theSignal = new Signal();
		theSignal.addObserver(new SignalObserver() {
			public void updateSignal(double x) {
				printStars((int)x);
			}
		});
		while(true)
		{
			//Do nothing
		}

	}
	
	private static void printStars(int x) {
		for (int i = 0; i < x; i++)
			System.out.print("*");
		System.out.println();		
	}

}
