public class brighter
{
  public static void main(String[] args)
  {
    Picture pic = new Picture(args[0]);
    for(int i = 0; i < pic.width(); i++)
    {
      for(int j = 0; j < pic.height(); j++)
      {
        pic.set(i,j,pic.get(i,j).brighter());
      }
    }
    pic.save("brighter"+args[0]);
  }
}
