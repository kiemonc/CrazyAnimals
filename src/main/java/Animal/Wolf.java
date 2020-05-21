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
	public static final int movementSpeed = 1;
	public static int maxPopulation, currentPopulation;
	/**
	 * Konstruktor tworzy wilka, nadaje mu początkowe parametry i umieszcza na podanym polu
	 * @param hunger początkowy głód
	 * @param thirst początkowe pragnienie
	 * @param age wiek
	 * @param isMale zmienna logiczna odpowiadająca na pytanie: czy zwierzę jest płci męskiej?
	 * @param field pole na którym zostanie umieszczone zwierzę
	 */
	public Wolf(int hunger, int thirst, int age, boolean isMale, IField field){
		super(hunger, thirst, age, isMale, field);
		AnimalStats.addAnimal(4);
	}
	public boolean canEat(IEatable target) {
		Random rnd = new Random();
		if(target instanceof Mouse)     return true;
		else if(target instanceof Cat)  return (rnd.nextInt() % 10 < 8 ? true : false);//80%
		else if(target instanceof Sheep)return (rnd.nextInt() % 10 < 6 ? true : false);//60%
		else if(target instanceof Cow)  return (rnd.nextInt() % 10 < 4 ? true : false);//40%
		return false;
		}
	public void multiply() {
		Random random = new Random();
		this.field.seatAnimal(new Wolf(0, 0, 0, random.nextBoolean(), this.field));
	}
	public String toString() {
		return (this.isMale) ? "W" : "w";
	}
}
