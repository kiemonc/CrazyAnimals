package objectProgramming.crazyAnimals.area;

import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import org.junit.Test;

public class WaterholeTest {

	@Test
	public void test() {
		List<Waterhole> waterholes = new ArrayList<Waterhole>();
		for(int i = 0; i < 100; i++) {
			waterholes.add(new Waterhole(0,i,new Random(0)));
		}
		assertTrue("Number of Waterholes", Waterhole.getNumber() == 100);
	}

}
