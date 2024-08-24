public class PrimeNumber
{
  public static void main(String[] args)
  {
    int inpNum = Integer.parseInt(args[0]);
    int biggestNum = (int)Math.sqrt(inpNum);
    boolean isPrime = true;
    for(int i = 2; i < biggestNum; i++)
    {
      if(inpNum % i == 0)
      {
        System.out.print("The number " + inpNum + " gives a whole number when divided by " + i + " and it equals " + inpNum/i);
        i = biggestNum;
        isPrime = false;
      }
    }
    if(isPrime)
    {
      System.out.print(inpNum + " is a prime number!");
    }
  }
}
