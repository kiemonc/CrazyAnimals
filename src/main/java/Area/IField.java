package Area;

import Animal.IEatable;
import Animal.IAnimal;
import java.util.List;

public interface IField {
	public boolean isEmpty();
	public List<IEatable> getEatable();
	public void destroy(IEatable eatable);
	public List<IAnimal> getAnimals();
	public void seatAnimal(IAnimal animal);
	public void putNewFeed();
	public int [] getCoordinates();
}
