public class SwirlFilter implements ScalableFilter {

    public String getMenuName() {return "Swirl";}

    public void apply(Picture src, Picture dest, double scale) {
        final double width = src.width();
        final double height = src.height();

	// In order to avoid rounding errors disturbing the calculations when the filter is set up
	// with its initial value we do explicitely what we expect Swirl to do for an angle of 0.
	if(scale == 0.0){
	   for (int x=0; x<src.width(); x++) {
	       for (int y=0; y<src.height(); y++) {
		   dest.set(x,y,src.get(x,y));
	       }
	   }
	}
	else 
	    for (int x=0; x<src.width(); x++) {
		double xr = x/width-0.5;
		for (int y=0; y<src.height(); y++) {
		    double yr = y/height-0.5;
		    double r = Math.sqrt(xr*xr + yr*yr);
		    double theta = Math.atan2(yr,xr);
		    double theta1 = 50*scale*r*(0.5-r) + theta;
		    int xs = (int)((0.5 + (r<0.5 ? r * Math.cos(theta1) : xr)) * width);
		    int ys = (int)((0.5 + (r<0.5 ? r * Math.sin(theta1) : yr)) * height);
		    dest.set(x,y,src.get(xs,ys));
		    
		}
	    }
    }
}
