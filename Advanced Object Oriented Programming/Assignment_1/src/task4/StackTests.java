package task4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTests {
	static Stack stk;
	@BeforeAll
	static void setup()
	{
		stk = new Stack();
	}
	
	@BeforeEach
	void reset()
	{
		if(!stk.empty())
		{
			stk.pop(stk.getSize());
		}
		for(int i = 0; i < 10; i++)
		{
			stk.push(i);
		}
	}
	@Test
	void tests() {
		
		assertEquals(10, stk.getSize(),"Check if size is 10");
		for(int i = 0; i < 5; i++)
		{
			assertEquals(9-i, stk.pop(), "Check if popped value is correct");
		}
		assertEquals(5, stk.getSize(), "Check if size is 5");
		
		int[] arr = new int[10];
		for(int i = 0; i < 10; i++)
		{
			arr[i] = 19-i;
		}
		stk.push(10, arr);
		assertEquals(15, stk.getSize(), "Check that the array got added correctly");
		assertTrue(stk.pop() == 10, "Check that order is correct after push");
		List<Integer> lst;
		lst = stk.pop(13);
		assertTrue(lst.get(12) == 11, "Check that the element on top of the stack is at the end of the list");
		assertEquals(1, stk.getSize(), "Check size after pop(n)");
		
	}

}
