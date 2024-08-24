package uppgift_1;
import java.util.*;
class ListNode<AnyType>
{
    public AnyType element;
    public ListNode<AnyType> next;

	  // Constructors

   public ListNode( AnyType theElement )
    {
        this( theElement, null );
    }

    public ListNode( AnyType theElement, ListNode<AnyType> n )
    {
        element = theElement;
        next    = n;
    }





    public static void main (String [] a)
    {
	 
	  ListNode<String> n1=new ListNode<String>("Nina");
	  
	  ListNode<String> n2=new ListNode<String>("Kalle",n1);
	  ListNode<String> n3=new ListNode<String>("Olle",n2);
	  ListNode<String> n4=new ListNode<String>("Mio",n3);

	  ListNode<String> n=n4;
	  while(n!=null)
	  {
		System.out.println(n.element);
		  n=n.next;
	  }
      
		   
			
			 }

}