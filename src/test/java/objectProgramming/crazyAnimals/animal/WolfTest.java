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
public class WolfTest {
	@Test
	public void eating() {
		Random random = new Random(1);
		IAnimal wolf = new Wolf(0, 0, 0, false, new Field(0, 0, new Random()), new Random(3));
		IEatable mouse = new Mouse(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				cat = new Cat(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				cow = new Cow(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				sheep = new Sheep(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				wolf2 = new Wolf(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				grass = new Feed(random), cheese = new Feed(random);
		assertFalse("Cant eat wolf", wolf.canEat(wolf2));
		assertFalse("Cant eat cheese", wolf.canEat(cheese));
		assertFalse("Cant eat grass", wolf.canEat(grass));
		//dla seed = 3
		assertTrue("Can eat mouse", wolf.canEat(mouse));
		assertTrue("Can eat cat", wolf.canEat(cat));
		assertTrue("Can eat cow", wolf.canEat(cow));
		assertTrue("Can eat sheep", wolf.canEat(sheep));
	}
	@Test
	public void multiplying() {
		IAnimal wolfMale = new Wolf(0, 0, 0, true, new Field(0, 0, new Random()), new Random()),
				wolfFemale = new Wolf(0, 0, 0, false, new Field(0, 0, new Random()), new Random());
		IAnimal [] animals = new IAnimal[10];
		for(int i = 0; i < 2; i++) {
			animals[5 * i] = new Cat(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
			animals[5 * i + 1] = new Cow(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
			animals[5 * i + 2] = new Mouse(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
			animals[5 * i + 3] = new Sheep(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
			animals[5 * i + 4] = new Wolf(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
		}
		for(int i = 0; i < 5; i++) {
			assertFalse("Male cant multiply with male", wolfMale.canMultiply(animals[i]));
			assertFalse("Female cant multiply with female", wolfFemale.canMultiply(animals[5 + i]));
			if(i == 4) {
				assertTrue("Male can multiply with female", wolfMale.canMultiply(animals[5 + i]));
				assertTrue("Female can multiply with male", wolfFemale.canMultiply(animals[i]));
			}
			else {
				assertFalse("Cat cant multiply with other species", wolfMale.canMultiply(animals[5 + i]));
				assertFalse("Cat cant multiply with other species", wolfFemale.canMultiply(animals[i]));
			}
		}
	}
	@Test
	public void multiplying2() {
		IAnimal wolf = new Wolf(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				wolf2 = new Wolf(0, 0, 0, true, new Field(0, 0, new Random()), new Random());
		if(wolf.canMultiply(wolf2)) {
			wolf.multiply();
			wolf2.multiply();
		}
		assertTrue("Child created", wolf.hasChild() instanceof Wolf);
		assertFalse("Moved after multiplying for female", wolf.getMovedAfterMultiplying());
		assertFalse("Moved after multiplying for male", wolf2.getMovedAfterMultiplying());
	}
	@Test
	public void toStringMethod() {
		IAnimal wolf = new Wolf(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				wolf2 = new Wolf(0, 0, 0, true, new Field(0, 0, new Random()), new Random());
		assertTrue("Female toString()", wolf.toString() == "w");
		assertTrue("Male toString()", wolf2.toString() == "W");
	}
}
