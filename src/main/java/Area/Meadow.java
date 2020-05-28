/**
 * 
 */
package Area;

/**
 * @author Mikołaj
 * Klasa odpowiada za przechowywanie informacji o stanie łąki. Klasa składa się z pól składowych. Rozmieszcza wopoje oraz pożywienie podczas inicjalizacji planszy. 
 * Rozmieszcza nowe pożywienie podczas trwania symulacji.
 */
public final class Meadow {
	
	private int width;
	private int height;
	private Field[][] tab;
	Meadow(int width, int height, int numWaterholes, int numFeeds) {
		//wiersze i kolumny są numerowane tak samo jak w macierzy
		tab = new Field[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				tab[i][j] = new Field();
			}
		}
		
		initialWaterholes(numWaterholes);
	}
	Meadow() {}
	private void initialFeed(int numFeeds) {}
	private void initialWaterholes(int numWaterholes) {}
	private void spreadNewFeed() {}
	public void doIteration() {}
	
}
