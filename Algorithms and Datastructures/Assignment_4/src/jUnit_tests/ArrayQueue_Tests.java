package jUnit_tests;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import uppgift_1.ArrayQueue;
import uppgift_1.UnderflowException;

class ArrayQueue_Tests {

	ArrayQueue<String> arr;
	
	@Test
	void reverseTest() {
		arr = new ArrayQueue<String>();
		arr.enqueue("A");
		arr.enqueue("B");
		arr.enqueue("C");
		ArrayQueue<String> reversed = arr.reverse();
		
		assertEquals("Checks if the reversed queue has the correct value", true, reversed.dequeue().equals("C"));
		assertEquals("Checks if the reversed queue has the correct value", true, reversed.dequeue().equals("B"));
		assertEquals("Checks if the reversed queue has the correct value", true, reversed.dequeue().equals("A"));
		
		assertEquals("Checks if the original queue has the correct value", true, arr.dequeue().equals("A"));
		assertEquals("Checks if the original queue has the correct value", true, arr.dequeue().equals("B"));
		assertEquals("Checks if the original queue has the correct value", true, arr.dequeue().equals("C"));
	}
	
}
