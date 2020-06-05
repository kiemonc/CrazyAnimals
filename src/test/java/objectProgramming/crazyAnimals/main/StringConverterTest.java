package objectProgramming.crazyAnimals.main;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;

public class StringConverterTest {

	@Test
	public void test() {
		StringConverter converter = new StringConverter();
		List<String> list = converter.split("1,2,3,4,5");
		Integer i = 1;
		for(String element : list) {
			assertTrue("String to list", element.equals(i.toString()));
			i++;
		}
		
		list = converter.split("2,3,4,5,6");
		i = 1;
		for(String element : list) {
			assertFalse("String to list", element.equals(i.toString()));
			i++;
		}
		
	}

}
