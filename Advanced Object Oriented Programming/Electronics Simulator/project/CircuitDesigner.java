package project;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Framework.Comp;
import Framework.FileSaver;
import Framework.Graph;
import Framework.MainFrame;
import Framework.Node;
import Framework.ShopBar;

public class CircuitDesigner extends MainFrame{
	private String CurrentSave="";
	private FileSaver file;
	private JFileChooser chooser;
	private File thisfile;
	private Graph graph;
	private ShopBar shopBar;
	
	
	public CircuitDesigner(Graph graph) {
		super(graph);
		this.graph = graph;
		chooser = new JFileChooser();
		thisfile = new File(CurrentSave);
		file = new FileSaver(thisfile,CurrentSave);
		shopBar = getShop();
		
		
	}
	
	/**
	 * The JMenuItem "Save", the action for when u click Save.
	 * Saves the current circuit layout and creates a File with a name of your choosing.
	 */
	@Override
	public void saveButton() {
		int input = JOptionPane.showConfirmDialog(null, "Want to Save?","Save",JOptionPane.YES_NO_OPTION);
		if(input == 0) {
			if(CurrentSave.equals("")) {
				int choice = chooser.showSaveDialog(null);
				if(choice == JFileChooser.APPROVE_OPTION) {
					CurrentSave = chooser.getSelectedFile().getName();
					thisfile = chooser.getSelectedFile();
					file = new FileSaver(thisfile,CurrentSave);
					if(!file.exist()) {
						file.saveNew(getCompText());								
						JOptionPane.showMessageDialog(null, "File Saved.");
					}
					else {
						CurrentSave = "";
						JOptionPane.showMessageDialog(null, "File name already exists.");
					}
				}
			}
			else {
				
				file.write(getCompText());						
				JOptionPane.showMessageDialog(null, "File Saved.");
			}	
		}
		
	}
	
	/**
	 * The JMenuItem "Load". Loads a file which you have saved before.
	 * Reads from the file and sets the components in the same way as it was saved.
	 * Updates the Shoplist to how it was on the saved circuit.
	 */
	@Override
	public void loadButton() {
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	newButton(); //resets graph
	    	CurrentSave = chooser.getSelectedFile().getName();
	    	thisfile = chooser.getSelectedFile();
	    	file = new FileSaver(thisfile,CurrentSave);
	    	try {
	    		
				Scanner sc = new Scanner(thisfile);
				Point2D start = new Point2D.Double(0, 0);
				Point2D end = new Point2D.Double(0, 0);
				while(sc.hasNextLine()) {
					String[] values = sc.nextLine().split(",");
					start.setLocation(Double.parseDouble(values[2]),Double.parseDouble(values[3]));
					end.setLocation(Double.parseDouble(values[4]),Double.parseDouble(values[5]));
					for(Object o : getToolbar().getTools()) {
						Comp c = (Comp)o;
						if(c.getText().equals(values[0])) {
							Comp current = (Comp) c.clone();
							current.translate(start, end);
							graph.add(current);
							
						}
					}
				}
				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "File not found!");
			}
	    	getPanel().update();
	    	shopBar.updateText(graph.getComponents());
	    }
	}
	
	/**
	 * The JMenuItem "Add all to shoppinglist". 
	 * Updates the shopBar text with the components in the circuit.
	 */
	@Override
	public void shopButton() {
		ArrayList<Comp> comps = graph.getComponents();
		shopBar.updateText(comps);
	}
	
	/**
	 * The JMenuItem "Check Shopping list".
	 * Sets the visibility to false or true depending on the current state.
	 * Hides or shows the shoppinglist.
	 */
	@Override
	public void showShopButton() {
		// TODO Auto-generated method stub
		getShop().setVisible(!getShop().isVisible());
	}
	
	/**
	 * The JMenuItem "Undo". 
	 * Deletes the last component which you have placed.
	 */
	@Override
	public void undoButton() {
		if(!graph.getComponents().isEmpty()) {
			ArrayList<Comp> comps = graph.getComponents();
			graph.remove(comps.get(comps.size()-1));
			getPanel().update();
		}
	}
	
	/**
	 * The JMenuItem "Show Components".
	 * Sets the visibility to false or true depending on the current state.
	 * Hides or shows the Toolbar which shows the buttons for the components.
	 */
	@Override
	public void showCompButton() {
		getToolbar().setVisible(!getToolbar().isVisible());
	}

	/**
	 * The JMenuItem "New".
	 * Deletes all components.
	 * Updates the shoppinglist TextArea to "".
	 */
	@Override
	public void newButton() {
		ArrayList<Comp> comps = graph.getComponents();
		for(int i = comps.size()-1; i >= 0; i--)
		{
			graph.remove(comps.get(i));
		}
		CurrentSave = "";
		shopBar.newList();
		getPanel().update();
	}
	
	/**
	 * Gets the String of all components in the circuit. 
	 * @return text, the String which includes:
	 * Component name, Amount of nodes, nodes X,Y position, the component value.
	 */
	public String getCompText() {
		ArrayList<Comp> comps = graph.getComponents();
		String text="";
		for(int i = 0; i < comps.size(); i++) {
			Comp c = comps.get(i);
			Node[] nodes = c.getNodes();
			text += c.getText();
			text += ","+nodes.length;
			for(Node n : nodes) {
				text +=","+n.getX();
				text +=","+n.getY();
			}
			text +=","+c.getValue()+ "\n";
		}
		return text;
	}
}
