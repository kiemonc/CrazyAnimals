/**
 * 
 */
package objectProgramming.crazyAnimals.main;

import java.util.Random;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.JCommander.Builder;

import objectProgramming.crazyAnimals.animal.AnimalStats;;

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
 * Parametry symulacji ustawiamy w klasie Parameters.
 * W opisie klasy Parameters znajdują się warunki, które powinny spełniać parametry początkowe.
 * W przypadku gdy wprowadzone parametry nie spełniają określonych tam warunków, zostanie wurzycony wyjątek.
 * Symulację determinujemy zmianą wartości seed w konstruktorze powyższej zmiennej Random random
 * Aby uruchomić sumylacje z parametrami można skorzystać z parsowania argumentów tekstowych. 
 * Po wpisaniu "--help" wyświetla się instrukcja 
 * @param args - Nie używane
 */
	public static void main(String[] args) {
		parameters = new Parameters(random);
		
		JCommander commander = new Builder().addObject(parameters).build();
		commander.parse(args);
		
		if(parameters.help) {
			commander.usage();
			return;
		}
		try {
			parameters.setParametrs();
		} catch (BadParametersException e) {
			return;
		}
		simulation = new Simulation(parameters, random);
		new AnimalStats();
		simulation.runSimulation();

	}

}
