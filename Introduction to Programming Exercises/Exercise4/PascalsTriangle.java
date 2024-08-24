public class PascalsTriangle
{
  public static void main(String[] args)
  {
    int n = Integer.parseInt(args[0]);
    long[] row = {1};
    ArraySupport.printlnArray(row,n);
    for(int i = 0; i < n; i++)
    {
      row = nextRow(row);
      ArraySupport.printlnArray(row, n);
    }
  }

  private static long[] nextRow(long[] row)
  {
    long[] theNextRow = new long[row.length+1];
    theNextRow[0] = 1;
    theNextRow[row.length] = 1;
    for(int i = 1; i < row.length; i++)
    {
      theNextRow[i] = row[i-1] + row[i];
    }
    return theNextRow;
  }

}
