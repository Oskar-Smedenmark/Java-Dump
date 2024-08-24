import java.awt.Color;
public class StdColor{
    public static double lum(Color c){
	int r = c.getRed();
	int g = c.getGreen();
	int b = c.getBlue();
	return .299*r + .587*g + .114*b;
    }

    public static boolean compatible(Color a, Color b){
	return Math.abs(lum(a) - lum(b)) >= 128.0;
    }

    public static Color toGray(Color c) {
	int y = (int) Math.round(lum(c));
	Color gray = new Color(y, y, y);
	return gray;
    }

    public static Color toRed(Color c){
	return new Color(c.getRed(),0,0);
    }
    public static Color toGreen(Color c){
	return new Color(0,c.getGreen(),0);
    }
    public static Color toBlue(Color c){
	return new Color(0,0,c.getBlue());
    }
    
    public static Color blend(Color c, Color d, double alpha){
	double r = c.getRed()*(1-alpha) + d.getRed()*alpha;
	double g = c.getGreen()*(1-alpha) + d.getGreen()*alpha;
	double b = c.getBlue()*(1-alpha) + d.getBlue()*alpha;
	return new Color((int)r, (int)g, (int)b);
    }

}