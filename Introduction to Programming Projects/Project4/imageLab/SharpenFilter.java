//Oskar Andersson
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
    int kernel[][] = new int[3][3];

    //Fill kernel with appropriate values
    fillKernel(kernel);

    //Go through every pixel
    for(int x = 1; x < width-1; x++)
    {
      for(int y = 1; y < height-1; y++)
      {
        int r = 0;
        int g = 0;
        int b = 0;
        //Apply kernel values to the 9 current pixels
        for(int i = -1; i < 2; i++)
        {
          for(int j = -1; j < 2; j++)
          {
            Color temp = src.get(x+i,y+j);
            r += temp.getRed()*kernel[i+1][j+1];
            g += temp.getGreen()*kernel[i+1][j+1];
            b += temp.getBlue()*kernel[i+1][j+1];
          }
        }

        //Check if values are outside the range 0 - 255
        r = bigSmall(r);
        g = bigSmall(g);
        b = bigSmall(b);

        //Color to be used
        Color col = new Color(r,g,b);

        dest.set(x,y, col);
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

  //Fills the kernel with appropriate sharpen values
  private static int[][] fillKernel(int[][] ker)
  {
    //Row 1
    ker[0][0] = 0;
    ker[1][0] = -1;
    ker[2][0] = 0;

    //Row 2
    ker[0][1] = -1;
    ker[1][1] = 5;
    ker[2][1] = -1;

    //Row 3
    ker[0][2] = 0;
    ker[1][2] = -1;
    ker[2][2] = 0;

    return ker;
  }
}
