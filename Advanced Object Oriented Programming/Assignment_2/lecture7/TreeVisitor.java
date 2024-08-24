package lecture7;

public interface TreeVisitor<T, R, A> {
	R visit(Tree<T> t, R initialResult, A initialValue);

	R visit(Leaf<T> l, R initialResult, A initialValue);

	R visit(Node<T> n, R initialResult, A initialValue);
}