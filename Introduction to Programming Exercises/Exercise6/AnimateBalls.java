public class AnimateBalls
{
  public static void main(String[] args)
  {
    Ball redBall = new Ball(1,1,0.5, StdDraw.RED);
    Ball blueBall = new Ball(1,1,0.2, StdDraw.BLUE);
    StdDraw.setXscale(0,20);
    StdDraw.setYscale(0,20);
    redBall.draw();
    blueBall.draw();
    StdDraw.show();
    StdDraw.pause(100);
    for(int i = 1; i<=5; i++)
    {
      redBall.move(1,0);
      redBall.draw();
      blueBall.move(0,i);
      blueBall.draw();
      StdDraw.show();
      StdOut.println(redBall + "\n" + blueBall + "\n");
      StdDraw.pause(100);
    }
  }
}
