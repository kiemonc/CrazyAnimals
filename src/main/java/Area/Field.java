package Area;

import Animal.IAnimal;
import Animal.IEatable;
import java.util.List;
import java.util.LinkedList;

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
	

	public boolean anyFeed() {
		return !(feed==null);
	}
	

	public boolean anyAnimal() {
		return !animals.isEmpty();
	}



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
	

	public List<IAnimal> getAnimals() {
		return animals;
	}
	

	public void seatAnimal(IAnimal animal) {
		animals.add(animal);
	}


	public void putNewFeed() {
		if(feed != null) {
			feed.beDestroyed();
		}
		feed = new Feed();
		
	}


	public void destroyEatable(IEatable eatable) {
		if(feed==eatable) {
			feed = null;
		} else if(animals.contains(eatable)) {
			animals.remove(eatable);
		}
	}


	public int [] getCoordinates() {
		int [] coordinates = {positionX,positionY};
		return coordinates;
	}
	
	@Override
	public String toString() {
		String string = "";
		for(IAnimal animal : animals) {
			string += animal;
		}
		if(feed != null) {
			string += feed;
		}
		
		while(string.length() < 4) {
			string += " ";
		}
		return string;
	}
}