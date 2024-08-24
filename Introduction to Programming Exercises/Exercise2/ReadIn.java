import java.io.IOException;

public class ReadIn
{
  public static void main(String[] args)
  {
    char input = 0;
    try
    {
      input = (char)System.in.read();
      System.out.println(input);
    }
    catch(IOException e)
    {
      System.out.println("Error getting input from user");
    }
  }
}
