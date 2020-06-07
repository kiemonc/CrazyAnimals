package objectProgramming.crazyAnimals.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Grupuje przyciski potrzebne do sterowania symulacją. 
 * @author Mikołaj
 *
 */
@SuppressWarnings("serial")
public class ControlPanel extends JPanel implements ActionListener {
	
	private JButton startStop;
	private JButton nextStep = new JButton("NEXT");
	private JButton end = new JButton("END");
	private JButton exit = new JButton("EXIT");
	private SimulationFrame parent;
	private Timer timer;
	
	/**
	 * Tworzy i wyrównuje przyciski
	 * @param timer - referencja do timera odpowiedzalnego za iterowanie symulacji.
	 * @param parent - referencja do głównego okna symulacji
	 */
	ControlPanel(Timer timer, SimulationFrame parent, boolean started) {
		this.timer = timer;
		this.parent = parent;
		setLayout(new FlowLayout());
		
		
		if(started) {
			startStop = new JButton("STOP");
			nextStep.setVisible(false);
		} else {
			startStop = new JButton("START");
			nextStep.setVisible(true);
		}
		setVisible(true);
		add(startStop);
		add(nextStep);
		add(end);
		add(exit);
		startStop.addActionListener(this);
		nextStep.addActionListener(this);
		end.addActionListener(this);
		exit.addActionListener(this);

	}
	
	/**
	 * Przechwytuje zdarzenia powstałe w wyniku kliknięcia w jeden przycisków w panelu kontroli.
	 * Wykonuje odpowiednie akcje
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if(source == startStop) {
			if(timer.isRunning()) {
				timer.stop();
				startStop.setText("START");
				nextStep.setVisible(true);
			} else {
				timer.start();
				startStop.setText("STOP");
				nextStep.setVisible(false);
			}
		} else if (source == nextStep) {
			parent.doIteration();
		} else if (source == end) {
			parent.gameOver();
		}
		if(source == exit) {
			System.exit(0);
		}
	}
}
