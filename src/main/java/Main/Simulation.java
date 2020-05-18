package Main;

import java.util.List;
import java.util.LinkedList;

/**
 * @author Miko�aj
 * Klasa odpowiada za przebieg symulacji. W niej znajduje si� g��wna p�tla symulacji. Koordynuje dzia�ania zwierz�t i wymusza mi�dzy nimi interakcje, takie jak rozmna�anie si�, zaspokojenie pragnienia czy g�odu. 
 * Generuje zwierz�ta i daje sygna� klasie Meadow do inicjalizacji.
 * Wy�wietla aktualny stan symulacji.
 * Odpowiada za sprawdzanie warunk�w ko�ca symulacji.
 */

public final class Simulation {
	private double startTime;
	private Parameters parameters;
	private int numIteration;
	private Area.Meadow meadow;
	private List<Animal.IAnimal> animals;
	
	public Simulation(Parameters parameters) {
		this.parameters = parameters;
		meadow = new Area.Meadow(parameters.meadowWidth, parameters.meadowHeight, parameters.numWaterholes, parameters.meadowHeight*parameters.meadowWidth/10);
		
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
			animal.move();
		}
		for(Animal.IAnimal animal: animals) {
			animal.doIteration();
		}
	}

/**
 * Wy�wietla aktualny stan sumlacji w przyjaznej dla u�ytkownika formie
 */
	private void showCurrentState() {}
	
/**
 * Sprawdza czy zosta�y spe�nione warunki ko�ca symulacji
 * Warto�ci ko�cowe symulacji s� akceptowalne. Przekroczenie tego zakresu zatrzymuje symulacje
 * @return Warto�� logiczna odpowiadaj�ca na pytanie czy nast�pi� koniec symulacji
 */
	private boolean ifEnd() {
		for(int i = 0; i < 5; i++) {
			if(Animal.Animal.population[i] < parameters.endMinNum[i] || Animal.Animal.population[i] > parameters.endMaxNum[i]) {
				return true;
			}
		}
		return false;
	}

	
}