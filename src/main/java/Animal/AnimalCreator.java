/**
 * 
 */
package Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Klasa odpowiada za tworzenie zadanej liczby zwierz¹t
 * @author jakub
 *
 */
public class AnimalCreator implements IAnimalCreator{
	private Random rnd = new Random();
	/**
	 * Tworzy zwierzêta o podanej iloœci
	 * @param liczba zwierz¹t z ka¿dego gatunku
	 * @return referencja do listy zwierz¹t
	 */
	public List<Animal> createAnimals(int nrOfCats, int nrOfCows, int nrOfMouses, int nrOfSheeps, int nrOfWolves) {
		List<Animal> list = new ArrayList<Animal>();
		for(int i = 0; i < nrOfCats; i++)   {list.add(createCat());}
		for(int i = 0; i < nrOfCows; i++)   {list.add(createCow());}
		for(int i = 0; i < nrOfMouses; i++) {list.add(createMouse());}
		for(int i = 0; i < nrOfSheeps; i++) {list.add(createSheep());}
		for(int i = 0; i < nrOfWolves; i++) {list.add(createWolf());}
		return list;
	}
	/**
	 * Tworzy jednego kota
	 * @return kot
	 */
	public Cat createCat() 	   { return new Cat  (0, 0, 0, rnd.nextBoolean()); }
	/**
	 * Tworzy jedn¹ krowê
	 * @return krowa
	 */
	public Cow createCow() 	   { return new Cow  (0, 0, 0, rnd.nextBoolean()); }
	/**
	 * Tworzy jednego wilka
	 * @return wilk
	 */
	public Wolf createWolf()   { return new Wolf (0, 0, 0, rnd.nextBoolean()); }
	/**
	 * Tworzy mysz
	 * @return mysz
	 */
	public Mouse createMouse() { return new Mouse(0, 0, 0, rnd.nextBoolean()); }
	/**
	 * Tworzy owcê
	 * @return owca
	 */
	public Sheep createSheep() { return new Sheep(0, 0, 0, rnd.nextBoolean()); }
}
