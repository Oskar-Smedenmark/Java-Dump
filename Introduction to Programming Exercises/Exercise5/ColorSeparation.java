import java.awt.Color;
public class ColorSeparation
{
  public static void main(String[] args)
  {
    Picture pic1 = new Picture(args[0]);
    Picture pic2 = new Picture(args[0]);
    Picture pic3 = new Picture(args[0]);
    for(int i = 0; i < pic1.height(); i++)
    {
      for(int j = 0; j < pic1.width(); j++)
      {
        Color col1 = pic1.get(j,i);
        Color col2 = pic2.get(j,i);
        Color col3 = pic3.get(j,i);
        pic1.set(j, i, ColorHandler.redify(col1));
        pic2.set(j, i, ColorHandler.greenify(col2));
        pic3.set(j, i, ColorHandler.blueify(col3));
      }
    }
    pic1.save("red_" + args[0]);
    pic2.save("green_" + args[0]);
    pic3.save("blue_" + args[0]);
  }
}
