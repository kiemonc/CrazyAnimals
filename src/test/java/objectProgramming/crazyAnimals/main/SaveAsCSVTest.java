package objectProgramming.crazyAnimals.main;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

import objectProgramming.crazyAnimals.animal.AnimalStats;
import objectProgramming.crazyAnimals.area.Feed;

public class SaveAsCSVTest {
	@Test
	public void test() {
		for(int i = 0; i < 100; i++) {
		Parameters parameters = new Parameters(new Random());
		try {
			parameters.initializeNumAnimals();
			parameters.setParametrs();
		} catch (BadParametersException e) {
			fail("BadParametersException");
		}
		parameters.path = "dataTest.csv";
		File file = new File(parameters.path);
		if(file.exists()) {
			file.delete();
			file = new File(parameters.path);
		}
		Feed.clearStatistics();
		new AnimalStats();
		try {
			SaveAsCSV.saveToFile(parameters);
		} catch (IOException e) {
			fail("IOException");
		}
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			assertTrue("First row", stringCompare(scanner.nextLine(), "date, meadow height, meadow width, number of waterholes, max iterations number, "
				+ "min cats on start, min cows on start, min mouses on start, min sheeps on start, min wolves on start, "
				+ "max cats on start, max cows on start, max mouses on start, max sheeps on start, max wolves on start, "
				+ "min cats at the end, min cows at the end, min mouses at the end, min sheeps at the end, min wolves at the end, "
				+ "max cats at the end, max cows at the end, max mouses at the end, max sheeps at the end, max wolves at the end, "
				+ "current number of cheese, max number of cheese, eaten cheese, destroyed cheese, "
				+ "current number of grass, max number of grass, eaten grass, destroyed grass, "
				+ "current population of cats, current population of cows, current population of mouses, current population of sheeps, current population of wolves, "
				+ "max population of cats, max population of cows, max population of mouses, max population of sheeps, max population of wolves"));
			assertTrue("Second row", stringCompare(scanner.nextLine().substring(21), "10, 10, 20, 100, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0"));
			assertTrue("No next rows", !scanner.hasNextLine());
			scanner.close();
		} catch (FileNotFoundException e) {
			fail("FileNotFoundException");
		}
		}
	}
	/**
	 * porównuje dwa ciągi znaków
	 * @param first pierwszy ciąg
	 * @param second drugi ciąg
	 * @return true - są takie same, false - nie są takie same
	 */
	private boolean stringCompare(String first, String second) {
		if(first.length() != second.length())
			return false;
		for(int i = 0; i < first.length(); i++)
			if(first.charAt(i) != second.charAt(i))
				return false;
		return true;
	}
}
