import java.awt.Color;
//Made by Oskar Andersson
//De kan inte lämna kanten eftersom de spawnnar med sin kant utanför ritytan.
//Då byter de riktning om och om igen och kommer ingen vart.
public class BouncingBalls{
  public static void main(String[] cmdLn){
    StdDraw.setCanvasSize(1000, 1000);
    StdDraw.enableDoubleBuffering();
    int n = Integer.parseInt(cmdLn[0]);
    int energy = Integer.parseInt(cmdLn[1]);
    int scale = 1;
    double radius = 0.05;

    StdDraw.setScale(-scale, scale);

    double[] xSpds = new double[n];
    double[] ySpds = new double[n];
    double[] xs = new double[n];
    double[] ys = new double[n];

    double[] grav = new double[n];

    for(int i = 0; i < n; i++)
    {
      xs[i] = (Math.random()*((2*scale) - (radius*3)))-scale + (radius*2);
      ys[i] = (Math.random()*((2*scale) - (radius*3)))-scale + (radius*2);
      xSpds[i] = Math.random()*0.02 - 0.01;
      ySpds[i] = Math.random()*0.02 - 0.01;
      grav[i] = 0.002;
    }
    while(true)
    {
      StdDraw.clear();
      for(int i = 0; i < n; i++)
      {
        StdDraw.setPenColor((int)Math.random()*256,(int)Math.random()*256,(int)Math.random()*256);
        StdDraw.filledCircle(xs[i], ys[i], radius);
        ySpds[i] -= grav[i];
        if(xs[i] >= scale - radius || xs[i] <= -scale + radius)
        {
          xSpds[i] = -xSpds[i];//*(1-((double)energy/100));
        }
        if(ys[i]+ySpds[i] <= -scale + radius || ys[i]+ySpds[i] >= scale-radius)
        {
          ySpds[i] = -ySpds[i]*(1-((double)energy/100));
          if(Math.abs(ySpds[i]) <= Math.abs(grav[i]*2))
          {
            grav[i] = -grav[i];
            ySpds[i] = ySpds[i]*1.1;
          }
        }

        xs[i] += xSpds[i];
        ys[i] += ySpds[i];
      }
      StdDraw.show();
      if(StdDraw.isKeyPressed('P'))
      {
        for(int i = 0; i < n; i++)
        {
          xSpds[i] += 0.04;
          ySpds[i] += 0.04;
        }
      }
    }
  }
}
