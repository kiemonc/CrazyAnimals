package Area;

/**
 * @author Mikołaj
 * Klasa, która przechowuje informacje o zawartości danego pola na łące
 */

public class Field {

	private Feed feed;
	private Animal[] animal;
	private Integer numAnimals;
	private Waterhole waterhole;
	
	Field() {
		numAnimals = 0;
	}
	
	boolean isEmpty() {return false;}
	public void putFeed(Feed feed) {
		this.feed = feed;
	}
	
	public void putAnimal(Animal animal) {
		this.animal[numAnimals] = animal;
		numAnimals++;
	}
}
