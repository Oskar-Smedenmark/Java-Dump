package uppgift3;
//we use the friendly data in the classes in the same package!

//these other  classes are BinaryNode and BinaryTree.

class HuffmanTree implements Comparable<HuffmanTree> {

	private BinaryNode root;
	private int weight; // computed from the frequencies in each merge.

	public HuffmanTree(Integer a, int freq) {
		root = new BinaryNode(a);
		weight = freq;
	}

	public HuffmanTree(HuffmanTree t1, HuffmanTree t2) {
		weight = t1.weight + t2.weight;
		root = new BinaryNode(null, t1.root, t2.root);
	}

	public int compareTo(HuffmanTree other) {
		return weight - other.weight;
	}

	public void codes(String[] c) {

		codes(root, "", c);
	}
	
	/**
	 * Prints the characters, frequency and codes
	 * @param freqs
	 * @param codes
	 */
	public void printInOrder(int[] freqs, String[] codes)
	{
		printInOrder(root, freqs, codes);
	}
	
	private void printInOrder(BinaryNode n, int[] freqs, String[] codes)
	{
		if (n.element == null) 
		{
			printInOrder(n.left, freqs, codes);
			printInOrder(n.right, freqs, codes);
		} 
		else
		{
			int chr = Integer.parseInt((n.element.toString()));
			System.out.println((char)chr + ": occurs " + freqs[chr] + " times and got the code: " + codes[chr]);
		}
	}

	private void codes(BinaryNode n, String s, String[] theCodes) {
		if (n.element == null) {
			codes(n.left, s + "0", theCodes);
			codes(n.right, s + "1", theCodes);
		} else
			theCodes[((Integer) (n.element)).intValue()] = s;
	}
}