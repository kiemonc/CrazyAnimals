package objectProgramming.crazyAnimals.area;

import static org.junit.Assert.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import objectProgramming.crazyAnimals.animal.IEatable;

public class MeadowTest {

	@Test
	public void test() {
		Random random = new Random();
		Meadow meadow = new Meadow(10, 10, 5, 10, random);
		
		
		List<LinkedList<IField>> table = meadow.fields;
		List<IField> fields = new ArrayList<IField>();
		for(LinkedList<IField> row : table) {
			fields.addAll(row);
		}
		assertTrue("Number of fields", fields.size() == 100);
		
		//Waterholes
		int numWaterholes = 0;
		for(IField field : fields) {
			if(field instanceof Waterhole) numWaterholes++;
		}
		assertTrue("Number of waterhoels", numWaterholes == 5);
		
		//Feed
		assertTrue("Number of feeds", numOfFeeds(fields) == 10);
		meadow.doIteration();
		assertTrue("Number of new feeds", numOfFeeds(fields) >= 10);
		
		//Random fields
		List<IField> randomFields = meadow.getRandomFields(10);
		assertTrue("Random fields", randomFields.size()==10);
		for(IField field : randomFields) {
			for(int i = randomFields.indexOf(field) + 1; i < randomFields.size(); i++) {
				assertTrue("Random fields repeating", field!=randomFields.get(i));
			}
		}
	
		//Neighbours
		assertTrue("First field", meadow.getNeighbours(fields.get(0)).size() == 3);
		assertTrue("Last field", meadow.getNeighbours(fields.get(fields.size()-1)).size() == 3);
		assertTrue("Field in the middle", meadow.getNeighbours(fields.get(25)).size() == 8);
		
		//To string
		meadow = new Meadow(10,10,0,0,random);
		String string = meadow.toString();
		String oneLine = "|";
		for(int i = 0; i < 10; i++) {
			oneLine += "    |";
		}
		oneLine += "\n";
		for(int i = 0; i < 10; i++) {
			assertTrue("To String", string.contains(oneLine));
			string = string.substring(string.indexOf(oneLine)+oneLine.length());
		}
		
	}
	
	private int numOfFeeds (List<IField> fields) {
		int numFeeds = 0;
		for(IField field : fields) {
			if(field.anyFeed()) {
				for(IEatable eatable : field.getEatable()) {
					if(eatable instanceof Feed)  {
						numFeeds++;
						continue;
					}
				}
			}
		}
		return numFeeds;
	}

}
