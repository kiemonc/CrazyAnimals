package Animal;
/**
 * 
 */

import java.util.Random;

/**
 * @author jakub
 *
 */
public class Wolf extends Animal {
	public static final int movementSpeed = 1;
	public static int maxPopulation, currentPopulation;
	
	public Wolf() {super();}
	public Wolf(int hunger, int thirst, int age, boolean isMale){
		super(hunger, thirst, age, isMale);
	}
	
	public boolean canEat(IEatable target) {
		Random rnd = new Random();
		if(target instanceof Mouse)     return true;
		else if(target instanceof Cat)  return (rnd.nextInt() % 10 < 8 ? true : false);//80%
		else if(target instanceof Sheep)return (rnd.nextInt() % 10 < 6 ? true : false);//60%
		else if(target instanceof Cow)  return (rnd.nextInt() % 10 < 4 ? true : false);//40%
		return false;
		}
	public void multiply() {
		//Wolf child = AnimalCreator.createWolf();
	}
}
