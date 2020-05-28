package Animal;
/**
 * 
 */

/**
 * @author jakub
 *
 */
public interface IAnimal {
	public void eat(IEatable target);
	public boolean canEat(IEatable target);
	public void moveTo(int direction);
	public void multiply();
	public void drink();
	public void die();
	public void getOlder();
	public boolean wantToMove();
}
