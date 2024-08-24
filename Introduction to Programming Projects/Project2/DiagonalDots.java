//Made by Oskar Andersson
public class DiagonalDots{
  public static void main(String[] cmdLn){
    int n = Integer.parseInt(cmdLn[0]);
    StdDraw.setScale(-n,n);
    for(int i = -n; i < 2*n+1; i++)
    {
      StdDraw.filledCircle(i,i,0.5);
      StdDraw.filledCircle(i,-i,0.5);
    }
  }
}
