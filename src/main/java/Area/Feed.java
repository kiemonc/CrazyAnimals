/**
 * 
 */
package Area;

/**
 * @author Mikołaj
 *
 */
public final class Feed implements IFeed {
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
