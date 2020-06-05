package objectProgramming.crazyAnimals.main;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.JCommander.Builder;

import objectProgramming.crazyAnimals.animal.AnimalStats;

public class SimulationTest {

	@Test
	public void test() {
		Random random = new Random();
		Parameters parameters = new Parameters(random);
		JCommander commander = new Builder().addObject(parameters).build();
		commander.parse("-i", "10");
		try {
			parameters.setParametrs();
		} catch (BadParametersException e) {

		}
		Simulation simulation = new Simulation(parameters, random);
		simulation.runSimulation();
		assertTrue("Number of iterations", simulation.numIteration <= 10);
		
		
		parameters = new Parameters(random);
		commander = new Builder().addObject(parameters).build();
		commander.parse("-w", "9", "-h", "11", "-wh", "37");
		try {
			parameters.setParametrs();
			fail("Number of waterholes");
		} catch (BadParametersException e) {
		simulation = new Simulation(parameters,random);	
		}
		while(!simulation.ifEnd()) {
			simulation.meadow.doIteration();
			simulation.numIteration++;
			int length = AnimalStats.getCurrentPopulation().length; 
			int[] numAll = Arrays.copyOf(AnimalStats.getCurrentPopulation(), length);
			simulation.removeOrMoveAnimals();
			assertTrue("Removing animals", compareTables(numAll, AnimalStats.getCurrentPopulation())==-1 || compareTables(numAll, AnimalStats.getCurrentPopulation())==0);
			simulation.interactionsBetweenAnimals();
		}
	}
	
	/**
	 * Porównuje 2 tablice 
	 * @param table1 - pierwsza tablica
	 * @param table2 - druga tablica
	 * @return 0 - wszystkie równe elementy, 1 - jeśli każdy element 1 tablicy jest większy bądz równy od odpowiedniego elementu 2 talicy, -1 - jeśli każdy element 1 tablicy jest mniejszy bądz równy od odpowiedniego elementu 2 tablicy, null - różne elementy
	 */
	private int compareTables(int [] table1, int [] table2) {
		boolean smaller = true;
		boolean greater = true;
		for(int i = 0; i < 5; i++) {
			if(table1[i] > table2[i]) {
				smaller = false;
			}
			if(table1[i] < table2[i]) {
				greater = false;
			}
		}
		return greater && smaller ? 0 :greater ? 1 : smaller ? -1 : null;
	}

}
