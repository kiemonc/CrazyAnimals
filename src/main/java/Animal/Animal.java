package Animal;
/**
 * 
 */

import Area.Field;

/**
 * @author jakub
 *
 */
public abstract class Animal implements IAnimal{
	
	protected int hunger, thirst, age, positionX, positionY, iterationsToMove;
	protected boolean isMale;
	
	public static int [] maxPopulation = new int[5], population = new int[5];
	
	public Animal() {
		this(0, 0, 0, true);
	}
	
	public Animal(int hunger, int thirst, int age, boolean isMale) {
		this.hunger = hunger;
		this.thirst = thirst;
		this.age = age;
		this.isMale = isMale;
	}
	public void moveTo(Field target) {
		
	}
	public void drink() {
		
	}
	public void die() {
		
	}
	public void getOlder() {
		
	}
	public boolean wantToMove() {
		
		return false;
	}
}
