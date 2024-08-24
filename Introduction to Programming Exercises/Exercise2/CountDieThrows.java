public class CountDieThrows
{
  public static void main(String[] args)
  {
    int dieNum = Integer.parseInt(args[0]);
    int dice = 0;
    int amountOfDieNum = 0;
    int amountOfRolls = 6000;
    for(int i = 0; i < amountOfRolls; i++)
    {
      dice = (int)Math.round(Math.random()*6)+1;
      if(dice == dieNum)
      {
        amountOfDieNum++;
      }
    }
    System.out.println("You rolled a " + dieNum + " " + amountOfDieNum + " times in " + amountOfRolls + " rolls.");
  }
}
