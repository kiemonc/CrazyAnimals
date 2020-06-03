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
public class SheepTest {
	@Test
	public void eating() {
		Random random = new Random(1);
		IAnimal sheep = new Sheep(0, 0, 0, false, new Field(0, 0, new Random()), new Random());
		IEatable mouse = new Mouse(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				cat = new Cat(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				cow = new Cow(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				sheep2 = new Sheep(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				wolf = new Wolf(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				grass = new Feed(random), cheese = new Feed(random);
		assertFalse("Cant eat mouse", sheep.canEat(mouse));
		assertFalse("Cant eat cat", sheep.canEat(cat));
		assertFalse("Cant eat cow", sheep.canEat(cow));
		assertFalse("Cant eat sheep", sheep.canEat(sheep2));
		assertFalse("Cant eat wolf", sheep.canEat(wolf));
		assertFalse("Cant eat cheese", sheep.canEat(cheese));
		assertTrue("Can eat grass", sheep.canEat(grass));
	}
	@Test
	public void multiplying() {
		IAnimal sheepMale = new Sheep(0, 0, 0, true, new Field(0, 0, new Random()), new Random()),
				sheepFemale = new Sheep(0, 0, 0, false, new Field(0, 0, new Random()), new Random());
		IAnimal [] animals = new IAnimal[10];
		for(int i = 0; i < 2; i++) {
			animals[5 * i] = new Cat(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
			animals[5 * i + 1] = new Cow(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
			animals[5 * i + 2] = new Mouse(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
			animals[5 * i + 3] = new Sheep(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
			animals[5 * i + 4] = new Wolf(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
		}
		for(int i = 0; i < 5; i++) {
			assertFalse("Male cant multiply with male", sheepMale.canMultiply(animals[i]));
			assertFalse("Female cant multiply with female", sheepFemale.canMultiply(animals[5 + i]));
			if(i == 3) {
				assertTrue("Male can multiply with female", sheepMale.canMultiply(animals[5 + i]));
				assertTrue("Female can multiply with male", sheepFemale.canMultiply(animals[i]));
			}
			else {
				assertFalse("Cat cant multiply with other species", sheepMale.canMultiply(animals[5 + i]));
				assertFalse("Cat cant multiply with other species", sheepFemale.canMultiply(animals[i]));
			}
		}
	}
	@Test
	public void multiplying2() {
		IAnimal sheep = new Sheep(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				sheep2 = new Sheep(0, 0, 0, true, new Field(0, 0, new Random()), new Random());
		if(sheep.canMultiply(sheep2)) {
			sheep.multiply();
			sheep2.multiply();
		}
		assertTrue("Child created", sheep.hasChild() instanceof Sheep);
		assertFalse("Moved after multiplying for female", sheep.getMovedAfterMultiplying());
		assertFalse("Moved after multiplying for male", sheep2.getMovedAfterMultiplying());
	}
	@Test
	public void toStringMethod() {
		IAnimal sheep = new Sheep(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				sheep2 = new Sheep(0, 0, 0, true, new Field(0, 0, new Random()), new Random());
		assertTrue("Female toString()", sheep.toString() == "s");
		assertTrue("Male toString()", sheep2.toString() == "S");
	}
}
