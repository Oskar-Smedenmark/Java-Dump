package exercise1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SignalWindow extends JFrame implements SignalObserver {
	private JTextArea jta;

	public SignalWindow() {
		
		jta = new JTextArea(100,20);
		jta.append("The signal amplitude.\n"); 
		add(jta);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
}


	public void updateSignal(double x) { 
		jta.append(""+x+"\n"); }


	public JTextArea getTextArea() {
		
		return jta;
	}


	
}
