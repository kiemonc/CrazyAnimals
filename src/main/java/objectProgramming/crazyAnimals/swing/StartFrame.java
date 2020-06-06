package objectProgramming.crazyAnimals.swing;
import javax.swing.*;

@SuppressWarnings("serial")
public class StartFrame extends JFrame {


	public StartFrame() {
		super("Crazy Animals");

		JPanel startPanel = new StartPanel(this);
		add(startPanel);
		setResizable(false);

 		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}