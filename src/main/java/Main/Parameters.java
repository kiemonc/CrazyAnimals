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
	
	public Parameters(Random random) throws BadParametersException {
		this.random = random;
		meadowWidth = 5;
		meadowHeight = 5;
		numWaterholes = 18;
		int [] startMinNum = {1,1,1,1,1};
		this.startMinNum = startMinNum;
		int [] startMaxNum = {3,3,3,3,3};
		this.startMaxNum = startMaxNum;
		int [] endMinNum = {0,-1,-1,-1,-1};
		this.endMinNum = endMinNum;
		int [] endMaxNum = {20,-1,-1,-1,-1};
		this.endMaxNum = endMaxNum;
		
		startNum = new int[5];
		
		
		int startMinNumAnimals = 0, startMaxNumAnimals = 0, endMaxNumAnimals = 0, endMinNumAnimals = 0;
		for(int i = 0; i < 5; i++) {
			if(startMinNum[i] < endMinNum[i] || (startMaxNum[i] > endMaxNum[i] && endMaxNum[i] >= 0) || startMaxNum[i] - startMinNum[i] < 0 || startMinNum[i] < 0 || endMinNum[i] < -1 || endMaxNum[i] < -1) {
				throw new BadParametersException();
			}
			startMaxNumAnimals += startMaxNum[i]; 
			startMinNumAnimals += startMinNum[i];
			endMinNumAnimals += endMinNum[i];
			endMaxNumAnimals += endMaxNum[i];
		}
		if(meadowHeight < 2 || meadowWidth < 2 ||startMinNumAnimals <= 0 || endMinNumAnimals < -4 || startMaxNumAnimals >= meadowHeight*meadowWidth || endMaxNumAnimals >= 2* meadowHeight*meadowWidth || numWaterholes > 2*(meadowHeight+meadowWidth-1)) {
			throw new BadParametersException();
		}
		
		for(int i = 0; i < 5; i++) {
			if(startMaxNum[i] - startMinNum[i] > 0) {
				startNum[i] = random.nextInt(this.startMaxNum[i] - this.startMinNum[i]) + this.startMinNum[i];
			}
			else startNum[i] = startMinNum[i];
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
