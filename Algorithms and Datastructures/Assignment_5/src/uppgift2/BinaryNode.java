package uppgift2;

import java.util.Iterator;

final class BinaryNode {

	// Friendly data; accessible by other package routines
	private Object element;
	private int amount;
	public BinaryNode left;
	public BinaryNode right;

	BinaryNode() {
		this(null);
	}

	BinaryNode(Object theElement) {
		this(theElement, null, null);
	}

	BinaryNode(Object theElement, BinaryNode lt, BinaryNode rt) {
		element = theElement;
		left = lt;
		right = rt;
		amount = 1;
	}

	/**
	 * Return the size of the binary tree rooted at t.
	 */
	public static int size(BinaryNode t) {
		if (t == null)
			return 0;
		else
			return 1 + size(t.left) + size(t.right);
	}

	/**
	 * Return the height of the binary tree rooted at t.
	 */
	public static int height(BinaryNode t) {
		if (t == null)
			return -1;
		else
			return 1 + Math.max(height(t.left), height(t.right));
	}

	public void printPreOrder() {
		System.out.println(element); // Node
		if (left != null)
			left.printPreOrder(); // Left
		if (right != null)
			right.printPreOrder(); // Right
	}

	public void printPostOrder() {
		if (left != null)
			left.printPostOrder(); // Left
		if (right != null)
			right.printPostOrder(); // Right
		System.out.println(element); // Node
	}

	public void printInOrder() {
		if (left != null)
			left.printInOrder(); // Left
		System.out.println(element); // Node
		if (right != null)
			right.printInOrder(); // Right
	}
	
	/**
	 * Checks if a specific object e exists in the tree, if it does it increases that nodes amount by 1 and returns true, otherwise it returns false
	 * @param e object that will be looked for
	 * @return True if object exists, false if it doesn't
	 */
	public boolean exists(Object e)
	{
		boolean res = false;
		Object ele = element;
		if(ele.equals("lol"))
		{
			int x = 0;
		}
		if(left != null)
		{
			res = left.exists(e);
		}
		if(right != null && !res)
		{
			res = right.exists(e);
		}
		if(element != null && !res)
		{
			if(element.toString().equals(e.toString()))
			{
				amount++;
				res = true;
			}
		}
		return res;
	}
	
	public Object getElement()
	{
		return element;
	}
	public void setElement(Object e)
	{
		element = e;
	}
	public int getAmount()
	{
		return amount;
	}
	
	/**
	 * Finds the node with the highest amount and returns it. The calling node is the root.
	 * @return The node with the highest amount
	 */
	public BinaryNode getMaxFrek()
	{
		BinaryNode largest = this;
		BinaryNode lft = left;
		BinaryNode rght = right;
		if(left != null)
		{
			lft = left.getMaxFrek();
			if(lft.amount > largest.amount)
			{
				largest = left;
			}
		}
		if(right != null)
		{
			rght = right.getMaxFrek();
			if(rght.amount > largest.amount)
			{
				largest = right;
			}
		}
		if(lft != null && lft.amount > largest.amount) //Check if left is the largest
		{
			largest = lft;
		}
		if(rght != null && rght.amount > largest.amount) //Check if right is the largest
		{
			largest = rght;
		}
		
		return largest;
	}

	/**
	 * Return a reference to a node that is the root of a duplicate of the binary
	 * tree rooted at the current node.
	 */
	public BinaryNode duplicate() {
		BinaryNode root = new BinaryNode(element);

		if (left != null) // If there's a left subtree
			root.left = left.duplicate(); // Duplicate; attach
		if (right != null) // If there's a right subtree
			root.right = right.duplicate(); // Duplicate; attach
		return root; // Return resulting tree
	}

}