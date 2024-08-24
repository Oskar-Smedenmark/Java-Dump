package jUnit_tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import uppgift_1.ArrayStack;

class ArrayStack_Tests {

	ArrayStack<String> arr;
	
	@Test
	void copyTest() {
		arr = new ArrayStack<String>();
		arr.push("A");
		arr.push("B");
		arr.push("C");
		ArrayStack<String> copy = arr.copy();
		
		assertEquals("Checks if copy is poping the same string as arr", true, arr.pop().equals(copy.pop()));
		assertEquals("Checks if copy is poping the same string as arr", true, arr.pop().equals(copy.pop()));
		assertEquals("Checks if copy is poping the same string as arr", true, arr.pop().equals(copy.pop()));
	}

}
