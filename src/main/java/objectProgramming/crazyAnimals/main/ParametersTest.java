package objectProgramming.crazyAnimals.main;

import static org.junit.Assert.*;

import org.junit.Test;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.JCommander.Builder;

import java.util.Random;


public class ParametersTest {

	@Test
	public void test() {
		Random random = new Random();
		Parameters parameters = new Parameters(random);
		JCommander commander = new Builder().addObject(parameters).build();
		commander.parse("-i", "-1");
		try {
			parameters.setParametrs();
			fail("Number of iterations");
		} catch (BadParametersException e) {
			
		}
		
		parameters = new Parameters(random);
		commander = new Builder().addObject(parameters).build();
		commander.parse("-w", "9", "-h", "11", "-wh", "37");
		try {
			parameters.setParametrs();
			fail("Number of waterholes");
		} catch (BadParametersException e) {
			
		}
		
		parameters = new Parameters(random);
		commander = new Builder().addObject(parameters).build();
		commander.parse("-w", "9", "-h", "11", "-sMin", "8,60,10,10,10", "-sMax", "9,60,10,10,10");
		try {
			parameters.setParametrs();
			fail("Start namber of animals");
		} catch (BadParametersException e) {
			
		}
		
		parameters = new Parameters(random);
		commander = new Builder().addObject(parameters).build();
		commander.parse("-w", "9", "-h", "11", "-sMin", "8,10,10,10,10", "-sMax", "9,10,10,10,10","-eMin", "9,10,10,10,10", "-eMax", "9,10,10,10,10");
		try {
			parameters.setParametrs();
			fail("End range of animals");
		} catch (BadParametersException e) {
			
		}
		
		parameters = new Parameters(random);
		commander = new Builder().addObject(parameters).build();
		commander.parse("-w", "9", "-h", "11", "-sMin", "8,10,10,10,10", "-sMax", "9,10,10,10,10");
		try {
			parameters.setParametrs();
		} catch (BadParametersException e) {
			
		}
		for(int i = 0; i < 5; i++) {
			assertTrue("Start number of animals out of range", parameters.startNum[i] >= parameters.startMinNum[i] &&  parameters.startNum[i] <= parameters.startMaxNum[i]);
		}
	}
}
