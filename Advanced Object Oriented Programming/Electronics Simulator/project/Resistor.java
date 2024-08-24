package project;

import java.awt.Color;
import java.awt.Toolkit;
import Framework.Comp;
import Framework.Node;

@SuppressWarnings("serial")
public class Resistor extends Comp{
	public Resistor(double val)
	{
		setImage(Toolkit.getDefaultToolkit().getImage("src/Resistor.png"));//new Image("Resistor.png"));
		setText("Resistor");
		setValue(val);
		Node[] nod = {new CircleNode(Color.WHITE), new CircleNode(Color.WHITE)};
		setXPos(0);
		setYPos(0);
		setNodes(nod);
		setSize(32,16);
	}
}
