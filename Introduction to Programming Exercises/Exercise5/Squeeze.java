public class Squeeze
{
  public static void main(String[] args)
  {
    while(!StdIn.isEmpty())
    {
      char[] row = StdIn.readLine().toCharArray();
      int amountOfSpaces = 0;
      for(int i = 0; i < row.length; i++)
      {
        if(row[i] == ' ')
        {
          if(row[i+1] == ' ')
          {
            for(int j = i; j < row.length-1; j++)
            {
              row[j] = row[j+1];
            }
            amountOfSpaces++;
            i--;
          }
        }
      }
      String strRow = "";
      for(int i = 0; i < row.length-amountOfSpaces; i++)
      {
        strRow += row[i];
      }
      StdOut.println(strRow);
    }

  }
}
