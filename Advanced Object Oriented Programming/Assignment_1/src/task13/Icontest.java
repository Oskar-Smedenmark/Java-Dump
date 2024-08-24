package task13;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;

public class Icontest implements Icon{
	private int width;
	Color currentcolor;
	Ellipse2D.Double test;
	Graphics2D g1;
	
	
	
	public Icontest() {
		currentcolor = Color.red;
	}
	
	public void setIconColor(Color a) {
		currentcolor = a;
		g1.setColor(currentcolor);
		g1.fill(test);
		
	}
	@Override
	public int getIconHeight() {
		return 20;
	}

	@Override
	public int getIconWidth() {
		
		return 20;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		//Graphics2D g1 = (Graphics2D)g;
		//Ellipse2D.Double test = new Ellipse2D.Double(0,0,20,20);
		g1 = (Graphics2D)g;
		test = new Ellipse2D.Double(0,0,20,20);
		g1.setColor(currentcolor);
		g1.fill(test);
		
	}
	

}
