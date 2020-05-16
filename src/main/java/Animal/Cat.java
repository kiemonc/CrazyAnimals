package Animal;

/**
 * 
 */

/**
 * @author jakub
 *
 */
public class Cat extends Animal {
	public static final int movementSpeed = 1;
	public static int maxPopulation, currentPopulation;
	
	public Cat() {super();}
	public Cat(int hunger, int thirst, int age, boolean isMale){
		super(hunger, thirst, age, isMale);
	}
	public boolean canEat(IEatable target) {
		if(target instanceof Mouse)
				return true;
		return false;
	}
	public void multiply() {
		//Cat child = AnimalCreator.createCat();
	}
}
