package objectProgramming.crazyAnimals.main;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;



public class MainTest {



	@Test
	public void test() {
		String [] args = {"-i", "1000","-sMin", "5,6,7,8,9", "-sMax", "6,7,8,9,10", "-eMin", "2,3,4,5,6",
				"-eMax", "10,11,12,13,14", "-h", "12", "-w", "14", "-wh", "11"};
		Main.setParameters(args);
		assertTrue("Number of iterations", Main.parameters.maxIterationNum == 1000);
		assertTrue("Meadow size", Main.parameters.meadowHeight == 12 && Main.parameters.meadowWidth == 14);
		assertTrue("Waterholes", Main.parameters.numWaterholes == 11);
		int[] sMin = {5,6,7,8,9};
		int[] sMax = {6,7,8,9,10};
		int[] eMin = {2,3,4,5,6};
		int[] eMax = {10,11,12,13,14};
		assertTrue("Start min numbers", Arrays.equals(sMin, Main.parameters.startMinNum));
		assertTrue("Start max numbers", Arrays.equals(sMax, Main.parameters.startMaxNum));
		assertTrue("End min numbers", Arrays.equals(eMin, Main.parameters.endMinNum));
		assertTrue("End max numbers", Arrays.equals(eMax, Main.parameters.endMaxNum));
	}


}
