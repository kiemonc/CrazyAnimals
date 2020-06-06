package objectProgramming.crazyAnimals.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class ControlPanel extends JPanel implements ActionListener {
	
	private JButton startStop = new JButton("STOP");
	private JButton nextStep = new JButton("NEXT");
	private SimulationFrame parent;
	
	private Timer timer;
	ControlPanel(Timer timer, SimulationFrame parent) {
		this.timer = timer;
		this.parent = parent;
		setLayout(new FlowLayout());
		startStop.addActionListener(this);
		nextStep.addActionListener(this);
		add(startStop);
		add(nextStep);
		nextStep.setVisible(false);
		setVisible(true);

	}
	
	
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
			parent.updateState();
		}
	}
}
