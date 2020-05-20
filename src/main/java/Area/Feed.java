/**
 * 
 */
package Area;

import Animal.IEatable;
import java.util.Random;

/**
 * 
 * Klasa przechowuje informacje na temat danego rodzaju pożywienia, tj. aktualna liczba, maksymalna liczba, liczba zjedzonych i liczba zniszczonych
 * @author Mikołaj
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
 * Konstruktor klasy Feed tworzy pożywienie, nadaje mu odpowiednią losową nazwę oraz dolicza kolejne obiekty do statystyki
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
 * Metoda zwraca nazwe danego pożywienia
 * @return String Nazwa pożywienia
 */
	public String getName() {return name;}
	
/**
 * Metoda zwraca aktualną liczba wszystkich obiektów danego rodzaju
 * @param name Rodzaj pożywienia
 * @return Aktualna liczba obietków
 */
	static int getNumAll(String name) {
		if(name=="grass") {return numAll[0];}
		else if(name=="cheese") {return numAll[1];}
		else {return 0;}
	}

/**
 * Metoda zwraca maksymalną liczba wszystkich obiektów danego rodzaju
 * @param name Rodzaj pożywienia
 * @return Maksymalna liczba obiektów
 */
	static int getNumMax(String name) {
		if(name=="grass") {return numMax[0];}
		else if(name=="cheese") {return numMax[1];}
		else {return 0;}
	}
	
/**
 * Metoda zwraca zjedzoną liczba wszystkich obiektów danego rodzaju
 * @param name Rodzaj pożywienia
 * @return Liczba zjedzonych obietków
 */
	static int getNumEaten(String name) {
		if(name=="grass") {return numEaten[0];}
		else if(name=="cheese") {return numEaten[1];}
		else {return 0;}
	}
	
/**
 * Metoda zwraca zniszczoną liczba wszystkich obiektów danego rodzaju
 * @param name Rodzaj pożywienia
 * @return  Liczba zniszczonych obiektów
 */
	static int getNumDestroyed(String name) {
		if(name=="grass") {return numDestroyed[0];}
		else if(name=="cheese") {return numDestroyed[1];}
		else {return 0;}
	}

/**
 * Metoda dolicza obiekt do statystyki obiektów zjedzonych i niszczy obiekt w polu, na którym obecnie się znajduje
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
 * Metoda dolicza obiekt do statystyki obiektów zniszczonych i niszczy obiekt w polu, na którym obecnie się znajduje
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
