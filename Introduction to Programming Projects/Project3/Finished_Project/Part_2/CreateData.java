//Oskar Andersson
import java.util.ArrayList;
public class CreateData
{
  public static void main(String[] args)
  {
    //Open the html file
    In page = new In(args[0]);

    //Read all lines and add it to a string
    String info = page.readAll();
    int pos = 0;
    ArrayList<String> names = new ArrayList<String>();

    int namePos = pos;
    for(int i = 0; i < 4; i++)
    {
      int nameP = info.indexOf("class=\"cnd\">",namePos);
      int fromNP = info.indexOf(">", nameP);
      int toNP = info.indexOf("</td>", fromNP);
      String intro = info.substring(fromNP + 1, toNP);
      namePos = fromNP;
    }

    StdOut.println("Dead line");
    boolean endOfPage = false;
    //Go through all the 35 states present on the page
    while(!endOfPage)
    {
      //Get the position to start from based on where it last ended up
      int p = info.indexOf("rowspan=\"4\">", pos);
      //Start of the word
      int from = info.indexOf("<b>", p);
      //End of the word
      int to = info.indexOf("</b>", from);
      //The word
      String name = info.substring(from + 3, to);

      if(!names.contains(name))
      {
        names.add(name);
        //Add the name to the output
        StdOut.print(name + ",");
        int numPos = p;
        //Get all four percentages
        for(int j = 0; j < 4; j++)
        {
          //class=\"cnd\">
          //Get the position to start from based on where p was first
          int numP = info.indexOf("class=\"per\"", numPos);
          //Start of the number
          int fromP = info.indexOf(">", numP);
          //End of the number
          int toP = info.indexOf("</td>", fromP);
          //The number in string form
          String num = info.substring(fromP + 1, toP);
          //Add the number to the output after stripping away weird characters
          StdOut.print(Float.parseFloat(num.replaceAll("&#37;", ""))*100 + ",");
          numPos = fromP;
        }
        StdOut.println();
        pos = from;
      }
      else
      {
        endOfPage = true;
      }
    }
  }
}
