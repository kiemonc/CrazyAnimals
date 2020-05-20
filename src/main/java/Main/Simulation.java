package Main;

import java.util.List;
import java.util.LinkedList;

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
	
	public Simulation(Parameters parameters) {
		this.parameters = parameters;
		meadow = new Area.Meadow(parameters.meadowWidth, parameters.meadowHeight, parameters.numWaterholes, parameters.meadowHeight*parameters.meadowWidth/10);
		animalCreator = new Animal.AnimalCreator();
		animals = animalCreator.createAnimals(parameters.startNum[0], parameters.startNum[1], parameters.startNum[2], parameters.startNum[3], parameters.startNum[4], meadow);
		numIteration = 0;
	}
	
/**
 * Startuje i konczy sumylacje	
 */
	public void runSimulation() {
		while(!ifEnd()) {
			numIteration++;
			mainLoop();
		}
	}
	private void mainLoop() {
		meadow.doIteration();
		for(Animal.IAnimal animal: animals) {
			if(animal.wantToMove()) {
				animal.move(meadow);
			}
		}
		for(Animal.IAnimal animal: animals) {
			animal.doIteration();
		}
	}

/**
 * Wyświetla aktualny stan sumlacji w przyjaznej dla użytkownika formie
 */
	private void showCurrentState() {}
	
/**
 * Sprawdza czy zostały spełnione warunki końca symulacji
 * Wartości końcowe symulacji są akceptowalne. Przekroczenie tego zakresu zatrzymuje symulacje
 * @return Wartość logiczna odpowiadająca na pytanie czy nastąpił koniec symulacji
 */
	private boolean ifEnd() {
		for(int i = 0; i < 5; i++) {
			if(Animal.AnimalStats.getCurrentPopulation()[i] < parameters.endMinNum[i] || Animal.AnimalStats.getCurrentPopulation()[i] > parameters.endMaxNum[i]) {
				return true;
			}
		}
		return false;
	}

	
}
