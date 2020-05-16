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
	 * Sprawia, �e obiekt zostaje zjedzony przez zwierz�
	 * @param target - jedzony obiekt
	 */
	public void eat(IEatable target);
	/**
	 * Okre�la czy zwierz� mo�e zje�� dany obiekt
	 * @param target - sprawdzany obiekt
	 * @return true - mo�e, false - nie mo�e
	 */
	public boolean canEat(IEatable target);
	/**
	 * Pozwala zmieni� pozycj� zwierz�cia
	 * @param direction - kierunek ruchu
	 */
	public void moveTo(int direction);
	/**
	 * Tworzy nowe zwierz� z dw�ch zwierz�t przeciwnej p�ci
	 */
	public void multiply();
	/**
	 * Uzupe�nia pragnienie zwierz�cia
	 */
	public void drink();
	/**
	 * Odpowiada za usuwanie zwierz�cia z planszy po �mierci
	 */
	public void die();
	/**
	 * Zwi�ksza wiek zwierz�cia o 1
	 */
	public void getOlder();
	/**
	 * Okre�la czy zwierz� chce si� ruszy�
	 * @return true - chce, false - nie chce
	 */
	public boolean wantToMove();
}
