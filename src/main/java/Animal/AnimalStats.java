/**
 * 
 */
package Animal;

/**
 * Klasa odpowiada za zbieranie statystyk dotyczących populacji zwierząt podczas działania symulacji
 * @author jakub
 */
public class AnimalStats {
	//0 - Cat, 1 - Cow, 2 - Mouse, 3 - Sheep, 4 - Wolf
	private static int [] currentPopulation = {0, 0, 0, 0, 0}, maxPopulation = {0, 0, 0, 0, 0};
	/**
	 * Dodaje zwierzą danego gatunku do statystyk
	 * @param animal gatunek zwierzęcia (0 - kot, 1 - krowa, 2 - mysz, 3 - owca, 4 - wilk)
	 */
	public static void addAnimal(int animal) {
		currentPopulation[animal]++;
		if(currentPopulation[animal] > maxPopulation[animal])
			maxPopulation[animal] = currentPopulation[animal];
	}
	/**
	 * Odejmuje zwierzą danego gatunku od statystyk
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
}
