package task8;

import static org.junit.Assert.assertSame;

import org.junit.jupiter.api.Test;

class MessageQueueTest {
	
	
	MessageQueue x = new MessageQueue(4);
	Message a = new Message("a");
	Message b = new Message("b");
	Message c = new Message("c");
	Message d = new Message("d");
	Message[] test = {a,b,c,d};
	Message[] test2;
	
	
	@Test
	void addTest() {
		x.add(a);
		assertSame("Checks if first object is a", x.peek(), x.remove() );
		x.add(a);
		x.add(b);
		x.add(c);
		x.add(d);
		for(int i = 0; i < x.size(); i++) {
		assertSame("checks if the add, adds correctly",x.remove(), test[i]);
		}
	}
	
	@Test
	void removeTest() {
		x.multadd(test, 4);
		for(int i = 0; i < 4; i++) {
			assertSame("checks if remove will remove in right order.",x.remove(),test[i]);
		}
		assertSame("if it removed.",x.size(),0);
		
	}
	
	@Test
	void doubleArray() {
		x.multadd(test,4);
		x.add(a);
		assertSame("checks if the elements length = 8, doubled from 4",x.length(),8);
	}
	
	@Test
	void multAdd() {
		x.multadd(test, 4);
		assertSame("checks if count 4",x.size(),4);
		for(int i = 0; i < 4; i++) {
			assertSame("checks if it added correctly",x.remove(),test[i]);
		}
	}
	
	@Test
	void multRemove() {
		x.multadd(test, 4);
		test2 = x.multRemove(4);
		assertSame("checks if the size = 0",x.size(),0);
		for(int i = 0; i < 4; i++) {
			assertSame("checks if the removed array is the same",test2[i],test[i]);
		}
		x.multadd(test, 4);
		x.multRemove(3);
		assertSame("checks if the size = 1",x.size(),1);
		assertSame("checks if head moved", x.peek(),test[3]);
		
		
		
		
	}

}
