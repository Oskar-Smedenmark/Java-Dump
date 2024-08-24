//David Bengtsson
public class Blue implements ImageFilter
{
  public String getMenuName()
  {
    return "Blueify";
  }
  public void apply(Picture src, Picture dest)
  {
    //Go through all pixels
    for(int x = 0; x < src.width(); x++)
    {
      for(int y = 0; y < src.height(); y++)
      {
        //Only get blue color
        dest.set(x,y, StdColor.toBlue(src.get(x,y)));
      }
    }
  }
}
