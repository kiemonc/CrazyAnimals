package Animal;
/**
 * 
 */

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
	public Sheep(int hunger, int thirst, int age, boolean isMale, IField field, Random random){
		super(hunger, thirst, age, isMale, field, random);
		AnimalStats.addAnimal(3);
	}
	public boolean canEat(IEatable target) {
		if(target instanceof Feed)
			if(((Feed)target).getName() == "grass")
				return true;
		return false;
		}
	public boolean canMultiply(IAnimal animal) {
		if(animal instanceof Sheep && animal.isMale() != isMale())
			return true;
		return false;
	}
	public void multiply() {
		if(getMovedAfterMultiplying() && !isMale()) {
			child = new Sheep(0, 0, 0, random.nextBoolean(), field, random);
			child.setMovedAfterMultiplying(false);
		}
		setMovedAfterMultiplying(false);
	}
	public int getMovementSpeed() {return movementSpeed;}
	@Override
	public String toString() {return (isMale()) ? "S" : "s";}
}
