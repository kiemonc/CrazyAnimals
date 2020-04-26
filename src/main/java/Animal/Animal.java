/**
 * 
 */
package Animal;

/**
 * @author jakub
 *
 */
public abstract class Animal{
	
	private int hunger, thirst, age;
	private static double movementSpeed;
	private boolean isMale;
	
	public Animal() {
		this(0, 0, 0, true);
	}
	
	public Animal(int hunger, int thirst, int age, boolean isMale) {
		this.hunger = hunger;
		this.thirst = thirst;
		this.age = age;
		this.isMale = isMale;
	}
}
