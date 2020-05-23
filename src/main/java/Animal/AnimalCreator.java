/**
 * 
 */
package Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Area.IField;
import Area.IMeadow;
/**
 * Klasa odpowiada za tworzenie zadanej liczby zwierząt i umieszczanie ich losowo na łące
 * @author jakub
 */
public class AnimalCreator implements IAnimalCreator{
	private Random random = new Random();
	
	public List<IAnimal> createAnimals(int nrOfCats, int nrOfCows, int nrOfMouses, int nrOfSheeps, int nrOfWolves, IMeadow meadow, Random random) {
		this.random = random;
		List<IField> fields = meadow.getRandomFields(nrOfCats + nrOfCows + nrOfMouses + nrOfSheeps + nrOfWolves);
		int fieldsIndex = 0;
		List<IAnimal> list = new ArrayList<IAnimal>();
		for(int i = 0; i < nrOfCats; i++)   {list.add(createCat(fields.get(fieldsIndex++)));}
		for(int i = 0; i < nrOfCows; i++)   {list.add(createCow(fields.get(fieldsIndex++)));}
		for(int i = 0; i < nrOfMouses; i++) {list.add(createMouse(fields.get(fieldsIndex++)));}
		for(int i = 0; i < nrOfSheeps; i++) {list.add(createSheep(fields.get(fieldsIndex++)));}
		for(int i = 0; i < nrOfWolves; i++) {list.add(createWolf(fields.get(fieldsIndex++)));}
		return list;
	}
	/**
	 * Tworzy jednego kota i umieszcza go na podanym polu
	 * @param field pole na którym ma zostać umieszczony kot
	 * @return referencja do utworzonego kota
	 */
	private Cat createCat(IField field) 	{ return new Cat  (0, 0, 0, random.nextBoolean(), field, random); }
	/**
	 * Tworzy jedną krowę i umieszcza ją na podanym polu
	 * @param field pole na którym ma zostać umieszczona krowa
	 * @return referencja do utworzonej krowy
	 */
	private Cow createCow(IField field)     { return new Cow  (0, 0, 0, random.nextBoolean(), field, random); }
	/**
	 * Tworzy jednego wilka i umieszcza go na podanym polu
	 * @param field pole na którym ma zostać umieszczony wilk
	 * @return referencja do utworzonego wilka
	 */
	private Wolf createWolf(IField field)   { return new Wolf (0, 0, 0, random.nextBoolean(), field, random); }
	/**
	 * Tworzy jedną mysz i umieszcza ją na podanym polu
	 * @param field pole na którym ma zostać umieszczona mysz
	 * @return referencja do utworzonej myszy
	 */
	private Mouse createMouse(IField field) { return new Mouse(0, 0, 0, random.nextBoolean(), field, random); }
	/**
	 * Tworzy jedną owcę i umieszcza ją na podanym polu
	 * @param field pole na którym ma zostać umieszczona owca
	 * @return referencja do utworzonej owcy
	 */
	private Sheep createSheep(IField field) { return new Sheep(0, 0, 0, random.nextBoolean(), field, random); }
}
