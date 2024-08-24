//Made by Oskar Andersson
public class BouncingBall{
  public static void main(String[] cmdLn){
    StdDraw.enableDoubleBuffering();
    double radius = 0.05;
    double xSpd = 0.0005;
    double ySpd = 0.0002;
    double x = 0.2;
    double y = 0.2;


    while(true)
    {
      StdDraw.clear();
      StdDraw.filledCircle(x, y, radius);
      StdDraw.show();
      if(x >= 1 - radius || x <= 0 + radius)
      {
        xSpd = -xSpd;
      }
      if(y >= 1 - radius || y <= 0 + radius)
      {
        ySpd = -ySpd;
      }
      x += xSpd;
      y += ySpd;
    }
  }
}
