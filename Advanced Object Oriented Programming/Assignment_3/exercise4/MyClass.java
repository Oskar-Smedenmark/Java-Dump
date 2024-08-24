package exercise4;

@Element(name="Box")
public class MyClass {
	
	@ElementField(name="Val1")
	String val;
	@ElementField(name="Val2")
	String val2;
	@ElementField(name="Val3")
	String val3;
	
	MyClass[] aClass;
	
	public MyClass(String val, MyClass[] theClass)
	{
		this.val = val;
		this.val2 = ""+(Integer.parseInt(val)+1);
		this.val3 = ""+(Integer.parseInt(val)+2);
		aClass = theClass;
	}
	public MyClass(String val)
	{
		this.val = val;
		this.val2 = ""+(Integer.parseInt(val)+1);
		this.val3 = ""+(Integer.parseInt(val)+2);
		aClass = null;
	}
	@SubElements(name="Storage")
	public MyClass[] getChild()
	{
		return aClass;
	}
	
	public String getVal()
	{
		return val;
	}
	
	public String getVal2()
	{
		return val2;
	}
	
	public String getVal3()
	{
		return val3;
	}
	
	public static void main(String[] args)
	{
		MyClass a = new MyClass("1", new MyClass[]{new MyClass("4"), new MyClass("7", new MyClass[]{new MyClass("10"), new MyClass("13", null)})});
		//MyClass[] a = {new MyClass("1", null), new MyClass("4", null), new MyClass("7", null)};
		Saver s = new Saver();
		System.out.println(s.save(a));
	 }
}
