import java.awt.Color;
public class Charges
{
  public static void main(String[] args)
  {
    int N = StdIn.readInt();
    Charge[] a = new Charge[N];
    int SIZE = 400;
    for(int i = 0; i < N; i++)
    {
      double x0 = Math.random();
      double y0 = Math.random();
      double q0 = Math.random()*15 - 7.5;
      a[i] = new Charge(x0, y0, q0);
    }
    Picture pic = new Picture(SIZE, SIZE);
    while(true)
    {
      for(int i = 0; i < N; i++)
      {
        a[i].setPos();
      }
      for (int i = 0; i < SIZE; i++)
      {
        for (int j = 0; j < SIZE; j++)
        {
          double V = 0.0;
          for (int k = 0; k < N; k++)
          {
            double x = 1.0 * i / SIZE;
            double y = 1.0 * j / SIZE;
            V = V + a[k].potentialAt(x, y);
          }
          Color c = getColor(V);
          pic.set(i, SIZE-1-j, c);
          }
        }
      pic.show();
    }
  }

  private static Color getColor(double potential)
  {
    double t = 128 + potential / 2.0e10;
    int red = 0;
    if (t < 0) red = 0;
    else if (t > 255) red = 255;
    else red = (int) t;
    return new Color(red, 0, 255-red);
  }
}
