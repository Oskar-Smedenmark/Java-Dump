package lecture7;

public class PrettyVisitor<T> implements TreeVisitor<T, String, Integer> {
 
	String res;
	@Override
	public String visit(Tree<T> t, String level, Integer lev) {
		return t.accept(this, level, lev);
	}

	@Override
	public String visit(Leaf<T> l, String level, Integer lev) {
		res += l.show(level);
		return level;
	}
	
	@Override
	public String visit(Node<T> n, String level, Integer lev) {
		if(level == "")
		{
			res =  "Root\n";
		}
		else
		{
			res += n.show(level);
		}
		level += "\n";
		for(Tree<T> child : n.getChildren())
		{
			child.accept(this, level, lev);
		}
		return res;
	}
}
