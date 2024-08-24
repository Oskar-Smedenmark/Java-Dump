package project;

import java.awt.Color;

import javax.swing.ImageIcon;

import Framework.Comp;
import Framework.Node;
@SuppressWarnings("serial")
public class Battery extends Comp{
	public Battery(double val)
	{
		setImage(new ImageIcon("src/Battery.png").getImage());
		setText("Battery");
		setValue(val);
		Node[] nod = {new CircleNode(Color.WHITE), new CircleNode(Color.WHITE)};
		setXPos(0);
		setYPos(0);
		setNodes(nod);
		setStartRot(Math.PI/2);
		setSize(32,16);
	}
}
