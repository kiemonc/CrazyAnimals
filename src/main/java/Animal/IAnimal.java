package Animal;
/**
 * 
 */

/**
 * @author jakub
 *
 */
public interface IAnimal {
	public void eat(String target);
	public void canEat(String target);
	public void moveTo(int direction);
	public void multiply();
	public void drink();
	public void die();
	public void getOlder();
	public boolean wantToMove();
}
