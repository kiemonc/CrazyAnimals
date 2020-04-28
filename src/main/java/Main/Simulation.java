package Main;

/**
 * @author Mikołaj
 * Klasa odpowiada za przebieg symulacji. W niej znajduje się główna pętla symulacji. Koordynuje działania zwierząt i wymusza między nimi interakcje, takie jak rozmnażanie się, zaspokojenie pragnienia czy głodu. 
 * Generuje zwierzęta i daje sygnał klasie Meadow do inicjalizacji.
 * Wyświetla aktualny stan symulacji.
 * Odpowiada za sprawdzanie warunków końca symulacji.
 */

public final class Simulation {
	private double startTime;
	private int numIteration;
	private Area.Meadow meadow;
	private Animal.Animal[] animals;
	
	public Simulation(Parameters parameters) {}
	public Simulation() {}
	private void setParameteres() {}
	private void initialMeadow() {}
	private void initialAnimals() {}
	
	private void mainLoop() {}
	private void doIteration() {}
	private void showCurrentState() {}
	private boolean ifEnd() {return false;}

	private void updateMeadowState() {}
	private void updateAnimalsState() {}
	private void doInteractionsBetweenAnimals() {}
	
}
