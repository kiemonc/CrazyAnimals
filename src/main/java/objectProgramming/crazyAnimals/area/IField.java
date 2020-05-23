package objectProgramming.crazyAnimals.area;

import java.util.List;

import objectProgramming.crazyAnimals.animal.IAnimal;
import objectProgramming.crazyAnimals.animal.IEatable;

public interface IField {
	
	/**
	 * Zwraca listę obiektów, które da się zjeść, do listy zwierząt dokleja pożywienie, jeśli znajduje się aktualnie na danym polu. Jeśli pole jest puste zwraca wartość null
	 * @return Lista obiektów dających się zjeść
	 */
	public List<IEatable> getEatable();
	
	/**
	 * Metoda usuwa dany obiekt z listy obietków zawartych w obiekcie klasy Field. Może to być obiekt typu Field lub IAnimal, które implementuję interfejs IEatable
	 * @param eatable Obiekt do zniszczenia
	 */
	public void destroyEatable(IEatable eatable);
	
	/**
	 * Metoda zwraca listę zwierząt znajdujacych się na danym polu
	 * @return Lista zwierząt
	 */
	public List<IAnimal> getAnimals();
	
	/**
	 * Metoda ustawia zwierzę na danym polu
	 * @param animal - ustawiane zwierzę
	 */
	public void seatAnimal(IAnimal animal);
	
	/**
	 * Metoda rozpoznaje czy na danym polu znajduje się aktualnie pożywienie i ewentualnie je usuwa
	 * i w to miejsce wkłada nowo wygenerowane pożywienie
	 */
	public void putNewFeed();
	
	/**
	 * @return Współrzędne pola
	 */
	public int [] getCoordinates();
	
	/**
	 * Informuje czy na danym polu znajduje się jakiekolwiek pożywienie
	 * @return boolean 	Wartość logiczna odpowiadająca na pytanie czy pole jest aktualnie puste
	 */
	public boolean anyFeed();
	
	/**
	 * Informuje czy na danym polu znajduje się jakiekolwiek zwierzę
	 * @return true - jest zwierzę, false - nie ma zwierzęcia
	 */
	public boolean anyAnimal();
}
