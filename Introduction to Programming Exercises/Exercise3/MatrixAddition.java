public class MatrixAddition
{
  public static void main(String[] args)
  {

    int rows = Integer.parseInt(args[0]);
    int cols = Integer.parseInt(args[1]);

    double[][] matrix = new double[rows][cols];

    for(int i = 0; i < rows; i++)
    {
      for(int j = 0; j < cols; j++)
      {
        matrix[i][j] = StdIn.readDouble();
      }
    }

    for(int i = 0; i < rows; i++)
    {
      for(int j = 0; j < cols; j++)
      {
        matrix[i][j] += StdIn.readDouble();
      }
    }

    for(int i = 0; i < rows; i++)
    {
      for(int j = 0; j < cols; j++)
      {
        StdOut.print(matrix[i][j] + " ");
      }
      StdOut.println();
    }

  }
}
