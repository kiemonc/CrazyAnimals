package Animal;
/**
 * 
 */

/**
 * @author jakub
 *
 */
public class Mouse extends Animal {
	public static final int movementSpeed = 1;

	public Mouse() {super();}
	
	public Mouse(int hunger, int thirst, int age, boolean isMale){
		super(hunger, thirst, age, isMale);
	}

	public void eat(String target) {}
	public void canEat(String target) {}
	public void multiply() {}
}
