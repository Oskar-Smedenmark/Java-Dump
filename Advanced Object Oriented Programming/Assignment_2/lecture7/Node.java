package lecture7;

import java.util.*;

public class Node<T> implements Tree<T> {

	private List<Tree<T>> children;

	public Node(List<Tree<T>> trees) {
		children = trees;
	}

	public <R> R accept(TreeVisitor<T, R> v, R initialResult) {
		return v.visit(this, initialResult);
	}

	public String toString() {
		return getClass().getName() + "[children = " + children + "]";
	}

	public List<Tree<T>> getChildren() {
		return children;
	}
	
	
	public String show(String level)
	{
		return indent(level) + "Node" + "\n";
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