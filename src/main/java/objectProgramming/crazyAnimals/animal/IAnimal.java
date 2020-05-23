package objectProgramming.crazyAnimals.animal;
/**
 * 
 */

/**
 * Interfejs przechowujący operacje klasy Animal
 * @author jakub
 */
public interface IAnimal extends IEatable{
	/**
	 * Określa czy zwierzę chce się ruszyć
	 * @return true - chce, false - nie chce
	 */
	public boolean wantToMove();
	/**
	 * Pozwala zmienić pozycję zwierzęcia na inną, losowo wybraną spośród pól sąsiednich do obecnego
	 * @param meadow - referencja do łąki
	 */
	public void move(objectProgramming.crazyAnimals.area.IMeadow meadow);
	/**
	 * Wykonuje iterację, tzn. zwiększa głód, pragnienie oraz wiek i zmniejsza ilość iteracji do wykonania ruchu
	 */
	public void doIteration();
	/**
	 * Jeżeli zwierzę posiada dziecko to metoda zwraca to dziecko i usuwa je ze swojej pamięci
	 * @return referencja do nowego zwierzęcia lub null
	 */
	public IAnimal hasChild();
	/**
	 * Określa płeć zwierzęcia
	 * @return true - męska, false - żeńska
	 */
	public boolean isMale();
	/**
	 * Określa czy zwierzę umarło czy nie
	 * @return true - umarło, false - żyje
	 */
	public boolean isDead();
	/**
	 * Pozwala ustawić wartość zmiennej movedAfterMultiplying
	 * @param value wartość przypisywana do tej zmiennej
	 */
	public void setMovedAfterMultiplying(boolean value);
	/**
	 * Pozwala pobrać wartość zmiennej movedAfterMultiplying
	 * @return wartość
	 */
	public boolean getMovedAfterMultiplying();
	
	/**
	 * Określa czy zwierzę może zjeść dany obiekt
	 * @param target - sprawdzany obiekt
	 * @return true - może, false - nie może
	 */
	public boolean canEat(IEatable target);
	/**
	 * Określa czy zwierze może się rozmnożyć z podanym zwierzęciem
	 * @param animal sprawdzane zwierzę
	 * @return true - może, false - nie może
	 */
	public boolean canMultiply(IAnimal animal);
	/**
	 * Tworzy nowe zwierzę z dwóch zwierząt przeciwnej płcic oraz tego samego gatunku i umieszcza je na łące
	 */
	public void multiply();
	/**
	 * Pozwala pobrać prędkość z jaką poruszają się zwierzęta (dokładnie mówiąc: ilość iteracji które muszą minąć aby zwierzę wykonało ruch)
	 * @return ilość iteracji
	 */
	public int getMovementSpeed();
	/**
	 * Pozwala wyświetlić zwierzę jako znak
	 * @return ciąg znaków, który zawiera jeden znak - reprezentację zwierzęcia
	 */
	@Override
	public String toString();
}
