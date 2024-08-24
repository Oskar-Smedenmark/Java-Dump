import java.awt.Color;
public class Ball
{
  public double x;
  public double y;
  private double r;
  private Color c;
  public Ball(double x, double y, double r, Color c)
  {
    this.x = x;
    this.y = y;
    this.r = r;
    this.c = c;
  }

  public void move(double dx, double dy)
  {
    this.x += dx;
    this.y += dy;
  }

  public void draw()
  {
    StdDraw.setPenColor(this.c);
    StdDraw.filledCircle(this.x, this.y, this.r);
  }

  public String toString()
  {
    return "Ball at (" + this.x + ", " + this.y + ") with radius " + this.r + " and with the color " + c.toString();
  }
}
