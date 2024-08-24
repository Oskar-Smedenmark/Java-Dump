import java.awt.Color;
public class ColorPlaying
{
  public static void main(String[] args)
  {
    Color blue = new Color(0,0,255);
    Color red = new Color(255,0,0);
    StdDraw.setPenColor(PictureHandler.mix(blue,red,0.5));
    StdDraw.setPenRadius(1);
    StdDraw.point(0.5,0.5);

    StdDraw.setPenColor(blue);
    StdDraw.setPenRadius(0.5);
    StdDraw.point(0.5,0.5);

    StdDraw.setPenColor(red);
    StdDraw.setPenRadius(0.25);
    StdDraw.point(0.5,0.5);
  }
}
