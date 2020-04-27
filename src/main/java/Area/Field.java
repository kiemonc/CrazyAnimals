package Area;

/**
 * @author Mikołaj
 * Klasa, która przechowuje informacje o zawartości danego pola na łące
 */

public final class Field {

	private Feed feed;
	private Waterhole waterhole;
	
	Field() {
		
	}
	
	public boolean isEmpty() {return true;}
	public void putFeed() {}
	public Feed getFeed() {return feed;}

	public boolean isWaterhole() {return false;}
}
