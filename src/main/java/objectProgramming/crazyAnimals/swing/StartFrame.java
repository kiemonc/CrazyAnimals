package objectProgramming.crazyAnimals.swing;
import javax.swing.*;

import objectProgramming.crazyAnimals.main.Parameters;

@SuppressWarnings("serial")
public class StartFrame extends JFrame {


	public StartFrame(Parameters parameters) {
		super("Crazy Animals");

		JPanel startPanel = new StartPanel(this, parameters);
		add(startPanel);
		setResizable(false);

 		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}