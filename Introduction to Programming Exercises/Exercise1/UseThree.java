/*
  Prints the first command line argument
*/
public class UseThree
{
   public static void main(String [] cmdLn)
   {
      String first = cmdLn[0];
      String second = cmdLn[1];
      String third = cmdLn[2];

      System.out.println("Hi, " + third + ", " + second + " and " + first);
      System.out.println("bc" + 2 + 3);
      System.out.println("bc" + (2 + 3));
   }
}
