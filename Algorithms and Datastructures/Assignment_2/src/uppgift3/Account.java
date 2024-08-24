//*******************************************************
//Account.java
//
//A bank account class with methods to deposit to, withdraw from,
//change the name on, charge a fee to, and print a summary of the account.
//*******************************************************
package uppgift3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
public class Account implements Comparable<Account>
{
   private double balance;
   private String acctNum;

//----------------------------------------------
//Constructor -- initializes balance, owner, and account number
//----------------------------------------------
   public Account(String number, double initBal)
   {
      balance = initBal;
      acctNum = number;
   }

//----------------------------------------------
// Checks to see if balance is sufficient for withdrawal.
// If so, decrements balance by amount; if not, prints message.
//----------------------------------------------
   public String withdraw(double amount)
   {
      String info="Insufficient funds";
      if (balance >= amount){
         balance=balance- amount;
         info= "Succeeded, the new balance is : "+ balance ;
      }
   
      return info;
   }

//----------------------------------------------
// Adds deposit amount to balance.
//----------------------------------------------
   public String deposit(double amount)
   {
      String info=""  ;
      if( amount<0)
         info = " Wrong amount";
      else{
         balance=balance+ amount;
         info=" Succeeded, the new balance is: " + balance;
      }
   
      return info;
   }

//----------------------------------------------
// Returns balance.
//----------------------------------------------
   public double getBalance()
   {
      return balance;
   }


//----------------------------------------------
// Returns a string containing the name, account number, and balance.
//----------------------------------------------
   public String toString()
   {
      return  " Numer: "+ acctNum+ " Balance: " + balance;
   }

//----------------------------------------------
// Returns accoutn number.
//----------------------------------------------

   public String getAcctNum()
   {
      return acctNum;
   }
	
   public boolean equals(Object other)
   {
	  Account o = (Account)other;
	  if(acctNum.equals(o.acctNum) && balance == o.balance)
	  {
		  return true;
	  }
      return false;
   }

   	//Compares two account objects
	public int compareTo(Account o) {
		double val = this.balance - o.balance;
		int comparison = 1;
		if(val < 0)
		{
			comparison = -1;
		}
		else if(val > 0)
		{
			comparison = 1;
		}
		if(this.acctNum == o.acctNum)
		{
			comparison = 0;
		}
		return comparison;
	}		

   public static void main ( String [] arg)
   {
   // Exempel om hur du kan använder ArrayList ocg Account-objekt
	  MyArrayList<Account> myList = new MyArrayList<Account>();
      ArrayList <Account> lista =new ArrayList<Account>();
   // Skapa ett konto och sedan lägga den i listan 
      Account a= new Account ( "1111111111", 1000);
      lista.add(a );
   // skapa account och lägg den i listan samtidigt 
      lista.add( new Account ( "1111111114", 2000));
      lista.add( new Account ( "1111111112", 2000));
      
      lista.add( new Account ( "1111111113", 199));
      
      Account b= new Account ( "1111111111", 1000);
      myList.add(b );
   // skapa account och lägg den i listan samtidigt 
      myList.add( new Account ( "1111111114", 2000));
      myList.add( new Account ( "1111111112", 2000));
      
      myList.add( new Account ( "1111111113", 199));
      
      Iterator<Account> ite = myList.iterator();
      //Collections.sort(myList); Funkar inte eftersom myArrayList inte implementerar Collection
      
      while(ite.hasNext())
      {
    	  Account temp = ite.next();
    	  temp.deposit(Math.random()*4000+1001);
    	  System.out.println(temp.toString());
      }
      
      /*for(int i = 0; i < lista.size(); i++)
      {
    	  System.out.println(lista.get(i).toString());
      }*/
      System.out.println();
      Collections.sort(lista);
      
      for(int i = 0; i < lista.size(); i++)
      {
    	  System.out.println(lista.get(i).toString());
      }
      System.out.println();
   // för att anropa metod skall först objektet returneras från listan
   // det görs med metoden get();
   // här nedan direkt anrop
      lista.get(1).deposit(4000);
   
   // här nedan först anrop av get() sedan,  
      Account konto= lista.get(1);
      System.out.println(konto.deposit(300));
   
   }
}