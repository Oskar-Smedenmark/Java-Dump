import java.awt.Color;
public class Polygon
{
  //Coordinates
  private double[] xCords;
  private double[] yCords;
  public Polygon(In in)
  {
      //Total amount of Coordinates
      int amountOfCords = in.readInt();
      //Create arrays
      xCords = new double[amountOfCords];
      yCords = new double[amountOfCords];
      //Add all coords
      for(int i = 0; i < xCords.length; i++)
      {
        xCords[i] = in.readDouble();
        yCords[i] = in.readDouble();
      }
  }
  public void draw(Color fillCol)
  {
    //Draw with the specific color that was passed in as an argument
    StdDraw.setPenColor(fillCol);
    StdDraw.filledPolygon(this.xCords, this.yCords);
  }
  public void draw()
  {
    StdDraw.polygon(this.xCords, this.yCords);
  }
}
