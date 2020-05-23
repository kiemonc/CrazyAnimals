/**
 * 
 */
package Main;

import java.util.Random;

/**
 * @author Mikołaj
 * Klasa odpowiada za startowanie i konczenie symulacji. Przechowuje ścieżkę do pliku wyjściowego statystyk.  Klasa generuje i zapisuje statystyki po zakończeniu symualcji.
 */
public final class Control {
	
	/**
	 * Referencja do obiektu random, umożliwiająca ustwienie wartości seed, która determinuje całą symulacje.
	 */
	private static Random random = new Random(0);
	private static Simulation simulation;

	//private static String statisticsPath;
	private static Parameters parameters;
	
	
	//private static void startSimulation() {}
	//private static void showStatistics() {}
	//private static void saveStatistics() {}
	//private static void setParamiters() {}


	
/** 
 * Metoda startująca cały program
 * @param args - Nie używane
 */
	public static void main(String[] args) {
		try {
		parameters = new Parameters(random);
		} catch (BadParametersException e) {
			return;
		}
		simulation = new Simulation(parameters, random);
		
		simulation.runSimulation();

	}

}
