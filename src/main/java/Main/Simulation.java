package Main;

import java.util.List;
import java.util.LinkedList;

/**
 * @author Miko³aj
 * Klasa odpowiada za przebieg symulacji. W niej znajduje siê g³ówna pêtla symulacji. Koordynuje dzia³ania zwierz¹t i wymusza miêdzy nimi interakcje, takie jak rozmna¿anie siê, zaspokojenie pragnienia czy g³odu. 
 * Generuje zwierzêta i daje sygna³ klasie Meadow do inicjalizacji.
 * Wyœwietla aktualny stan symulacji.
 * Odpowiada za sprawdzanie warunków koñca symulacji.
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
 * Wyœwietla aktualny stan sumlacji w przyjaznej dla u¿ytkownika formie
 */
	private void showCurrentState() {}
	
/**
 * Sprawdza czy zosta³y spe³nione warunki koñca symulacji
 * Wartoœci koñcowe symulacji s¹ akceptowalne. Przekroczenie tego zakresu zatrzymuje symulacje
 * @return Wartoœæ logiczna odpowiadaj¹ca na pytanie czy nast¹pi³ koniec symulacji
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