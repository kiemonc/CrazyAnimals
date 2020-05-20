package Animal;

import java.util.List;
import java.util.Random;

import Area.IField;
import Area.IMeadow;

/**
 * Klasa zawiera wspólne parametry i operacje które mogą zostać wykonane na każdym zwierzęciu
 * @author jakub
 */
public abstract class Animal implements IAnimal, IEatable{
	
	protected int hunger, thirst, age, iterationsToMove;
	protected boolean isMale;
	protected IField field;
	private Random random = new Random();
	
	/**
	 * Konstruktor tworzy zwierzę, nadaje mu początkowe parametry i umieszcza na podanym polu
	 * @param hunger początkowy głód
	 * @param thirst początkowe pragnienie
	 * @param age wiek
	 * @param isMale zmienna logiczna odpowiadająca na pytanie: czy zwierzę jest płci męskiej?
	 * @param field pole na którym zostanie umieszczone zwierzę
	 */
	public Animal(int hunger, int thirst, int age, boolean isMale, IField field) {
		this.hunger = hunger;
		this.thirst = thirst;
		this.age = age;
		this.isMale = isMale;
		this.field = field;
	}
	public void eat(IEatable target) {
		target.beEaten();
		this.hunger = 0;
	}
	public void move(IMeadow meadow) {
		List<IField> fields = meadow.getNeighbours(this.field);
		IField chosenField = fields.get(random.nextInt(fields.size()));
		chosenField.seatAnimal(this);
		this.field = chosenField;
	}
	public void drink() {this.thirst = 0;}
	public void die() {
		if(this instanceof Cat)
			AnimalStats.takeAnimal(0);
		else if(this instanceof Cow)
			AnimalStats.takeAnimal(1);
		else if(this instanceof Mouse)
			AnimalStats.takeAnimal(2);
		else if(this instanceof Sheep)
			AnimalStats.takeAnimal(3);
		else if(this instanceof Wolf)
			AnimalStats.takeAnimal(4);
		field.destroyEatable(this);
	}
	public boolean isDying() {
		if(this.age >= 100 || this.hunger >= 100 || this.thirst >= 100)
			return true;
		else return false;
	}
	public void getOlder() {this.age++;}
	public void doIteration() {
		this.hunger++;
		this.thirst++;
		if(this.iterationsToMove > 0)
			this.iterationsToMove--;
	}
	public boolean wantToMove() {return (this.iterationsToMove == 0 ? true : false);}
	public void beEaten() {this.die();}
}
