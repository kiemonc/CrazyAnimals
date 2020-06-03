/**
 * 
 */
package objectProgramming.crazyAnimals.animal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import org.junit.Test;

import objectProgramming.crazyAnimals.area.*;

/**
 * @author jakub
 *
 */
public class AnimalTest {
	@Test
	public void wantToMoveMethod() {
		IMeadow meadow = new Meadow(5, 5, 5, 5, new Random());
		IAnimal cat = new Cat(0, 0, 0, false, meadow.getRandomFields(1).get(0), new Random());
		
		assertTrue("Before iterations", cat.wantToMove());
		cat.move(meadow);
		for(int i = 1; i < Cat.movementSpeed; i++) {
			cat.doIteration();
			assertFalse(i + " iteration", cat.wantToMove());
		}
		cat.doIteration();
		assertTrue(Cat.movementSpeed + " iteration", cat.wantToMove());
	}
	@Test
	public void moveMethod() {
		Random random = new Random();
		IMeadow meadow = new Meadow(5, 5, 5, 5, random);
		IAnimalCreator creator = new AnimalCreator();
		List<IAnimal> animals = creator.createAnimals(0, 24, 0, 0, 0, meadow, random);
		IField field;
		do{
			field = meadow.getRandomFields(1).get(0);
		}while(field.anyAnimal());
		Animal cat = new Cat(0, 0, 0, false, field, random);
		
		cat.move(meadow);
		assertTrue("Cant move", cat.field == field);
	}
	@Test
	public void doIterationMethod() {
		Random random = new Random();
		IMeadow meadow = new Meadow(5, 5, 5, 5, random); 
		IField field = meadow.getRandomFields(1).get(0);
		IAnimal animal = new Cat(100, 0, 0, false, field, random);
		//hunger death
		assertFalse("Not dead because of hunger before iteration", animal.isDead());
		animal.doIteration();
		assertTrue("Dead because of hunger after iteration", animal.isDead());
		//thirst death
		animal = new Cat(0, 100, 0, false, field, random);
		assertFalse("Not dead because of thirst before iteration", animal.isDead());
		animal.doIteration();
		assertTrue("Dead because of thirst after iteration", animal.isDead());
		//age death
		animal = new Cat(0, 0, 100, false, field, random);
		assertFalse("Not dead because of age before iteration", animal.isDead());
		animal.doIteration();
		assertTrue("Dead because of age after iteration", animal.isDead());
		//eating
		field = meadow.getRandomFields(1).get(0);
		animal = new Cat(0, 0, 0, false, field, random);
		IAnimal animal2 = new Mouse(0, 0, 0, false, field, random);
		assertTrue("2 animals on field", field.getAnimals().size() == 2);
		animal.doIteration();
		assertTrue("1 animal on field after iteration", field.getAnimals().size() == 1 && field.getAnimals().get(0) == animal);
		//multiplying
		animal2 = new Cat(0, 0, 0, true, field, random);
		assertTrue("2 animals on field", field.getAnimals().size() == 2);
		animal.doIteration();
		assertTrue("3 animal on field after iteration", field.getAnimals().size() == 3);
	}
	@Test
	public void hasChildMethod() {
		Random random = new Random();
		Animal animal = new Cat(0, 0, 0, false, new Field(0, 0, random), random);
		assertTrue("Dont have child", animal.hasChild() == null);
		animal.multiply();
		assertTrue("Have child", animal.child == animal.hasChild());
	}
	@Test
	public void otherPublicMethods() {
		IAnimal femaleCat = new Cat(99, 0, 0, false, new Field(0, 0, new Random()), new Random()),
				maleCat = new Cat(0, 0, 0, true, new Field(0, 0, new Random()), new Random());
		
		//isMale
		assertFalse("isMale() method", femaleCat.isMale());
		assertTrue("isMale() method", maleCat.isMale());
		
		//isDead
		femaleCat.doIteration();
		maleCat.doIteration();
		assertFalse("isDead() method", femaleCat.isDead());
		assertFalse("isDead() method", maleCat.isDead());
		femaleCat.doIteration();
		assertTrue("isDead() method", femaleCat.isDead());
		
		//movedAfterMultiplying
		femaleCat.setMovedAfterMultiplying(false);
		maleCat.setMovedAfterMultiplying(true);
		assertFalse("MovedAfterMultiplyig false", femaleCat.getMovedAfterMultiplying());
		assertTrue("MovedAfterMultiplyig false", maleCat.getMovedAfterMultiplying());
		
		//beEaten
		femaleCat.beEaten();
		assertTrue("Eaten is dead", femaleCat.isDead());
	}
	@Test
	public void privateMethods() {
		Animal animal = new Cat(0, 0, 0, false, new Field(0, 0, new Random()), new Random());
		IEatable target = new Feed(new Random());
		animal.eat(target);
		
		//canMoveThere
		Random random = new Random();
		IField field = new Field(0, 0, random);
		assertTrue("Empty field", animal.canMoveThere(field));
		field.putNewFeed();
		assertTrue("Field with feed", animal.canMoveThere(field));
		field = new Field(0, 0, random);
		field.seatAnimal(new Cat(0, 0, 0, true, new Field(0, 0, random), random));
		assertTrue("Multipliable animal", animal.canMoveThere(field));
		field.seatAnimal(new Cow(0, 0, 0, false, new Field(0, 0, random), random));
		assertFalse("Other animal", animal.canMoveThere(field));
		field = new Field(0, 0, random);
		for(int i = 0; i < 2; i++)
			field.seatAnimal(new Cat(0, 0, 0, true, new Field(0, 0, random), random));
		assertFalse("Too many animals", animal.canMoveThere(field));
		
		//eat
		animal = new Cat(100, 0, 0, false, field, random);
		animal.eat(new Mouse(0, 0, 0, true, field, random));
		animal.doIteration();
		assertFalse("Hunger decreased after eating", animal.isDead());
		
		//drink
		animal = new Cat(0, 100, 0, false, field, random);
		animal.drink();
		animal.doIteration();
		assertFalse("Thirst decreased after drinking", animal.isDead());
	}
}
