package Main;

import java.util.List;
import java.util.LinkedList;
import java.util.Random;


/**
 * @author Mikołaj
 * Klasa odpowiada za przebieg symulacji. W niej znajduje się główna pętla symulacji. Koordynuje działania zwierząt i wymusza między nimi interakcje, takie jak rozmnażanie się, zaspokojenie pragnienia czy głodu. 
 * Generuje zwierzęta i daje sygnał klasie Meadow do inicjalizacji.
 * Wyświetla aktualny stan symulacji.
 * Odpowiada za sprawdzanie warunków końca symulacji.
 */

public final class Simulation {
	private double startTime;
	private Parameters parameters;
	private int numIteration;
	private Area.Meadow meadow;
	private Animal.IAnimalCreator animalCreator;
	private List<Animal.IAnimal> animals;
	private Random random;
	
	public Simulation(Parameters parameters, Random random) {
		this.parameters = parameters;
		this.random = random;
		meadow = new Area.Meadow(parameters.meadowWidth, parameters.meadowHeight, parameters.numWaterholes, parameters.meadowHeight*parameters.meadowWidth/10, random);
		animalCreator = new Animal.AnimalCreator();
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
		for(Animal.IAnimal animal: animals) {
			if(animal.isDead()) {
				animals.remove(animal);
				break;
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
		LinkedList<Animal.IAnimal> children = new LinkedList<Animal.IAnimal>();
		for(Animal.IAnimal animal: animals) {
			animal.doIteration();
			Animal.IAnimal child = animal.hasChild();
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
			if(Animal.AnimalStats.getCurrentPopulation()[i] < parameters.endMinNum[i] || (parameters.endMaxNum[i]!= -1 && Animal.AnimalStats.getCurrentPopulation()[i] > parameters.endMaxNum[i])) {
				return true;
			}
		}
		return false;
	}

	
}
