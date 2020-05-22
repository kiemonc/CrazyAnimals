package Animal;

/**
 * Interfejs odpowiada za grupowanie obiektów z klas Animal i Feed, które mogą zostać zjedzone przez obiekty klasy Animal
 * @author Mikołaj
 */

public interface IEatable {
	/**
	 * Pozwala zniszczyć zjedzony obiekt (zwierzę lub jedzenie)
	 */
	public void beEaten();
}
