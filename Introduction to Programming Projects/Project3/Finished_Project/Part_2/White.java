//Oskar Andersson
public class White
{
  public static void main(String[] args)
  {
    //Draws the polygons without color(Polygon needs to only draw themselves without color for this to work)
    In in = new In("purple/"+args[0]);
    //Get the min and max values of the map representation
    double minX = in.readDouble();
    double minY = in.readDouble();
    double maxX = in.readDouble();
    double maxY = in.readDouble();
    StdDraw.setXscale(minX, maxX);
    StdDraw.setYscale(minY, maxY);

    int amountOfPolys = in.readInt();

    for(int i = 0; i < amountOfPolys; i++)
    {
      in.readLine();
      in.readLine();
      in.readLine();
      in.readLine();
      Polygon poly = new Polygon(in);
      poly.draw();
    }
  }
}
