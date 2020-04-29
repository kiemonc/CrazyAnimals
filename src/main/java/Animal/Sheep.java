package Animal;
/**
 * 
 */

/**
 * @author jakub
 *
 */
public class Sheep extends Animal {
	public static final int movementSpeed = 1;

	public Sheep() {super();}
	
	public Sheep(int hunger, int thirst, int age, boolean isMale){
		super(hunger, thirst, age, isMale);
	}

	public void eat(IEatable target) {}
	public boolean canEat(IEatable target) {return false;}
	public void multiply() {}
}
