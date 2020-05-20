/**
 * 
 */
package Animal;

/**
 * Klasa odpowiada za zbieranie statystyk dotycz¹cych populacji zwierz¹t podczas dzia³ania symulacji
 * @author jakub
 */
public class AnimalStats {
	//0 - Cat, 1 - Cow, 2 - Mouse, 3 - Sheep, 4 - Wolf
	private static int [] currentPopulation = {0, 0, 0, 0, 0}, maxPopulation = {0, 0, 0, 0, 0};
	/**
	 * Dodaje zwierzê danego gatunku do statystyk
	 * @param animal gatunek zwierzêcia (0 - kot, 1 - krowa, 2 - mysz, 3 - owca, 4 - wilk)
	 */
	public static void addAnimal(int animal) {
		currentPopulation[animal]++;
		if(currentPopulation[animal] > maxPopulation[animal])
			maxPopulation[animal] = currentPopulation[animal];
	}
	/**
	 * Odejmuje zwierzê danego gatunku od statystyk
	 * @param animal gatunek zwierzêcia (0 - kot, 1 - krowa, 2 - mysz, 3 - owca, 4 - wilk)
	 */
	public static void takeAnimal(int animal) {
		currentPopulation[animal]--;
	}
	/**
	 * Pozwala pobraæ aktualn¹ populacjê dla wszystkich gatunków
	 * @return statystyki dotycz¹ce obecnej populacji
	 */
	public static int [] getCurrentPopulation() {
		return currentPopulation;
	}
	/**
	 * Pozwala pobraæ maksymaln¹ populacjê dla wszystkich gatunków
	 * @return statystyki dotycz¹ce maksymalnej populacji
	 */
	public static int [] getMaxPopulation() {
		return maxPopulation;
	}
}
