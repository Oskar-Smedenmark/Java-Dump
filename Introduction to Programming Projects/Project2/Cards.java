//Made by Oskar Andersson
public class Cards{
  public static void main(String[] cmdLn){
    StdDraw.enableDoubleBuffering();
    StdDraw.clear(StdDraw.GRAY);
    StdDraw.picture(0.5,0.5,"pngCards/ace_of_spades.png", 0.5, 1.4*0.5);
    double angle = -30;
    while(true)
    {
      StdDraw.clear(StdDraw.GRAY);
      StdDraw.picture(0.5,0.5,"pngCards/ace_of_spades.png", 0.5, 1.4*0.5, angle);
      angle -= 0.05;
      StdDraw.show();
    }
  }
}
