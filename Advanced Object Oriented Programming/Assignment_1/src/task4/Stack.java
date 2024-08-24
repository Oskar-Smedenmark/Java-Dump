package task4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stack {
	List<Integer> stack;
	int current;
	
	public Stack()
	{
		stack = new ArrayList<Integer>();
		current = 0;
	}
	
	public int pop()
	{
		if(current > 0)
		{
			current--;
			return stack.remove(current);
		}
		return -1;
	}
	public List<Integer> pop(int n)
	{
		if(n > current-1 || n <= 0)
		{
			return null;
		}
		
		List<Integer> ret = new ArrayList<Integer>();
		int[] arr = new int[n];
		for(int i = n-1; i >= 0; i--)
		{
			arr[i] = pop();
		}
		for(int i = 0; i < arr.length; i++)
		{
			ret.add(arr[i]);
		}
		return ret;
	}
		
	public void push(int e)
	{
		stack.add(e);
		current++;
	}
	public void push(int n, int[] elements)
	{
		for(int i = 0; i < n; i++)
		{
			push(elements[i]);
		}
	}
	
	public boolean empty()
	{
		return current == 0;
	}
	
	public int getSize()
	{
		return current;
	}
	
	public static void main(String[] args)
	{
		Stack st = new Stack();
		for(int i = 0; i < 21; i++)
		{
			st.push(i);
		}
	}
}
