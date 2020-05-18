/**
 * 
 */
package Area;

/**
 * @author Miko³aj
 * Klasa przechowuje informacje na temat iloœci wodopojów na ³¹ce. Powoduje, ¿e pole, które jest wodopojem, jest rozró¿nialne ze zwyk³ym polem.
 */
public final class Waterhole extends Field{
	private static int number = 0;
	
	
/**
 * Konstruktor klasy Waterhole korzysta z konostruktora klasy Field, po której Waterhole dziedziczy. Dodatkowo zlicza powsta³e obiekty
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