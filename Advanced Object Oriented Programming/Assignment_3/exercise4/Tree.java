package exercise4;

@Element(name="node")
public class Tree<T> {
	
	private Tree<T>[] children = null;	
	
	@ElementField(name="value")
	private T value;
	
	public Tree(T v, Tree<T>[] trees) { children = trees; value = v; }
	public Tree(T v) { value = v; }
	
	@SubElements(name="subnodes")
	public Tree<T>[] getChildren() { return children; }
	
	public T getValue() { return value; }

	public static void main(String[] args)
	{
		Tree<String> t = new Tree<String>("top",
		new Tree[] {
		new Tree("sub1"),
		new Tree("sub2")
		});
				
		Saver s = new Saver();
		String r = s.save(t);
		System.out.println(r);
	}
}
