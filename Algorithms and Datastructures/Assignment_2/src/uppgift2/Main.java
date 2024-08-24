package uppgift2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args)
	{
		myArrayListTest();
	}
	
	public static void reverseTest()
	{
		List<Integer> heltal = new ArrayList<Integer>();
		Collections.addAll(heltal, 1,2,3,4,5);
		List<Double> flyttal = new ArrayList<Double>();
		Collections.addAll(flyttal, 1.25,3.14,9.7);
		List<String> campusLindholmen = new ArrayList<String>();
		Collections.addAll(campusLindholmen, "Saga", "Svea", "Jupiter");
		CollectionOps.print(CollectionOps.reverse(heltal));
		CollectionOps.print(CollectionOps.reverse(flyttal));
		CollectionOps.print(CollectionOps.reverse(campusLindholmen));
	}
	
	public static void myArrayListTest()
	{
		MyArrayList<String> list = new MyArrayList<String>(3);
		System.out.println(list.isEmpty());
		list.add("Test");
		list.contains(null);
		System.out.println(list.isEmpty());
		list.add("A string");
		list.add("This is a longer string");
		list.add("And a last test aswell");
		System.out.println(list.toString());
		list.remove("A string");
		System.out.println(list.toString());
		System.out.println(list.contains("Test"));
		
		Object[] arr = list.toArray();
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + ", ");
		}
		list.add("A string");
		list.add("This is a longer string");
		list.add("And a last test aswell");
		Iterator<String> a = list.iterator();
		
		while(a.hasNext())
		{
			System.out.println(a.next());
		}
		
	}
}
