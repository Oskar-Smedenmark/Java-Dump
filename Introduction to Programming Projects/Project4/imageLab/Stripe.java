import java.awt.Color;
public class Stripe implements PictureGenerator{
    
    public String getMenuName() {return "Stripe";}

    public Picture picture() {
	Picture pic = new Picture(500,600);
	int stripe = pic.width()/10;
	int mid = pic.width()/2;
	for (int x=0; x< pic.width(); x++)
	    for (int y=0; y<pic.height(); y++) {
		if(x<mid-stripe||x>mid+stripe)pic.set(x,y,Color.WHITE);
	    }
	return pic;
    }
}