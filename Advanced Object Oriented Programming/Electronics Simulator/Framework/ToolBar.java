package Framework;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

@SuppressWarnings("serial")
public class ToolBar extends JPanel{
	
	private ButtonGroup group;
	private ArrayList<Object> tools;
	private GridBagConstraints gbc;
	private JTextField tField;
	
	/**
	 * Takes a graph and creates the toolbar panel which adds buttons equals to the graphs components.
	 * @param graph that the toolbar gets its components.
	 */
	public ToolBar(Graph graph) {
		group = new ButtonGroup();
		tools = new ArrayList<Object>();
		this.setLayout(new GridLayout(10,1));
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1;
		for(Comp c : graph.getTools())
			add(c);
		tField = new JTextField();
		this.add(tField, gbc);
	}

	/**
	 * Get's the selected tool.
	 * @return Currently selected tool or null if no tool is selected.
	 */
	public Object getSelectedTool() {
		int i = 0;
		for(Object o : tools) {
			JToggleButton button = (JToggleButton)getComponent(i++);
					if(button.isSelected()) {
						return o;
					}
		}
		return null;
	}
	
	/**
	 * Gives the parsed value if in allowed form in the form of a Double.
	 * @return Double parsed from the text field or 0 if incorrect form. 
	 */
	public double valueFromText()
	{
		if(tField.getText().matches("^[0-9]+([.][0-9]+)?$"))
		{
			return Double.parseDouble(tField.getText());
		}
		return 0;
	}
	
	/**
	 * Gives the tools in the toolbar.
	 * @return ArrayList of tools as a ArrayList<Object>.
	 */
	public ArrayList<Object> getTools()
	{
		return tools;
	}
	
	/**
	 * Creates the buttons for the toolbar.
	 * @param s Component that is to be added to the toolbar.
	 */
	private void add(final Comp s) {
		JToggleButton button = new JToggleButton(s.getText());
        group.add(button);
        this.add(button,gbc);
        tools.add(s);
	}
}
