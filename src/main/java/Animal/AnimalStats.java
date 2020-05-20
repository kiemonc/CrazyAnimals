/**
 * 
 */
package Animal;

/**
 * Klasa odpowiada za zbieranie statystyk dotycz�cych populacji zwierz�t podczas dzia�ania symulacji
 * @author jakub
 */
public class AnimalStats {
	//0 - Cat, 1 - Cow, 2 - Mouse, 3 - Sheep, 4 - Wolf
	private static int [] currentPopulation = {0, 0, 0, 0, 0}, maxPopulation = {0, 0, 0, 0, 0};
	/**
	 * Dodaje zwierz� danego gatunku do statystyk
	 * @param animal gatunek zwierz�cia (0 - kot, 1 - krowa, 2 - mysz, 3 - owca, 4 - wilk)
	 */
	public static void addAnimal(int animal) {
		currentPopulation[animal]++;
		if(currentPopulation[animal] > maxPopulation[animal])
			maxPopulation[animal] = currentPopulation[animal];
	}
	/**
	 * Odejmuje zwierz� danego gatunku od statystyk
	 * @param animal gatunek zwierz�cia (0 - kot, 1 - krowa, 2 - mysz, 3 - owca, 4 - wilk)
	 */
	public static void takeAnimal(int animal) {
		currentPopulation[animal]--;
	}
	/**
	 * Pozwala pobra� aktualn� populacj� dla wszystkich gatunk�w
	 * @return statystyki dotycz�ce obecnej populacji
	 */
	public static int [] getCurrentPopulation() {
		return currentPopulation;
	}
	/**
	 * Pozwala pobra� maksymaln� populacj� dla wszystkich gatunk�w
	 * @return statystyki dotycz�ce maksymalnej populacji
	 */
	public static int [] getMaxPopulation() {
		return maxPopulation;
	}
}
