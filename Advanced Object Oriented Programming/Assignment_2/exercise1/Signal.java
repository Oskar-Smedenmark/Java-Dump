package exercise1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class Signal {

	private double amplitude;
	private int SAMPLING = 1000;
	private Sampler theSampler;
	private ArrayList<SignalObserver> theObservers;
	
	public Signal() {
		theSampler = new DefaultSampler();
		theObservers = new ArrayList<SignalObserver>();
		
		Timer t = new Timer(SAMPLING,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextValue(theSampler.read());
			}
		});
		t.start();
	}
	
	public void addSignalObserver(SignalObserver s) {
		theObservers.add(s);
	}
	
	private void nextValue(double x) {
		amplitude = x;
		for(SignalObserver so : theObservers)
			so.updateSignal(amplitude);
	}
	
	public void setTheSampler(Sampler aSampler) {
		theSampler = aSampler;
	}
}

