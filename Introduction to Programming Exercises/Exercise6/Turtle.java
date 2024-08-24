public class Turtle
{
  private double x, y;
  private double angle;
  private boolean isDown;

  public Turtle(double x0, double y0, double a0)
  {
    x = x0;
    y = y0;
    angle = a0;
    this.isDown = false;
  }

  public void penDown()
  {
    this.isDown = true;
  }
  public void penUp()
  {
    this.isDown = false;
  }

  public void turnLeft(double delta)
  {
    angle = angle + delta;
  }

  public void turnRight(double delta)
  {
    angle -= delta;
  }

  public void goForward(double d)
  {
    double oldX = x;
    double oldY = y;
    x = x + d*Math.cos(Math.toRadians(angle));
    y = y + d*Math.sin(Math.toRadians(angle));
    if(this.isDown)
    {
      StdDraw.line(oldX, oldY, x, y);
      StdDraw.show(500);
    }
  }
}
