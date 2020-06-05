
package objectProgramming.crazyAnimals.main;

import java.util.Random;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.JCommander.Builder;

import objectProgramming.crazyAnimals.animal.AnimalStats;


import objectProgramming.crazyAnimals.swing.StartFrame;

import com.beust.jcommander.ParameterException;
import java.awt.EventQueue;

/**
 * 
 * Główna klasa projektu.
 * Klasa odpowiada za startowanie i konczenie symulacji. Przechowuje ścieżkę do pliku wyjściowego statystyk.  Klasa generuje i zapisuje statystyki po zakończeniu symualcji.
 * @author Mikołaj
 */
public final class Main {
	
	/**
	 * Referencja do obiektu random, umożliwiająca ustwienie wartości seed, która determinuje całą symulacje.
	 */
	private static Random random = new Random(100);
	private static Simulation simulation;
	static Parameters parameters;
	
/** 
 * Ustawia parametry symulacji z wykorzystaniem parasera.
 * Przechwytuje wyjątki błędnych parametrów.
 * @param args - argumenty tekstowe przekazane przez funkcję main, które je otrzymałą podczas uruchomienia aplikacji
 */
	static void setParameters(String [] args) {
		parameters = new Parameters(random);
		JCommander commander = new Builder().addObject(parameters).build();
		try {
			commander.parse(args);
		} catch (ParameterException e) {
			System.out.println("Wrong format of parameters");
			System.exit(-1);
		}
		if(parameters.help) {
			commander.usage();
			System.exit(-1);
		}
		try {
			parameters.initializeNumAnimals();
			parameters.setParametrs();
		} catch (BadParametersException e) {
			System.out.println("Parameters' conflict");
			System.exit(-1);
		}
	}
	
/** 
 * Metoda startująca cały program
 * Parametry symulacji ustawiamy w klasie Parameters.
 * W opisie klasy Parameters znajdują się warunki, które powinny spełniać parametry początkowe.
 * W przypadku gdy wprowadzone parametry nie spełniają określonych tam warunków, zostanie wurzycony wyjątek.
 * Symulację determinujemy zmianą wartości seed w konstruktorze powyższej zmiennej Random random
 * Aby uruchomić sumylacje z parametrami można skorzystać z parsowania argumentów tekstowych. 
 * Po wpisaniu "--help" wyświetla się instrukcja
 * Przykładowe parametry: "-h 10 -w 10 -i 20 -sMin 1,1,1,1,1 -sMax 5,5,5,5,5 -eMin -1,-1,-1,-1,-1 -eMax 10,10,10,10,10 -wh 15"
 * @param args - parametry startowe aplikacji
 */
	public static void main(String[] args) {
		setParameters(args);
		new AnimalStats();
		if(parameters.console) {
			runSimulation();
		} else {
 		EventQueue.invokeLater(new Runnable() {
 			@Override
 			public void run() {
 				new StartFrame();
 			}
 		});
		}
	}
	
	public static void runSimulation(Parameters parameters) {
		simulation = new Simulation(parameters, random);
		simulation.runSimulation();
	}
	
	public static void runSimulation() {
		runSimulation(parameters);
	}
}
