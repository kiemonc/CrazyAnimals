package Animal;
/**
 * 
 */

import java.util.Random;

import Area.Feed;
import Area.IField;

/**
 * Klasa przechowuje warto�� pr�dko�ci z jak� poruszaj� si� krowy oraz operacje charakterystyczne dla tego gatunku.
 * Pozwala odr�ni� krowy od innych zwierz�t
 * @author jakub
 */
public class Cow extends Animal {
	public static final int movementSpeed = 1;
	public static int maxPopulation, currentPopulation;
	/**
	 * Konstruktor tworzy krow�, nadaje jej pocz�tkowe parametry i umieszcza na podanym polu
	 * @param hunger pocz�tkowy g��d
	 * @param thirst pocz�tkowe pragnienie
	 * @param age wiek
	 * @param isMale zmienna logiczna odpowiadaj�ca na pytanie: czy zwierz� jest p�ci m�skiej?
	 * @param field pole na kt�rym zostanie umieszczone zwierz�
	 */
	public Cow(int hunger, int thirst, int age, boolean isMale, IField field){
		super(hunger, thirst, age, isMale, field);
		AnimalStats.addAnimal(1);
	}

	public boolean canEat(IEatable target) {
		if(target instanceof Feed)
			if(((Feed)target).getName() == "grass")
				return true;
		return false;
		}
	public void multiply() {
		Random random = new Random();
		this.field.seatAnimal(new Cow(0, 0, 0, random.nextBoolean(), this.field));
	}
}
