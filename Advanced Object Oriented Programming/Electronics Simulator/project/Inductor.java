package project;

import java.awt.Color;
import java.awt.Toolkit;
import Framework.Comp;
import Framework.Node;
@SuppressWarnings("serial")
public class Inductor extends Comp{
	public Inductor(double val)
	{
		setImage(Toolkit.getDefaultToolkit().getImage("src/Inductor.png"));//new Image("Resistor.png"));
		setText("Inductor");
		setValue(val);
		Node[] nod = {new CircleNode(Color.WHITE), new CircleNode(Color.WHITE)};
		setXPos(0);
		setYPos(0);
		setNodes(nod);
		setSize(32,16);
	}
}
