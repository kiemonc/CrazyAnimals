package Animal;
/**
 * 
 */

import java.util.Random;

import Area.IField;

/**
 * Klasa przechowuje wartość prędkości z jaką poruszają sią wilki oraz operacje charakterystyczne dla tego gatunku.
 * Pozwala odróżnić wilki od innych zwierząt
 * @author jakub
 */
public class Wolf extends Animal {
	private static final int movementSpeed = 1;
	/**
	 * Konstruktor tworzy wilka, nadaje mu początkowe parametry i umieszcza na podanym polu
	 * @param hunger początkowy głód
	 * @param thirst początkowe pragnienie
	 * @param age wiek
	 * @param isMale zmienna logiczna odpowiadająca na pytanie: czy zwierzę jest płci męskiej?
	 * @param field pole na którym zostanie umieszczone zwierzę
	 */
	public Wolf(int hunger, int thirst, int age, boolean isMale, IField field, Random random){
		super(hunger, thirst, age, isMale, field, random);
		AnimalStats.addAnimal(4);
	}
	public boolean canEat(IEatable target) {
		if(target instanceof Mouse)     return true;
		else if(target instanceof Cat)  return (random.nextInt() % 10 < 8 ? true : false);//80%
		else if(target instanceof Sheep)return (random.nextInt() % 10 < 6 ? true : false);//60%
		else if(target instanceof Cow)  return (random.nextInt() % 10 < 4 ? true : false);//40%
		return false;
		}
	public boolean canMultiply(IAnimal animal) {
		if(animal instanceof Wolf && animal.isMale() != isMale())
			return true;
		return false;
	}
	public void multiply() {
		child = new Wolf(0, 0, 0, random.nextBoolean(), field, random);
		field.seatAnimal(child);
	}
	public int getMovementSpeed() {return movementSpeed;}
	@Override
	public String toString() {return (isMale()) ? "W" : "w";}
}
