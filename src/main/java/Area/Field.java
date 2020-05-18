package Area;

import Animal.IAnimal;
import Animal.IEatable;
import java.util.List;
import java.util.LinkedList;

/**
 * @author Miko�aj
 * Klasa, kt�ra przechowuje informacje o zawarto�ci danego pola na ��ce. Przechowuje informacj� o tym czy na danym polu znajduje si� po�ywienie dla zwierz�t oraz przechowuje to po�ywienie.
 */

public class Field implements IField{

	private List<IAnimal> animals;
	private Feed feed;
	private int positionX;
	private int positionY;
	
/**
 * Konstruktor klasy Field tworzy pola, odpowiada za przypisanie wsp�rz�dnych oraz generacje listy zwierz�t. Nie ma potrzeby tworzenia konstruktora domy�lnego
 * @param positionX 
 * @param positionY
 */
	Field(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
		animals = new LinkedList<IAnimal>();
	}
	
/**
 * Informuje czy na danym polu znajduje si� jakiekolwiek po�ywienie
 * @return boolean 	Warto�� logiczna odpowiadaj�ca na pytanie czy pole jest aktualnie puste
 */
	public boolean anyFeed() {
		return !(feed==null);
	}
	
/**
 * Informuje czy na danym polu znajduje si� jakiekolwiek zwierz�
 * @return
 */
	public boolean anyAnimal() {
		return !animals.isEmpty();
	}


/**
 * Zwraca list� obiekt�w, kt�re da si� zje��, do listy zwierz�t dokleja po�ywienie, je�li znajduje si� aktualnie na danym polu. Je�li pole jest puste zwraca warto�� null
 * @return Lista obiekt�w daj�cych si� zje��
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
 * Metoda zwraca list� zwierz�t znajdujacych si� na danym polu
 * @return Lista zwierz�t
 */
	public List<IAnimal> getAnimals() {
		return animals;
	}
	
/**
 * Metoda ustawia zwierz� na danym polu
 * @param IAnimal ustawiane zwierz�
 */
	public void seatAnimal(IAnimal animal) {
		animals.add(animal);
	}

/**
 * Metoda rozpoznaje czy na danym polu znajduje si� aktualnie po�ywienie i ewentualnie je usuwa
 * i w to miejsce wk�ada nowo wygenerowane po�ywienie
 */
	public void putNewFeed() {
		if(feed != null) {
			feed.beDestroyed();
		}
		feed = new Feed();
		
	}

/**
 * Metoda usuwa dany obiekt z listy obietk�w zawartych w obiekcie klasy Field. Mo�e to by� obiekt typu Field lub IAnimal, kt�re implementuj� interfejs IEatable
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
 * @return Wsp�rz�dne pola
 */
	public int [] getCoordinates() {
		int [] coordinates = {positionX,positionY};
		return coordinates;
	}
}