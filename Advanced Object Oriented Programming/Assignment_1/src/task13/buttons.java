package task13;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class buttons {

	JFrame frame = new JFrame("Circle");
	JPanel panel = new JPanel();
	JButton button = new JButton("Red");
	JButton button2 = new JButton("Green");
	JButton button3 = new JButton("Blue");
	
	
	
	Icontest icontru = new Icontest();
	JLabel mylabel = new JLabel();
	
public buttons() {
	button.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			//button.setBackground(Color.RED);
			//circle.paintComponent(circle.getGraphics(),Color.RED);
			changeColor(Color.RED);
		}
	});
	button2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent f) {
			//button2.setBackground(Color.GREEN);	
			//circle.paintComponent(circle.getGraphics(),Color.GREEN);
			changeColor(Color.GREEN);
		}
	});
	button3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent f) {
			//button3.setBackground(Color.BLUE);	
			//circle.paintComponent(circle.getGraphics(),Color.BLUE);
			changeColor(Color.BLUE);
			
			
		}
	});
		panel.setLayout(new BoxLayout(panel,BoxLayout.LINE_AXIS));
		
		mylabel.setIcon(icontru);
		
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
		panel.add(mylabel);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(225, 100);
		
		frame.setVisible(true);
	}
	public static void main(String args[]){
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new buttons();
			}
		});
	}
	
	public void changeColor(Color col)
	{
		icontru.setIconColor(col);
		panel.revalidate();
		panel.repaint();
	}
	
	     
}

