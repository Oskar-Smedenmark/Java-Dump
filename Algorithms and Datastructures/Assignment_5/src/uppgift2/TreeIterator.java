package uppgift2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class TreeIterator implements Iterator<Object> {
	Stack<BinaryNode> stack = new Stack<BinaryNode>();

	/**
	 *  Pushes current node and its left children on to the stack
	 */
	private void pushLeftChildren(BinaryNode cur) {
		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}
	}

	/** Constructor */
	public TreeIterator(BinaryNode root) {
		pushLeftChildren(root);
	}

	/** {@inheritDoc} */
	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** {@inheritDoc} */
	@Override
	public BinaryNode next() {
		if (!hasNext()) {
			throw new NoSuchElementException("All nodes have been visited!");
		}

		BinaryNode res = stack.pop();
		pushLeftChildren(res.right);

		return res;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("remove() is not supported.");
	}
}