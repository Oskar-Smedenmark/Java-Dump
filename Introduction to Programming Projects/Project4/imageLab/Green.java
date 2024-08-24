//David Bengtsson
public class Green implements ImageFilter
{
  public String getMenuName()
  {
    return "Greenify";
  }
  public void apply(Picture src, Picture dest)
  {
    //Go through all pixels
    for(int x = 0; x < src.width(); x++)
    {
      for(int y = 0; y < src.height(); y++)
      {
        //Only get green color
        dest.set(x,y, StdColor.toGreen(src.get(x,y)));
      }
    }
  }
}
