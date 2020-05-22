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
	private int hunger, thirst, age, iterationsToMove;
	private boolean isMale, isDead = false, movedAfterMultiplying = true;
	
	protected IField field;
	protected IAnimal child = null;
	protected Random random = new Random();
	
	/**
	 * Konstruktor tworzy zwierzę, nadaje mu początkowe parametry i umieszcza na podanym polu
	 * @param hunger początkowy głód
	 * @param thirst początkowe pragnienie
	 * @param age wiek
	 * @param isMale zmienna logiczna odpowiadająca na pytanie: czy zwierzę jest płci męskiej?
	 * @param field pole na którym zostanie umieszczone zwierzę
	 */
	public Animal(int hunger, int thirst, int age, boolean isMale, IField field, Random random) {
		this.random = random;
		this.hunger = hunger;
		this.thirst = thirst;
		this.age = age;
		this.isMale = isMale;
		this.field = field;
		field.seatAnimal(this);
	}
	public boolean wantToMove() {return (iterationsToMove == 0 ? true : false);}
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
		setMovedAfterMultiplying(true);
	}
	public void doIteration() {
		if(isDying()){
			die();
			return;
		}
		if(field.getEatable().size() > 1) {
			List<IEatable> eatable = field.getEatable();
			for(int i = 0; i < eatable.size(); i++)
				if(canEat(eatable.get(i)))
					eat(eatable.get(i));
				else if(eatable.get(i) instanceof Area.Feed)
					field.destroyEatable(eatable.get(i));
		}
		if(field.getAnimals().size() > 1) {
			List<IAnimal> animals = field.getAnimals();
			for(int i = 0; i < animals.size(); i++) {
				if(canMultiply(animals.get(i)) && !isMale()) {
					animals.get(i).multiply();
					multiply();
					break;
				}
			}
		}
		if(field instanceof Area.Waterhole)
			this.drink();
		hunger += 5;
		thirst += 5;
		if(!wantToMove())
			iterationsToMove--;
		age++;
	}
	public IAnimal hasChild() {
		IAnimal tmp = child;
		child = null;
		return tmp;
		}
	public boolean isMale() {return isMale;}
	public boolean isDead() {return isDead;}
	public void setMovedAfterMultiplying(boolean value) {movedAfterMultiplying = value;}
	public boolean getMovedAfterMultiplying() {return movedAfterMultiplying;}
	public void beEaten() {die();}
	
	private boolean isDying() {
		if(age >= 100 || hunger >= 100 || thirst >= 100)
			return true;
		else return false;
	}
	/**
	 * Pozwala stwierdzić czy zwierzę może ruszyć się na zadane pole
	 * @param field sprawdzane pole
	 * @return true - może się ruszyć, false - nie może się ruszyć
	 */
	private boolean canMoveThere(IField field) {
		if(field.anyAnimal()){
			List<IAnimal> animals = field.getAnimals();
			if(animals.size() >= 2)
				return false;
			for(int i = 0; i < animals.size(); i++){
				if(!(canEat(animals.get(i)) || canMultiply(animals.get(i))))
					return false;
			}
		}
		return true;
	}
	/**
	 * Sprawia, że obiekt zostaje zjedzony przez zwierzę
	 * @param target - jedzony obiekt
	 */
	private void eat(IEatable target) {
		target.beEaten();
		hunger = (hunger > 50) ? hunger - 50 : 0;
	}
	/**
	 * Uzupełnia pragnienie zwierzęcia
	 */
	private void drink() {thirst = (thirst > 30) ? thirst - 30 : 0;}
	/**
	 * Usuwa zwierzę z pola i uwzględnia to w statystykach
	 */
	private void die() {
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
}
