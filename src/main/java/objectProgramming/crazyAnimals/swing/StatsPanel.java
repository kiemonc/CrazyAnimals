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
public class StatsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final String [] animalsNames = {"Cats", "Cows", "Mouses", "Sheeps", "Wolves"}, feedNames = {"Grass", "Cheese"};
	private JLabel [] animals = new JLabel[5], feed = new JLabel[2];
	public StatsPanel() {
		for(int i = 0; i < 5; i++) {
			animals[i] = new JLabel(animalsNames[i] + ": " + AnimalStats.getCurrentPopulation()[i]); 
			add(animals[i]);
		}
		for(int i = 0; i < 2; i++) {
			feed[i] = new JLabel(feedNames[i] + ": " + Feed.getNumAll(feedNames[i].toLowerCase()));
			add(feed[i]);
		}
	}
	
	public void update() {
		for(int i = 0; i < 5; i++)
			animals[i].setText(animalsNames[i] + ": " + AnimalStats.getCurrentPopulation()[i]);
		for(int i = 0; i < 2; i++) 
			feed[i].setText(feedNames[i] + ": " + Feed.getNumAll(feedNames[i].toLowerCase()));
	}
}
