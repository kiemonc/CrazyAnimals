package Animal;
/**
 * 
 */

/**
 * Interfejs przechowujący operacje klasy Animal
 * @author jakub
 */
public interface IAnimal {
	/**
	 * Sprawia, że obiekt zostaje zjedzony przez zwierzę
	 * @param target - jedzony obiekt
	 */
	public void eat(IEatable target);
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
	 * Zwiększa wiek zwierzęcia o 1
	 */
	public void getOlder();
	/**
	 * Wykonuje iterację, tzn. zwiększa głód oraz pragnienie i zmniejsza ilość iteracji do wykonania ruchu
	 */
	public void doIteration();
	/**
	 * Określa czy zwierzę chce się ruszyć
	 * @return true - chce, false - nie chce
	 */
	public boolean wantToMove();
	/**
	 * Pozwala wyświetlić zwierzę jako znak
	 * @return ciąg znaków, który zawiera jeden znak - reprezentację zwierzęcia
	 */
	@Override
	public String toString();
}
