/**
 * 
 */
package objectProgramming.crazyAnimals.animal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import objectProgramming.crazyAnimals.area.Meadow;

/**
 * @author jakub
 *
 */
public class AnimalCreatorTest {
	@Test
	public void creationgAnimals(){
		Random random = new Random();
		IAnimalCreator creator = new AnimalCreator();
		List<IAnimal> animalsList = new LinkedList<>();
		animalsList = creator.createAnimals(1, 1, 1, 1, 1, new Meadow(5, 5, 5, 5, random), random);
		assertTrue("One cat created", animalsList.get(0) instanceof Cat);
		assertTrue("One cow created", animalsList.get(1) instanceof Cow);
		assertTrue("One mouse created", animalsList.get(2) instanceof Mouse);
		assertTrue("One sheep created", animalsList.get(3) instanceof Sheep);
		assertTrue("One wolf created", animalsList.get(4) instanceof Wolf);
		assertTrue("Size of created list", animalsList.size() == 5);
	}
	@Test 
	public void creatingCats() {
		Random random = new Random();
		IAnimalCreator creator = new AnimalCreator();
		List<IAnimal> animalsList = new LinkedList<>();
		animalsList = creator.createAnimals(5, 0, 0, 0, 0, new Meadow(5, 5, 5, 5, random), random);
		assertTrue("Size of created list", animalsList.size() == 5);
		for(int i = 0; i < animalsList.size(); i++) {
			assertTrue("Cat created", animalsList.get(i) instanceof Cat);
		}
	}
	@Test 
	public void creatingCows() {
		Random random = new Random();
		IAnimalCreator creator = new AnimalCreator();
		List<IAnimal> animalsList = new LinkedList<>();
		animalsList = creator.createAnimals(0, 6, 0, 0, 0, new Meadow(5, 5, 5, 5, random), random);
		assertTrue("Size of created list", animalsList.size() == 6);
		for(int i = 0; i < animalsList.size(); i++) {
			assertTrue("Cat created", animalsList.get(i) instanceof Cow);
		}
	}
	@Test 
	public void creatingMouses() {
		Random random = new Random();
		IAnimalCreator creator = new AnimalCreator();
		List<IAnimal> animalsList = new LinkedList<>();
		animalsList = creator.createAnimals(0, 0, 7, 0, 0, new Meadow(5, 5, 5, 5, random), random);
		assertTrue("Size of created list", animalsList.size() == 7);
		for(int i = 0; i < animalsList.size(); i++) {
			assertTrue("Cat created", animalsList.get(i) instanceof Mouse);
		}
	}
	@Test 
	public void creatingSheeps() {
		Random random = new Random();
		IAnimalCreator creator = new AnimalCreator();
		List<IAnimal> animalsList = new LinkedList<>();
		animalsList = creator.createAnimals(0, 0, 0, 20, 0, new Meadow(5, 5, 5, 5, random), random);
		assertTrue("Size of created list", animalsList.size() == 20);
		for(int i = 0; i < animalsList.size(); i++) {
			assertTrue("Cat created", animalsList.get(i) instanceof Sheep);
		}
	}
	@Test 
	public void creatingWolves() {
		Random random = new Random();
		IAnimalCreator creator = new AnimalCreator();
		List<IAnimal> animalsList = new LinkedList<>();
		animalsList = creator.createAnimals(0, 0, 0, 0, 1, new Meadow(5, 5, 5, 5, random), random);
		assertTrue("Size of created list", animalsList.size() == 1);
		for(int i = 0; i < animalsList.size(); i++) {
			assertTrue("Cat created", animalsList.get(i) instanceof Wolf);
		}
	}
	@Test
	public void noAnimalsCreated() {
		Random random = new Random();
		IAnimalCreator creator = new AnimalCreator();
		List<IAnimal> animalsList = new LinkedList<>();
		animalsList = creator.createAnimals(0, 0, 0, 0, 0, new Meadow(5, 5, 5, 5, random), random);
		assertTrue("No animal created", animalsList.size() == 0);
	}
	@Test
	public void manyAnimalsOnSmallMeadow() {
		Random random = new Random();
		IAnimalCreator creator = new AnimalCreator();
		List<IAnimal> animalsList = new LinkedList<>();
		animalsList = creator.createAnimals(10, 10, 10, 10, 10, new Meadow(5, 5, 5, 5, random), random);
		assertFalse("Animals not created", animalsList.size() == 50);
		assertTrue("Created as many animals as possible", animalsList.size() == 25);
		for(int i = 0; i < animalsList.size(); i++) {
			if(i < 10) assertTrue("Cats created", animalsList.get(i) instanceof Cat);
			else if(i < 20) assertTrue("Cows created", animalsList.get(i) instanceof Cow);
			else assertTrue("Mouses created", animalsList.get(i) instanceof Mouse);
		}
	}
}
