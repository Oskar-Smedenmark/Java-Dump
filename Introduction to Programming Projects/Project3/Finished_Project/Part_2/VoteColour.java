import java.awt.Color;
public class VoteColour
{
  private Color voteCol;
  private String name;
  //constructor
  public VoteColour(In in)
  {
    //Is the input file empty?
    if(!in.isEmpty())
    {
      String line = in.readLine();
      //Split the string into different strings and also removing the ,
      String[] parts = line.split(",");
      int red = 0;
      int green = 0;
      int blue = 0;

      name = parts[0];
      //Read the numbers
      red = Integer.parseInt(parts[1]);
      blue = Integer.parseInt(parts[2]);
      green = Integer.parseInt(parts[3]);

      //Set the correct color
      if(red >= blue && red >= green)
      {
        voteCol = new Color(255,0,0);
      }
      else if(blue > red && blue > green)
      {
        voteCol = new Color(0,0,255);
      }
      else
      {
        voteCol = new Color(0,255,0);
      }
    }
    else
    {
      //If the file was empty, return a gray color.
      voteCol = new Color(128,128,128);
    }
  }
  //Return the color
  public Color getColor()
  {
    return voteCol;
  }

  public String getName()
  {
    return name;
  }
}
