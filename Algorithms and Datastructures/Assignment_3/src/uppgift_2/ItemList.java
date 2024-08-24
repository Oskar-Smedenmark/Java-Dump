package uppgift_2;

/**
 * Klassen ItemList är en länkad lista som innehåller noder av Item-objekt.
 * Första noden i listan ( header) innehåller inget objekt.
 */

public class ItemList{
	private Node header;
	private int size;

	public ItemList() {
		header = new Node(null);
	}

	/**
	 * Skapar ett nytt Node-objekt med ett nytt Item objekt och lägger den i listan.
	 * Ökar värdet av variabel size;
	 */
	public void add(Item newItem) {
		Node node = header;
		Node newNode = new Node(newItem, node.next);
		node.next = newNode;
		size++;
	}
	
	//Prints the searched item/items
	public void printItems(String id)
	{
		Node node = header;
		while(node.next != null)
		{
			if(node.next.itm.getItemName().equals(id) || node.next.itm.getItemNumber().equals(id))
			{
				System.out.println(node.next.itm.toString());
			}
			node = node.next;
		}
	}
	
	//Returns an array represntation of the list
	public Item[] toArray()
	{
		Item[] arr = new Item[size];
		Node node = header.next;
		for(int i = 0; i < size; i++)
		{
			arr[i] = node.itm;
			node = node.next;
		}
		return arr;
	}


	/**
	 * Skapar ett ny Node objekt med ett nytt Item-objekt och lägger den i listan på
	 * plats index, Ökar värdet av variabel size;
	 */
	public void add(Item newItem, int index) {
		Node node = header.next;
		int pos = 0;
		if(index == 0)
		{
			Node newNode = new Node(newItem, header.next);
			header.next = newNode;
			size++;
		}
		else
		{
			while(node.next != null)
			{
				if(index == pos+1) //If the next position in the list is the correct place
				{
					Node newNode = new Node(newItem, node.next);
					node.next = newNode;
					size++;
					break;
				}
				pos++;
				node = node.next;
			}
			if(index >= size) //If the index is at the end or further
			{
				Node newNode = new Node(newItem, node.next);
				node.next = newNode;
				size++;
			}
		}
	}
	
	//Adds an item sorted by the compareTo function
	public void addSort(Item newItem)
	{
		boolean success = false;
		if(size == 0) //If the size is zero just add the item to the list
		{
			Node newNode = new Node(newItem, header.next);
			header.next = newNode;
			size++;
		}
		else
		{
			Node node = header;
			while(node.next != null) 
			{
				if(newItem.compareTo(node.next.itm) <= 0) //Check if the position is correct
				{
					Node newNode = new Node(newItem, node.next);
					node.next = newNode;
					success = true;
					size++;
					break;
				}
				node = node.next;
			}
			if(!success) //If no position was found add the item at the end of the list
			{
				Node newNode = new Node(newItem, node.next);
				node.next = newNode;
				size++;
			}
		}
	}

	/**
	 * Returnerar true om det finns ett Item-objekt vars RFIDNR är lika med metodens
	 * parametern id
	 */
	public boolean find(String id) {
		Node node = header.next;
		while(node.next != null)
		{
			if(node.itm.getItemNumber().equals(id))
			{
				return true;
			}
			node = node.next;
		}
		if(node.itm.getItemNumber().equals(id))
		{
			return true;
		}
		return false;
	}

	/**
	 * Ta bort noden som innehåller Item- objektet med viss id
	 */
	public Item remove(String id){
		if(size <= 0)
		{
			return null;
		}
		Node node = header;
		while(node.next != null)
		{
			if(node.next.itm.getItemNumber().equals(id)) //If the item is found
			{
				Item ret = node.next.itm;
				node.next = node.next.next;
				size--;
				return ret;
			}
			node = node.next;
		}
		if(node.itm.getItemNumber().equals(id)) //Check the last item
		{
			Item ret = node.next.itm;
			node.next = node.next.next;
			size--;
			return ret;
		}
		return null;
	}

	/**
	 * Räknar och returnerar antalet Item- objekt med ett vis namn oavsett RFIDNR
	 */
	public int countObjects(String name) {
		Node node = header.next;
		int amount = 0;
		while(node.next != null)
		{
			if(node.itm.name.equals(name)) //If the item is found
			{
				amount++;
			}
			node = node.next;
		}
		if(node.itm.name.equals(name)) //Last item
		{
			amount++;
		}
		return amount;
	}

	/**
	 * Skriver ut innehållet i listan
	 */
	public void printList() {
		Node node = header.next;
		while(node != null)
		{
			System.out.println(node.itm.toString());
			node = node.next;
		}
	}

	/**
	 * Returnera true om listan är tom annars false
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returnera antlet element i listan
	 */
	public int size() {
		return size;
	}
	
	public static void main(String[] args)
	{
		ItemList list = new ItemList();
		System.out.println(list.isEmpty());
		list.add(new Item("ABC", "123"));
		list.add(new Item("ABC", "64888"));
		list.add(new Item("ABC", "555656"));
		list.add(new Item("ABC", "363636"));
		list.add(new Item("DEF", "456"));
		list.add(new Item("GHI", "789"));
		list.add(new Item("FIRST", "1133331"), 0);
		list.add(new Item("MIDDLE", "1111111"), 4);
		list.add(new Item("END", "1111211"), 8);
		System.out.println(list.isEmpty());

		System.out.println(list.size());
		list.printList();
		System.out.println(list.find("123"));
		System.out.println("\n"+list.remove("789")+"\n");

		System.out.println(list.size());
		list.printList();
		System.out.println("\n"+list.countObjects("ABC")+"\n");
		
		
	}

}