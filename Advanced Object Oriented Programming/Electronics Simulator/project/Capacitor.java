package project;

import java.awt.Color;
import java.awt.Toolkit;
import Framework.Comp;
import Framework.Node;
@SuppressWarnings("serial")
public class Capacitor extends Comp{
	public Capacitor(double val)
	{
		setImage(Toolkit.getDefaultToolkit().getImage("src/Capacitor.png"));
		setText("Capacitor");
		setValue(val);
		Node[] nod = {new CircleNode(Color.WHITE), new CircleNode(Color.WHITE)};
		setXPos(0);
		setYPos(0);
		setNodes(nod);
		setSize(32,16);
		setStartRot(Math.PI/2);
	}
}
