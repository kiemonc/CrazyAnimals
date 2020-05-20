/**
 * 
 */
package Main;

/**
 * @author Mikołaj
 * Klasa odpowiada za startowanie i konczenie symulacji. Przechowuje ścieżkę do pliku wyjściowego statystyk.  Klasa generuje i zapisuje statystyki po zakończeniu symualcji.
 */
public final class Control {
	private static Simulation simulation;

	private static String statisticsPath;
	private static Parameters parameters;
	
	
	private static void startSimulation() {}
	private static void showStatistics() {}
	private static void saveStatistics() {}
	private static void setParamiters() {}


	
	
	public static void main(String[] args) {
		parameters = new Parameters();
		simulation = new Simulation(parameters);
		
		simulation.runSimulation();

	}

}
