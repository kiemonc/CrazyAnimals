package Animal;

import java.util.List;

import Area.IMeadow;
import Area.IField;

/**
 * Interfejs przechowuj¹cy operacje klasy AnimalCreator
 * @author jakub
 */
public interface IAnimalCreator {
	/**
	 * Tworzy zwierzêta w podanej liczbie i rozmieszcza je losowo na ³¹ce
	 * @param nrOfCats liczba kotów
	 * @param nrOfCows liczba krów
	 * @param nrOfMouses liczba myszy
	 * @param nrOfSheeps liczba owiec
	 * @param nrOfWolves liczba wilków
	 * @return referencja do listy zwierz¹t
	 */
	public List<Animal> createAnimals(int nrOfCats, int nrOfCows, int nrOfMouses, int nrOfSheeps, int nrOfWolves, IMeadow meadow);
	/**
	 * Tworzy jednego kota i umieszcza go na podanym polu
	 * @param field pole na którym ma zostaæ umieszczony kot
	 * @return referencja do utworzonego kota
	 */
	public Cat createCat(IField field);
	/**
	 * Tworzy jedn¹ krowê i umieszcza j¹ na podanym polu
	 * @param field pole na którym ma zostaæ umieszczona krowa
	 * @return referencja do utworzonej krowy
	 */
	public Cow createCow(IField field);
	/**
	 * Tworzy jednego wilka i umieszcza go na podanym polu
	 * @param field pole na którym ma zostaæ umieszczony wilk
	 * @return referencja do utworzonego wilka
	 */
	public Wolf createWolf(IField field);
	/**
	 * Tworzy jedn¹ mysz i umieszcza j¹ na podanym polu
	 * @param field pole na którym ma zostaæ umieszczona mysz
	 * @return referencja do utworzonej myszy
	 */
	public Mouse createMouse(IField field);
	/**
	 * Tworzy jedn¹ owcê i umieszcza j¹ na podanym polu
	 * @param field pole na którym ma zostaæ umieszczona owca
	 * @return referencja do utworzonej owcy
	 */
	public Sheep createSheep(IField field);
}
