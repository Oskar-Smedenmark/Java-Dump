public class CountOccurrencesOf
{
  public static void main(String[] args)
  {
    int theNum = Integer.parseInt(args[1]);
    int amountOfInputs = Integer.parseInt(args[0]);
    int[] nums = new int[amountOfInputs];
    int occurencesOftheNum = 0;
    for(int i = 0; i < amountOfInputs; i++)
    {
      nums[i] = StdIn.readInt();
      if(nums[i] == theNum)
      {
        occurencesOftheNum++;
      }
    }
    System.out.println("The number of occurences of the number " + theNum + " is " + occurencesOftheNum);
  }
}
