/**
 * 
 */
package Area;

import Animal.IEatable;

/**
 * @author Mikołaj
 *	Klasa przechowuje informacje na temat danego rodzaju pożywienia, tj. aktualna ilość, maksymalna ilość, ilość zjedzonych i ilość zniszczonych
 *
 */
public final class Feed implements IEatable {
	private static int[] numAll;
	private static int[] numMax;
	private static int[] numEaten;
	private static int[] numDestroyed;
	
	private String name;
	
	Feed() {}
	public String getName() {return name;}
	static int getNumAll() {return numAll[1];}
	static int getNumMax() {return numMax[1];}
	static int getNumEaten() {return numEaten[1];}
	static int getNumDestroyed() {return numDestroyed[1];}
	
	public void beEaten() {}
	public void beDestroyed() {}
}
