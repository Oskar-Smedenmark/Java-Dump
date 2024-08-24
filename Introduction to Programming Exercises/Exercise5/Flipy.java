import java.awt.Color;
public class Flipy
{
  public static void main(String[] args)
  {
    Picture pic = new Picture(args[0]);
    pic = PictureHandler.flipY(pic);
    pic.show();
    pic.save("flipedY.png");
  }
}
