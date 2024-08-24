import java.awt.Color;
public class Flipx
{
  public static void main(String[] args)
  {
    Picture pic = new Picture(args[0]);
    pic = PictureHandler.flipX(pic);
    pic.show();
    pic.save("flipedX.png");
  }
}
