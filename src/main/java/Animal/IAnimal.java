/**
 * 
 */
package Animal;

/**
 * @author jakub
 *
 */
public interface IAnimal {
	public void eat(Animal animal);
	public void eat(Feed feed);
	public void moveTo(Field target);
	public void multiply();
	public void drink();
	public void die();
}
