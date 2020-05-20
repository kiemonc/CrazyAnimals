package Animal;

import java.util.Random;
import Area.IField;

/**
 * Klasa przechowuje wartość prędkości z jaką poruszają się koty oraz operacje charakterystyczne dla tego gatunku.
 * Pozwala odróżnić koty od innych zwierząt
 * @author jakub
 */
public class Cat extends Animal {
	public static final int movementSpeed = 1;
	public static int maxPopulation = 0, currentPopulation = 0;
	/**
	 * Konstruktor tworzy kota, nadaje mu pocz�tkowe parametry i umieszcza na podanym polu
	 * @param hunger początkowy głód
	 * @param thirst początkowe pragnienie
	 * @param age wiek
	 * @param isMale zmienna logiczna odpowiadająca na pytanie: czy zwierzę jest płci męskiej?
	 * @param field pole na którym zostanie umieszczone zwierzę
	 */
	public Cat(int hunger, int thirst, int age, boolean isMale, IField field){
		super(hunger, thirst, age, isMale, field);
		AnimalStats.addAnimal(0);
	}
	public boolean canEat(IEatable target) {
		if(target instanceof Mouse)
			return true;
		return false;
	}
	public void multiply() {
		Random random = new Random();
		this.field.seatAnimal(new Cat(0, 0, 0, random.nextBoolean(), this.field));
	}
}
