package objectProgramming.crazyAnimals.animal;
/**
 * 
 */

import java.util.Random;

import objectProgramming.crazyAnimals.area.IField;

/**
 * Klasa przechowuje wartoĹ›Ä‡ prÄ™dkoĹ›ci z jakÄ… poruszajÄ… siÄ… wilki oraz operacje charakterystyczne dla tego gatunku.
 * Pozwala odrĂłĹĽniÄ‡ wilki od innych zwierzÄ…t
 * @author jakub
 */
public class Wolf extends Animal {
	static final int movementSpeed = 2;
	/**
	 * Konstruktor tworzy wilka, nadaje mu poczÄ…tkowe parametry i umieszcza na podanym polu
	 * @param hunger poczÄ…tkowy gĹ‚Ăłd
	 * @param thirst poczÄ…tkowe pragnienie
	 * @param age wiek
	 * @param isMale zmienna logiczna odpowiadajÄ…ca na pytanie: czy zwierzÄ™ jest pĹ‚ci mÄ™skiej?
	 * @param field pole na ktĂłrym zostanie umieszczone zwierzÄ™
	 * @param random referencja do zmiennej typu Random
	 */
	public Wolf(int hunger, int thirst, int age, boolean isMale, IField field, Random random){
		super(hunger, thirst, age, isMale, field, random);
		AnimalStats.addAnimal(4);
	}
	@Override
	public boolean canEat(IEatable target) {
		if(target instanceof Mouse)     return (random.nextInt() % 10 < 8 ? true : false);//80%
		else if(target instanceof Cat)  return (random.nextInt() % 10 < 6 ? true : false);//60%
		else if(target instanceof Sheep)return (random.nextInt() % 10 < 4 ? true : false);//40%
		else if(target instanceof Cow)  return (random.nextInt() % 10 < 2 ? true : false);//20%
		return false;
		}
	@Override
	public boolean canMultiply(IAnimal animal) {
		if(animal instanceof Wolf && animal.isMale() != isMale())
			return true;
		return false;
	}
	@Override
	public void multiply() {
		if(getMovedAfterMultiplying() && !isMale()) {
			child = new Wolf(0, 0, 0, random.nextBoolean(), field, random);
			child.setMovedAfterMultiplying(false);
		}
		setMovedAfterMultiplying(false);
	}
	@Override
	public int getMovementSpeed() {return movementSpeed;}
	@Override
	public String toString() {return (isMale()) ? "W" : "w";}
}
