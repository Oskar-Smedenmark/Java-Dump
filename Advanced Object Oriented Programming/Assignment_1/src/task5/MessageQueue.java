package task5;

/** 
A first-in, first-out bounded collection of messages. 
*/
/**
 * A message left by the caller.
 */

public class MessageQueue {

	/**
	 * Constructs an empty message queue.
	 * 
	 * @param capacity the maximum capacity of the queue
	 * @precondition capacity > 0
	 */
	public MessageQueue(int capacity) {
		assert capacity > 0 : "Capacity can't be zero/less than zero!";
		elements = new Message[capacity];
		count = 0;
		head = 0;
		tail = 0;
	}

	/**
	 * Remove message at head.
	 * 
	 * @return the message that has been removed from the queue
	 * @precondition size() > 0
	 */

	public Message remove() {
		assert size() > 0 : "List is empty.";

		if (elements[head] == null) {
			Message r = elements[0];
			head = 1;
			count--;
			return r;
		}

		Message r = elements[head];
		head = (head + 1) % elements.length;
		count--;
		return r;
	}

	/**
	 * Append a message at tail.
	 * 
	 * @param aMessage the message to be appended
	 */
	public void add(Message aMessage) {
		if (isFull()) {
			doubleArray();
		}
		elements[tail] = aMessage;
		tail = (tail + 1) % elements.length;
		count++;

	}

	/**
	 * Get the total number of messages in the queue.
	 * 
	 * @return the total number of messages in the queue
	 */
	public int size() {
		return count;
	}

	/**
	 * Checks whether this queue is full
	 * 
	 * @return true if the queue is full
	 */
	public boolean isFull() {
		return count == elements.length;
	}

	/**
	 * Get message at head.
	 * 
	 * @return the message that is at the head of the queue
	 * @precondition size() > 0
	 */
	public Message peek() {
		assert size() > 0 : "List is empty.";
		return elements[head];
	}

	/**
	 * Doubles the array and sets head to 0, tail to last element.
	 * 
	 */
	public void doubleArray() {
		Message[] newArray = new Message[elements.length * 2];
		int tick = 0;
		for (int i = 0; i < elements.length; i++) {
			if (head + i > elements.length - 1) {
				newArray[i] = elements[tick];
				tick++;
			} else {
				newArray[i] = elements[head + i];
			}
		}
		head = 0;
		tail = count;
		elements = newArray;
	}

	private Message[] elements;
	private int head;
	private int tail;
	private int count;

	public static void main(String[] args) {

		Message a = new Message("Hey");
		Message c = new Message("there");
		Message d = new Message("soul");
		Message e = new Message("sister");
		Message f = new Message("Be");
		Message g = new Message("gone");
		Message h = new Message("that");
		Message i = new Message("lmao");
		MessageQueue b = new MessageQueue(4);
		//b.peek();
		//b.remove();
		b.add(a);
		b.add(c);
		b.add(d);
		b.add(e);

		System.out.println(b.remove());
		System.out.println(b.remove());
		// b.add(h);
		// b.add(i);

		System.out.println(b.remove());
		// System.out.println(b.remove());
		System.out.println();
		System.out.println();

		b.add(a);
		b.add(c);
		b.add(d);
		b.add(e);
		b.add(f);
		b.add(g);
		b.add(h);
		b.add(i);

		System.out.println(b.remove());
		System.out.println(b.remove());
		System.out.println(b.remove());
		System.out.println(b.remove());
		System.out.println(b.remove());
		System.out.println(b.remove());
		System.out.println(b.remove());
		System.out.println(b.remove());
		System.out.println(b.remove());

		b.add(d);
		b.add(e);
		b.add(f);
		b.add(g);
		b.add(h);
		b.add(i);

	}

}
