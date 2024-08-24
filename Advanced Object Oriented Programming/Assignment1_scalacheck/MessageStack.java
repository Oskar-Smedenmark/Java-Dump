import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MessageStack {
	List<Message> stack;
	int current;
	
	public MessageStack()
	{
		stack = new ArrayList<Message>();
		current = 0;
	}
	
	/**
	 * size > 0
	 * Removes the top message of the stack
	 * @return The message at the top of the stack. If stack is empty, null
	 */
	public Message pop()
	{
		if(current > 0)
		{
			current--;
			return stack.remove(current);
		}
		return null;
	}
	/**
	 * size > n
	 * Removes n messages from the stack. Top message on the stack will be last in the list.
	 * @return A list of type List with n message objects. If stack is empty or n is outside range, null
	 */
	public List<Message> pop(int n)
	{
		if(n > current-1 || n <= 0)
		{
			return null;
		}
		
		List<Message> ret = new ArrayList<Message>();
		Message[] arr = new Message[n];
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
		
	/**
	 * e must be of Message type
	 * Adds message e to the stack
	 * @param e
	 */
	public void push(Message e)
	{
		stack.add(e);
		current++;
	}
	/**
	 * Array must be of Message type
	 * Adds n amount of messages to the stack.
	 * @param n amount of messages to add.
	 * @param elements message array to add.
	 */
	public void push(int n, Message[] elements)
	{
		for(int i = 0; i < n; i++)
		{
			push(elements[i]);
		}
	}
	
	/**
	 * Checks if stack is empty.
	 * @return True if stack have 0 messages.
	 */
	public boolean empty()
	{
		return current == 0;
	}
	
	/**
	 * Gives the amount of messages currently on the stack.
	 * @return Amount of messages on the stack.
	 */
	public int size()
	{
		return current;
	}
	
	public static void main(String[] args)
	{
		MessageStack st = new MessageStack();
		for(int i = 0; i < 21; i++)
		{
			st.push(new Message(""+i));
		}
		System.out.println(st.pop().toString());
	}
}
