package objectProgramming.crazyAnimals.main;

import java.util.Random;

import objectProgramming.crazyAnimals.swing.SimulationFrame;

public class TestMain {

	public static void main(String[] args) {
		Parameters parameters = new Parameters(new Random(0));
		parameters.initializeNumAnimals();
		try {
			parameters.setParametrs();
		} catch (BadParametersException e) {
			e.printStackTrace();
		}
		Simulation simulation = new Simulation(parameters, new Random(0));
		
		SimulationFrame frame = new SimulationFrame(simulation);
	}

}
