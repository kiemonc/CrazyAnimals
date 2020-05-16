package Animal;
/**
 * 
 */

/**
 * @author jakub
 *
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
	 * Pozwala zmieniæ pozycjê zwierzêcia
	 * @param direction - kierunek ruchu
	 */
	public void moveTo(int direction);
	/**
	 * Tworzy nowe zwierzê z dwóch zwierz¹t przeciwnej p³ci
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
	 * Okreœla czy zwierzê chce siê ruszyæ
	 * @return true - chce, false - nie chce
	 */
	public boolean wantToMove();
}
