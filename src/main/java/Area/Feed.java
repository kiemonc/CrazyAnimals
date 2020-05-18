/**
 * 
 */
package Area;

import Animal.IEatable;
import java.util.Random;

/**
 * @author Miko³aj
 *	Klasa przechowuje informacje na temat danego rodzaju po¿ywienia, tj. aktualna liczba, maksymalna liczba, liczba zjedzonych i liczba zniszczonych
 *
 */
public final class Feed implements IEatable {
	//[0] - grass; [1] - cheese
	private static int[] numAll;
	private static int[] numMax;
	private static int[] numEaten;
	private static int[] numDestroyed;
	
	private String name;
	private static Random random = new Random(0);
/**
 * Konstruktor klasy Feed tworzy po¿ywienie, nadaje mu odpowiedni¹ losow¹ nazwê oraz dolicza kolejne obiekty do statystyki
 * @param Nic
 */
	public Feed() {
		if(random.nextBoolean()) {
			this.name = "grass";
			numAll[0]++;
			if(numAll[0] > numMax[0]) {
				numMax[0]++;
			}
		} else {
			this.name = "cheese";
			numAll[1]++;
			if(numAll[1] > numMax[1]) {
				numMax[1]++;
			}
		}
	}
	
/**
 * Metoda zwraca nazwe danego po¿ywienia
 * @return String Nazwa po¿ywienia
 */
	public String getName() {return name;}
	
/**
 * Metoda zwraca aktualn¹ liczba wszystkich obiektów danego rodzaju
 * @param name Rodzaj po¿ywienia
 * @return Aktualna liczba obietków
 */
	static int getNumAll(String name) {
		if(name=="grass") {return numAll[0];}
		else if(name=="cheese") {return numAll[1];}
		else {return 0;}
	}

/**
 * Metoda zwraca maksymaln¹ liczba wszystkich obiektów danego rodzaju
 * @param name Rodzaj po¿ywienia
 * @return Maksymalna liczba obiektów
 */
	static int getNumMax(String name) {
		if(name=="grass") {return numMax[0];}
		else if(name=="cheese") {return numMax[1];}
		else {return 0;}
	}
	
/**
 * Metoda zwraca zjedzon¹ liczba wszystkich obiektów danego rodzaju
 * @param name Rodzaj po¿ywienia
 * @return Liczba zjedzonych obietków
 */
	static int getNumEaten(String name) {
		if(name=="grass") {return numEaten[0];}
		else if(name=="cheese") {return numEaten[1];}
		else {return 0;}
	}
	
/**
 * Metoda zwraca zniszczon¹ liczba wszystkich obiektów danego rodzaju
 * @param name Rodzaj po¿ywienia
 * @return  Liczba zniszczonych obiektów
 */
	static int getNumDestroyed(String name) {
		if(name=="grass") {return numDestroyed[0];}
		else if(name=="cheese") {return numDestroyed[1];}
		else {return 0;}
	}

/**
 * Metoda dolicza obiekt do statystyki obiektów zjedzonych i niszczy obiekt w polu, na którym obecnie siê znajduje
 */
	public void beEaten() {
		if(name=="grass") {
			numEaten[0]++;
		}
		if(name=="cheese") {
			numEaten[1]++;
		}
	}
	
/**
 * Metoda dolicza obiekt do statystyki obiektów zniszczonych i niszczy obiekt w polu, na którym obecnie siê znajduje
 */
	public void beDestroyed() {
		if(name=="grass") {
			numDestroyed[0]++;
		}
		if(name=="cheese") {
			numDestroyed[1]++;
		}
	}
}