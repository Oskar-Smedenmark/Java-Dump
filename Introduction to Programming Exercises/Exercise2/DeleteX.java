public class DeleteX
{
  public static void main(String[] args)
  {
    String inputRemoved = "";
    char charToRemove = args[0].charAt(0);
    while(!StdIn.isEmpty())
    {
      String[] input = StdIn.readAllStrings();
      StdOut.print("Starting input: ");
      for(int i = 0; i < input.length; i++)
      {
        StdOut.print(input[i] + " ");
      }
      StdOut.println("");
      for(int i = 0; i < input.length; i++)
      {
        for(int j = 0; j < input[i].length(); j++)
        {
          if(input[i].charAt(j) != charToRemove)
          {
            inputRemoved += input[i].charAt(j);
          }
        }
        inputRemoved += " ";
      }
    }
    StdOut.println("Ending input: " + inputRemoved);
  }
}
