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
    Ball[] balls = new Ball[n];

    double[] grav = new double[n];

    for(int i = 0; i < n; i++)
    {
      balls[i] = new Ball((Math.random()*((2*scale) - (radius*3)))-scale + (radius*2), (Math.random()*((2*scale) - (radius*3)))-scale + (radius*2), radius, StdDraw.GREEN);
      xSpds[i] = Math.random()*0.02 - 0.01;
      ySpds[i] = Math.random()*0.02 - 0.01;
      grav[i] = 0.002;
    }
    while(true)
    {
      StdDraw.clear();
      for(int i = 0; i < n; i++)
      {
        balls[i].draw();
        ySpds[i] -= grav[i];
        if(balls[i].x >= scale - radius || balls[i].x <= -scale + radius)
        {
          xSpds[i] = -xSpds[i];//*(1-((double)energy/100));
        }
        if(balls[i].y+ySpds[i] <= -scale + radius || balls[i].y+ySpds[i] >= scale-radius)
        {
          ySpds[i] = -ySpds[i]*(1-((double)energy/100)) - grav[i];
        }

        balls[i].move(xSpds[i], ySpds[i]);
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
      StdDraw.pause(10);
    }
  }
}
