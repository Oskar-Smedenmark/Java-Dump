package project;

import Framework.Comp;
import Framework.Graph;

public class SimpleGraph extends Graph {

	public SimpleGraph(int gridSizeX, int gridSizeY) {
		super(gridSizeX, gridSizeY);
	}

	/**
	 * @Return Comp array for the toolbar
	 */
	public Comp[] getTools(){
		return new Comp[] {new Wire(), new Resistor(0), new Capacitor(0), new Inductor(0), new Battery(0)};
	}
}
