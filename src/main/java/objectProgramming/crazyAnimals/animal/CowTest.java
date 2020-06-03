/**
 * 
 */
package objectProgramming.crazyAnimals.animal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import objectProgramming.crazyAnimals.area.Feed;
import objectProgramming.crazyAnimals.area.Field;

/**
 * @author jakub
 *
 */
public class CowTest {
	@Test
	public void eating() {
		Random random = new Random(1);
		IAnimal cow = new Cow(0, 0, 0, false, new Field(0, 0, new Random()), new Random());
		IEatable mouse = new Mouse(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				cat = new Cat(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				cow2 = new Cow(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				sheep = new Sheep(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				wolf = new Wolf(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				grass = new Feed(random), cheese = new Feed(random);
		assertFalse("Cant eat mouse", cow.canEat(mouse));
		assertFalse("Cant eat cat", cow.canEat(cat));
		assertFalse("Cant eat cow", cow.canEat(cow2));
		assertFalse("Cant eat sheep", cow.canEat(sheep));
		assertFalse("Cant eat wolf", cow.canEat(wolf));
		assertFalse("Cant eat cheese", cow.canEat(cheese));
		assertTrue("Can eat grass", cow.canEat(grass));
	}
	@Test
	public void multiplying() {
		IAnimal cowMale = new Cow(0, 0, 0, true, new Field(0, 0, new Random()), new Random()),
				cowFemale = new Cow(0, 0, 0, false, new Field(0, 0, new Random()), new Random());
		IAnimal [] animals = new IAnimal[10];
		for(int i = 0; i < 2; i++) {
			animals[5 * i] = new Cat(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
			animals[5 * i + 1] = new Cow(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
			animals[5 * i + 2] = new Mouse(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
			animals[5 * i + 3] = new Sheep(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
			animals[5 * i + 4] = new Wolf(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
		}
		for(int i = 0; i < 5; i++) {
			assertFalse("Male cant multiply with male", cowMale.canMultiply(animals[i]));
			assertFalse("Female cant multiply with female", cowFemale.canMultiply(animals[5 + i]));
			if(i == 1) {
				assertTrue("Male can multiply with female", cowMale.canMultiply(animals[5 + i]));
				assertTrue("Female can multiply with male", cowFemale.canMultiply(animals[i]));
			}
			else {
				assertFalse("Cat cant multiply with other species", cowMale.canMultiply(animals[5 + i]));
				assertFalse("Cat cant multiply with other species", cowFemale.canMultiply(animals[i]));
			}
		}
	}
	@Test
	public void multiplying2() {
		IAnimal cow = new Cow(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				cow2 = new Cow(0, 0, 0, true, new Field(0, 0, new Random()), new Random());
		if(cow.canMultiply(cow2)) {
			cow.multiply();
			cow2.multiply();
		}
		assertTrue("Child created", cow.hasChild() instanceof Cow);
		assertFalse("Moved after multiplying for female", cow.getMovedAfterMultiplying());
		assertFalse("Moved after multiplying for male", cow2.getMovedAfterMultiplying());
	}
	@Test
	public void toStringMethod() {
		IAnimal cow = new Cow(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				cow2 = new Cow(0, 0, 0, true, new Field(0, 0, new Random()), new Random());
		assertTrue("Female toString()", cow.toString() == "c");
		assertTrue("Male toString()", cow2.toString() == "C");
	}
}
