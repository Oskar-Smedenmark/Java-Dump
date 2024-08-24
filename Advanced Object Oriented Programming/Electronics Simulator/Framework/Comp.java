package Framework;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;

import javax.swing.JComponent;
@SuppressWarnings("serial")
public abstract class Comp extends JComponent implements Cloneable{
	
	private int width;
	private int height;
	private double rot;
	private Image pic;
	private String text;
	private double value;
	private Node[] nodes;
	private int x;
	private int y;
	private double startRot = 0;
	
	/**
	 * Gives the current value of the component.
	 * @return Value of component.
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Gives the name of the component.
	 * @return Name of the component.
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Gives the image/sprite
	 * @return image/sprite of the component.
	 */
	public Image getImage() {
		return pic;
	}

	/**
	 * Gives the current nodes of the component.
	 * @return Node array of the component nodes.
	 */
	public Node[] getNodes() {
		return nodes;
	}
	
	/**
	 * Used to set the image/sprite width and height(This does not scale the picture!).
	 * @param width The width pixel size. 
	 * @param width The height pixel size.
	 */
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Gives the width of the image/sprite.
	 * @return Width of the component image/sprite.
	 */
	public int getWidth(){
		return width;
	}
	
	/**
	 * Gives the height of the image/sprite.
	 * @return Height of the component image/sprite.
	 */
	public int getHeight(){
		return height;
	}
	
	/**
	 * Sets the rotation in radians of the component.
	 * @param rotation angle in radians that component will have.
	 */
	private void setRot(double rotation){
		rot = rotation;
	}
	
	/**
	 * Sets the default starting rotation as radians to align sprites correctly.
	 * Defaults at 0 radians.
	 * @param rotation in radians to be set.
	 */
	public void setStartRot(double rotation)
	{
		startRot = rotation;
	}
	
	/**
	 * Sets the value of the component.
	 * @param val Value that component will get.
	 */
	public void setValue(double val) {
		value = val;
	}
	
	/**
	 * Sets the name of the component.
	 * @param txt name that the component will have.
	 */
	public void setText(String txt) {
		text = txt;
	}

	/**
	 * Sets the image/sprite of the component.
	 * @param ico image that component will have.
	 */
	public void setImage(Image ico) {
		pic = ico;
	}

	/**
	 * Sets the nodes of the component.
	 * @param nodes array of nodes that component will have.
	 */
	public void setNodes(Node[] nodes) {
		this.nodes = nodes;
	}

	/**
	 * Gives the x position of the component.
	 * @return x position as a double
	 */
	public int getXPos() {
		return x;
	}

	/**
	 * Only use this function to set the initial position of the component.
	 * Use the function translate to set position!
	 * @param x Position component will get.
	 */
	public void setXPos(int x) {
		this.x = x;
	}

	/**
	 * Gives the y position of the component.
	 * @return y position as a double
	 */
	public int getYPos() {
		return y;
	}
	
	/**
	 * Only use this function to set the initial position of the component.
	 * Use the function translate to set position!
	 *  @param y Position component will get.
	 */
	public void setYPos(int y) {
		this.y = y;
	}
	
	/**
	 * Paints the component and the nodes at their current positon
	 */
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		Node n0 = getNodes()[0];
		Node n1 = getNodes()[1];
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(2));
		g2.drawLine((int)(n0.getX()+n0.getBounds().getWidth()/2), (int)(n0.getY()+n0.getBounds().getHeight()/2), (int)(n1.getX()+n1.getBounds().getWidth()/2), (int)(n1.getY()+n1.getBounds().getHeight()/2));
		n0.draw(g2);
		n1.draw(g2);
		g2 = (Graphics2D)g.create();
		g2.rotate(rot, getXPos() + (width/2), getYPos() + (height/2));
		g2.drawImage(getImage(), getXPos(), getYPos(), this);
		g2.dispose();		
	}
	
	/**
	 * Gives the rotation angle between 2 points in radians
	 * @param startP positon to measure angle from
	 * @param endPoint position to measure angle to
	 * @return Rotation angle in radians
	 */
	public double rotation(Point2D startP, Point2D endPoint)
	{
		double yP = endPoint.getY() - startP.getY();
		double xP = endPoint.getX() - startP.getX();
		return Math.atan2(yP, xP);
	}

	/**
	 * Translates the component and the nodes on the panel to the corresponding points
	 * @param startP position for first node
	 * @param endPoint position for last node
	 */
	public void translate(Point2D startP, Point2D endPoint) {
		Node[] ns = getNodes();
		setXPos((int)(startP.getX() + (endPoint.getX()-startP.getX())/2 - (width/3)));
		setYPos((int)(startP.getY() + (endPoint.getY()-startP.getY())/2 - (height/3)));
		ns[0].translate(startP.getX(), startP.getY());
		ns[1].translate(endPoint.getX(), endPoint.getY());
		setRot(startRot + rotation(startP, endPoint));
	}
	
	/**
	 * Clones the component and its nodes.
	 * @return Object the component as an Object.
	 */
	public Object clone()
	{
		try {
			Comp cl = (Comp) super.clone();
			cl.width = this.width;
			cl.height = this.height;
			cl.rot = this.rot;
			cl.pic = this.pic;
			cl.text = this.text;
			cl.value = this.value;
			cl.x = this.x;
			cl.y = this.y;
			cl.startRot = this.startRot;
			Node[] newNodes = new Node[2];
			for(int i = 0; i < 2; i++)
			{
				Node n = nodes[i];
				newNodes[i] = (Node)n.clone();
				
			}
			cl.setNodes(newNodes);
			return cl;
		}catch(CloneNotSupportedException ex) {
			return null;
		}
	}
}
