/**
 * 
 */
package Area;

/**
 * @author Miko�aj
 * Klasa przechowuje informacje na temat ilo�ci wodopoj�w na ��ce. Powoduje, �e pole, kt�re jest wodopojem, jest rozr�nialne ze zwyk�ym polem.
 */
public final class Waterhole extends Field{
	private static int number = 0;
	
	
/**
 * Konstruktor klasy Waterhole korzysta z konostruktora klasy Field, po kt�rej Waterhole dziedziczy. Dodatkowo zlicza powsta�e obiekty
 * @param positionX
 * @param positionY
 */
	Waterhole(int positionX, int positionY) {
		super(positionX, positionY);
		number++;
	}
	
/**
 * 
 * @return Liczba obiekt�w klasy Waterhole
 */
	static int getNumber() {return number;}
}