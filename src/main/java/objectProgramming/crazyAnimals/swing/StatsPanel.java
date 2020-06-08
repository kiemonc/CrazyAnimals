/**
 * 
 */
package objectProgramming.crazyAnimals.swing;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import objectProgramming.crazyAnimals.animal.Species;
import objectProgramming.crazyAnimals.area.Feed;

/**
 * Panel wyświetlający statystyki w postaci numeru iteracji, ilości zwierząt i pożywienia każdego gatunku
 * @author jakub
 */
@SuppressWarnings("serial")
public class StatsPanel extends JPanel {
	
	private static final String [] feedNames = {"Grass", "Cheese"};
	private List<JLabel>  animals = new LinkedList<>(), feed = new LinkedList<>();
	private JLabel iterationNr;
	/**
	 * Konstruktor tworzy etykiety pokazujące aktualne statystyki zwierząt i jedzenia
	 * @param iterNr numer aktualnej iteracji
	 */
	public StatsPanel(int iterNr) {
		iterationNr = new JLabel("Iteration number: " + iterNr);
		add(iterationNr);
		
		for(Species species : Species.values()) 
			animals.add(new JLabel(species.getName() + ": " + species.getStats()[0])); 
		
		for(JLabel animal : animals)
			add(animal);
		
		for(int i = 0; i < 2; i++) {
			feed.add(new JLabel(feedNames[i] + ": " + Feed.getNumAll(i == 0 ? "grass" : "cheese")));
			add(feed.get(i));
		}
	}
	/**
	 * Metoda aktualizuje etykiety aby były one zgodne z aktualnymi statystykami
	 * @param iterNr numer aktualnej iteracji
	 */
	public void update(int iterNr) {
		iterationNr.setText("Iteration number: " + iterNr);
		int index = 0;
		for(Species species : Species.values())
			animals.get(index++).setText(species.getName() + ": " + species.getStats()[0]); 
			
		for(int i = 0; i < 2; i++) 
			feed.get(i).setText(feedNames[i] + ": " + Feed.getNumAll(i == 0 ? "grass" : "cheese"));
	}
}
