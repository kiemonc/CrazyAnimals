/**
 * 
 */
package Area;

/**
 * @author Mikołaj
 * Klasa przechowuje informacje na temat ilości wodopojów na łące. Powoduje, że pole, które jest wodopojem, jest rozróżnialne ze zwykłym polem.
 */
public final class Waterhole extends Field{
	private static int number;
	
	
	
	Waterhole() {}
	static int getNumber() {return number;}
}
