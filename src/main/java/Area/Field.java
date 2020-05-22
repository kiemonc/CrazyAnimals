package Area;

import Animal.IAnimal;
import Animal.IEatable;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;

/**
 * 
 * Klasa, która przechowuje informacje o zawartości danego pola na łące. Przechowuje informację o tym czy na danym polu znajduje się pożywienie dla zwierząt oraz przechowuje to pożywienie.
 * @author Mikołaj
 */

public class Field implements IField{

	private List<IAnimal> animals;
	private Feed feed;
	private int positionX;
	private int positionY;
	private Random random;
	
	/**
	 * Konstruktor klasy Field tworzy pola, odpowiada za przypisanie współrzędnych oraz generacje listy zwierząt. Nie ma potrzeby tworzenia konstruktora domyślnego
	 * @param positionX 
	 * @param positionY
	 */
	Field(int positionX, int positionY, Random random) {
		this.random = random;
		this.positionX = positionX;
		this.positionY = positionY;
		animals = new LinkedList<IAnimal>();
	}
	
	@Override
	public boolean anyFeed() {
		return !(feed==null);
	}
	
	@Override
	public boolean anyAnimal() {
		return !animals.isEmpty();
	}


	@Override
	public List<IEatable> getEatable() {
		if(animals.isEmpty() && feed==null) {
			return null;
		}
		
		List<IEatable> eatable = new LinkedList<IEatable>();
		if(!animals.isEmpty() && feed!=null) {
			addAnimalsToList(eatable);
			eatable.add((IEatable)feed);
		} else if(animals.isEmpty() && feed!=null) {
			eatable.add((IEatable)feed);
		} else if(!animals.isEmpty() && feed==null) {
			addAnimalsToList(eatable);
		}
		return eatable;
	}
	
	private void addAnimalsToList(List<IEatable> list) {
		for(IAnimal animal : animals) {
			list.add((IEatable)animal);
		}
	}
	
	@Override
	public List<IAnimal> getAnimals() {
		return animals;
	}
	
	@Override
	public void seatAnimal(IAnimal animal) {
		animals.add(animal);
	}

	@Override
	public void putNewFeed() {
		if(feed != null) {
			feed.beDestroyed();
		}
		feed = new Feed(random);
		
	}

	@Override
	public void destroyEatable(IEatable eatable) {
		if(feed==eatable) {
			feed = null;
		} else if(animals.contains(eatable)) {
			animals.remove(eatable);
		}
	}

	@Override
	public int [] getCoordinates() {
		int [] coordinates = {positionX,positionY};
		return coordinates;
	}
	
/**
 * Przeciążona metodam, która konwertuje pole na ciąg znaków.
 * Ciąg znaków ma zawsze długość 4, pierwsze 3 znaki to znaki symbolizujące zwierzęta znajdujące się na danym polu.
 * Jeśli zwierząt na danym polu jest mniej niż 3 to reszta znaków przeznaczona na zwierzęta to spacje.
 * Ostatni znak to symbol pożywienia, które aktulanie znajduje się na danym polu.
 * @return 4 znakowy ciąg opisujący zwierzęta i pożywienie
 */
	@Override
	public String toString() {
		String string = "";
		for(IAnimal animal : animals) {
			string += animal;
		}
		while(string.length() < 3) {
			string += " ";
		}
		if(feed != null) {
			string += feed;
		} else {
			string += " ";
		}
		

		return string;
	}
}