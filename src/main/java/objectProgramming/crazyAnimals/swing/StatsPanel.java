/**
 * 
 */
package objectProgramming.crazyAnimals.swing;

import javax.swing.JLabel;
import javax.swing.JPanel;

import objectProgramming.crazyAnimals.animal.AnimalStats;
import objectProgramming.crazyAnimals.area.Feed;

/**
 * @author jakub
 *
 */
@SuppressWarnings("serial")
public class StatsPanel extends JPanel {
	
	private static final String [] animalsNames = {"Cats", "Cows", "Mouses", "Sheeps", "Wolves"}, feedNames = {"Grass", "Cheese"};
	private JLabel [] animals = new JLabel[5], feed = new JLabel[2];
	/**
	 * Konstruktor tworzy etykiety pokazujące aktualne statystyki zwierząt i jedzenia
	 */
	public StatsPanel() {
		for(int i = 0; i < 5; i++) {
			animals[i] = new JLabel(animalsNames[i] + ": " + AnimalStats.getCurrentPopulation()[i]); 
			add(animals[i]);
		}
		for(int i = 0; i < 2; i++) {
			feed[i] = new JLabel(feedNames[i] + ": " + Feed.getNumAll(i == 0 ? "cheese" : "grass"));
			add(feed[i]);
		}
	}
	/**
	 * Metoda aktualizuje etykiety aby były one zgodne z aktualnymi statystykami
	 */
	public void update() {
		for(int i = 0; i < 5; i++)
			animals[i].setText(animalsNames[i] + ": " + AnimalStats.getCurrentPopulation()[i]);
		for(int i = 0; i < 2; i++) 
			feed[i].setText(feedNames[i] + ": " + Feed.getNumAll(i == 0 ? "cheese" : "grass"));
	}
}
