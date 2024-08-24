public class ReadDoubles
{
  public static void main(String[] args)
  {
    int n = Integer.parseInt(args[0]);
    double[] nums = new double[n];
    for(int i = 0; i < n; i++)
    {
      nums[i] = StdIn.readDouble();
    }
    double min = ArraySupport.min(nums);
    double max = ArraySupport.max(nums);
    double avg = ArraySupport.average(nums);
    System.out.println("Max value: " + max);
    System.out.println("Min value: " + min);
    System.out.println("Average value: " + avg);
  }
}
