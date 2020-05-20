package Animal;
/**
 * 
 */

/**
 * Interfejs przechowuj¹cy operacje klasy Animal
 * @author jakub
 */
public interface IAnimal {
	/**
	 * Sprawia, ¿e obiekt zostaje zjedzony przez zwierzê
	 * @param target - jedzony obiekt
	 */
	public void eat(IEatable target);
	/**
	 * Okreœla czy zwierzê mo¿e zjeœæ dany obiekt
	 * @param target - sprawdzany obiekt
	 * @return true - mo¿e, false - nie mo¿e
	 */
	public boolean canEat(IEatable target);
	/**
	 * Pozwala zmieniæ pozycjê zwierzêcia na inn¹, losowo wybran¹ spoœród pól s¹siednich do obecnego
	 * @param direction - kierunek ruchu
	 */
	public void move(Area.IMeadow meadow);
	/**
	 * Tworzy nowe zwierzê z dwóch zwierz¹t przeciwnej p³cic oraz tego samego gatunku
	 */
	public void multiply();
	/**
	 * Uzupe³nia pragnienie zwierzêcia
	 */
	public void drink();
	/**
	 * Odpowiada za usuwanie zwierzêcia z planszy po œmierci
	 */
	public void die();
	/**
	 * Zwiêksza wiek zwierzêcia o 1
	 */
	public void getOlder();
	/**
	 * Wykonuje iteracjê, tzn. zwiêksza g³ód oraz pragnienie i zmniejsza iloœæ iteracji do wykonania ruchu
	 */
	public void doIteration();
	/**
	 * Okreœla czy zwierzê chce siê ruszyæ
	 * @return true - chce, false - nie chce
	 */
	public boolean wantToMove();
}
