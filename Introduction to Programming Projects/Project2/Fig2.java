//Made by Oskar Andersson
public class Fig2{
  public static void main(String[] cmdLn){
    int n = Integer.parseInt(cmdLn[0]);
    StdDraw.setXscale(0,n);
    StdDraw.setYscale(0,n);
    StdDraw.line(0,0,1,1);
    StdDraw.line(0,1,1,0);
  }
}
