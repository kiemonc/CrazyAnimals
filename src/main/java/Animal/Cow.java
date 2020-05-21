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
	public static final int movementSpeed = 1;
	public static int maxPopulation, currentPopulation;
	/**
	 * Konstruktor tworzy krowę, nadaje jej początkowe parametry i umieszcza na podanym polu
	 * @param hunger początkowy głód
	 * @param thirst początkowe pragnienie
	 * @param age wiek
	 * @param isMale zmienna logiczna odpowiadająca na pytanie: czy zwierzą jest płci męskiej?
	 * @param field pole na którym zostanie umieszczone zwierzę
	 */
	public Cow(int hunger, int thirst, int age, boolean isMale, IField field){
		super(hunger, thirst, age, isMale, field);
		AnimalStats.addAnimal(1);
	}

	public boolean canEat(IEatable target) {
		if(target instanceof Feed)
			if(((Feed)target).getName() == "grass")
				return true;
		return false;
		}
	public void multiply() {
		Random random = new Random();
		this.field.seatAnimal(new Cow(0, 0, 0, random.nextBoolean(), this.field));
	}
	public String toString() {
		return (this.isMale) ? "C" : "c";
	}
}
