package objectProgramming.crazyAnimals.animal;

import java.util.List;
import java.util.Random;

import objectProgramming.crazyAnimals.area.Feed;
import objectProgramming.crazyAnimals.area.IField;
import objectProgramming.crazyAnimals.area.IMeadow;

/**
 * Klasa zawiera wspólne parametry i operacje które mogą zostać wykonane na każdym zwierzęciu
 * @author jakub
 */
public abstract class Animal implements IAnimal{
	private int hunger, thirst, age, iterationsToMove;
	private boolean isMale, isDead = false, movedAfterMultiplying = true;
	private static int lastNumber = 0;
	private int number;
	private boolean hasPanel;
	IField field;
	IAnimal child;
	Random random;
	/**
	 * Konstruktor tworzy zwierzę, nadaje mu początkowe parametry i umieszcza na podanym polu
	 * @param hunger początkowy głód
	 * @param thirst początkowe pragnienie
	 * @param age wiek
	 * @param isMale zmienna logiczna odpowiadająca na pytanie: czy zwierzę jest płci męskiej?
	 * @param field pole na którym zostanie umieszczone zwierzę
	 * @param random referencja do zmiennnej typu Random
	 */
	public Animal(int hunger, int thirst, int age, boolean isMale, IField field, Random random) {
		this.hunger = hunger;
		this.thirst = thirst;
		this.age = age;
		this.isMale = isMale;
		this.field = field;
		this.random = random;
		field.seatAnimal(this);
		lastNumber++;
		number = lastNumber;
		child = null;
		hasPanel = false;
	}
	@Override
	public boolean wantToMove() {return (iterationsToMove == 0 ? true : false);}
	@Override
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
	@Override
	public void doIteration() {
		if(field == null)
			return;
		if(age >= 100 || hunger >= 100 || thirst >= 100){
			die();
			return;
		}
		if(field.getEatable().size() > 1) {
			List<IEatable> eatable = field.getEatable();
			for(int i = 0; i < eatable.size(); i++) {
				if(canEat(eatable.get(i)))
					eat(eatable.get(i));
				if(eatable.get(i) instanceof Feed) {
					((Feed)eatable.get(i)).beDestroyed();
					field.destroyEatable(eatable.get(i));
				}
			}
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
		if(field instanceof objectProgramming.crazyAnimals.area.Waterhole)
			drink();
		addHunger();
		thirst += 2;
		if(!wantToMove())
			iterationsToMove--;
		age++;
	}
	@Override
	public IAnimal hasChild() {
		IAnimal tmp = child;
		child = null;
		return tmp;
		}
	@Override
	public boolean isMale() {return isMale;}
	@Override
	public boolean isDead() {return isDead;}
	@Override
	public void setMovedAfterMultiplying(boolean value) {movedAfterMultiplying = value;}
	@Override
	public boolean getMovedAfterMultiplying() {return movedAfterMultiplying;}
	@Override
	public void beEaten() {die();}
	@Override
	public int [] getStats() {
		return new int[] {hunger, thirst, age, (isMale ? 1 : 0), iterationsToMove, number, field.getCoordinates()[0], field.getCoordinates()[1]};
	}
	
	/**
	 * Pozwala stwierdzić czy zwierzę może ruszyć się na zadane pole
	 * @param field sprawdzane pole
	 * @return true - może się ruszyć, false - nie może się ruszyć
	 */
	boolean canMoveThere(IField field) {
		if(field.anyAnimal()){
			List<IAnimal> animals = field.getAnimals();
			if(animals.size() >= 2)
				return false;
			for(int i = 0; i < animals.size(); i++){
				if(this instanceof Wolf) {
					if(animals.get(i) instanceof Wolf && animals.get(i).isMale() == this.isMale())
						return false;
				}
				else 
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
	void eat(IEatable target) {
		target.beEaten();
		hunger = (hunger > 50) ? hunger - 50 : 0;
	}
	/**
	 * Uzupełnia pragnienie zwierzęcia
	 */
	void drink() {thirst = (thirst > 50) ? thirst - 50 : 0;}
	/**
	 * Usuwa zwierzę z pola i uwzględnia to w statystykach
	 */
	void die() {
		if(isDead()) 
			return;
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
	/**
	 * Dodaje głód w zależności od gatunku
	 */
	void addHunger() {
		if(this instanceof Cat || this instanceof Wolf)
			hunger += 3;
		else if(this instanceof Cow || this instanceof Mouse || this instanceof Sheep)
			hunger += 5;
	}
	
	/**
	 * Zwraca inukalny numer zwierzęcia
	 * @return unikalny numer
	 */
	public int getAnimalNumber() {
		return number;
	}
	
	/**
	 * Ustawia informacje czy zwierzę ma już owarty swój panel.
	 */
	public void setHasPanel(boolean panel) {
		hasPanel = panel;
	}
	
	/**
	 * Daje informacje czy zwierzę ma już owarty swój panel.
	 * @return wartość zmiennej hasPanel
	 */
	public boolean getHasPanel() {
		return hasPanel;
	}
}
