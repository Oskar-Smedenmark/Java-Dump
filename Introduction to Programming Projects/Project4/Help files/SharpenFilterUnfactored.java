import java.awt.Color;
public class SharpenFilter implements ImageFilter
{
  public String getMenuName()
  {
    return "Sharpen";
  }
  public void apply(Picture src, Picture dest)
  {
    int width = src.width();
    int height = src.height();

    for(int x = 0; x < width; x++)
    {
      for(int y = 0; y < height; y++)
      {
        if(x == 0 || x == width -1 || y == 0 || y == height-1)
        {
          dest.set(x,y, src.get(x,y));
        }
        else
        {
          Color col = src.get(x,y);
          int r = col.getRed()*5;
          int g = col.getGreen()*5;
          int b = col.getBlue()*5;

          //left neighbor
          Color neighCol = src.get(x-1,y);
          int nr = neighCol.getRed()*-1;
          int ng = neighCol.getGreen()*-1;
          int nb = neighCol.getBlue()*-1;
          //Right neighbor
          neighCol = src.get(x+1,y);
          nr += neighCol.getRed()*-1;
          ng += neighCol.getGreen()*-1;
          nb += neighCol.getBlue()*-1;
          r = r + nr;
          g = g + ng;
          b = b + nb;
          //Up neighbor
          neighCol = src.get(x,y-1);
          nr = neighCol.getRed()*-1;
          ng = neighCol.getGreen()*-1;
          nb = neighCol.getBlue()*-1;
          r = r + nr;
          g = g + ng;
          b = b + nb;
          //Down neighbor
          neighCol = src.get(x,y+1);
          nr = neighCol.getRed()*-1;
          ng = neighCol.getGreen()*-1;
          nb = neighCol.getBlue()*-1;
          r = r + nr;
          g = g + ng;
          b = b + nb;

          r = bigSmall(r);
          g = bigSmall(g);
          b = bigSmall(b);

          col = new Color(r,g,b);

          dest.set(x,y, col);
        }
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
