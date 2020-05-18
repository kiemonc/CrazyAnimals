/**
 * 
 */
package Main;

/**
 * @author Miko�aj
 * Klasa odpowiada za startowanie i konczenie symulacji. Przechowuje �cie�k� do pliku wyj�ciowego statystyk.  Klasa generuje i zapisuje statystyki po zako�czeniu symualcji.
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