package objectProgramming.crazyAnimals.area;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

import java.util.Random;

public class FeedTest {
	@Test
	public void test() {
		for(int k = 0; k < 100; k++) {
			Feed.clearStatistics();
			Random random = new Random(0);
			List<Feed> feeds = new ArrayList<Feed>();
			for(int i = 0; i < 10; i++) {
				feeds.add(new Feed(random));
			}
			int grassNumber = 0;
			int cheeseNumber = 0;
			for(Feed feed : feeds) {
				if(feed.getName() =="grass") {
					grassNumber++;
					assertTrue("toString() method", feed.toString()=="g");
				}
				if(feed.getName() == "cheese") {
					cheeseNumber++;
					assertTrue("toString() method", feed.toString()=="h");
				}
			}
			assertTrue("Number of feeds", Feed.getNumAll("grass") + Feed.getNumAll("cheese") == grassNumber + cheeseNumber);
			feeds.get(0).beDestroyed();
			assertTrue("Destroying", Feed.getNumDestroyed(feeds.get(0).getName())==1);
			feeds.remove(0);
			feeds.get(0).beEaten();
			assertTrue("Eating", Feed.getNumEaten(feeds.get(0).getName())==1);
			assertFalse("Current number and max number", Feed.getNumAll(feeds.get(0).getName())==Feed.getNumMax(feeds.get(0).getName()));
			assertTrue("Nubmer of eaten", Feed.getNumEaten(feeds.get(0).getName())==1);
			feeds.remove(0);
			for(Feed feed : feeds) {
				feed.beDestroyed();
			}
			assertTrue("Current number after destroying", Feed.getNumAll("grass") + Feed.getNumAll("cheese") == 0);
			assertTrue("Max numbers of grass", Feed.getNumMax("grass")== grassNumber);
			assertTrue("Max numbers of cheese", Feed.getNumMax("cheese")== cheeseNumber);
		}
	}
}
