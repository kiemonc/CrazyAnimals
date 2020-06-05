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
public class MouseTest {
	@Test
	public void eating() {
		Random random = new Random(1);
		IAnimal mouse = new Mouse(0, 0, 0, false, new Field(0, 0, new Random()), new Random());
		IEatable mouse2 = new Mouse(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				cat = new Cat(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				cow = new Cow(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				sheep = new Sheep(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				wolf = new Wolf(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				grass = new Feed(random), cheese = new Feed(random);
		assertFalse("Cant eat mouse", mouse.canEat(mouse2));
		assertFalse("Cant eat cat", mouse.canEat(cat));
		assertFalse("Cant eat cow", mouse.canEat(cow));
		assertFalse("Cant eat sheep", mouse.canEat(sheep));
		assertFalse("Cant eat wolf", mouse.canEat(wolf));
		assertTrue("Can eat cheese", mouse.canEat(cheese));
		assertFalse("Cant eat grass", mouse.canEat(grass));
	}
	@Test
	public void multiplying() {
		IAnimal mouseMale = new Mouse(0, 0, 0, true, new Field(0, 0, new Random()), new Random()),
				mouseFemale = new Mouse(0, 0, 0, false, new Field(0, 0, new Random()), new Random());
		IAnimal [] animals = new IAnimal[10];
		for(int i = 0; i < 2; i++) {
			animals[5 * i] = new Cat(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
			animals[5 * i + 1] = new Cow(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
			animals[5 * i + 2] = new Mouse(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
			animals[5 * i + 3] = new Sheep(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
			animals[5 * i + 4] = new Wolf(0, 0, 0, (i == 0 ? true : false), new Field(0, 0, new Random()), new Random());
		}
		for(int i = 0; i < 5; i++) {
			assertFalse("Male cant multiply with male", mouseMale.canMultiply(animals[i]));
			assertFalse("Female cant multiply with female", mouseFemale.canMultiply(animals[5 + i]));
			if(i == 2) {
				assertTrue("Male can multiply with female", mouseMale.canMultiply(animals[5 + i]));
				assertTrue("Female can multiply with male", mouseFemale.canMultiply(animals[i]));
			}
			else {
				assertFalse("Cat cant multiply with other species", mouseMale.canMultiply(animals[5 + i]));
				assertFalse("Cat cant multiply with other species", mouseFemale.canMultiply(animals[i]));
			}
		}
	}
	@Test
	public void multiplying2() {
		IAnimal mouse = new Mouse(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				mouse2 = new Mouse(0, 0, 0, true, new Field(0, 0, new Random()), new Random());
		if(mouse.canMultiply(mouse2)) {
			mouse.multiply();
			mouse2.multiply();
		}
		assertTrue("Child created", mouse.hasChild() instanceof Mouse);
		assertFalse("Moved after multiplying for female", mouse.getMovedAfterMultiplying());
		assertFalse("Moved after multiplying for male", mouse2.getMovedAfterMultiplying());
	}
	@Test
	public void toStringMethod() {
		IAnimal mouse = new Mouse(0, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				mouse2 = new Mouse(0, 0, 0, true, new Field(0, 0, new Random()), new Random());
		assertTrue("Female toString()", mouse.toString() == "m");
		assertTrue("Male toString()", mouse2.toString() == "M");
	}
}
