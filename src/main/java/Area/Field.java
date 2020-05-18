package Area;

import Animal.IAnimal;
import Animal.IEatable;
import java.util.List;
import java.util.LinkedList;

/**
 * @author Mikołaj
 * Klasa, która przechowuje informacje o zawartości danego pola na łące. Przechowuje informację o tym czy na danym polu znajduje się pożywienie dla zwierząt oraz przechowuje to pożywienie.
 */

public class Field implements IField{

	private List<IAnimal> animals;
	private Feed feed;
	private int positionX;
	private int positionY;
	
/**
 * Konstruktor klasy Field tworzy pola, odpowiada za przypisanie współrzędnych oraz generacje listy zwierząt. Nie ma potrzeby tworzenia konstruktora domyślnego
 * @param positionX 
 * @param positionY
 */
	Field(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
		animals = new LinkedList<IAnimal>();
	}
	
/**
 * Metoda informuje czy dane pole jest aktualnie puste, tzn. czy znajdują się na nim jakieś zwierzęta lub jakieś pożywienie
 * @return boolean 	Wartość logiczna odpowiadająca na pytanie czy pole jest aktualnie puste
 */
	public boolean isEmpty() {
		if(animals.isEmpty() && feed==null) return true;
		else return false;
	}


/**
 * Metoda zwraca listę obiektów, które da się zjeść, do listy zwierząt dokleja pożywienie, jeśli znajduje się aktualnie na danym polu. Jeśli pole jest puste zwraca wartość null
 * @return Lista obiektów dających się zjeść
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
 * Metoda zwraca listę zwierząt znajdujacych się na danym polu
 * @return Lista zwierząt
 */
	public List<IAnimal> getAnimals() {
		return animals;
	}
	
/**
 * Metoda ustawia zwierzę na danym polu
 * @param IAnimal ustawiane zwierzę
 */
	public void seatAnimal(IAnimal animal) {
		animals.add(animal);
	}

/**
 * Metoda rozpoznaje czy na danym polu znajduje się aktualnie pożywienie i ewentualnie je usuwa
 * i w to miejsce wkłada nowo wygenerowane pożywienie
 */
	public void putNewFeed() {
		if(feed != null) {
			feed.beDestroyed();
		}
		feed = new Feed();
		
	}

/**
 * Metoda usuwa dany obiekt z listy obietków zawartych w obiekcie klasy Field. Może to być obiekt typu Field lub IAnimal, które implementuję interfejs IEatable
 * @param eatable Obiekt do zniszczenia
 */
	public void destroy(IEatable eatable) {
		if(feed==eatable) {
			feed = null;
		} else if(animals.contains(eatable)) {
			animals.remove(eatable);
		}
	}

/**
 * @return Współrzędne pola
 */
	public int [] getCoordinates() {
		int [] coordinates = {positionX,positionY};
		return coordinates;
	}
}