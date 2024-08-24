public class Flower{
  private static void square(Turtle t, double size){
    for(int i = 0; i < 4; i++){
      t.goForward(size);
      t.turnLeft(90);
    }
  }
  public static void main(String [] cmdLn)
  {
    Turtle turtle = new Turtle(0.5,0.5,0);
    for(int i = 0; i<40; i++){
      square(turtle,0.3);
      turtle.turnRight(20);
    }
  }
}
