/**
 * 
 */
package Main;

/**
 * @author Mikołaj
 * Klasa komunikuje się z użytkownikiem, ustawia i przechowuje parametry początkowe, czyli minialne i maksymalne liczebności każdego gatunku zwierząt, wymiary łąki oraz liczbę wodopojów.
 * Klasa ustawia i przechowuje liczbę wodopojów.
 */
public final class Parameters {
	public Parameters(String inputString) {}
	public Parameters() {}
	public int meadowWidth;
	public int meadowHeight;
	public int numWaterholes;
	
	public int[] startMaxNum;
	public int[] startMinNum;
	public int[] endMaxNum;
	public int[] endMinNum;
}
