package objectProgramming.crazyAnimals.animal;

import java.util.List;
import java.util.Random;

import objectProgramming.crazyAnimals.area.IMeadow;

/**
 * Interfejs przechowujący operacje klasy AnimalCreator
 * @author jakub
 */
public interface IAnimalCreator {
	/**
	 * Tworzy zwierzęta w podanej liczbie i rozmieszcza je losowo na łące
	 * @param nrOfCats liczba kotów
	 * @param nrOfCows liczba krów
	 * @param nrOfMouses liczba myszy
	 * @param nrOfSheeps liczba owiec
	 * @param nrOfWolves liczba wilków
	 * @param meadow referencja do łąki
	 * @param random referencja do zmiennej typu Random
	 * @return referencja do listy zwierząt
	 */
	public List<IAnimal> createAnimals(int nrOfCats, int nrOfCows, int nrOfMouses, int nrOfSheeps, int nrOfWolves, IMeadow meadow, Random random);
}
