package Main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame {

	private static final long serialVersionUID = -2236147160962102591L;

	public Frame() {
		super("Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setSize(300,200);
		setLocation(300,200);
		
		JLabel label = new JLabel();
		label.setText("test");
		
		JPanel panel = new JPanel();
		panel.add(label);
			
		add(panel);
	}
}