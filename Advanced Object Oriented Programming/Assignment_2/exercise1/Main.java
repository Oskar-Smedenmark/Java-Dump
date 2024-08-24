package exercise1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		SignalWindow v = new SignalWindow();
		StarObserver z = new StarObserver();
		
		Sampler o = new DefaultSampler();
		Sampler l = new Sinus(0, 90);
		
		Signal a = new Signal();
		
		
		a.addSignalObserver(v);
		a.addSignalObserver(z);
		
		//A frame for Buttons which makes you choose from noise/random to sinus.
		JButton button1 = new JButton("Sinus");
		 button1.addActionListener(new ActionListener(){  
			 public void actionPerformed(ActionEvent e){  
				 a.setTheSampler(l);
			         }  
			     });
		 
		 JButton button2 = new JButton("Default");
		 button2.addActionListener(new ActionListener(){  
			 public void actionPerformed(ActionEvent e){  
				 a.setTheSampler(o);
			         }  
			     });
		 
		panel.add(button1);
		panel.add(button2);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		}
	
		
}
