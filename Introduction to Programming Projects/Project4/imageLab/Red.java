//David Bengtsson
public class Red implements ImageFilter
{
  public String getMenuName()
  {
    return "Redify";
  }
  public void apply(Picture src, Picture dest)
  {
    //Go through all pixels
    for(int x = 0; x < src.width(); x++)
    {
      for(int y = 0; y < src.height(); y++)
      {
        //Only get red color
        dest.set(x,y, StdColor.toRed(src.get(x,y)));
      }
    }
  }
}
