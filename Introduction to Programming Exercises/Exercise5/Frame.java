import java.awt.Color;

public class Frame
{
  public static void main(String[] args)
  {
    Picture pic = new Picture(args[0]);
    int wid = Integer.parseInt(args[1]);
    int r = Integer.parseInt(args[2]);
    int g = Integer.parseInt(args[3]);
    int b = Integer.parseInt(args[4]);
    for(int i = 0; i < pic.width(); i++)
    {
      for(int j = 0; j < pic.height(); j++)
      {
        if(i < wid || i >= pic.width()-wid)
        {
          pic.set(i,j,new Color(r,g,b));
        }
        else
        {
          if(j < wid ||j >= pic.height()-wid)
          {
            pic.set(i,j,new Color(r,g,b));
          }
        }
      }
    }
    pic.save("Framed"+args[0]);
  }
}
