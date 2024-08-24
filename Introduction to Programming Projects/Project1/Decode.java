public class Decode
{
  public static void main(String[] args)
  {
    int codeToDecode = Integer.parseInt(args[0]);
    StdOut.println("Input code: " + codeToDecode + ", " + decode(codeToDecode));
  }

  public static String decode(int decodeCode)
  {
    String[] inputs = StdIn.readAllLines();
    String name = "";
    int code = 0;
    for(int i = 0; i < inputs.length; i++)
    {
      String[] row = inputs[i].split(" ");
      for(int j = 0; j < row.length; j++)
      {
        switch(j)
        {
          case 0:
            code = Integer.parseInt(row[j]);
          break;
          case 1:
            name = row[j];
          break;
          default:
            name += " " + row[j];
          break;
        }
      }
      if(decodeCode == code)
      {
        return name;
      }
    }
    return "";
  }
}
