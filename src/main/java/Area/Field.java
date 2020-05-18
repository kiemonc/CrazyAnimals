package Area;

import Animal.IAnimal;
import Animal.IEatable;
import java.util.List;
import java.util.LinkedList;

/**
 * @author Miko³aj
 * Klasa, która przechowuje informacje o zawartoœci danego pola na ³¹ce. Przechowuje informacjê o tym czy na danym polu znajduje siê po¿ywienie dla zwierz¹t oraz przechowuje to po¿ywienie.
 */

public class Field implements IField{

	private List<IAnimal> animals;
	private Feed feed;
	private int positionX;
	private int positionY;
	
/**
 * Konstruktor klasy Field tworzy pola, odpowiada za przypisanie wspó³rzêdnych oraz generacje listy zwierz¹t. Nie ma potrzeby tworzenia konstruktora domyœlnego
 * @param positionX 
 * @param positionY
 */
	Field(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
		animals = new LinkedList<IAnimal>();
	}
	
/**
 * Informuje czy na danym polu znajduje siê jakiekolwiek po¿ywienie
 * @return boolean 	Wartoœæ logiczna odpowiadaj¹ca na pytanie czy pole jest aktualnie puste
 */
	public boolean anyFeed() {
		return !(feed==null);
	}
	
/**
 * Informuje czy na danym polu znajduje siê jakiekolwiek zwierzê
 * @return
 */
	public boolean anyAnimal() {
		return !animals.isEmpty();
	}


/**
 * Zwraca listê obiektów, które da siê zjeœæ, do listy zwierz¹t dokleja po¿ywienie, jeœli znajduje siê aktualnie na danym polu. Jeœli pole jest puste zwraca wartoœæ null
 * @return Lista obiektów daj¹cych siê zjeœæ
 */
	public List<IEatable> getEatable() {
		if(animals.isEmpty() && feed==null) {
			return null;
		}
		List<IEatable> eatable = new LinkedList<IEatable>();
		if(!animals.isEmpty() && feed!=null) {
			eatable.add((IEatable)animals);
			eatable.add((IEatable)feed);
		} else if(animals.isEmpty() && feed!=null) {
			eatable.add((IEatable)feed);
		} else if(!animals.isEmpty() && feed==null) {
			eatable.add((IEatable)animals);
		}
		return eatable;
	}
	
/**
 * Metoda zwraca listê zwierz¹t znajdujacych siê na danym polu
 * @return Lista zwierz¹t
 */
	public List<IAnimal> getAnimals() {
		return animals;
	}
	
/**
 * Metoda ustawia zwierzê na danym polu
 * @param IAnimal ustawiane zwierzê
 */
	public void seatAnimal(IAnimal animal) {
		animals.add(animal);
	}

/**
 * Metoda rozpoznaje czy na danym polu znajduje siê aktualnie po¿ywienie i ewentualnie je usuwa
 * i w to miejsce wk³ada nowo wygenerowane po¿ywienie
 */
	public void putNewFeed() {
		if(feed != null) {
			feed.beDestroyed();
		}
		feed = new Feed();
		
	}

/**
 * Metoda usuwa dany obiekt z listy obietków zawartych w obiekcie klasy Field. Mo¿e to byæ obiekt typu Field lub IAnimal, które implementujê interfejs IEatable
 * @param eatable Obiekt do zniszczenia
 */
	public void destroyEatable(IEatable eatable) {
		if(feed==eatable) {
			feed = null;
		} else if(animals.contains(eatable)) {
			animals.remove(eatable);
		}
	}

/**
 * @return Wspó³rzêdne pola
 */
	public int [] getCoordinates() {
		int [] coordinates = {positionX,positionY};
		return coordinates;
	}
}