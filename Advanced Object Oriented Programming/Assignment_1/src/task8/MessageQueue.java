package task8;
/** 
A first-in, first-out bounded collection of messages. 
*/ 
/**
 * A message left by the caller.
 */

public class MessageQueue 
{ 
	
/** 
   Constructs an empty message queue. 
   @param capacity the maximum capacity of the queue 
   @precondition capacity > 0
*/ 
public MessageQueue(int capacity) 
{ 
	if(capacity <= 0) {System.out.println("Not possible to create an MessageQueue with 0 elements");}
  elements = new Message[capacity]; 
  count = 0; 
  head = 0; 
  tail = 0; 
} 

/** 
   Remove message at head. 
   @return the message that has been removed from the queue
   @precondition size() > 0 
*/ 
public Message remove() 
{ 
	if(count == 0) {System.out.println("List is empty."); return null;}

	if(elements[head] == null) {
		  Message r = elements[0];
		  head = 1;
		  count--; 
		  return r;
		  }
  
	  Message r = elements[head];
	  head=(head+1)%elements.length;
	  count--; 
	  return r;
  
} 

/** 
   Append a message at tail. 
   @param aMessage the message to be appended 
*/ 
public void add(Message aMessage) 
{ 
	if(isFull()) {
		doubleArray();
	}
  elements[tail] = aMessage;
  tail = (tail+1)%elements.length;
  count++; 

   
} 

/** 
   Get the total number of messages in the queue. 
   @return the total number of messages in the queue 
*/ 
public int size() 
{ 
  return count; 
} 

/** 
   Checks whether this queue is full
   @return true if the queue is full
*/ 
public boolean isFull()
{ 
  return count == elements.length; 
} 

/** 
   Get message at head. 
   @return the message that is at the head of the queue 
   @precondition size() > 0 
*/ 
public Message peek() 
{ 
	if(count == 0) {System.out.println("Nothing in the list.");}
  return elements[head]; 
} 

/** 
 *  @param Doubles the array and sets head to 0, tail to last element.
 *  @precondition size() > 0
 *  @postcondition The given array is doubled in size.
 */
public void doubleArray() {
	Message[] newArray = new Message[elements.length*2];
	int tick = 0;
	for(int i = 0; i < elements.length; i++) {
		if(head+i > elements.length-1) {
			newArray[i] = elements[tick];
			tick++;
		}
		else {
			newArray[i] = elements[head+i];
		}
	}
	head = 0;
	tail = count;
	elements = newArray;
}

/** 
Adds multiple messages. 
@param mess the message array which have all messages to append. 
@param n size of the message array.
@precondition mess size() > 0, n must be correct size of mess size
@postcondition the message in mess is added at tail, from start to end into the MessageQueue
*/ 
public void multadd(Message[] mess, int n) {
	for(int i = 0; i < n; i++)
	{
		add(mess[i]);
	}
	
}

/** 
removes multiple messages. 
@param n is number of messages to remove.
@precondition n > 0 and size() of MessageQueue > 0
@return the removed messages in an array.
*/ 
public Message[] multRemove(int n) {
	Message[] removecopy = new Message[n];
	for(int i = 0; i < n; i++) {
		removecopy[i] = remove();
	}
	return removecopy;
}

/**
 * Prints the MessageQueue.
 */
public void print() {
	int temphead;
	temphead = head;
	
	for(int i = 0; i < count; i++) {
		if(temphead == elements.length || elements[temphead] == null) {
			temphead = 0;
		}
		System.out.println(elements[temphead].toString());
		temphead++;
	}
}
public int length() {
	return elements.length;
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
	Message h = new Message("thine");
	Message i = new Message("lover");
	MessageQueue b = new MessageQueue(4);
	Message[] z = {a,c,d,e};
	Message[] test = {f,g,h,i};
	
	b.multadd(z, z.length);
	b.multadd(z, z.length);
	b.multRemove(3);
	b.multadd(test, test.length);
	b.multRemove(3);
	
	b.print();
	
}


}


