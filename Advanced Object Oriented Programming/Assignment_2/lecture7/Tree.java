package lecture7;

public interface Tree<T> {
	<R, A> R accept(TreeVisitor<T, R, A> v, R initialResult, A lev);

}