package objectProgramming.crazyAnimals.area;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Random;
import objectProgramming.crazyAnimals.animal.*;

public class FieldTest {
	
	@Test
	public void test() {
		Random random = new Random();
		Field field1 = new Field(0,1,random);
		Field field2 = new Field(0,0, random);
		assertTrue("Coordinates", field1.getCoordinates()[0]==0 && field1.getCoordinates()[1]==1);
		IAnimal cat = new Cat(0,0,0,true,field1,random);
		assertTrue("anyAnimal()", field1.anyAnimal());
		assertFalse("anyAnimal()", field2.anyAnimal());
		assertTrue("Coordinates", field1.getAnimals().get(0) == cat);
		field1.putNewFeed();
		assertTrue("Eatable", field1.getEatable().size()==2);
		Feed feed = (Feed) field1.getEatable().get(1);
		assertTrue("String", field1.toString().equals(cat.toString() + "  " + feed.toString()));
		field1.putNewFeed();
		assertTrue("New feed",  field1.getEatable().get(1) != feed);
		field1.destroyEatable(cat);
		assertTrue("Destroying eatable", field1.getEatable().size()==1);
		
		IAnimal cat1 = new Cat(0,0,0,true,field2,random);
		IAnimal cat2 = new Cat(0,0,0,true,field2,random);

		assertTrue("Eatable 1", cat1 == field2.getEatable().get(0));
		assertTrue("Eatable 1", cat2 == field2.getEatable().get(1));
		
	}

}
