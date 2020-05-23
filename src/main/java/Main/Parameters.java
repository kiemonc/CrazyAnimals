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

	
	public Parameters(Random random) throws BadParametersException {
		meadowWidth = 30;
		meadowHeight = 30;
		numWaterholes = 100;
		
		int [] startMinNum = {100,100,100,100,50};
		this.startMinNum = startMinNum;
		int [] startMaxNum = {100,100,100,100,50};
		this.startMaxNum = startMaxNum;
		int [] endMinNum = {-1,-1,-1,-1,-1};
		this.endMinNum = endMinNum;
		int [] endMaxNum = {-1,-1,-1,-1,-1};
		this.endMaxNum = endMaxNum;
		
		this.maxIterationNum = 1000;
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
		if(meadowHeight < 2 || meadowWidth < 2 || startMinNumAnimals <= 0 || endMinNumAnimals < -5 || startMaxNumAnimals >= meadowHeight*meadowWidth || endMaxNumAnimals >= 2* meadowHeight*meadowWidth || numWaterholes > 2*(meadowHeight+meadowWidth-1)) {
			throw new BadParametersException();
		}
		
		for(int i = 0; i < 5; i++) {
			if(startMaxNum[i] - startMinNum[i] > 0) {
				startNum[i] = random.nextInt(this.startMaxNum[i] - this.startMinNum[i]) + this.startMinNum[i];
			}
			else startNum[i] = startMinNum[i];
		}
		
	}
	
	/**
	 * Szerokość łąki liczona w polach
	 */
	public final int meadowWidth;
	
	/**
	 * Wysokość łąki liczona w polach
	 */
	public final int meadowHeight;
	
	/**
	 * Liczba wodopoi
	 */
	public final int numWaterholes;
	
	/**
	 * Maksymalna liczba iteracji. Iteracja o zadanym numerze jest ostatnią wykonywaną.
	 */
	public final int maxIterationNum;
	
	
	/**
	 * Tablica liczebności zwierząt podczas startu symulacji
	 * [0] - cat; [1] - cow; [2] - mouse; [3] - sheep; [4] - wolf
	 */
	public int[] startNum;
	
	/**
	 * Tablica maksymalnych liczebności zwierząt podczas startu symulacji
	 * [0] - cat; [1] - cow; [2] - mouse; [3] - sheep; [4] - wolf
	 */
	public final int[] startMaxNum;
	/**
	 * Tablica minimalnych liczebności zwierząt podczas startu symulacji
	 * [0] - cat; [1] - cow; [2] - mouse; [3] - sheep; [4] - wolf
	 */
	public final int[] startMinNum;
	
	/**
	 * Tablica maksymalnych liczebności zwierząt. Przekroczenie, którejkowiek wartości kończy symulację.
	 * -1 oznacza, że liczebność danego gatunku nie jest brana pod uwagę
	 * [0] - cat; [1] - cow; [2] - mouse; [3] - sheep; [4] - wolf
	 */
	public final int[] endMaxNum;
	
	/**
	 * Tablica minimalnej liczebności zwierząt. Przekroczenie, którejkowiek wartości kończy symulację.
	 * -1 oznacza, że liczebność danego gatunku nie jest brana pod uwagę
	 * [0] - cat; [1] - cow; [2] - mouse; [3] - sheep; [4] - wolf
	 */
	public final int[] endMinNum;
	
}
