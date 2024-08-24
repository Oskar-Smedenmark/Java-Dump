public class OccurencesOf
{
  public static void main(String[] args)
  {
    String word = args[0];
    int occOf = 0;
    int posInRow = 0;
    while(!StdIn.isEmpty())
    {
      char[] row = StdIn.readLine().toCharArray();
      String wordInRow = "";
      for(int i = 0; i < row.length; i++)
      {
        if(row[posInRow] != ' ')
        {
          wordInRow += row[posInRow];
        }
        else
        {
          if(wordInRow.equals(word))
          {
            occOf++;
          }
          wordInRow = "";
        }
        posInRow++;
      }
      posInRow = 0;
    }
    System.out.println("Occurences of " + word + " is " + occOf);
  }
}
