package Animal;
/**
 * 
 */

import java.util.Random;

import Area.Feed;
import Area.IField;

/**
 * Klasa przechowuje wartość prędkości z jaką poruszają się krowy oraz operacje charakterystyczne dla tego gatunku.
 * Pozwala odróżnić krowy od innych zwierząt
 * @author jakub
 */
public class Cow extends Animal {
	private static final int movementSpeed = 1;
	/**
	 * Konstruktor tworzy krowę, nadaje jej początkowe parametry i umieszcza na podanym polu
	 * @param hunger początkowy głód
	 * @param thirst początkowe pragnienie
	 * @param age wiek
	 * @param isMale zmienna logiczna odpowiadająca na pytanie: czy zwierzą jest płci męskiej?
	 * @param field pole na którym zostanie umieszczone zwierzę
	 */
	public Cow(int hunger, int thirst, int age, boolean isMale, IField field, Random random){
		super(hunger, thirst, age, isMale, field, random);
		AnimalStats.addAnimal(1);
	}

	public boolean canEat(IEatable target) {
		if(target instanceof Feed)
			if(((Feed)target).getName() == "grass")
				return true;
		return false;
		}
	public boolean canMultiply(IAnimal animal) {
		if(animal instanceof Cow && animal.isMale() != isMale())
			return true;
		return false;
	}
	public void multiply() {
		child = new Cow(0, 0, 0, random.nextBoolean(), field, random);
		field.seatAnimal(child);
	}
	public int getMovementSpeed() {return movementSpeed;}
	@Override
	public String toString() {return (isMale()) ? "C" : "c";}
}
