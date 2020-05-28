package objectProgramming.crazyAnimals.main;

import java.util.List;
import java.util.LinkedList;
import java.util.Random;


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
	private int numIteration;
	private objectProgramming.crazyAnimals.area.Meadow meadow;
	private objectProgramming.crazyAnimals.animal.IAnimalCreator animalCreator;
	private List<objectProgramming.crazyAnimals.animal.IAnimal> animals;
	
	public Simulation(Parameters parameters, Random random) {
		this.parameters = parameters;
		meadow = new objectProgramming.crazyAnimals.area.Meadow(parameters.meadowWidth, parameters.meadowHeight, parameters.numWaterholes, parameters.meadowHeight*parameters.meadowWidth/10, random);
		animalCreator = new objectProgramming.crazyAnimals.animal.AnimalCreator();
		animals = animalCreator.createAnimals(parameters.startNum[0], parameters.startNum[1], parameters.startNum[2], parameters.startNum[3], parameters.startNum[4], meadow, random);
		numIteration = 0;
	}
	
/**
 * Startuje i kończy sumylacje	
 */
	public void runSimulation() {
		showCurrentState();
		while(!ifEnd()) {
			numIteration++;
			mainLoop();
		}

		System.out.println("Koniec symulacji");
	}
	
/**
 * Zawiera wszystkie czynności wykonywane podczas jednej iteracji symualcji
 * Czyli pokazywanie łąki, iterację łąki, przemiszczanie się i usuwanie zwierząt oraz interakcję pomiędzy zwierzętami
 */
	private void mainLoop() {
		meadow.doIteration();
		removeOrMoveAnimals();
		interactionsBetweenAnimals();
		System.out.println(numIteration);
		showCurrentState();
	}
	
/**
 * Usuwa z listy zwierzęta, które już nie żyją
 */
	private void removeOrMoveAnimals() {
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
	private void interactionsBetweenAnimals() {
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
	private void showCurrentState() {
		System.out.println(meadow);
	}
	
/**
 * Sprawdza czy zostały spełnione warunki końca symulacji
 * Wartości końcowe symulacji są akceptowalne. Przekroczenie tego zakresu zatrzymuje symulacje
 * @return Wartość logiczna odpowiadająca na pytanie czy nastąpił koniec symulacji
 */
	private boolean ifEnd() {
		for(int i = 0; i < 5; i++) {
			if(objectProgramming.crazyAnimals.animal.AnimalStats.getCurrentPopulation()[i] < parameters.endMinNum[i] || (parameters.endMaxNum[i]!= -1 && objectProgramming.crazyAnimals.animal.AnimalStats.getCurrentPopulation()[i] > parameters.endMaxNum[i])) {
				return true;
			}
		if(parameters.maxIterationNum <= numIteration) {
			return true;
		}
		}
		return false;
	}

	
}
