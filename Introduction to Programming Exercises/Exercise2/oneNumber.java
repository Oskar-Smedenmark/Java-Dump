/*
Takes a number that is 9 digits or shortet long and writes them out in opposite
order on seperate lines
*/
class oneNumber
{
  public static void main(String[] args)
  {
    char[] arr = args[0].toCharArray();
    for(int i = arr.length-1; i >= 0; i--)
    {
      System.out.println(arr[i]);
    }
  }
}
