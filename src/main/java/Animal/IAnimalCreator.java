package Animal;

import java.util.List;

import Area.IMeadow;
import Area.IField;

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
	 * @return referencja do listy zwierząt
	 */
	public List<IAnimal> createAnimals(int nrOfCats, int nrOfCows, int nrOfMouses, int nrOfSheeps, int nrOfWolves, IMeadow meadow);
	/**
	 * Tworzy jednego kota i umieszcza go na podanym polu
	 * @param field pole na którym ma zostać umieszczony kot
	 * @return referencja do utworzonego kota
	 */
	public Cat createCat(IField field);
	/**
	 * Tworzy jedną krowę i umieszcza ją na podanym polu
	 * @param field pole na którym ma zostać umieszczona krowa
	 * @return referencja do utworzonej krowy
	 */
	public Cow createCow(IField field);
	/**
	 * Tworzy jednego wilka i umieszcza go na podanym polu
	 * @param field pole na którym ma zostać umieszczony wilk
	 * @return referencja do utworzonego wilka
	 */
	public Wolf createWolf(IField field);
	/**
	 * Tworzy jedną mysz i umieszcza ją na podanym polu
	 * @param field pole na którym ma zostać umieszczona mysz
	 * @return referencja do utworzonej myszy
	 */
	public Mouse createMouse(IField field);
	/**
	 * Tworzy jedną owcę i umieszcza ją na podanym polu
	 * @param field pole na którym ma zostać umieszczona owca
	 * @return referencja do utworzonej owcy
	 */
	public Sheep createSheep(IField field);
}
