import java.awt.Color;
public class PictureHandler
{
  public static Color mix(Color a, Color b, double f)
  {
    int aR = a.getRed();
    int aG = a.getGreen();
    int aB = a.getBlue();
    int bR = b.getRed();
    int bG = b.getGreen();
    int bB = b.getBlue();

    int mR = clamp(0, 255, (int)(aR*f+bR*(1-f)));
    int mG = clamp(0, 255, (int)(aG*f+bG*(1-f)));
    int mB = clamp(0, 255, (int)(aB*f+bB*(1-f)));

    return new Color(mR, mG, mB);
  }

  private static int clamp(int min, int max, int val)
  {
    int result = val;
    if(val < min)
    {
      result = min;
    }
    else if (val > max)
    {
      result = max;
    }
    return result;

  }
  public static Color redify(Color orig)
  {
    return new Color(orig.getRed(), 0, 0);
  }
  public static Color greenify(Color orig)
  {
    return new Color(0,orig.getGreen(),0);
  }
  public static Color blueify(Color orig)
  {
    return new Color(0, 0, orig.getBlue());
  }
  public static Color invert(Color orig)
  {
    return new Color(255-orig.getRed(), 255-orig.getGreen(), 255-orig.getBlue());
  }
  public static Color brighter(Color orig, double percent)
  {
    return new Color((int)(orig.getRed()*(1+percent)), (int)(orig.getGreen()*(1+percent)), (int)(orig.getBlue()*(1+percent)));
  }

  public static Picture flipX(Picture pic)
  {
    for(int i = 0; i < pic.width()/2; i++)
    {
      for(int j = 0; j < pic.height(); j++)
      {
        Color temp = pic.get(i,j);
        pic.set(i,j, pic.get(pic.width()-i-1,j));
        pic.set(pic.width()-i-1, j, temp);
      }
    }
    return pic;
  }
  public static Picture flipY(Picture pic)
  {
    for(int i = 0; i < pic.height()/2; i++)
    {
      for(int j = 0; j < pic.width(); j++)
      {
        Color temp = pic.get(j,i);
        pic.set(j,i, pic.get(j,pic.height()-1-i));
        pic.set(j, pic.height()-1-i, temp);
      }
    }
    return pic;
  }
}
