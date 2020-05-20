package Animal;
/**
 * 
 */

/**
 * Interfejs przechowuj�cy operacje klasy Animal
 * @author jakub
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
	 * Pozwala zmieni� pozycj� zwierz�cia na inn�, losowo wybran� spo�r�d p�l s�siednich do obecnego
	 * @param direction - kierunek ruchu
	 */
	public void move(Area.IMeadow meadow);
	/**
	 * Tworzy nowe zwierz� z dw�ch zwierz�t przeciwnej p�cic oraz tego samego gatunku
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
	 * Wykonuje iteracj�, tzn. zwi�ksza g��d oraz pragnienie i zmniejsza ilo�� iteracji do wykonania ruchu
	 */
	public void doIteration();
	/**
	 * Okre�la czy zwierz� chce si� ruszy�
	 * @return true - chce, false - nie chce
	 */
	public boolean wantToMove();
}
