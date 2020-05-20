/**
 * 
 */
package Main;

import java.util.Random;
/**
 * @author Mikołaj
 * Klasa komunikuje się z użytkownikiem, ustawia i przechowuje parametry początkowe, czyli minialne i maksymalne liczebności każdego gatunku zwierząt, wymiary łąki oraz liczbę wodopojów.
 * Klasa ustawia i przechowuje liczbę wodopojów.
 */
public final class Parameters {
	Random random;
	
	public Parameters() {
		random = new Random(0);
		meadowWidth = 100;
		meadowHeight = 100;
		numWaterholes = 10;
		int [] startMinNum = {1,1,1,1,1};
		this.startMinNum = startMinNum;
		int [] startMaxNum = {4,4,4,4,4};
		this.startMaxNum = startMaxNum;
		int [] endMinNum = {2,2,2,2,2};
		this.endMinNum = endMinNum;
		int [] endMaxNum = {3,3,3,3,3};
		this.endMaxNum = endMaxNum;
		
		for(int i = 0; i < 5; i++) {
			startNum[i] = random.nextInt(startMaxNum[i]) + startMinNum[i];
		}
	}
	
	public final int meadowWidth;
	public final int meadowHeight;
	public final int numWaterholes;
	
	
	//[0]cat [1]cow [2]mouse [3]sheep [4]wolf
	public int[] startNum;
	
	public final int[] startMaxNum;
	public final int[] startMinNum;
	public final int[] endMaxNum;
	public final int[] endMinNum;
	
}
