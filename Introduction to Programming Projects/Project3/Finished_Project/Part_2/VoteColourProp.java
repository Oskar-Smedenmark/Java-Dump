import java.awt.Color;
public class VoteColourProp
{
  private Color voteCol;
  //County name beloning to this color
  private String countyName;
  //Constructor
  public VoteColourProp(In in)
  {
    //Is the file empty?
    if(!in.isEmpty())
    {
      //Read the line
      String line = in.readLine();
      //Split the line into parts where ever there is a ','
      String[] parts = line.split(",");
      float red = 0;
      float green = 0;
      float blue = 0;
      //Assign the correct strings and parse the floats from them
      countyName = parts[0];
      red = Float.parseFloat(parts[1]);
      blue = Float.parseFloat(parts[2]);
      green = Float.parseFloat(parts[3]);
      //Assign the correct color to voteCol based on what party that won
      if(red >= blue && red >= green)
      {
        voteCol = new Color(red/(red+blue+green),0,0);
      }
      else if(blue > red && blue > green)
      {
        voteCol = new Color(0,0,blue/(red+blue+green));
      }
      else
      {
        voteCol = new Color(0,green/(red+blue+green),0);
      }
    }
    else
    {
      //Assign a grey color
      voteCol = new Color(128,128,128);
    }
  }
  //Returns the color
  public Color getColor()
  {
    return voteCol;
  }
  //Returns the name
  public String getName()
  {
    return countyName;
  }
}
