/**
 * 
 */
package objectProgramming.crazyAnimals.area;

import java.util.Random;

import objectProgramming.crazyAnimals.animal.IEatable;

/**
 * 
 * Klasa przechowuje informacje na temat danego rodzaju pożywienia, tj. aktualna liczba, maksymalna liczba, liczba zjedzonych i liczba zniszczonych
 * @author Mikołaj
 */
public final class Feed implements IEatable {
	//[0] - grass; [1] - cheese
	private static int[] numAll = new int[2];
	private static int[] numMax = new int[2];
	private static int[] numEaten = new int[2];
	private static int[] numDestroyed = new int[2];
	
	private String name;
/**
 * Konstruktor klasy Feed tworzy pożywienie, nadaje mu odpowiednią losową nazwę oraz dolicza kolejne obiekty do statystyki
 * @param random - referencja do wspólnego dla całej symulacji obiektu random
 */
	public Feed(Random random) {

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
	public static int getNumAll(String name) {
		if(name=="grass") {return numAll[0];}
		else if(name=="cheese") {return numAll[1];}
		else {return 0;}
	}

/**
 * Metoda zwraca maksymalną liczba wszystkich obiektów danego rodzaju
 * @param name Rodzaj pożywienia
 * @return Maksymalna liczba obiektów
 */
	public static int getNumMax(String name) {
		if(name=="grass") {return numMax[0];}
		else if(name=="cheese") {return numMax[1];}
		else {return 0;}
	}
	
/**
 * Metoda zwraca zjedzoną liczba wszystkich obiektów danego rodzaju
 * @param name Rodzaj pożywienia
 * @return Liczba zjedzonych obietków
 */
	public static int getNumEaten(String name) {
		if(name=="grass") {return numEaten[0];}
		else if(name=="cheese") {return numEaten[1];}
		else {return 0;}
	}
	
/**
 * Metoda zwraca zniszczoną liczba wszystkich obiektów danego rodzaju
 * @param name Rodzaj pożywienia
 * @return  Liczba zniszczonych obiektów
 */
	public static int getNumDestroyed(String name) {
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
			numAll[0]--;
		}
		if(name=="cheese") {
			numEaten[1]++;
			numAll[1]--;
		}
	}
	
/**
 * Metoda dolicza obiekt do statystyki obiektów zniszczonych i niszczy obiekt w polu, na którym obecnie się znajduje
 */
	public void beDestroyed() {
		if(name=="grass") {
			numDestroyed[0]++;
			numAll[0]--;
		}
		if(name=="cheese") {
			numDestroyed[1]++;
			numAll[1]--;
		}
	}
	
/**
 * Konweruje dane pożywienie na znak
 * @return g - grass, h - cheese, " " - inne przypadki
 */
	@Override 
	public String toString() { 
		if(name=="grass") return "g";
		if(name=="cheese") return "h";
		return " ";
	}
}
