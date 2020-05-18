package Animal;
/**
 * 
 */

import java.util.Random;

import Area.IField;

/**
 * Klasa przechowuje wartoœæ prêdkoœci z jak¹ poruszaj¹ siê wilki oraz operacje charakterystyczne dla tego gatunku.
 * Pozwala odró¿niæ wilki od innych zwierz¹t
 * @author jakub
 */
public class Wolf extends Animal {
	public static final int movementSpeed = 1;
	public static int maxPopulation, currentPopulation;
	/**
	 * Konstruktor tworzy wilka, nadaje mu pocz¹tkowe parametry i umieszcza na podanym polu
	 * @param hunger pocz¹tkowy g³ód
	 * @param thirst pocz¹tkowe pragnienie
	 * @param age wiek
	 * @param isMale zmienna logiczna odpowiadaj¹ca na pytanie: czy zwierzê jest p³ci mêskiej?
	 * @param field pole na którym zostanie umieszczone zwierzê
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
}
