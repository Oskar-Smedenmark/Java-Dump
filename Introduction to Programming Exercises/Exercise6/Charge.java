public class Charge
{
  private double x;
  private double y;
  private double xSpd;
  private double ySpd;
  private double q;

  public Charge(double x0,double y0,double q0)
  {
    this.x = x0;
    this.y = y0;
    this.q = q0;
    double dir = Math.random();
    this.xSpd = Math.random()*0.025-0.0125;
    this.ySpd = Math.random()*0.025-0.0125;
  }

  public void setPos()
  {
    this.x += this.xSpd;
    this.y += this.ySpd;
    if(this.x >= 1 || this.x <= 0)
    {
      this.xSpd = -this.xSpd;
    }
    if(this.y >= 1 || this.y <= 0)
    {
      this.ySpd = -this.ySpd;
    }
  }

  //elektrisk potential vid (x,y) orsakad av laddningen
  public double potentialAt(double x, double y)
  {
    double dx = x-this.x;
    double dy = y-this.y;
    double r = Math.sqrt(dx*dx + dy*dy);
    double k = 8.99e09;
    return k*this.q/r;
  }

  public String toString()
  {
    return "x: " + this.x + "\ny: " + this.y + "\nq: " + this.q;
  }
}
