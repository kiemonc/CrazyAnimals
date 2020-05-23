package Area;

import java.util.List;
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
