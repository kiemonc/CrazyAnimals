package objectProgramming.crazyAnimals.main;

import java.util.List;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

import objectProgramming.crazyAnimals.animal.Animal;
import objectProgramming.crazyAnimals.animal.AnimalCreator;
import objectProgramming.crazyAnimals.animal.AnimalStats;
import objectProgramming.crazyAnimals.animal.IAnimal;
import objectProgramming.crazyAnimals.animal.IAnimalCreator;
import objectProgramming.crazyAnimals.area.Feed;
import objectProgramming.crazyAnimals.area.Meadow;


/**
 * 
 * Klasa odpowiada za przebieg symulacji. W niej znajduje się główna pętla symulacji. Koordynuje działania zwierząt i wymusza między nimi interakcje, takie jak rozmnażanie się, zaspokojenie pragnienia czy głodu. 
 * Generuje zwierzęta i daje sygnał klasie Meadow do inicjalizacji.
 * Wyświetla aktualny stan symulacji.
 * Odpowiada za sprawdzanie warunków końca symulacji.
 * @author Mikołaj
 */

public final class Simulation {
	//private double startTime;
	private Parameters parameters;
	int numIteration;
	Meadow meadow;
	private IAnimalCreator animalCreator;
	private List<IAnimal> animals;
	private String endMessage;
	private String[] animalNames = {"cats","cows","mice","sheep","wolfs"};
	
	/**
	 * Zeruje statystyki, tworzy łąke i wyzwala tworzenie zwierząt. Zeruje nr iteracji
	 * @param parameters - parametery początkowe
	 * @param random - referencja to zmiennej losowej
	 */
	public Simulation(Parameters parameters, Random random) {
		new AnimalStats();
		Feed.clearStatistics();
		Animal.clearAnimalNum();
		this.parameters = parameters;
		meadow = new Meadow(parameters.meadowWidth, parameters.meadowHeight, parameters.numWaterholes, parameters.meadowHeight*parameters.meadowWidth/10, random);
		animalCreator = new AnimalCreator();
		animals = animalCreator.createAnimals(parameters.startNum[0], parameters.startNum[1], parameters.startNum[2], parameters.startNum[3], parameters.startNum[4], meadow, random);
		numIteration = 0;
	}
	
/**
 * Startuje i kończy sumylacje. Używane tylko w przypadku wyświetlania w konsoli	
 */
	public void runSimulation() {
		
		showDescription();
		showCurrentState();
		while(!ifEnd()) {
			mainLoop();
		}
		showDescription();
		System.out.println(AnimalStats.getString());


		
		try{
			SaveAsCSV.saveToFile(parameters);
			System.out.println("Parameters saved at: " + parameters.path);
		}
		catch(IOException e) {
			System.out.println("Saving failed");
		}
		System.out.println("End of simulation");
		System.out.println("Reason: " + endMessage);
	}
	
/**
 * Zawiera wszystkie czynności wykonywane podczas jednej iteracji symualcji
 * Czyli pokazywanie łąki, iterację łąki, 
 */
	void mainLoop() {
		doIteration();
		showCurrentState();
		
	}
/**
 * Zawiera rutynowe metody neizbędne do przeprowadzanai symulacji.
 * Aktualizuje nr iteracji.
 * Przemiszczanie się i usuwanie zwierząt oraz interakcję pomiędzy zwierzętami
 */
	public void doIteration() {
		numIteration++;
		meadow.doIteration();
		removeOrMoveAnimals();
		interactionsBetweenAnimals();
	}
	
/**
 * Usuwa z listy zwierzęta, które już nie żyją
 */
	void removeOrMoveAnimals() {
		for(int i = 0; i < animals.size(); i++) {
			objectProgramming.crazyAnimals.animal.IAnimal animal = animals.get(i);
			if(animal.isDead()) {
				animals.remove(animal);
				i--;
				continue;
			}
			if(animal.wantToMove()) {
				animal.move(meadow);
			}
		}
	}
	
/**
 * Iteruje po liście zwierząt i każe im wykonywać między sobą interakcje
 * Dodaje do listy zwierząt nowo powstałe zwierzęta
 */
	void interactionsBetweenAnimals() {
		LinkedList<objectProgramming.crazyAnimals.animal.IAnimal> children = new LinkedList<objectProgramming.crazyAnimals.animal.IAnimal>();
		for(objectProgramming.crazyAnimals.animal.IAnimal animal: animals) {
			animal.doIteration();
			objectProgramming.crazyAnimals.animal.IAnimal child = animal.hasChild();
			if(child != null) children.add(child);
		}
		animals.addAll(children);
	}

/**
 * Wyświetla aktualny stan sumlacji w przyjaznej dla użytkownika formie
 */
	void showCurrentState() {
		if(parameters.console) {
			System.out.println(numIteration);
			System.out.println(meadow);
		} 
	}
	
/**
 * Sprawdza czy zostały spełnione warunki końca symulacji
 * Wartości końcowe symulacji są akceptowalne. Przekroczenie tego zakresu zatrzymuje symulacje
 * @return Wartość logiczna odpowiadająca na pytanie czy nastąpił koniec symulacji
 */
	public boolean ifEnd() {
		for(int i = 0; i < 5; i++) {
			if(objectProgramming.crazyAnimals.animal.AnimalStats.getCurrentPopulation()[i] < parameters.endMinNum[i]) {
				endMessage = "min number of " + animalNames[i];
				return true;
			} else if(parameters.endMaxNum[i]!= -1 && objectProgramming.crazyAnimals.animal.AnimalStats.getCurrentPopulation()[i] > parameters.endMaxNum[i]) {
				endMessage = "max number of " + animalNames[i];
				return true;
			}
		if(parameters.maxIterationNum <= numIteration) {
			endMessage = "max number of iterations";
			return true;
		}
		}
		return false;
	}
	
	
/**
 * Wypisuje w konsoli opis symboli obiektów znajduących się na planszy.
 */
	private void showDescription() {
		System.out.println("Feed: h - cheese, g - grass");
		System.out.println("Animals: capital letter - male, lower letter - female");
		System.out.println("K - cat, C - cow, M - mouse, S - sheep, W - wolf");
		System.out.println("/    / - waterhole");
		System.out.println(" /    \\    / - two neighbouring waterholes");
	}
	
	/**
	 * Zwraca wiadomość końcową opisująco powód zakończenia symulacji
	 * @return wiadomość końcowa
	 */
	public String getEndMessage() {
		return endMessage;
	}
	
	/**
	 * Zwraca referncje do aktualnie wykorzystywanej łaki
	 * @return referencja do łąki
	 */
	public Meadow getMeadow() {
		return meadow;
	}

	/**
	 * Zwraca numer iteracji
	 * @return numer iteracji
	 */
	public int getItertionNum() {
		return numIteration;
	}
	
}
