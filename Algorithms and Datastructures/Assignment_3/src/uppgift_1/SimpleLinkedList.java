package uppgift_1;

/**
* Klassen SimpleLinkedList är en länkad lista som innehåller noder av objekt.
* Första noden i listan innehåller inget objekt.
*/

public class SimpleLinkedList{
   private ListNode header;
   private int size;
 
   public SimpleLinkedList( ) {
      header = new ListNode( null );
      size = 0;
   }
 
 /**
 Skapar en ny ListNode  med ett nytt objekt och lägger den i listan
  */
   public void insert (String theobj)
   {
      ListNode nynode = new ListNode(theobj);
    
      ListNode temp = header;
      while(temp.next != null){
         temp=temp.next;
      }
     
      temp.next=nynode;
      size++;
   }


	/*		 
	Ta bort noden som innehåller respektive objekt
	*/
   	public void remove(String theobj) {
      ListNode node = header;
     
      while(node.next != null){
         if(node.next.element.equals(theobj)){
            node.next = node.next.next;
            break;
         }
         node = node.next;
      }
      size--;
   	}
 
 /**
 Skriver ut innehållet i listan
  */
   	public void print() {
      ListNode node = header.next;
      while(node != null){
         System.out.println(node.element);
         node = node.next;
      }
   	}   

   public void insert2(String theobj ) {
      ListNode nynode = new ListNode(theobj, header.next);
      header.next = nynode;
      size++;
   }
 
// Detta skall du göra 
	public void insert ( String obj, int index)
	{
	  ListNode node = header.next;
	  int pos = 0;
	  if(index == 0)
	  {
		  ListNode newNode = new ListNode(obj, header.next);
		  header.next = newNode;
	  }
	  else
	  {
		  while(node != null)
		  {
			if(index == pos+1)
			{
				ListNode newNode = new ListNode(obj, node.next);
				node.next = newNode;
			}
			pos++;
			node = node.next;
		  }
	  }
	  size++;
	}

	// Returnerar och tar bort ett objekt från lista
	public String remove(int index) throws IndexOutOfBoundsException
	{
		if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		ListNode node = header.next;
		int pos = 0;
		ListNode lastNode = header;
		String ele = "";
		while(node.next != null)
		{
			if(index == pos)
			{
				ele = node.element;
				lastNode.next = node.next;
			}
			pos++;
			lastNode = node;
			node = node.next;
		}
		 return ele;
	}

	//returnerar storleken på listan. Lägg till i klasssen  en variabel för detta
	// uppdatera variabeln när det är fallet 
	public int size()
	{
	     return size;
	} 
	
	public String toString()
	{
		ListNode node = header.next;
		String res = "";
		while(node.next != null)
		{
			res += node.element + "\r\n";
			node = node.next;
		}
		res += node.element;
		return res;
	} 
	
	public void shift(int k)
	{
		boolean neg = false;
		if(k < 0)
		{
			neg = true;
		}
		k = Math.abs(k) % this.size;
		ListNode[] shifted = new ListNode[k + 1];
		int pos = -1;
		ListNode node = header.next;
		ListNode lastNode = node;
		
		while(node != null)
		{
			pos++;
			if(pos == k+1)
			{
				pos = 0;
			}
			shifted[pos] = node; 
			lastNode = node;
			node = node.next;
			
		}
		
		if(neg)
		{
			for(int i = 0; i < k; i++)
			{
				lastNode.next = this.header.next;
				lastNode = this.header.next;
				this.header.next = this.header.next.next;
				lastNode.next = null;
			}
		}
		else
		{
			for(int i = 0; i < k; i++)
			{
				shifted[pos].next = this.header.next;
				this.header.next = shifted[pos];
				pos--;
				if(pos < 0)
				{
					pos = k;
				}
			}
			shifted[pos].next = null;
		}
	}
 
	public static void main ( String [] arg)
	{
		// testa metoderna från klassen SimpleLinkedList
		SimpleLinkedList klassLista=new SimpleLinkedList();
		klassLista.insert("Olle");
		klassLista.insert2("Nina");
		klassLista.insert2("Kalle");
		klassLista.insert2("David");
		klassLista.print();
		System.out.println();
		klassLista.shift(-2);
		System.out.println("Shifted\n");
		klassLista.print();
   }
}
	 
	 