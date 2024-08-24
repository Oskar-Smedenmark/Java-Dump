package Framework;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public abstract class Graph{
	public abstract Comp[] getTools();
	private ArrayList<Comp> components;
	private int gridX;
	private int gridY;
	
		public Graph(int gridSizeX, int gridSizeY) {
			components = new ArrayList<Comp>();
			gridX = gridSizeX;
			gridY = gridSizeY;
		}
		
		/**
		 * Removes the given Component.
		 * @param c Component of type Comp to be removed.
		 * @return True if component was removed, otherwise false.
		 */
		public boolean remove(Comp c)
		{
			return components.remove(c);
		}
	
		/**
		 * Draws the grid and the components.
		 * @param g2
		 */
		public void draw(Graphics2D g2) {		
			g2.setColor(Color.LIGHT_GRAY);
			g2.setStroke(new BasicStroke(2));
			int padding = 5;
			for(int i = 0; i < 320; i++)
			{
				g2.drawLine(i*gridX + padding, 0, i*gridX + padding , 6400);
				for(int j = 0; j < 320; j++)
				{
					g2.drawLine(0, j*gridY + padding, 6400, j*gridY + padding);
				}
			}
			for(Comp c : components)
				c.paint(g2);
		}
		
		/**
		 * 
		 * @return The width of the grid
		 */
		public int getGridX()
		{
			return gridX;
		}
		
		/**
		 * 
		 * @return The height of the grid
		 */
		public int getGridY()
		{
			return gridY;
		}
		
		public ArrayList<Comp> getComponents(){
			return components;
		}

		/**
		 * Adds component c to the graph
		 * @param c Component that is to be added
		 */
		public void add(Comp c) {
			components.add(c);
		}
}
