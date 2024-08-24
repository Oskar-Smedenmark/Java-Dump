//Made by Oskar Andersson
public class Fig3{
  public static void main(String[] cmdLn){
    int n = Integer.parseInt(cmdLn[0]);
    StdDraw.setXscale(-n,n);
    StdDraw.setYscale(-n,n);
    StdDraw.circle(0,0,1);
    StdDraw.filledCircle(0,0,0.5);
  }
}
