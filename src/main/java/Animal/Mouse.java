package Animal;
/**
 * 
 */

import Area.Feed;

/**
 * @author jakub
 *
 */
public class Mouse extends Animal {
	public static final int movementSpeed = 1;
	public static int maxPopulation, currentPopulation;

	public Mouse() {super();}
	public Mouse(int hunger, int thirst, int age, boolean isMale){
		super(hunger, thirst, age, isMale);
	}
	
	public boolean canEat(IEatable target) {
		if(target instanceof Feed)
			if(((Feed)target).getName() == "cheese")
				return true;
		return false;
		}
	public void multiply() {
		//Mouse child = AnimalCreator.createMouse();
	}
}
