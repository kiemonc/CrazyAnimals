/**
 * 
 */
package Main;

/**
 * @author Miko�aj
 * Klasa komunikuje si� z u�ytkownikiem, ustawia i przechowuje parametry pocz�tkowe, czyli minialne i maksymalne liczebno�ci ka�dego gatunku zwierz�t, wymiary ��ki oraz liczb� wodopoj�w.
 * Klasa ustawia i przechowuje liczb� wodopoj�w.
 */
public final class Parameters {
	public Parameters() {
		meadowWidth = 100;
		meadowHeight = 100;
		numWaterholes = 10;
		int [] startMinNum = {1,1,1,1,1};
		this.startMinNum = startMinNum;
		int [] startMaxNum = {4,4,4,4,4};
		this.startMaxNum = startMaxNum;
		int [] endMinNum = {2,2,2,2,2};
		this.endMinNum = endMinNum;
		int [] endMaxNum = {3,3,3,3,3};
		this.endMaxNum = endMaxNum;
		
	}

	public final int meadowWidth;
	public final int meadowHeight;
	public final int numWaterholes;
	
	
	//[0]cat [1]cow [2]mouse [3]sheep [4]wolf
	public final int[] startMaxNum;
	public final int[] startMinNum;
	public final int[] endMaxNum;
	public final int[] endMinNum;
	
}