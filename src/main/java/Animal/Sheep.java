package Animal;
/**
 * 
 */

import java.util.List;
import java.util.Random;

import Area.Feed;
import Area.IField;

/**
 * Klasa przechowuje wartość prędkości z jaką poruszają się owce oraz operacje charakterystyczne dla tego gatunku.
 * Pozwala odróżnić owce od innych zwierząt
 * @author jakub
 */
public class Sheep extends Animal {
	private static final int movementSpeed = 1;
	/**
	 * Konstruktor tworzy owcę, nadaje jej początkowe parametry i umieszcza na podanym polu
	 * @param hunger początkowy głód
	 * @param thirst początkowe pragnienie
	 * @param age wiek
	 * @param isMale zmienna logiczna odpowiadająca na pytanie: czy zwierzę jest płci męskiej?
	 * @param field pole na którym zostanie umieszczone zwierzę
	 */
	public Sheep(int hunger, int thirst, int age, boolean isMale, IField field){
		super(hunger, thirst, age, isMale, field);
		AnimalStats.addAnimal(3);
	}
	public boolean canEat(IEatable target) {
		if(target instanceof Feed)
			if(((Feed)target).getName() == "grass")
				return true;
		return false;
		}
	public boolean canMoveThere(IField field) {
		if(field.anyAnimal())
		{
			List<IAnimal> animals = field.getAnimals();
			for(int i = 0; i < animals.size(); i++)
			{
				if(!(animals.get(i) instanceof Sheep && animals.get(i).isMale() != this.isMale))
					return false;
			}
		}
		return true;
	}
	public boolean canMultiply(IAnimal animal) {
		if(animal instanceof Sheep && animal.isMale() != this.isMale())
			return true;
		return false;
	}
	public void multiply() {
		Random random = new Random();
		this.field.seatAnimal(new Sheep(0, 0, 0, random.nextBoolean(), this.field));
	}
	public int getMovementSpeed() {return movementSpeed;}
	public String toString() {
		return (this.isMale) ? "S" : "s";
	}
}
