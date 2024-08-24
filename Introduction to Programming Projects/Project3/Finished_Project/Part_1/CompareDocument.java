public class CompareDocument
{
  public static void main(String[] args)
  {
    int k = 5;
    int d = 10000;
    String document = args[0];

    Sketch[] sketches = new Sketch[1000];
    In in = new In(document);
    sketches[0] = new Sketch(in.readAll(), k, d);
    int pos = 1;
    String[] fileNames = new String[1000];
    boolean cont = true;
    StdOut.println("Enter filenames(-1 to stop):");
    while(cont)
    {
      fileNames[pos] = StdIn.readLine();
      if(!fileNames[pos].equals("-1"))
      {
        in = new In(fileNames[pos]);
        sketches[pos] = new Sketch(in.readAll(), k, d);
        pos++;
      }
      else
      {
        cont = false;
      }
    }
    StdOut.println("\n" + document + " compared to:");
    double max = 0;
    int index = 1;
    for(int i = 1; i < pos; i++)
    {
      double val = sketches[0].similarTo(sketches[i]);
      if(max < val)
      {
        max = val;
        index = i;
      }
      StdOut.printf(fileNames[i] + ": " + "%8.2f", val);
      StdOut.println();
    }
    StdOut.println("\nThe text that is the most similar to " + document + " is " + fileNames[index]);
  }
}
