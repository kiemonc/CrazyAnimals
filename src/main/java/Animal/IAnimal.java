package Animal;
/**
 * 
 */

/**
 * Interfejs przechowujący operacje klasy Animal
 * @author jakub
 */
public interface IAnimal extends IEatable{
	/**
	 * Sprawia, że obiekt zostaje zjedzony przez zwierzę
	 * @param target - jedzony obiekt
	 */
	public void eat(IEatable target);
	/**
	 * Określa płeć zwierzęcia
	 * @return true - męska, false - żeńska
	 */
	public boolean isMale();
	/**
	 * Określa czy zwierzę może zjeść dany obiekt
	 * @param target - sprawdzany obiekt
	 * @return true - może, false - nie może
	 */
	public boolean canEat(IEatable target);
	/**
	 * Pozwala zmienić pozycję zwierzęcia na inną, losowo wybraną spośród pól sąsiednich do obecnego
	 * @param meadow - referencja do łąki
	 */
	public void move(Area.IMeadow meadow);
	/**
	 * Pozwala stwierdzić czy zwierzę może ruszyć się na zadane pole
	 * @param field sprawdzane pole
	 * @return true - może się ruszyć, false - nie może się ruszyć
	 */
	public boolean canMoveThere(Area.IField field);
	/**
	 * Określa czy zwierze może się rozmnożyć z podanym zwierzęciem
	 * @param animal sprawdzane zwierzę
	 * @return true - może, false - nie może
	 */
	public boolean canMultiply(IAnimal animal);
	/**
	 * Tworzy nowe zwierzę z dwóch zwierząt przeciwnej płcic oraz tego samego gatunku
	 */
	public void multiply();
	/**
	 * Uzupełnia pragnienie zwierzęcia
	 */
	public void drink();
	/**
	 * Odpowiada za usuwanie zwierzęcia z planszy po śmierci
	 */
	public void die();
	/**
	 * Określa czy zwierzę umarło czy nie
	 * @return true - umarło, false - żyje
	 */
	public boolean isDead();
	/**
	 * Wykonuje iterację, tzn. zwiększa głód, pragnienie oraz wiek i zmniejsza ilość iteracji do wykonania ruchu
	 */
	public void doIteration();
	/**
	 * Określa czy zwierzę chce się ruszyć
	 * @return true - chce, false - nie chce
	 */
	public boolean wantToMove();
	/**
	 * Pozwala pobrać prędkość z jaką poruszają się zwierzęta (dokładnie mówiąc: ilość iteracji które muszą minąć aby zwierzę wykonało ruch)
	 * @return prędkość
	 */
	public int getMovementSpeed();
	/**
	 * Jeżeli zwierzę posiada dziecko to metoda zwraca to dziecko i usuwa je ze swojej pamięci
	 * @return referencja do nowego zwierzęcia lub null
	 */
	public IAnimal hasChild();
	/**
	 * Pozwala ustawić wartość zmiennej movedAfterMultiplying
	 * @param boolean wartość przypisywana do tej zmiennej
	 */
	public void setMovedAfterMultiplying(boolean value);
	/**
	 * Pozwala pobrać wartość zmiennej movedAfterMultiplying
	 * @return wartość
	 */
	public boolean getMovedAfterMultiplying();
	/**
	 * Pozwala wyświetlić zwierzę jako znak
	 * @return ciąg znaków, który zawiera jeden znak - reprezentację zwierzęcia
	 */
	@Override
	public String toString();
}
