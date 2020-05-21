package Animal;

import java.util.List;
import java.util.Random;

import Area.IField;
import Area.IMeadow;

/**
 * Klasa zawiera wspólne parametry i operacje które mogą zostać wykonane na każdym zwierzęciu
 * @author jakub
 */
public abstract class Animal implements IAnimal{
	
	protected int hunger, thirst, age, iterationsToMove;
	protected boolean isMale;
	protected IField field;
	private boolean isDead;
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
		isDead = false;
	}
	public boolean isMale() {
		return isMale;
	}
	public void eat(IEatable target) {
		target.beEaten();
		hunger = (hunger > 50) ? hunger - 50 : 0;
	}
	public void move(IMeadow meadow) {
		List<IField> fields = meadow.getNeighbours(this.field);
		boolean canMoveAnywhere = false;
		for(int i = 0; i < fields.size(); i++)
			if(this.canMoveThere(fields.get(i)))
				canMoveAnywhere = true;
		if(canMoveAnywhere == false)
			return;
		IField chosenField;
		do {
		chosenField = fields.get(random.nextInt(fields.size()));
		}while(canMoveThere(chosenField) == false);
		chosenField.seatAnimal(this);
		field.destroyEatable(this);
		field = chosenField;
		iterationsToMove = getMovementSpeed();
	}
	public void drink() {thirst = (thirst > 30) ? thirst - 30 : 0;}
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
		isDead = true;
	}
	public boolean isDying() {
		if(age >= 100 || hunger >= 100 || thirst >= 100)
			return true;
		else return false;
	}
	public boolean isDead() {return isDead;}
	public void doIteration() {
		if(isDying())
			die();
		if(field.getEatable().size() > 1) {
			List<IEatable> eatable = field.getEatable();
			for(int i = 0; i < eatable.size(); i++)
				if(canEat(eatable.get(i)))
					eat(eatable.get(i));;
		}
		if(field.getAnimals().size() > 1) {
			List<IAnimal> animals = field.getAnimals();
			for(int i = 0; i < animals.size(); i++)
				if(canMultiply(animals.get(i)) && isMale() == false)
					multiply();
		}
		if(field instanceof Area.Waterhole)
			this.drink();
		hunger++;
		thirst++;
		if(!wantToMove())
			iterationsToMove--;
		age++;
	}
	public boolean wantToMove() {return (iterationsToMove == 0 ? true : false);}
	public void beEaten() {die();}
}
