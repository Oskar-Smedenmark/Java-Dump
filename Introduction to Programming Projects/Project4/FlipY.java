//David Bengtsson
public class FlipY implements ImageFilter
{
  public String getMenuName()
  {
    return "Flip vertically";
  }
  public void apply(Picture src, Picture dest)
  {
    //Go through all pixels
    for(int x = 0; x < src.width(); x++)
    {
      for(int y = 0; y < src.height(); y++)
      {
        //Set pixel to opposite pixel
        dest.set(x,y, src.get(x,src.height()-y-1));
      }
    }
  }
}
