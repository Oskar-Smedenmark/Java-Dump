
public class BWFilter implements ImageFilter {

    public String getMenuName() {return "Black and White";}

    public void apply(Picture src, Picture dest) {
	for (int x=0; x< src.width(); x++)
	    for (int y=0; y<src.height(); y++) {
		dest.set(x,y,StdColor.toGray(src.get(x,y)));
	    }
    }
}