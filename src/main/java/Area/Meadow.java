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
	private IField[][] tab;
	
/**
 * Konstruktor klasy Meadow tworzy łąke z zadanymi parametrami początkowymi
 * @param width Szerokość łąki
 * @param height Wysokość łąki
 * @param numWaterholes Ilość wodopoi
 * @param numFeeds Początkowa ilość pożywienia
 */
	Meadow(int width, int height, int numWaterholes, int numFeeds) {
		//wiersze i kolumny są numerowane tak samo jak w macierzy
		tab = new IField[height][width];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				tab[y][x] = new Field(x,y);
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
