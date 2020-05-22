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
		meadowWidth = 5;
		meadowHeight = 5;
		numWaterholes = 14;
		int [] startMinNum = {5,0,0,0,0};
		this.startMinNum = startMinNum;
		int [] startMaxNum = {5,0,0,0,0};
		this.startMaxNum = startMaxNum;
		int [] endMinNum = {0,-1,-1,-1,-1};
		this.endMinNum = endMinNum;
		int [] endMaxNum = {20,-1,-1,-1,-1};
		this.endMaxNum = endMaxNum;
		
		startNum = new int[5];
		for(int i = 0; i < 5; i++) {
			if(startMaxNum[i] > 0) {
				startNum[i] = random.nextInt(this.startMaxNum[i]) + this.startMinNum[i];
			}
			else startNum[i] = 0;
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
