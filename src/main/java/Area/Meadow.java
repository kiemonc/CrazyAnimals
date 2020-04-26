/**
 * 
 */
package Area;

/**
 * @author Mikołaj
 * Klasa odpowiada za przechowywanie informacji o stanie łąki. Klasa składa się z pól składowych. 
 */
public class Meadow {
	
	private Integer width;
	private Integer height;
	private Field[][] tab;
	Meadow(Integer width, Integer height, Integer numWaterholes, Integer numFeeds) {
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
	private void buildMap() {}
	private void initialFeed(Integer numFeeds) {}
	private void spreadFeed() {}
	private void initialWaterholes(Integer numWaterholes) {}
	private void initialAnimals() {}
	
}
