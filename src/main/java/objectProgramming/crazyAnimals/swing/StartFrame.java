package objectProgramming.crazyAnimals.swing;
import javax.swing.*;

public class StartFrame extends JFrame {

	private static final long serialVersionUID = 4030969856704141014L;

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