package Area;

import Animal.IEatable;
import Animal.IAnimal;
import java.util.List;

public interface IField {
	public List<IEatable> getEatable();
	public void destroyEatable(IEatable eatable);
	public List<IAnimal> getAnimals();
	public void seatAnimal(IAnimal animal);
	public void putNewFeed();
	public int [] getCoordinates();
	public boolean anyFeed();
	public boolean anyAnimal();
}