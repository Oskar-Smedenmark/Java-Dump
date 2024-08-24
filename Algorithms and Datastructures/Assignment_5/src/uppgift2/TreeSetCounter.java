package uppgift2;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class TreeSetCounter<AnyType> {
	
	BinaryNode root;
	
	public TreeSetCounter()
	{
		root = new BinaryNode();
	}
	
	/**
	 * Adds a word if it doesn't exist in the tree, otherwise it increases its counter by 1
	 * @param e element to add
	 * @return True if a new word is added false if a word already exists
	 */
	public boolean addWord(AnyType e)
	{
		boolean exists = false;
		if(root.getElement() != null)
		{
			exists = root.exists(e);
		}
		else
		{
			root.setElement(e);
			exists = true;
		}
		if(!exists) //If the word doesn't exist, add it to the tree in alphabetical order
		{
			BinaryNode focusNode = root;
			BinaryNode parent = root;
			BinaryNode newNode = new BinaryNode(e);
			while(true)
			{
				parent = focusNode;
				if(e.toString().compareTo(parent.getElement().toString()) < 0)
				{
					focusNode = parent.left;
					if(focusNode == null)
					{
						parent.left = newNode;
						return true;
					}
				}
				else
				{
					focusNode = parent.right;
					if(focusNode == null)
					{
						parent.right = newNode;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Makes the tree empty
	 */
	public void makeEmpty()
	{
		root = null;
	}
	
	/**
	 * Gives the object that have occured the most times in the tree
	 * @return The object that have occured the most times
	 */
	public BinaryNode getMaxFrek()
	{
		return root.getMaxFrek();
	}
	
	public TreeIterator iterator()
	{
		return new TreeIterator(root);
	}
	
	public static void main(String[] args)
	{
		TreeSetCounter<String> tree = new TreeSetCounter<String>();
		
		Scanner file = null;

		int amountOfWords = 0;
		
		try
		{
			file = new Scanner(new File("Huckfinn.txt"));
			
			while(file.hasNextLine())
			{
				String line = file.nextLine();
				String[] sWords = line.split(" |\t");
				for(int i = 0; i < sWords.length; i++)
				{
					amountOfWords++;
					tree.addWord(sWords[i]);
				}
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
		BinaryNode node = tree.getMaxFrek();
		System.out.println(amountOfWords + " words\nLargest frequency:\n" + node.getElement() + ": " + node.getAmount() + " st");
		
		TreeIterator ite = tree.iterator();
		System.out.println("\nAll words:\n");
		while(ite.hasNext())
		{
			BinaryNode word = ite.next();
			System.out.println(word.getElement().toString() + ": " + word.getAmount() + " st");
		}
	}
}
