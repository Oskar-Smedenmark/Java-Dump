package uppgift_1;

public class RandomQueue<AnyType> {
	ListNode<AnyType> front;
	ListNode<AnyType> back;
	int size;
	
	public RandomQueue()
	{
		front = new ListNode(null);
		back = front;
		size = 0;
	}
	
	/**Add an element at the back of the queue
	 * 
	 * @param ele the element to add to the queue
	 */
	public void enqueue(Object ele)
	{
		front.next = new ListNode(ele, front.next);
		size++;
	}
	/**Checks if the queue is empty
	 * @return true if empty, otherwise false 
	*/
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	/**
	 * Removes a random object from the list
	 * @return The removed object
	 * @throws UnderflowException
	 */
	public AnyType dequeue() throws UnderflowException
	{
		if(isEmpty())
		{
			throw new UnderflowException("RandomQueue dequeue");
		}
		int index = (int)(Math.random()*size);
		
		Object ele = null;
		ListNode<AnyType> node = front;
		int pos = 0;
		
		while(node.next != null) //Goes to the node right before the item to remove then remove it
		{
			if(index == pos)
			{
				ele = node.next.element;
				node.next = node.next.next;
			}
			if(node.next != null)
			{
				node = node.next;
			}
			pos++;
		}
		size--;
		 return (AnyType) ele;
	}
	
	public static void main(String[] args)
	{
		RandomQueue<String> q = new RandomQueue<String>();
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		q.enqueue("D");
		
		try
		{
			System.out.println(q.dequeue());
			System.out.println(q.dequeue());
			System.out.println(q.dequeue());
			System.out.println(q.dequeue());		
			System.out.println(q.dequeue());
		}
		catch(UnderflowException e)
		{
			System.out.println(e);
		}
	}
}
