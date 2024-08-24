//Oskar Andersson
public class Glass implements ImageFilter
{
  public String getMenuName()
  {
    return "Glass";
  }
  public void apply(Picture src, Picture dest)
  {
    int blur = 5;
    int width = src.width();
    int height = src.height();
    //Go through all pixels
    for(int x = 0; x < width; x++)
    {
      for(int y = 0; y < height; y++)
      {
<<<<<<< HEAD
        int xNeighbour = (width + x + random(-blur, blur)) % width;
        int yNeighbour = (height + y + random(-blur, blur)) % height;
=======
        //Get a random neighbor
        int xNeighbour = (width + x + random(-5, 5)) % width;
        int yNeighbour = (height + y + random(-5, 5)) % height;
        //Set new color to that pixels color
>>>>>>> f6f0978b3d876dc0dd146381f96c534f71dc6890
        dest.set(x,y, src.get(xNeighbour, yNeighbour));
      }
    }
  }

  //Returns a random value within the specified interval
  private static int random(int a, int b)
  {
    int min = a;
    int max = b;

    //Set min to always be the b value
    if(a > b)
    {
      min = b;
      max = a;
    }

    return min + (int)(Math.random()*((max-min)+1));
  }
}
