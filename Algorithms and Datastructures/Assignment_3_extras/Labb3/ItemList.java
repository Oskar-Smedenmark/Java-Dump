
   import java.util.*;

/**
 * Klassen ItemList �r en l�nkad lista som inneh�ller noder av Item-objekt.
 * F�rsta noden i listan ( header) inneh�ller inget objekt.
 */

   public class ItemList{
      private Node header;
      int size;
    
      public ItemList( ) {
         header = new Node( null );
      }
    
    /**
    Skapar ett ny Node-objekt med ett nytt Item objekt och l�gger den i listan. 
    �kar v�rdet av variabel size;
     */
      public void add(Item newItem) {
      
      
      }
    
    /**
    Skapar ett ny Node objekt med ett nytt Item-objekt och l�gger den i listan p� plats index,
    �kar v�rdet av variabel size;
   */
      public void add( Item newItem, int index)
      {
      
      
      }
    
    
    /**
    Returnerar true om det finns ett Item-objekt vars RFIDNR �r lika med metodens parametern id 
     */
      public boolean find(String id) {
          
         return true;	 
      }
    
   /**    
       Ta bort noden som inneh�ller Item- objektet med viss id*/
      public Item remove(String id) {
      
         return null;
      }
   
    /**
     R�knar och returnerar antalet Item- objekt med ett vis namn oavsett RFIDNR 
     */
   
      public int countObjects(String name) {
      
         return 0;
      }
   
    
    /**
    Skriver ut inneh�llet i listan
    */
      public void printList() {
      }
    
    /**
     Returnera true om listan �r tom annars false
    */
      public boolean isEmpty()
      {
         return true;
      }
		
		/**
     Returnera antlet element i listan
    */
      public int size()
      {
         return 0;
      }

    
        
   }