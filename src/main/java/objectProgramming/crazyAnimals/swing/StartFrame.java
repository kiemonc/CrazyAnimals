package objectProgramming.crazyAnimals.swing;
import javax.swing.*;

import objectProgramming.crazyAnimals.main.Parameters;

/**
 * Startowe okno symulacji. Wyświetla panel startowy.
 * @author Mikołaj
 *
 */
@SuppressWarnings("serial")
public class StartFrame extends JFrame {

/**
 * Tworzy okno z tytułem "Crazy Animals". Dodaje do okna panel startowy.
 * @param parameters - parametry domyślne
 */
	public StartFrame(Parameters parameters) {
		super("Crazy Animals");
		JPanel startPanel = new StartPanel(this, parameters);
		add(startPanel);
		setResizable(false);
		setSize(380,260);
 		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}