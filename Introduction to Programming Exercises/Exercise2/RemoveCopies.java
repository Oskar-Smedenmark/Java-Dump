public class RemoveCopies
{
  public static void main(String[] args)
  {
    int[] nums = new int[args.length];
    int[] lonelyNums = new int[args.length];
    for(int i = 0; i < nums.length; i++)
    {
      nums[i] = Integer.parseInt(args[i]);
    }
    boolean exists = false;
    int amountOfLonelyNums = 0;
    for(int i = 0; i < nums.length; i++)
    {
      for(int j = 0; j < nums.length; j++)
      {
        if(nums[i] == lonelyNums[j])
        {
          exists = true;
        }
      }
      if(!exists)
      {
        lonelyNums[amountOfLonelyNums] = nums[i];
        amountOfLonelyNums++;
      }
      exists = false;
    }
    System.out.println("");
    for(int i = 0; i < amountOfLonelyNums; i++)
    {
      System.out.print(lonelyNums[i] + " ");
    }
  }
}
