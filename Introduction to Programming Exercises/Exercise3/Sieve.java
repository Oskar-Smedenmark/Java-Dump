public class Sieve
{
  public static void main(String[] args)
  {
    System.out.print("Input: ");
    while(!StdIn.isEmpty())
    {
      int num = StdIn.readInt();
      StdOut.println("Closest prime is: " + closestPrime(num));
      System.out.print("Input: ");
    }
  }

  public static boolean isPrime(int num)
  {
    //Slow as hell, but sure.
    if(num < 2)
    {
      return false;
    }
    boolean[] primes = new boolean[num+1];
    for(int i = 2; i < num+1; i++)
    {
      primes[i] = true;
    }
    for(int i = 2; i < (int)Math.sqrt(num)+1; i++)
    {
      if(primes[i])
      {
        for(int j = i+i; j < num+1; j = j+i)
        {
          primes[j] = false;
        }
      }
    }

    //This is so much more efficient what? Why would you ever not use this?!
    /*for(int i = 2; i < (int)Math.sqrt(num) && prime; i++)
    {
      if(num % i == 0)
      {
        prime = false;
      }
    }*/
    return primes[num];
  }

  public static int closestPrime(int num)
  {
    int prime = 0;
    for(int i = num; i > 2 && prime == 0; i--)
    {
      if(isPrime(i))
      {
        prime = i;
      }
    }
    return prime;
  }
}
