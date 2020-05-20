package Animal;

import java.util.Random;
import Area.IField;

/**
 * Klasa przechowuje wartoœæ prêdkoœci z jak¹ poruszaj¹ siê koty oraz operacje charakterystyczne dla tego gatunku.
 * Pozwala odró¿niæ koty od innych zwierz¹t
 * @author jakub
 */
public class Cat extends Animal {
	public static final int movementSpeed = 1;
	public static int maxPopulation = 0, currentPopulation = 0;
	/**
	 * Konstruktor tworzy kota, nadaje mu pocz¹tkowe parametry i umieszcza na podanym polu
	 * @param hunger pocz¹tkowy g³ód
	 * @param thirst pocz¹tkowe pragnienie
	 * @param age wiek
	 * @param isMale zmienna logiczna odpowiadaj¹ca na pytanie: czy zwierzê jest p³ci mêskiej?
	 * @param field pole na którym zostanie umieszczone zwierzê
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
