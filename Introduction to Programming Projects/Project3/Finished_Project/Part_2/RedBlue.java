import java.awt.Color;
public class RedBlue
{
  public static void main(String[] args)
  {
    //Get the file names
    String county = "purple/" + args[0] + ".txt";
    String votes = "purple/" + args[0] + args[1] + ".txt";

    //Read the files
    In countys = new In(county);
    //This one is needed for the VoteColourProp constructor
    In votesIn = new In(votes);
    //This one is needed to make a list of all the colors
    In votesInCols = new In(votes);
    //Discard unnecessary lines
    votesIn.readLine();
    votesInCols.readLine();
    //Add all lines from the votes to an array
    String[] allVotes = votesIn.readAllLines();
    VoteColourProp[] cols = new VoteColourProp[allVotes.length];
    //Create a new VoteColourProp for every line in allVotes
    for(int i = 0; i < allVotes.length; i++)
    {
      cols[i] = new VoteColourProp(votesInCols);
    }
    //Get the min and max values of the map representation
    double minX = countys.readDouble();
    double minY = countys.readDouble();
    double maxX = countys.readDouble();
    double maxY = countys.readDouble();

    //Set the draw scale
    StdDraw.setXscale(minX, maxX);
    StdDraw.setYscale(minY, maxY);

    //Get total amount of polygons
    int amountOfPolys = countys.readInt();
    Polygon[] polys = new Polygon[amountOfPolys];
    //Create the polygons
    for(int i = 0; i < polys.length; i++)
    {
      countys.readLine();
      countys.readLine();
      String countyName = countys.readLine();
      countys.readLine();
      polys[i] = new Polygon(countys);

      //Draw the polygon, color based on its name
      polys[i].draw(getVoteColor(cols, countyName));
    }
  }

  //Returns the correct color for the polygon
  public static Color getVoteColor(VoteColourProp[] cols, String countyName)
  {
    //Go through all the colors and look for the one with the same name
    for(int i = 0; i < cols.length; i++)
    {
      //Does the names equal eachother?
      if(cols[i].getName().contains(countyName))
      {
        //If they do return that color
        return cols[i].getColor();
      }
    }
    //If no names matched the passed in name, return a gray color.
    return new Color(128,128,128);
  }
}
