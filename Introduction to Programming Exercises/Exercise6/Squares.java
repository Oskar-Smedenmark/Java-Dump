public class Squares
{
  public static void square(Turtle t, double size)
  {
    t.penDown();
    for(int i = 0; i < 4; i++)
    {
      t.goForward(size);
      t.turnLeft(90);
    }
    t.penUp();
  }
  public static void main(String[] args)
  {
    Turtle tur = new Turtle(0.01,0.01,0);
    for(int i = 0; i < 4; i++)
    {
        square(tur, 0.3);
        tur.goForward(0.98);
        tur.turnLeft(90);
    }
  }
}
