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
		AnimalStats stats = new AnimalStats();
		assertTrue("0 stats at the begining", arraysEqual(stats.getStats(), new int[]{0, 0}));
		stats.addAnimal();
		assertTrue("One current, one max", arraysEqual(stats.getStats(), new int[]{1, 1}));
		stats.takeAnimal();
		assertTrue("Zero current, one max", arraysEqual(stats.getStats(), new int[]{0, 1}));
		stats.clearStats();
		assertTrue("0 after clear method", arraysEqual(stats.getStats(), new int[]{0, 1}));
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
