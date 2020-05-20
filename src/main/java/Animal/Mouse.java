package Animal;
/**
 * 
 */

import java.util.Random;

import Area.Feed;
import Area.IField;

/**
 * Klasa przechowuje wartość prędkości z jaką poruszają się myszy oraz operacje charakterystyczne dla tego gatunku.
 * Pozwala odróżnić myszy od innych zwierząt
 * @author jakub
 */
public class Mouse extends Animal {
	public static final int movementSpeed = 1;
	public static int maxPopulation, currentPopulation;
	/**
	 * Konstruktor tworzy mysz, nadaje jej pocz�tkowe parametry i umieszcza na podanym polu
	 * @param hunger początkowy głód
	 * @param thirst początkowe pragnienie
	 * @param age wiek
	 * @param isMale zmienna logiczna odpowiadająca na pytanie: czy zwierzę jest płci męskiej?
	 * @param field pole na którym zostanie umieszczone zwierzę
	 */
	public Mouse(int hunger, int thirst, int age, boolean isMale, IField field){
		super(hunger, thirst, age, isMale, field);
		AnimalStats.addAnimal(2);
	}
	
	public boolean canEat(IEatable target) {
		if(target instanceof Feed)
			if(((Feed)target).getName() == "cheese")
				return true;
		return false;
		}
	public void multiply() {
		Random random = new Random();
		this.field.seatAnimal(new Mouse(0, 0, 0, random.nextBoolean(), this.field));
	}
}
