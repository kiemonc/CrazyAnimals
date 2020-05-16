package Animal;

/**
 * @author jakub
 * Klasa zawiera wsp�lne parametry i operacje dla zwierz�t
 */
public abstract class Animal implements IAnimal, IEatable{
	
	protected int hunger, thirst, age, positionX, positionY, iterationsToMove;
	protected boolean isMale;
	
	public Animal() {this(0, 0, 0, true);}
	
	public Animal(int hunger, int thirst, int age, boolean isMale) {
		this.hunger = hunger;
		this.thirst = thirst;
		this.age = age;
		this.isMale = isMale;
	}
	public void eat(IEatable target) {
		target.beEaten();
		this.hunger = 0;
	}
	public void moveTo(int direction) {
		switch(direction){
		case 0: positionX++; break;
		case 1: positionY--; break;
		case 2: positionX--; break;
		case 3: positionY++; break;
		}
	}
	public void drink() {this.thirst = 0;}
	public void die() {}
	public void getOlder() {this.age++;}                                         //hunger, thirst, iterationsToMove "--" ?
	public boolean wantToMove() {return (iterationsToMove == 0 ? true : false);}
	public void beEaten() {this.die();}
}
