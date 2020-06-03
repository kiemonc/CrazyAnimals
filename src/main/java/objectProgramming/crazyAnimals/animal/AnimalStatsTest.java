/**
 * 
 */
package objectProgramming.crazyAnimals.animal;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author jakub
 *
 */
public class AnimalStatsTest {
	@Test
	public void test() {
		assertTrue("No animals at the begining", arraysEqual(AnimalStats.getCurrentPopulation(), new int[]{0, 0, 0, 0, 0}));
		assertTrue("Max population at the begining", arraysEqual(AnimalStats.getMaxPopulation(), new int[]{0, 0, 0, 0, 0}));
		AnimalStats.addAnimal(0);
		assertTrue("One cat", arraysEqual(AnimalStats.getCurrentPopulation(), new int[]{1, 0, 0, 0, 0}));
		AnimalStats.addAnimal(1);
		AnimalStats.takeAnimal(0);
		assertTrue("One cow", arraysEqual(AnimalStats.getCurrentPopulation(), new int[]{0, 1, 0, 0, 0}));
		AnimalStats.addAnimal(2);
		AnimalStats.takeAnimal(1);
		assertTrue("One mouse", arraysEqual(AnimalStats.getCurrentPopulation(), new int[]{0, 0, 1, 0, 0}));
		AnimalStats.addAnimal(3);
		AnimalStats.takeAnimal(2);
		assertTrue("One sheep", arraysEqual(AnimalStats.getCurrentPopulation(), new int[]{0, 0, 0, 1, 0}));
		AnimalStats.addAnimal(4);
		AnimalStats.takeAnimal(3);
		assertTrue("One wolf", arraysEqual(AnimalStats.getCurrentPopulation(), new int[]{0, 0, 0, 0, 1}));
		AnimalStats.takeAnimal(4);
		assertTrue("No animals at the end", arraysEqual(AnimalStats.getCurrentPopulation(), new int[]{0, 0, 0, 0, 0}));
		assertTrue("Max population at the end", arraysEqual(AnimalStats.getMaxPopulation(), new int[]{1, 1, 1, 1, 1}));
	} 
	/**
	 * Metoda porównuje dwie tablice liczb całkowitych
	 * @param array1 pierwsza tablica
	 * @param array2 druga tablica
	 * @return true - są sobie równe, false - nie są sobie równe
	 */
	public boolean arraysEqual(int[] array1, int[] array2) {
		if(array1.length != array2.length)
			return false;
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] != array2[i])
				return false;
		}
		return true;
	}
}
