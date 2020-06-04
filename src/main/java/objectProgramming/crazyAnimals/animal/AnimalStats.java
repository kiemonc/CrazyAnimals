/**
 * 
 */
package objectProgramming.crazyAnimals.animal;

/**
 * Klasa odpowiada za zbieranie statystyk dotyczących populacji zwierząt podczas działania symulacji
 * @author jakub
 */
public class AnimalStats {
	//0 - Cat, 1 - Cow, 2 - Mouse, 3 - Sheep, 4 - Wolf
	private static int [] currentPopulation, maxPopulation;
	/**
	 * Konstruktor klasy zeruje wszystkie statystyki
	 */
	public AnimalStats() {
		currentPopulation = new int []{0, 0, 0, 0, 0};
		maxPopulation = new int[]{0, 0, 0, 0, 0};
	}
	/**
	 * Dodaje zwierzę danego gatunku do statystyk
	 * @param animal gatunek zwierzęcia (0 - kot, 1 - krowa, 2 - mysz, 3 - owca, 4 - wilk)
	 */
	public static void addAnimal(int animal) {
		currentPopulation[animal]++;
		if(currentPopulation[animal] > maxPopulation[animal])
			maxPopulation[animal] = currentPopulation[animal];
	}
	/**
	 * Odejmuje zwierzę danego gatunku od statystyk
	 * @param animal gatunek zwierzęcia (0 - kot, 1 - krowa, 2 - mysz, 3 - owca, 4 - wilk)
	 */
	public static void takeAnimal(int animal) {
		currentPopulation[animal]--;
	}
	/**
	 * Pozwala pobrać aktualną populację dla wszystkich gatunków
	 * @return statystyki dotyczące obecnej populacji
	 */
	public static int [] getCurrentPopulation() {
		return currentPopulation;
	}
	/**
	 * Pozwala pobrać maksymalną populację dla wszystkich gatunków
	 * @return statystyki dotyczące maksymalnej populacji
	 */
	public static int [] getMaxPopulation() {
		return maxPopulation;
	}
	/**
	 * Pozwala pobrać statystyki w postaci wartości z opisami
	 * @return
	 */
	public static String getString() {
		String stats = "Current population: ";
		stats += "\nCats: " + getCurrentPopulation()[0];
		stats += "\nCows: " + getCurrentPopulation()[1];
		stats += "\nMouses: " + getCurrentPopulation()[2];
		stats += "\nSheeps: " + getCurrentPopulation()[3];
		stats += "\nWolves: " + getCurrentPopulation()[4];
		
		stats += "\n\nMax population: ";
		stats += "\nCats: " + getMaxPopulation()[0];
		stats += "\nCows: " + getMaxPopulation()[1];
		stats += "\nMouses: " + getMaxPopulation()[2];
		stats += "\nSheeps: " + getMaxPopulation()[3];
		stats += "\nWolves: " + getMaxPopulation()[4];
		stats += "\n";
		return stats;
	}
}
