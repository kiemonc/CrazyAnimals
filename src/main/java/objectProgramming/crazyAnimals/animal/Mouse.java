package objectProgramming.crazyAnimals.animal;
/**
 * 
 */

import java.util.Random;

import objectProgramming.crazyAnimals.area.Feed;
import objectProgramming.crazyAnimals.area.IField;

/**
 * Klasa przechowuje wartość prędkości z jaką poruszają się myszy oraz operacje charakterystyczne dla tego gatunku.
 * Pozwala odróżnić myszy od innych zwierząt
 * @author jakub
 */
public class Mouse extends Animal {
	private static final int movementSpeed = 1;
	/**
	 * Konstruktor tworzy mysz, nadaje jej początkowe parametry i umieszcza na podanym polu
	 * @param hunger początkowy głód
	 * @param thirst początkowe pragnienie
	 * @param age wiek
	 * @param isMale zmienna logiczna odpowiadająca na pytanie: czy zwierzę jest płci męskiej?
	 * @param field pole na którym zostanie umieszczone zwierzę
	 * @param random referencja do zmiennej typu Random
	 */
	public Mouse(int hunger, int thirst, int age, boolean isMale, IField field, Random random){
		super(hunger, thirst, age, isMale, field, random);
		AnimalStats.addAnimal(2);
	}
	public boolean canEat(IEatable target) {
		if(target instanceof Feed)
			if(((Feed)target).getName() == "cheese")
				return true;
		return false;
		}
	public boolean canMultiply(IAnimal animal) {
		if(animal instanceof Mouse && animal.isMale() != isMale())
			return true;
		return false;
	}
	public void multiply() {
		if(getMovedAfterMultiplying() && !isMale()) {
			child = new Mouse(0, 0, 0, random.nextBoolean(), field, random);
			child.setMovedAfterMultiplying(false);
		}
		setMovedAfterMultiplying(false);
	}
	public int getMovementSpeed() {return movementSpeed;}
	@Override
	public String toString() {return (isMale()) ? "M" : "m";}
}
