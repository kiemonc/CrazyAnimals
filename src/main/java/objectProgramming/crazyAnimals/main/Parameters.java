/**
 * 
 */
package objectProgramming.crazyAnimals.main;


import com.beust.jcommander.Parameter;
import java.util.List;
import java.util.Random;
/**
 * 
 * Ustawia i przechowuje parametry początkowe, czyli minialne i maksymalne liczebności każdego gatunku zwierząt, wymiary łąki oraz liczbę wodopojów.
 * Przechwytuje sparsowane argumenty funkcji Control.maio(String args);
 * Sprawdza poprawność agrumentów.
 * Przedział możliwej początkowej liczbeności gatunku musi zawierać się w przedziale końcowym liczebności.
 * Na łące początkowo musi znajdować się conajmniej 1 zwierzę.
 * Liczby początkowe nie mogę być mniejsze od 0.
 * Końcowe liczby mogą równać się -1 w przypadku gdy dana wartość ma nie być sprawdzana w warunkach końcowych symulacji.
 * Początkowa liczba zwierząt musi być mniejsza od liczby pól.
 * Liczba wodopoi musi być większa od 0, ale musi być mniejsza bądz równa liczbie pól znajdujących się przy krawędzi łąki.
 * Maksymalna liczba iteracji musi być większa od 0.
 * @author Mikołaj
 */
public final class Parameters {
	
/**
 * Referencja do obietku Radnom wspólnego dla całej symulacji
 */
	private Random random;
	
	public Parameters(Random random) {
		this.random = random;
	}
	
/**
 * Ustawia parametry przechwycone podczas parsowania lub pozostawia domyślne wartości.
 * Sprawdza zgodność parametrów opisaną w opisie klasy Parameters.
 * Kiedy parametry okazują się być niezgodne wyrzuca wyjątek.
 * @throws BadParametersException - wyjątek sprzeczności agumentów
 */
	public void setParametrs() throws BadParametersException {

		
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
		if(maxIterationNum <= 0 || meadowHeight < 2 || meadowWidth < 2 || startMinNumAnimals <= 0 || endMinNumAnimals < -5 || startMaxNumAnimals >= meadowHeight*meadowWidth) { // || endMaxNumAnimals >= 2* meadowHeight*meadowWidth) {
			throw new BadParametersException();
		}
		if(numWaterholes > 2*(meadowHeight+meadowWidth-2) || numWaterholes < 1) {
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
	 * Przechowuje informacje czy została wywołana pomoc podczas parsowania
	 */
	@Parameter(names = {"--help","-hp"}, description = "Show help")
	boolean help = false;
	 
	/**
	 * Szerokość łąki liczona w polach
	 */
	@Parameter(names = {"--witdh","-w"}, description = "Width of meadow in fields")
	public int meadowWidth = 10;
	
	 
	/**
	 * Wysokość łąki liczona w polach
	 */
	@Parameter(names = {"--height","-h"}, description = "Height of meadow in fields")
	public int meadowHeight = 10;
	
	/**
	 * Liczba wodopoi
	 */
	@Parameter(names = {"--waterholes","-wh"}, description = "Number of waterholes")
	public int numWaterholes = 20;
	
	/**
	 * Maksymalna liczba iteracji. Iteracja o zadanym numerze jest ostatnią wykonywaną.
	 */
	@Parameter(names = {"--iterations","-i"}, description = "Max number of iterations. After this number of iterations the simulation will stop.")
	public int maxIterationNum = 100;
	
	
	/**
	 * Tablica liczebności zwierząt podczas startu symulacji
	 * [0] - cat; [1] - cow; [2] - mouse; [3] - sheep; [4] - wolf
	 */
	public int[] startNum;
	
	/**
	 * Tablica maksymalnych liczebności zwierząt podczas startu symulacji
	 * [0] - cat; [1] - cow; [2] - mouse; [3] - sheep; [4] - wolf
	 */
	@Parameter(names = {"--startMaxNum","-sMax"}, description = "Start max number of animals of each species, separated by ',' [0] - cat; [1] - cow; [2] - mouse; [3] - sheep; [4] - wolf")
	List<String> startMaxNumList;
	public int [] startMaxNum = {10,10,10,10,10};
	
	/**
	 * Tablica minimalnych liczebności zwierząt podczas startu symulacji
	 * [0] - cat; [1] - cow; [2] - mouse; [3] - sheep; [4] - wolf
	 */
	@Parameter(names = {"--startMinNum","-sMin"}, description = "Start min number of animals of each species, separated by ',' [0] - cat; [1] - cow; [2] - mouse; [3] - sheep; [4] - wolf")
	List<String> startMinNumList;
	public int [] startMinNum = {8,8,8,8,8};
	
	/**
	 * Tablica maksymalnych liczebności zwierząt. Przekroczenie, którejkowiek wartości kończy symulację.
	 * -1 oznacza, że liczebność danego gatunku nie jest brana pod uwagę
	 * [0] - cat; [1] - cow; [2] - mouse; [3] - sheep; [4] - wolf
	 */
	@Parameter(names = {"--endMaxNum","-eMax"}, description = "Max number of animals of each species, separated by ',' [0] - cat; [1] - cow; [2] - mouse; [3] - sheep; [4] - wolf")
	List<String> endMaxNumList;
	public int [] endMaxNum = {-1,-1,-1,-1,-1};
	
	@Parameter(names = {"--console","-c"}, description = "True if user would like to run simulation in console")
	boolean console=false;
	
	/**
	 * Tablica minimalnej liczebności zwierząt. Przekroczenie, którejkowiek wartości kończy symulację.
	 * -1 oznacza, że liczebność danego gatunku nie jest brana pod uwagę
	 * [0] - cat; [1] - cow; [2] - mouse; [3] - sheep; [4] - wolf
	 */
	@Parameter(names = {"--endMinNum","-eMin"}, splitter = StringConverter.class, description = "Mix number of animals of each species, separated by ',' [0] - cat; [1] - cow; [2] - mouse; [3] - sheep; [4] - wolf")
	List<String> endMinNumList;
	public int [] endMinNum = {-1,-1,-1,-1,-1};
	
	private int [] listToTable(List<String> list) {
		int [] numbers = new int [5];
		for(int i = 0; i < 5; i++) {
			numbers[i] = Integer.parseInt(list.get(i));
		}
		return numbers;
	}
	
	/**
	 * Ścieżka do pliku, który zostanie zapisany na końcu symulacji. Jeżeli już istniej plik o takiej nazwie to statystyki zostaną dopisane na końcu pliku.
	 */
	@Parameter(names = {"--path","-p"}, description = "Path to the file with statistics")
	public String path = "data.csv";
	
	
	/**
	 * Inicjalizuje początkowe oraz końcowe graniczne liczebności zwierząt.
	 * Zaminia listy uzyskany podczas parsowania na tablice.
	 * W przypadku brak list z parsowania wstawia domyślne wartości
	 */
	public void initializeNumAnimals() {
		if(startMinNumList != null && startMinNumList.size() == 5) {
			startMinNum = listToTable(startMinNumList);
		}
		if(startMaxNumList != null && startMaxNumList.size() == 5) {
			startMaxNum = listToTable(startMaxNumList);
		}
		if(endMinNumList != null && endMinNumList.size() == 5) {
			endMinNum = listToTable(endMinNumList);
		}
		if(endMaxNumList != null && endMaxNumList.size() == 5) {
			endMaxNum = listToTable(endMaxNumList);
		}
		
	}
}
