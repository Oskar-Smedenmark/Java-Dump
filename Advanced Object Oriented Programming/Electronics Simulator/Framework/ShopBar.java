package Framework;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ShopBar extends JPanel{
	private JTextArea textfield;
	private GridBagConstraints gbc;
	/**
	 * Creates the ShopBar panel.
	 * Sets Layout and Editable to false.
	 */
	public ShopBar() {
		this.setLayout(new GridLayout(1,1));
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weighty = 1;
        textfield = new JTextArea("");
        textfield.setEditable(false);
        add(textfield, gbc);
	}
	
	/**
	 * Updates the text in JTextArea to the current existing components in circuit.
	 * @param comps is the ArrayList which has the current drawn components.
	 */
	public void updateText(ArrayList<Comp> comps) {
		String str = "";
		@SuppressWarnings("unchecked")
		ArrayList<Comp> copy = (ArrayList<Comp>)comps.clone();
		for(int i = copy.size() - 1; i >= 0 ; i = copy.size() - 1)
		{
			ArrayList<Comp> same = new ArrayList<Comp>();
			Comp original = copy.get(i);
			for(int j = i; j >= 0; j--)
			{
				Comp compare = copy.get(j);
				if(compare.getValue() == original.getValue() && compare.getText().equals(original.getText()))
				{
					same.add(compare);
				}
			}
			for(Comp remove : same)
			{
				copy.remove(remove);
			}
			double value = same.get(0).getValue();
			str += same.get(0).getText() + " " + same.size() + "x ";
			if(value >= 1000)
			{
				value = (double)(Math.round((value/1000)*100))/100;
				str += value + "k \n";
			}
			else
			{
				str += value + "\n";
			}
			
		}
		textfield.setText(str);
		add(textfield,gbc);
	}
	/**
	 * Gets the Text from JTextArea.
	 * @return the text which the JTextArea has.
	 */
	public String getTextField() {
		return textfield.getText();
	}
	
	/**
	 * Sets the JTextArea text to "".
	 */
	public void newList() {
		textfield.setText("");
	}
}
