package Framework;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public interface Node extends Cloneable{
	public void draw(Graphics2D g2);
	public void translate(double dx, double dy);
	public Rectangle2D getBounds();
	public Object clone();
	public double getX();
	public double getY();
}
