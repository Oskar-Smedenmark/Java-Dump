package lecture7;

public class Leaf<T> implements Tree<T> {

	private T value;

	public Leaf(T v) {
		value = v;
	}

	public <R> R accept(TreeVisitor<T, R> v, R initialResult) {
		return v.visit(this, initialResult);
	}

	public String toString() {
		return getClass().getName() + "[value = " + value + "]";
	}

	public T getValue() {
		return value;
	}
	public String show(String level)
	{
		return indent(level) + value.toString() + "\n";
	}
	
	public String indent(String level)
	{
		String indent = "";
		for(int i = 0; i < level.length(); i++)
		{
			indent += "   ";
		}
		return indent;
	}
}