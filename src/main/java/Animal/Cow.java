package Animal;
/**
 * 
 */

import Area.Feed;

/**
 * @author jakub
 *
 */
public class Cow extends Animal {
	public static final int movementSpeed = 1;
	public static int maxPopulation, currentPopulation;

	public Cow() {super();}
	public Cow(int hunger, int thirst, int age, boolean isMale){
		super(hunger, thirst, age, isMale);
	}

	public boolean canEat(IEatable target) {
		if(target instanceof Feed)
			if(((Feed)target).getName() == "grass")
				return true;
		return false;
		}
	public void multiply() {
		//Cow child = AnimalCreator.createCow();
	}
}
