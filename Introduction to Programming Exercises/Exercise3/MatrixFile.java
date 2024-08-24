public class MatrixFile
{
  public static void main(String[] args)
  {

    int rows = Integer.parseInt(args[0]);
    int cols = Integer.parseInt(args[1]);

    double[][] matrix1 = new double[rows][cols];
    double[][] matrix2 = new double[rows][cols];

    for(int i = 0; i < rows; i++)
    {
      for(int j = 0; j < cols; j++)
      {
        matrix1[i][j] = StdIn.readDouble();
        StdOut.print(matrix1[i][j] + " ");
      }
      StdOut.println();
    }

    for(int i = 0; i < rows; i++)
    {
      for(int j = 0; j < cols; j++)
      {
        matrix2[i][j] = StdIn.readDouble();
        StdOut.print(matrix2[i][j] + " ");
      }
      StdOut.println();
    }
  }
}
