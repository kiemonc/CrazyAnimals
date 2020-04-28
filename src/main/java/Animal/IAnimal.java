package Animal;
/**
 * 
 */

/**
 * @author jakub
 *
 */
public interface IAnimal {
	public void eat(Object target);
	public boolean canEat(Object target);
	public void moveTo(int direction);
	public void multiply();
	public void drink();
	public void die();
	public void getOlder();
	public boolean wantToMove();
}
