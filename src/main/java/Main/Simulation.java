package Main;

public final class Simulation {
	private double startTime;
	private int numIteration;
	private Area.Meadow meadow;
	private Animal.Animal[] animals;
	private Parameters parameters;
	
	public Simulation(Parameters parameters) {}
	public Simulation() {}
	private void setParameteres() {}
	private void initialMeadow() {}
	private void initialAnimals() {}
	
	public void mainLoop() {}
	private void doIteration() {}
	private boolean ifEnd() {return false;}

	private void updateMeadowState() {}
	private void updateAnimalsState() {}
	private void doInteractionsBetweenAnimals() {}
	
}
