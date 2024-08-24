package junit_test;
import static org.junit.Assert.*; 
import org.junit.Before;
import org.junit.Test;

import uppgift_2.Item;
import uppgift_2.ItemList;

public class ItemListTest {

	ItemList list_1;
			
   /** Fixture initialization (common initialization
    *  for all tests). **/
	 
   @Before 
   public void setUp() {
		//  new list for every test case
		list_1 = new ItemList();
   }
	
	@Test
	public void addTest()
	{
		for(int i = 0; i< 1000; i++)
		{
			list_1.add(new Item(""+i, ""+i));
		}
		assertEquals("Add 1000 obj test with size()", 1000, list_1.size());
		
		Item testItem = new Item("TEST", "1234");
		list_1.add(testItem, 6);
		list_1.add(testItem, 100000);	
		list_1.add(testItem, 0);	
	}

	@Test
	public void isEmptyTest()
	{
		assertEquals("Test if new list is empty", true, list_1.isEmpty());
		for(int i = 0; i < 1000; i++)
		{
			list_1.add(new Item(""+i, ""+i));
		}
		assertEquals("Test if list with objects isn't empty", false, list_1.isEmpty());
		for (int i = 0; i < 1000; i++)
		{
			list_1.remove(""+i);
		}
		assertEquals("Remove all objects check that list is empty", true, list_1.isEmpty());
	}
	
	@Test
	public void removeTest()
	{
		Item testItem = new Item("TEST", "1234");
		Item testItem1 = new Item("TEST1", "1235");
		assertEquals("Try to remove non existing object check if remove() returns null", null, list_1.remove("1"));
		list_1.add(testItem);
		list_1.add(testItem1);
		list_1.add(testItem);
		list_1.remove("1234");
		assertEquals("Check that size has decreased", 2, list_1.size());
	}
	
	@Test
	public void findTest()
	{
		list_1.add(new Item("TEST", "1234"));
		assertEquals("Test find() with existing object", true, list_1.find("1234"));
		assertEquals("Test find() with non existing object", false, list_1.find("4321"));
	}

	@Test
	public void sizeTest()
	{
		assertEquals("Check that new list has size 0", 0, list_1.size());
	}
	
	@Test
	public void countObjects()
	{
		for(int i = 0; i < 1000; i++)
		{
			list_1.add(new Item("1000", ""+i));
		}
		assertEquals("Check if countObjects returns the same result as size", 1000, list_1.countObjects("1000"));
		for(int i = 0; i < 500; i++)
		{
			list_1.remove(""+i);
		}
		assertEquals("Check if countObjects returns 500 after 500 remove calls", 500, list_1.countObjects("1000"));
	}
}