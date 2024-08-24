/*Oskar Andersson Dataingenjör*/
public class InputNumbers
{
  public static void main(String[] args)
  {
    int n = Integer.parseInt(args[0]);
    int curNum = 0;
    int max = -99999999;
    int min = 99999999;
    double sum = 0;
    for(int i = 0; i < n; i++)
    {
      curNum = StdIn.readInt();
      if(curNum > max)
      {
        max = curNum;
      }
      if(curNum < min)
      {
        min = curNum;
      }
      sum += curNum;
    }
    int avg = (int)Math.round((sum/n));
    System.out.println("Max is = " + max);
    System.out.println("Min is = " + min);
    System.out.println("Average is = " + avg);
  }
}
