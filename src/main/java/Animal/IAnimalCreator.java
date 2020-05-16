package Animal;

import java.util.List;

public interface IAnimalCreator {
	public List<Animal> createAnimals(int nrOfCats, int nrOfCows, int nrOfMouses, int nrOfSheeps, int nrOfWolves);
}
