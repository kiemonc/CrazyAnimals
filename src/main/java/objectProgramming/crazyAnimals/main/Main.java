
package objectProgramming.crazyAnimals.main;

import java.util.Random;

import javax.swing.JOptionPane;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.JCommander.Builder;

import objectProgramming.crazyAnimals.animal.AnimalStats;
import objectProgramming.crazyAnimals.animal.Species;
import objectProgramming.crazyAnimals.swing.SimulationFrame;
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
	private static Random random = new Random();
	private static Simulation simulation;
	static Parameters parameters;
	static private StartFrame startFrame;
	
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
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Wrong format list of parameters");
			System.exit(-1);
		}
		if(parameters.help) {
			commander.usage();
			System.exit(-1);
		}
		try {
			try {
			parameters.initializeNumAnimals();
			}  catch (NumberFormatException e) {
				System.out.println("Wrong format of number in list");
				System.exit(-1);
			}
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
 * Po wpisaniu "-c" wyświetla się symulacja w konsoli
 * Po wpisaniu "-r" uruchamia się symulacja w GUI i odrazu startuje
 * Przykładowe parametry: "-h 10 -w 10 -i 20 -sMin 1,1,1,1,1 -sMax 5,5,5,5,5 -eMin -1,-1,-1,-1,-1 -eMax 10,10,10,10,10 -wh 15"
 * @param args - parametry startowe aplikacji
 */
	public static void main(String[] args) {
		setParameters(args);
		for(Species species : Species.values())
			species.clearStats();
		
		if(parameters.console) {
			try {
				parameters.setParametrs();
			} catch (BadParametersException e) {
				System.out.println("Bad parameters");
			}
			simulation = new Simulation(parameters, random);
			simulation.runSimulation();
		} else if(parameters.runAtStart) {
			runSimulation();
		} else {
			EventQueue.invokeLater(new Runnable() {
 			@Override
 			public void run() {
 				startFrame = new StartFrame(parameters);
 			}
 		});
		}
	}
	
	
/**
 * Używane podczas używanie GUI. Startuje sumalacje. Uruchamia główne okno symulacji.
 * @param parameters - parametry startu symulacji
 */
	public static void runSimulation(Parameters parameters) {
		try {
			parameters.setParametrs();
		} catch (BadParametersException e) {
			JOptionPane.showMessageDialog(startFrame, "Invalid parameters","Error", JOptionPane.ERROR_MESSAGE);
		}
		simulation = new Simulation(parameters, random);
 		EventQueue.invokeLater(new Runnable() {
 			@Override
 			public void run() {
 				new SimulationFrame(simulation, startFrame, parameters);
 			}
 		});
	}
	
/**
 * Uruchamia symulacje z domyślnemi argumentami lub sprarsowanymi.
 */
	public static void runSimulation() {
		runSimulation(parameters);
	}
}
