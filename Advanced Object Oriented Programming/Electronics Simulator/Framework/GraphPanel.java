package Framework;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import javax.swing.JComponent;
import project.Wire;

@SuppressWarnings("serial")
public class GraphPanel extends JComponent{
	private	Graph graph;
	private	ToolBar toolbar;
	private Point2D startP;

	private int gridX;
	private int gridY;
	
	private Comp current;
		
	/**
	 * @param aToolBar The toolbar of tools
	 * @param aGraph The graph to be drawn upon
	 */
	public GraphPanel(ToolBar aToolBar, Graph aGraph) {
		toolbar = aToolBar;
		graph = aGraph;
		gridX = graph.getGridX();
		gridY = graph.getGridY();
		
		//Spawns a new component at mouse position
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				Point2D point = event.getPoint();
				point = alignToGrid(point);
				startP = point;
				
				Comp comp = (Comp) toolbar.getSelectedTool();
				if(comp == null)
				{
					comp = new Wire();
				}
				current = (Comp) comp.clone();
				current.setValue(toolbar.valueFromText());
				current.translate(startP, startP);
				graph.add(current);
			}
		});
		

		//Updates and moves the component.
		addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent event) {
				Point2D point = event.getPoint();
				point = alignToGrid(point);
				current.translate(startP, point);
				repaint();
			}
			});
	}
	
	/**
	 * Aligns the point to the grid based on the set grid size.
	 * @param pos Point to align.
	 * @return The aligned point.
	 */
	private Point2D alignToGrid(Point2D pos)
	{
		int X = (int)(Math.round((pos.getX()/gridX))*gridX);
		int Y = (int)(Math.round((pos.getY()/gridY))*gridY);
		Point2D alignedPos = (Point2D) pos.clone();
		alignedPos.setLocation(X, Y);
		return alignedPos;
	}
	
	/**
	 * Paints graph
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		graph.draw(g2);
	}
	
	/**
	 * Repaints the graph
	 */
	public void update()
	{
		repaint();
	}
	
}
