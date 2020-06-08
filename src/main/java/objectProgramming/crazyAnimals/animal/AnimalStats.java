/**
 * 
 */
package objectProgramming.crazyAnimals.animal;

/**
 * Klasa odpowiada za zbieranie statystyk dotyczących populacji zwierząt podczas działania symulacji
 * @author jakub
 */
public class AnimalStats {
	private int currentPopulation = 0, maxPopulation = 0;
	/**
	 * Metoda odpowiada za zerowanie statystyk
	 */
	public void clearStats() {
		currentPopulation = 0;
		maxPopulation = 0;
	}
	/**
	 * Dodaje jedno zwierzę do statystyk
	 */
	public void addAnimal() {
		currentPopulation++;
		if(currentPopulation > maxPopulation)
			maxPopulation = currentPopulation;
	}
	/**
	 * Odejmuje jedno zwierzę od statystyk
	 */
	public void takeAnimal() {currentPopulation--;}
	/**
	 * Pozwala pobrać statystyki gatunku
	 * @return tablica ze statystykami [obecna populacja, maksymalna populacja]
	 */
	public int [] getStats() {return new int [] {currentPopulation, maxPopulation};}

}
