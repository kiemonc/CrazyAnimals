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
 * Klasa odpowiada za tworzenie zadanej liczby zwierz¹t i umieszczanie ich losowo na ³¹ce
 * @author jakub
 */
public class AnimalCreator implements IAnimalCreator{
	private Random random = new Random();
	
	public List<Animal> createAnimals(int nrOfCats, int nrOfCows, int nrOfMouses, int nrOfSheeps, int nrOfWolves, IMeadow meadow) {
		List<IField> fields = meadow.getRandomFields(nrOfCats + nrOfCows + nrOfMouses + nrOfSheeps + nrOfWolves);
		int fieldsIndex = 0;
		List<Animal> list = new ArrayList<Animal>();
		for(int i = 0; i < nrOfCats; i++)   {list.add(createCat(fields.get(fieldsIndex++)));}
		for(int i = 0; i < nrOfCows; i++)   {list.add(createCow(fields.get(fieldsIndex++)));}
		for(int i = 0; i < nrOfMouses; i++) {list.add(createMouse(fields.get(fieldsIndex++)));}
		for(int i = 0; i < nrOfSheeps; i++) {list.add(createSheep(fields.get(fieldsIndex++)));}
		for(int i = 0; i < nrOfWolves; i++) {list.add(createWolf(fields.get(fieldsIndex++)));}
		return list;
	}
	public Cat createCat(IField field) 	   { return new Cat  (0, 0, 0, random.nextBoolean(), field); }
	public Cow createCow(IField field)     { return new Cow  (0, 0, 0, random.nextBoolean(), field); }
	public Wolf createWolf(IField field)   { return new Wolf (0, 0, 0, random.nextBoolean(), field); }
	public Mouse createMouse(IField field) { return new Mouse(0, 0, 0, random.nextBoolean(), field); }
	public Sheep createSheep(IField field) { return new Sheep(0, 0, 0, random.nextBoolean(), field); }
}
