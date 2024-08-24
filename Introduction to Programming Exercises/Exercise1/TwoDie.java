/*
Simulates rolling 2 die
*/
public class TwoDie
{
  public static void main(String[] args)
  {
    int dice1 = 0;
    int dice2 = 0;
    dice1 = (int)Math.floor(Math.random()*6)+1;
    dice2 = (int)Math.floor(Math.random()*6)+1;
    System.out.println("You rolled a " + dice1 + " and a " + dice2);
    System.out.println("The total is: " + (dice1 + dice2));
  }
}
