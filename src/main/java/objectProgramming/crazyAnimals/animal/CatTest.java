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
public class CatTest {
	@Test
	public void eating() {
		Random random = new Random(1);
		IAnimal cat = new Cat(0, 0, 0, false, new Field(0, 0, new Random()), new Random());
		IEatable mouse = new Mouse(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				secondCat = new Cat(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				cow = new Cow(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				sheep = new Sheep(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				wolf = new Wolf(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				grass = new Feed(random), cheese = new Feed(random);
		assertTrue("Can eat mouse", cat.canEat(mouse));
		assertFalse("Cant eat cat", cat.canEat(secondCat));
		assertFalse("Cant eat cow", cat.canEat(cow));
		assertFalse("Cant eat sheep", cat.canEat(sheep));
		assertFalse("Cant eat wolf", cat.canEat(wolf));
		assertFalse("Cant eat cheese", cat.canEat(cheese));
		assertFalse("Cant eat grass", cat.canEat(grass));
	}
	@Test
	public void multiplying() {
		IAnimal catMale = new Cat(0, 0, 0, true, new Field(0, 0, new Random()), new Random()),
				catFemale = new Cat(0, 0, 0, false, new Field(0, 0, new Random()), new Random());
		IAnimal [] animals = new IAnimal[10];
		for(int i = 0; i < 2; i++) {
			animals[5 * i] = new Cat(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
			animals[5 * i + 1] = new Cow(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
			animals[5 * i + 2] = new Mouse(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
			animals[5 * i + 3] = new Sheep(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
			animals[5 * i + 4] = new Wolf(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
		}
		for(int i = 0; i < 5; i++) {
			assertFalse("Male cant multiply with male", catMale.canMultiply(animals[i]));
			assertFalse("Female cant multiply with female", catFemale.canMultiply(animals[5 + i]));
			if(i == 0) {
				assertTrue("Male can multiply with female", catMale.canMultiply(animals[5 + i]));
				assertTrue("Female can multiply with male", catFemale.canMultiply(animals[i]));
			}
			else {
				assertFalse("Cat cant multiply with other species", catMale.canMultiply(animals[5 + i]));
				assertFalse("Cat cant multiply with other species", catFemale.canMultiply(animals[i]));
			}
		}
	}
	@Test
	public void multiplying2() {
		IAnimal cat = new Cat(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				cat2 = new Cat(0, 0, 0, true, new Field(0, 0, new Random()), new Random());
		if(cat.canMultiply(cat2)) {
			cat.multiply();
			cat2.multiply();
		}
		assertTrue("Child created", cat.hasChild() instanceof Cat);
		assertFalse("Moved after multiplying for female", cat.getMovedAfterMultiplying());
		assertFalse("Moved after multiplying for male", cat2.getMovedAfterMultiplying());
	}
	@Test
	public void toStringMethod() {
		IAnimal cat = new Cat(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				cat2 = new Cat(0, 0, 0, true, new Field(0, 0, new Random()), new Random());
		assertTrue("Female toString()", cat.toString() == "k");
		assertTrue("Male toString()", cat2.toString() == "K");
	}
}
