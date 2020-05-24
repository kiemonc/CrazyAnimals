package objectProgramming.crazyAnimals.area;

import java.util.List;

/**
 * Interfejs odpowiedzialny za udostępnianie metod niezbędnych do współpracy z łąką.
 * Zawiera takie metody jak: pobieranie sąsiadów danego pola, udostępnianie losowych pól o zadanej licznie, wykananie jednej iteracji.
 * @author Mikołaj
 *
 */

public interface IMeadow {
	
	/**
	 * Metoda wyszukuje i tworzy listę sąsiadów
	 * @param field Pole, którego sąsiadów należy znalezć
	 * @return lista najbliższych sąsiadów
	 */
	public List<IField> getNeighbours(IField field);
	
	/**
	 * Zwraca listę losowych pól w liczbie zadanej w parametrze
	 * @param numFields liczba pól do zwrócenia
	 * @return lista losowych pól
	 */
	public List<IField> getRandomFields(int numFields);
	
	/**
	 * Wykonuje rutynowe czyności, które są niezbędne podczas iterowania symulacji, czyli m.in. rozkłada nowe pożywienie
	 */
	public void doIteration();
}
