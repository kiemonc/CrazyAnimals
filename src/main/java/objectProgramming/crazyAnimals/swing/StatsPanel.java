/**
 * 
 */
package objectProgramming.crazyAnimals.swing;

import javax.swing.JLabel;
import javax.swing.JPanel;

import objectProgramming.crazyAnimals.animal.Cat;
import objectProgramming.crazyAnimals.animal.Cow;
import objectProgramming.crazyAnimals.animal.Mouse;
import objectProgramming.crazyAnimals.animal.Sheep;
import objectProgramming.crazyAnimals.animal.Wolf;
import objectProgramming.crazyAnimals.area.Feed;

/**
 * Panel wyświetlający statystyki w postaci numeru iteracji, ilości zwierząt i pożywienia każdego gatunku
 * @author jakub
 */
@SuppressWarnings("serial")
public class StatsPanel extends JPanel {
	
	private static final String [] animalsNames = {"Cats", "Cows", "Mouses", "Sheeps", "Wolves"}, feedNames = {"Grass", "Cheese"};
	private JLabel [] animals = new JLabel[5], feed = new JLabel[2];
	private JLabel iterationNr;
	/**
	 * Konstruktor tworzy etykiety pokazujące aktualne statystyki zwierząt i jedzenia
	 * @param iterNr numer aktualnej iteracji
	 */
	public StatsPanel(int iterNr) {
		iterationNr = new JLabel("Iteration number: " + iterNr);
		add(iterationNr);
		for(int i = 0; i < 5; i++) {
			switch(i) {
			case 0: animals[i] = new JLabel(animalsNames[i] + ": " + Cat.stats.getStats()[0]); break;
			case 1: animals[i] = new JLabel(animalsNames[i] + ": " + Cow.stats.getStats()[0]); break;
			case 2: animals[i] = new JLabel(animalsNames[i] + ": " + Mouse.stats.getStats()[0]); break;
			case 3: animals[i] = new JLabel(animalsNames[i] + ": " + Sheep.stats.getStats()[0]); break;
			case 4: animals[i] = new JLabel(animalsNames[i] + ": " + Wolf.stats.getStats()[0]); break;
			}
			add(animals[i]);
		}
		for(int i = 0; i < 2; i++) {
			feed[i] = new JLabel(feedNames[i] + ": " + Feed.getNumAll(i == 0 ? "grass" : "cheese"));
			add(feed[i]);
		}
	}
	/**
	 * Metoda aktualizuje etykiety aby były one zgodne z aktualnymi statystykami
	 * @param iterNr numer aktualnej iteracji
	 */
	public void update(int iterNr) {
		iterationNr.setText("Iteration number: " + iterNr);
		for(int i = 0; i < 5; i++)
			switch(i) {
			case 0: animals[i].setText(animalsNames[i] + ": " + Cat.stats.getStats()[0]); break;
			case 1: animals[i].setText(animalsNames[i] + ": " + Cow.stats.getStats()[0]); break;
			case 2: animals[i].setText(animalsNames[i] + ": " + Mouse.stats.getStats()[0]); break;
			case 3: animals[i].setText(animalsNames[i] + ": " + Sheep.stats.getStats()[0]); break;
			case 4: animals[i].setText(animalsNames[i] + ": " + Wolf.stats.getStats()[0]); break;
			}
		for(int i = 0; i < 2; i++) 
			feed[i].setText(feedNames[i] + ": " + Feed.getNumAll(i == 0 ? "grass" : "cheese"));
	}
}
