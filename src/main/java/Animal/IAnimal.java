package Animal;
/**
 * 
 */


import Area.Field;

/**
 * @author jakub
 *
 */
public interface IAnimal {
	public void eat(Object target);
	public void canEat(Object target);
	public void moveTo(Field target);
	public void multiply();
	public void drink();
	public void die();
	public void getOlder();
	public boolean wantToMove();
}
