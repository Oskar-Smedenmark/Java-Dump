
   import java.util.*;

/**
 * Klassen ItemList är en länkad lista som innehåller noder av Item-objekt.
 * Första noden i listan ( header) innehåller inget objekt.
 */

   public class ItemList{
      private Node header;
      int size;
    
      public ItemList( ) {
         header = new Node( null );
      }
    
    /**
    Skapar ett ny Node-objekt med ett nytt Item objekt och lägger den i listan. 
    Ökar värdet av variabel size;
     */
      public void add(Item newItem) {
      
      
      }
    
    /**
    Skapar ett ny Node objekt med ett nytt Item-objekt och lägger den i listan på plats index,
    Ökar värdet av variabel size;
   */
      public void add( Item newItem, int index)
      {
      
      
      }
    
    
    /**
    Returnerar true om det finns ett Item-objekt vars RFIDNR är lika med metodens parametern id 
     */
      public boolean find(String id) {
          
         return true;	 
      }
    
   /**    
       Ta bort noden som innehåller Item- objektet med viss id*/
      public Item remove(String id) {
      
         return null;
      }
   
    /**
     Räknar och returnerar antalet Item- objekt med ett vis namn oavsett RFIDNR 
     */
   
      public int countObjects(String name) {
      
         return 0;
      }
   
    
    /**
    Skriver ut innehållet i listan
    */
      public void printList() {
      }
    
    /**
     Returnera true om listan är tom annars false
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