import java.util.*;
import java.io.*;

public class LgerProgram
{
static Scanner scan = new Scanner(System.in);
static ItemList inStore =new ItemList();
static ItemList outStore=new ItemList();
static long nr=1111111111;

public static void main(String[] args)
      {
       try{
       Scanner filescan=new Scanner(new File("Verktyg.txt"));
		 while( filescan.hasNext())
		 System.out.println( filescan.next());
		 }
		 
		 catch(IOException ex){System.out.println("Filen finns inte");}
        printMenu();
         int choice = scan.nextInt();
         scan.nextLine(); 

         while (choice != 0)
         {
            dispatch(choice);
            printMenu();
            choice = scan.nextInt();
				scan.nextLine();  
         }
	}
		
		public static String getRFID()
		{
		 return ""+ nr++;
		 
		}
   
       public static void dispatch(int choice)
      {
         int loc;
      
      
         switch(choice)
         {
            case 0: 
               System.out.println("EXIT");
               System.exit(0);
               break;
         		
            case 1:
               {
					   // H�r bygger du upp lagret. Fyller inlager med Item-objekt vars namn l�ser du fr�n filen.
						// RFIDNR som du beh�ver till varje Item- kan skapas av metoden ge
						// Utlagret �r i b�rjan tom

                                 	               			
                  break;
               }
            case 2:
               {
                  						
                  break;
               }	 
            case 3:
               {
                  break;
               }
            	
            case 4:
				    {
					    break;
					 }
				case 5:
				    {
					    break;
					 }
					 
				case 6:
				    {
					    break;
					 }

            
            
            
            default:
               System.out.println("Sorry, invalid choice");
         }
      }
   
    //----------------------------
    // Skriver ut anv�ndar meny 
    //----------------------------
       public static void printMenu()
      {
         System.out.println("\n  Welcome");
         System.out.println("   ====");
         System.out.println("0: Exit");
         System.out.println("1: Setup Store");
         System.out.println("2: ??");
         System.out.println("3: ??" );
         System.out.println("4: ??");
			System.out.println("5: ??");
         System.out.println("6: ??");
      
         System.out.print("\nEnter your choice: ");
      }
		
		
		
	   }
 
/* Exempel hur man l�ser fr�n fil. 
try{
       Scanner filescan=new Scanner(new File("Verktyg.txt"));
		 while( filescan.hasNext())
		 System.out.println( filescan.next());
		 }
		 
		 catch(IOException ex){System.out.println("Filen finns inte");
*/