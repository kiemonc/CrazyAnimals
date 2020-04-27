package Animal;
/**
 * 
 */

/**
 * @author jakub
 *
 */
public class Wolf extends Animal {
	public static final int movementSpeed = 1;
	
	public Wolf() {super();}
	
	public Wolf(int hunger, int thirst, int age, boolean isMale){
		super(hunger, thirst, age, isMale);
	}

	public void eat(String target) {}
	public boolean canEat(String target) {return false;}
	public void multiply() {}
}
