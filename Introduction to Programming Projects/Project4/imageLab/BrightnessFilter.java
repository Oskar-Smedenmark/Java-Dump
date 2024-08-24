//Oskar Andersson
import java.awt.Color;
public class BrightnessFilter implements ScalableFilter
{
  public String getMenuName()
  {
    return "Brightness";
  }
  public void apply(Picture src, Picture dest, double scale)
  {
    int width = src.width();
    int height = src.height();
    //Get current amount to change
    int amount = (int)(128 * scale);

    //Go through all pixels
    for(int x = 0; x < width; x++)
    {
      for(int y = 0; y < height; y++)
      {
        Color col = src.get(x,y);
        //Apply amount to colora
        int r = col.getRed() + amount;
        int g = col.getGreen() + amount;
        int b = col.getBlue() + amount;

        //Check if outside the range 0 - 255
        r = bigSmall(r);
        g = bigSmall(g);
        b = bigSmall(b);

        //Apply new color
        col = new Color(r,g,b);
        dest.set(x,y,col);
      }
    }
  }

  //Checks if integer is larger or smaller than 255 and 0.
  private static int bigSmall(int a)
  {
    int res = a;
    if(a < 0)
    {
      res = 0;
    }
    if(a > 255)
    {
      res = 255;
    }
    return res;
  }
}
