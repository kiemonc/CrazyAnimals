package Animal;

import java.util.List;

import Area.IMeadow;
import Area.IField;

/**
 * Interfejs przechowuj�cy operacje klasy AnimalCreator
 * @author jakub
 */
public interface IAnimalCreator {
	/**
	 * Tworzy zwierz�ta w podanej liczbie i rozmieszcza je losowo na ��ce
	 * @param nrOfCats liczba kot�w
	 * @param nrOfCows liczba kr�w
	 * @param nrOfMouses liczba myszy
	 * @param nrOfSheeps liczba owiec
	 * @param nrOfWolves liczba wilk�w
	 * @return referencja do listy zwierz�t
	 */
	public List<IAnimal> createAnimals(int nrOfCats, int nrOfCows, int nrOfMouses, int nrOfSheeps, int nrOfWolves, IMeadow meadow);
	/**
	 * Tworzy jednego kota i umieszcza go na podanym polu
	 * @param field pole na kt�rym ma zosta� umieszczony kot
	 * @return referencja do utworzonego kota
	 */
	public Cat createCat(IField field);
	/**
	 * Tworzy jedn� krow� i umieszcza j� na podanym polu
	 * @param field pole na kt�rym ma zosta� umieszczona krowa
	 * @return referencja do utworzonej krowy
	 */
	public Cow createCow(IField field);
	/**
	 * Tworzy jednego wilka i umieszcza go na podanym polu
	 * @param field pole na kt�rym ma zosta� umieszczony wilk
	 * @return referencja do utworzonego wilka
	 */
	public Wolf createWolf(IField field);
	/**
	 * Tworzy jedn� mysz i umieszcza j� na podanym polu
	 * @param field pole na kt�rym ma zosta� umieszczona mysz
	 * @return referencja do utworzonej myszy
	 */
	public Mouse createMouse(IField field);
	/**
	 * Tworzy jedn� owc� i umieszcza j� na podanym polu
	 * @param field pole na kt�rym ma zosta� umieszczona owca
	 * @return referencja do utworzonej owcy
	 */
	public Sheep createSheep(IField field);
}
