package Animal;
/**
 * 
 */

/**
 * @author jakub
 *
 */
public class Cow extends Animal {
	public static final int movementSpeed = 1;

	public Cow() {super();}
	
	public Cow(int hunger, int thirst, int age, boolean isMale){
		super(hunger, thirst, age, isMale);
	}

	public void eat(Object target) {}
	public boolean canEat(Object target) {return false;}
	public void multiply() {}
}
