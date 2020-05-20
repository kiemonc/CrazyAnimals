/**
 * 
 */
package Area;

/**
 * 
 * Klasa przechowuje informacje na temat ilości wodopojów na łące. Powoduje, że pole, które jest wodopojem, jest rozróżnialne ze zwykłym polem.
 * @author Mikołaj
 */
public final class Waterhole extends Field{
	private static int number = 0;
	
	
/**
 * Konstruktor klasy Waterhole korzysta z konostruktora klasy Field, po której Waterhole dziedziczy. Dodatkowo zlicza powstałe obiekty
 * @param positionX
 * @param positionY
 */
	Waterhole(int positionX, int positionY) {
		super(positionX, positionY);
		number++;
	}
	
/**
 * 
 * @return Liczba obiektów klasy Waterhole
 */
	static int getNumber() {return number;}
}
