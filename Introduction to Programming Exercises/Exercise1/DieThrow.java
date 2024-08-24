/*
Simulates rolling a dice
*/
public class DieThrow
{
  public static void main(String[] args)
  {
    int dice = (int)Math.round(Math.random()*6)+1;
    System.out.println("You rolled a " + dice);
  }
}
