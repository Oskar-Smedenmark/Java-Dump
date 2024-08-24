//David Bengtsson
public class FlipX implements ImageFilter
{
  public String getMenuName()
  {
    return "Flip horizontally";
  }
  public void apply(Picture src, Picture dest)
  {
    //Go through all pixels
    for(int x = 0; x < src.width(); x++)
    {
      for(int y = 0; y < src.height(); y++)
      {
        //Set pixel to opposite pixel
        dest.set(x,y, src.get(src.width()-x-1,y));
      }
    }
  }
}
