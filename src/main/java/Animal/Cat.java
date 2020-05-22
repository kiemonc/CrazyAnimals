package Animal;

import java.util.Random;

import Area.IField;

/**
 * Klasa przechowuje wartość prędkości z jaką poruszają się koty oraz operacje charakterystyczne dla tego gatunku.
 * Pozwala odróżnić koty od innych zwierząt
 * @author jakub
 */
public class Cat extends Animal {
	private static final int movementSpeed = 1;
	/**
	 * Konstruktor tworzy kota, nadaje mu początkowe parametry i umieszcza na podanym polu
	 * @param hunger początkowy głód
	 * @param thirst początkowe pragnienie
	 * @param age wiek
	 * @param isMale zmienna logiczna odpowiadająca na pytanie: czy zwierzę jest płci męskiej?
	 * @param field pole na którym zostanie umieszczone zwierzę
	 */
	public Cat(int hunger, int thirst, int age, boolean isMale, IField field, Random random){
		super(hunger, thirst, age, isMale, field, random);
		AnimalStats.addAnimal(0);
	}
	public boolean canEat(IEatable target) {
		if(target instanceof Mouse)
			return true;
		return false;
	}
	public boolean canMultiply(IAnimal animal) {
		if(animal instanceof Cat && animal.isMale() != isMale())
			return true;
		return false;
	}
	public void multiply() {
		if(getMovedAfterMultiplying() && !isMale()) {
			child = new Cat(0, 0, 0, random.nextBoolean(), field, random);
			child.setMovedAfterMultiplying(false);
		}
		setMovedAfterMultiplying(false);
	}
	public int getMovementSpeed() {return movementSpeed;}
	@Override
	public String toString() {return (isMale()) ? "K" : "k";}
}
