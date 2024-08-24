package project;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import Framework.Node;

public class CircleNode implements Node{
	private double x;
	private double y;
	private double size;
	private Color color;
	private int DEFAULT_SIZE = 10;
	
	public CircleNode(Color aColor) {
		size = DEFAULT_SIZE;
		x = 0;
		y = 0;
		color = aColor;
	}
	
	public Object clone() {
		try {
			return super.clone();
		}catch(CloneNotSupportedException ex) {
			return null;
		}
	}
	
	/**
	 * Draws the node on the Graphics2D at the x and y coordinates.
	 */
	public void draw(Graphics2D g2) {
		Ellipse2D circle = new Ellipse2D.Double(x, y, size, size);
		Color oldColor = g2.getColor();
		g2.setColor(color);
		g2.fill(circle);
		g2.setColor(oldColor);
		g2.draw(circle);
	}
	
	/**
	 * Sets the position of the node.
	 * @params dx x position to switch to.
	 * @params dy y position to switch to.
	 */
	public void translate(double dx, double dy) {
		x = dx;
		y = dy;
	}
	
	/**
	 * Gets the x position of the node.
	 * @return x position.
	 */
	public double getX()
	{
		return x;
	}
	
	/**
	 * Gets the y position of the node.
	 * @return y position.
	 */
	public double getY()
	{
		return y;
	}
	
	/**
	 * Gets the bounds of the node.
	 * @return Rectangle2D, The bounds of the node.
	 */
	public Rectangle2D getBounds() {
		return new Rectangle2D.Double(x,y,size,size);
	}
}
