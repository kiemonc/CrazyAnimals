package Area;

/**
 * @author Mikołaj
 * Klasa, która przechowuje informacje o zawartości danego pola na łące
 */

public class Field {

	private Feed feed;
	
	Field() {
		
	}
	
	public boolean isEmpty() {return true;}
	public void putFeed() {}
	public Feed getFeed() {return feed;}

	public boolean isWaterhole() {return false;}
}
