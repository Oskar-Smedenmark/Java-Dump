package project;

import java.awt.Color;

import Framework.Comp;
import Framework.Node;

@SuppressWarnings("serial")
public class Wire extends Comp{
	public Wire()
	{
		setImage(null);
		setText("Wire");
		setValue(0);
		Node[] nod = {new CircleNode(Color.WHITE), new CircleNode(Color.WHITE)};
		setXPos(0);
		setYPos(0);
		setNodes(nod);
		setSize(0,0);
	}
}
